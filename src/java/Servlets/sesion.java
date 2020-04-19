/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.UsuarioJpaController;
import Metodos.controlEncriptacion;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alejandro
 */
public class sesion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         try {
            //<editor-fold defaultstate="collapsed" desc="VARIABLES">
            HttpSession sesion = request.getSession();
            controlEncriptacion md5 = new controlEncriptacion();
            UsuarioJpaController jpa_usuario = new UsuarioJpaController();
            List lst_usuario = null;
            int opc = Integer.parseInt(request.getParameter("opc"));
            int idUsuario = 0;
            boolean accion = true;
            int id_usuario = 0;

            String user, password, passwordEncrypt = "";
//</editor-fold>

            switch (opc) {
                //<editor-fold defaultstate="collapsed" desc="1. INICIO DE SESION">
                case 1:
                    user = request.getParameter("Txt_user");
                    password = request.getParameter("Txt_password");
                    if (password.length() >= 8) {
                        passwordEncrypt = md5.md5(password);
                        lst_usuario = jpa_usuario.usuarioSesion(user, passwordEncrypt);
                        if (lst_usuario == null) {
                            lst_usuario = jpa_usuario.usuarioSesion(user, password);
                        }
                    } else {
                        lst_usuario = jpa_usuario.usuarioSesion(user, password);
                    }
                    if (lst_usuario == null) {
                        request.setAttribute("Alerta", "Usuario_no_existe");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    } else {
                        Object[] obj_sesion = (Object[]) lst_usuario.get(0);
                        if ((Integer) obj_sesion[6] == 0) {
                            request.setAttribute("Alerta", "Usuario_desactivado");
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                        } else if (obj_sesion[7].toString().equals("Si")) {
                            request.setAttribute("idUsuario", obj_sesion[0]);
                            request.setAttribute("Alerta", "Cambio_contraseña");
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                        } else {
                            sesion.setAttribute("idUsuario", obj_sesion[0]);
                            sesion.setAttribute("Nombres", obj_sesion[1]);
                            sesion.setAttribute("Rol/Nombres", obj_sesion[5] + "/" + obj_sesion[1]);
                            sesion.setAttribute("Documento", obj_sesion[2]);
//                            sesion.setAttribute("Codigo", obj_sesion[3]);
                            sesion.setAttribute("Usuario", obj_sesion[3]);
                            sesion.setAttribute("idRol", obj_sesion[8]);
                            sesion.setAttribute("NombreRol", obj_sesion[5]);
                            sesion.setAttribute("Estado", obj_sesion[6]);
                            request.getRequestDispatcher("pelicula.jsp").forward(request, response);
                        }
                    }
                    break;
                case 2:
                    idUsuario = Integer.parseInt(request.getParameter("Id_usuario"));
                    password = request.getParameter("Txt_password");
                    passwordEncrypt = md5.md5(password);
                    accion = jpa_usuario.cambiarPass(idUsuario, passwordEncrypt);
                    request.setAttribute("Alerta", "password_actualizada");
                    request.getRequestDispatcher("pelicula.jsp").forward(request, response);
                    break;
            }
        } catch (Exception e) {
            request.getRequestDispatcher("salir.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
