/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controlador.PeliculaJpaController;
import static Entidades.Usuario_.nombre;
import static Entidades.Usuario_.usuario;
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
public class pelicula extends HttpServlet {

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
        try {
            //<editor-fold defaultstate="collapsed" desc="VARIABLES">
            HttpSession sesion = request.getSession();
            int opc = Integer.parseInt(request.getParameter("opc"));
            PeliculaJpaController jpa_pelis = new PeliculaJpaController();
            int idAccion = 0;
            String descripcion, categoria, query = "";
            boolean accion = true;
//            String nombreUser = sesion.getAttribute("Nombres").toString();
//</editor-fold>
            switch (opc) {
                case 1:
                    //<editor-fold defaultstate="collapsed" desc="FUNCION DE SERVELT">
                    try {
                        query = request.getParameter("query").toString();
                    } catch (Exception e) {
                        query = "";
                    }
                    try {
                        idAccion = Integer.parseInt(request.getParameter("idAccion"));
                    } catch (Exception e) {
                        idAccion = 0;
                    }
                    request.setAttribute("idAccion", idAccion);
                    if (idAccion != 0 && idAccion != 3) {
                        request.setAttribute("Accion", "Modificar_pelicula");
                    } else if (idAccion == 3) {
                        request.setAttribute("Accion", "Estrenos");
                    } else {
                        request.setAttribute("Accion", "Registro_pelicula");
                    }
                    request.setAttribute("query", query);
                    request.getRequestDispatcher("pelicula.jsp").forward(request, response);
                    break;
                //</editor-fold>
                case 2:
                    //<editor-fold defaultstate="collapsed" desc="REGISTRA">
                    descripcion = request.getParameter("Txt_descripcion");
                    categoria = request.getParameter("Cbx_categoria");
                    accion = jpa_pelis.registarPelicula(descripcion, categoria);
                    if (accion) {
                        request.setAttribute("Alerta", "Registro_pelicula");
                    } else {
                        request.setAttribute("Alerta", "Modificar_pelicula");
                    }
                    request.getRequestDispatcher("pelicula?opc=1&idAccion=0").forward(request, response);
                    break;
//</editor-fold>
                case 3:
                    //<editor-fold defaultstate="collapsed" desc="MODIFICA">
                    try {
                        idAccion = Integer.parseInt(request.getParameter("idAccion"));
                    } catch (Exception e) {
                        idAccion = 0;
                    }
                    descripcion = request.getParameter("Txt_descripcionM");
                    categoria = request.getParameter("Cbx_categoria");
                    accion = jpa_pelis.modificarPelicula(descripcion, categoria, idAccion);
                    if (accion) {
                        request.setAttribute("Alerta", "Modificar_pelicula");
                    } else {
                        request.setAttribute("Alerta", "Error_modificar");
                    }
                    request.getRequestDispatcher("pelicula?opc=1&idAccion=0").forward(request, response);
                    break;
                //</editor-fold>
                case 4:
                    //<editor-fold defaultstate="collapsed" desc="ELIMINAR">
                    try {
                        idAccion = Integer.parseInt(request.getParameter("idAccion"));
                    } catch (Exception e) {
                        idAccion = 0;
                    }
                    accion = jpa_pelis.eliminarPelicula(idAccion);
                    if (accion) {
                        request.setAttribute("Alerta", "Pelicula_eliminada");
                    } else {
                        request.setAttribute("Alerta", "Error_eliminar");
                    }
                    request.getRequestDispatcher("pelicula?opc=1&idAccion=0").forward(request, response);
                    break;
                //</editor-fold>
            }
        } catch (Exception e) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
