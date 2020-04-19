/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.Serializable;
import javax.persistence.Query;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alejandro
 */
public class PeliculaJpaController implements Serializable {

   public PeliculaJpaController() {
        emf = Persistence.createEntityManagerFactory("JavaTestPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

 
    public List consultaPelicula() {
        EntityManager etm = getEntityManager();
        etm.getTransaction().begin();
        try {
            Query q = etm.createNativeQuery("SELECT * FROM pelicula ORDER BY Fecha_registro desc");
            List consulta = q.getResultList();
            etm.getTransaction().commit();
            etm.clear();
            etm.close();
            if (consulta.isEmpty()) {
                return null;
            } else {
                return consulta;
            }
        } catch (Exception e) {
            return null;
        }
    }
    public List consultaPeliculaId(int idp) {
        EntityManager etm = getEntityManager();
        etm.getTransaction().begin();
        try {
            Query q = etm.createNativeQuery("CALL `sp_pelicula_con_id`('" + idp + "')");
            List consulta = q.getResultList();
            etm.getTransaction().commit();
            etm.clear();
            etm.close();
            if (consulta.isEmpty()) {
                return null;
            } else {
                return consulta;
            }
        } catch (Exception e) {
            return null;
        }
    }
    public List consultaPeliculaAño(String año) {
        EntityManager etm = getEntityManager();
        etm.getTransaction().begin();
        try {
            Query q = etm.createNativeQuery("CALL `sp_pelicula_con_id`('" + año + "')");
            List consulta = q.getResultList();
            etm.getTransaction().commit();
            etm.clear();
            etm.close();
            if (consulta.isEmpty()) {
                return null;
            } else {
                return consulta;
            }
        } catch (Exception e) {
            return null;
        }
    }
    public boolean registarPelicula(String desc, String cat) {
        EntityManager etm = getEntityManager();
        etm.getTransaction().begin();
        try {
            Query q = etm.createNativeQuery("CALL `sp_pelicula_register`('" + desc + "', '" + cat + "')");
            int resultado = q.executeUpdate();
            etm.getTransaction().commit();
            etm.clear();
            etm.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean modificarPelicula(String desc, String cat, int idu) {
        EntityManager etm = getEntityManager();
        etm.getTransaction().begin();
        try {
            Query q = etm.createNativeQuery("CALL `sp_pelicula_update`('" + desc + "', '" + cat + "', '" + idu + "')");
            int resultado = q.executeUpdate();
            etm.getTransaction().commit();
            etm.clear();
            etm.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean eliminarPelicula(int idp) {
        EntityManager etm = getEntityManager();
        etm.getTransaction().begin();
        try {
            Query q = etm.createNativeQuery("CALL `sp_pelicula_delete`('" + idp + "')");
            int resultado = q.executeUpdate();
            etm.getTransaction().commit();
            etm.clear();
            etm.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
  
    
}
