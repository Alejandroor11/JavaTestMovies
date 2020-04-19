/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.exceptions.NonexistentEntityException;
import Controlador.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Pelicula;
import Entidades.Trailer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Alejandro
 */
public class TrailerJpaController implements Serializable {

    public TrailerJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Trailer trailer) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Pelicula idPelicula = trailer.getIdPelicula();
            if (idPelicula != null) {
                idPelicula = em.getReference(idPelicula.getClass(), idPelicula.getIdPelicula());
                trailer.setIdPelicula(idPelicula);
            }
            em.persist(trailer);
            if (idPelicula != null) {
                idPelicula.getTrailerCollection().add(trailer);
                idPelicula = em.merge(idPelicula);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Trailer trailer) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Trailer persistentTrailer = em.find(Trailer.class, trailer.getIdTrailer());
            Pelicula idPeliculaOld = persistentTrailer.getIdPelicula();
            Pelicula idPeliculaNew = trailer.getIdPelicula();
            if (idPeliculaNew != null) {
                idPeliculaNew = em.getReference(idPeliculaNew.getClass(), idPeliculaNew.getIdPelicula());
                trailer.setIdPelicula(idPeliculaNew);
            }
            trailer = em.merge(trailer);
            if (idPeliculaOld != null && !idPeliculaOld.equals(idPeliculaNew)) {
                idPeliculaOld.getTrailerCollection().remove(trailer);
                idPeliculaOld = em.merge(idPeliculaOld);
            }
            if (idPeliculaNew != null && !idPeliculaNew.equals(idPeliculaOld)) {
                idPeliculaNew.getTrailerCollection().add(trailer);
                idPeliculaNew = em.merge(idPeliculaNew);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = trailer.getIdTrailer();
                if (findTrailer(id) == null) {
                    throw new NonexistentEntityException("The trailer with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Trailer trailer;
            try {
                trailer = em.getReference(Trailer.class, id);
                trailer.getIdTrailer();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The trailer with id " + id + " no longer exists.", enfe);
            }
            Pelicula idPelicula = trailer.getIdPelicula();
            if (idPelicula != null) {
                idPelicula.getTrailerCollection().remove(trailer);
                idPelicula = em.merge(idPelicula);
            }
            em.remove(trailer);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Trailer> findTrailerEntities() {
        return findTrailerEntities(true, -1, -1);
    }

    public List<Trailer> findTrailerEntities(int maxResults, int firstResult) {
        return findTrailerEntities(false, maxResults, firstResult);
    }

    private List<Trailer> findTrailerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Trailer.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Trailer findTrailer(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Trailer.class, id);
        } finally {
            em.close();
        }
    }

    public int getTrailerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Trailer> rt = cq.from(Trailer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
