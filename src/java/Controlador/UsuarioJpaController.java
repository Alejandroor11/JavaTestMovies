/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

/**
 *
 * @author Alejandro
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController() {
        emf = Persistence.createEntityManagerFactory("JavaTestPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    
     public List usuarioSesion(String usa, String ctn) {
        EntityManager etm = getEntityManager();
        etm.getTransaction().begin();
        try {
            Query q = etm.createNativeQuery("CALL `sp_usuario_t_sesion`('" + usa + "', '" + ctn + "')");
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
    public boolean modificarUsuario(int doc, String nom, String user, String contra) {
        EntityManager etm = getEntityManager();
        etm.getTransaction().begin();
        try {
            Query q = etm.createNativeQuery("CALL `sp_usuario_update`('" + doc + "','" + nom + "','" + user + "','" + contra + "')");
            int resultado = q.executeUpdate();
            etm.getTransaction().commit();
            etm.clear();
            etm.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean registrarUsuario(int doc, String nom, String user, String contra) {
        EntityManager etm = getEntityManager();
        etm.getTransaction().begin();
        try {
            Query q = etm.createNativeQuery("CALL `sp_usuario_register`('" + doc + "','" + nom + "','" + user + "','" + contra + "')");
            int resultado = q.executeUpdate();
            etm.getTransaction().commit();
            etm.clear();
            etm.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean eliminarUsuario(int idu) {
        EntityManager etm = getEntityManager();
        etm.getTransaction().begin();
        try {
            Query q = etm.createNativeQuery("CALL `sp_usuario_delete`('" + idu + "')");
            int resultado = q.executeUpdate();
            etm.getTransaction().commit();
            etm.clear();
            etm.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public List consultarUsuarios() {
        EntityManager etm = getEntityManager();
        etm.getTransaction().begin();
        try {
            Query q = etm.createNativeQuery("CALL `sp_atv_c_activo`()");
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
    public List consultarUsuariosid(int idu) {
        EntityManager etm = getEntityManager();
        etm.getTransaction().begin();
        try {
            Query q = etm.createNativeQuery("CALL `sp_usuario_c_id`('" + idu + "')");
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
    public boolean cambiarPass(int isa, String ctn) {
        EntityManager etm = getEntityManager();
        etm.getTransaction().begin();
        try {
            Query q = etm.createNativeQuery("update usuario set Contrasena= '" + ctn + "' where IdUsuario=" + isa + "");
            int resultado = q.executeUpdate();
            etm.getTransaction().commit();
            etm.clear();
            etm.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
     public boolean reestablecePass(int isa) {
        EntityManager etm = getEntityManager();
        etm.getTransaction().begin();
        try {
            Query q = etm.createNativeQuery("CALL `sp_usuario_rest_pass`('" + isa + "')");
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
