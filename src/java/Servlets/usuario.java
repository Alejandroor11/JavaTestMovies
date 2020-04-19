/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.UsuarioJpaController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alejandro
 */
public class usuario extends HttpServlet {

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
            int opc = Integer.parseInt(request.getParameter("opc"));
            UsuarioJpaController jpa_usuario = new UsuarioJpaController();
            int idAccion = 0;
            int idUser = 0;
            String nombre, usuario, contraseña;
            int documento = 0;
            boolean accion = true;
//            String nombreUser = sesion.getAttribute("Nombres").toString();
//</editor-fold>
            switch (opc) {
                case 1:
                    //<editor-fold defaultstate="collapsed" desc="FUNCION DE SERVELT">
                    try {
                        idAccion = Integer.parseInt(request.getParameter("idAccion"));
                    } catch (Exception e) {
                        idAccion = 0;
                    }
                    request.setAttribute("idAccion", idAccion);
                    request.getRequestDispatcher("usuario.jsp").forward(request, response);
                    break;
                //</editor-fold>
                case 2:
                    //<editor-fold defaultstate="collapsed" desc="REGISTRA">
                    documento = Integer.parseInt(request.getParameter("Txt_documento"));
                    nombre = request.getParameter("Txt_nombre");
                    usuario = request.getParameter("Txt_usuario");
                    contraseña = request.getParameter("Txt_contra");
                    accion = jpa_usuario.registrarUsuario(documento, nombre, usuario, contraseña);
                    if (accion) {
                        request.setAttribute("Alerta", "Registro_proceso");
                        request.setAttribute("var1", nombre);
                    } else {
                        request.setAttribute("Alerta", "Error_registro");
                    }
                    request.getRequestDispatcher("usuario?opc=1&idAccion=0").forward(request, response);
                    break;
//</editor-fold>
                case 3:
                    //<editor-fold defaultstate="collapsed" desc="MODIFICA">
                    try {
                        idUser = Integer.parseInt(request.getParameter("idUser"));
                    } catch (Exception e) {
                        idUser = 0;
                    }
                    nombre = request.getParameter("Txt_nombre");
                    usuario = request.getParameter("Txt_usuario");
                    contraseña = request.getParameter("Txt_contra");
                    accion = jpa_usuario.modificarUsuario(idUser, nombre, usuario, contraseña);
                    if (accion) {
                        request.setAttribute("Alerta", "Modificar_proceso");
                        request.setAttribute("var1", nombre);
                    } else {
                        request.setAttribute("Alerta", "Error_modificar");
                    }
                    request.getRequestDispatcher("usuario?opc=1&idAccion=0").forward(request, response);
                    break;
                //</editor-fold>
                case 4:
                    //<editor-fold defaultstate="collapsed" desc="ELIMINAR">
                    try {
                        idUser = Integer.parseInt(request.getParameter("idUser"));
                    } catch (Exception e) {
                        idUser = 0;
                    }
                    accion = jpa_usuario.eliminarUsuario(idUser);
                    if (accion) {
                        request.setAttribute("Alerta", "Usuario_eliminado");
                    } else {
                        request.setAttribute("Alerta", "Error_eliminar");
                    }
                    request.getRequestDispatcher("usuario?opc=1&idAccion=0").forward(request, response);
                    break;
                //</editor-fold>
                case 5:
                    //<editor-fold defaultstate="collapsed" desc="RESTABLECER CONTRASEÑA">
                    idUser = Integer.parseInt(request.getParameter("idUser"));
                    accion = jpa_usuario.reestablecePass(idUser);
                    request.setAttribute("Alerta", "password_restablecida");
                    request.getRequestDispatcher("salir.jsp").forward(request, response);
                    break;
//</editor-fold>
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
