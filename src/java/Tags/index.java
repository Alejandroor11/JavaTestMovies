/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tags;

import Controlador.UsuarioJpaController;
import static Entidades.Usuario_.idUsuario;
import java.awt.Menu;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Alejandro
 */
public class index extends TagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            HttpSession sesion = pageContext.getSession();
            if (sesion.getAttribute("Documento") != null || sesion.getAttribute("Nombres") != null || sesion.getAttribute("NombreRol") != null){
                int idUsuario = Integer.parseInt(pageContext.getSession().getAttribute("idUsuario").toString());
                String nombre = (String) sesion.getAttribute("Nombres");
                String rol = (String) sesion.getAttribute("NombreRol");
                out.print("<div id='templatemo_header'>");
                out.print("<div style='float:right'><img src='Interfaz/Contenido/images/MoviesLogo.png' alt='logo' width='86.5px' height='88.5px' /></div>");
                out.print("<div id='site_title'><a href='#' onclick='CerrarSesion();' ><h1><b>" + rol.toUpperCase() + "/</b><b class='green'>" + nombre.toUpperCase() + "</b></a></h1></div>");
                out.print("</div>");
                out.print("<div id='templatemo_menu' class='ddsmoothmenu'>");
                out.print("<div style=\"float:right; margin-top:14px; margin-right:10px;\"><a  style='font-size: 12.2px;color: #fff;text-decoration: none;Font-weight: 700;outline: none;text-align: center;' href='#' onclick=\"ReestablecerPass('" + idUsuario + "');\">Restablecer contraseña</a></div>");
                out.print("<ul>");
                out.print("<li style = 'margin-left : 35%;' ><a href='index.jsp'>Inicio</a></li>");
                //<editor-fold defaultstate="collapsed" desc="PELICULAS">
                out.print("<li><a href='#'>Peliculas</a>");
                out.print("<ul>");
                out.print("<li><a href='pelicula?opc=1&idAccion=0'>Todas</a></li>");
                out.print("</ul>");
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="Trailers">
                out.print("<li><a href='#'>Trailers</a>");
                out.print("<ul>");
                out.print("<li><a href='#'>Estrenos</a>");
                out.print("<li><a href='#'>Todos</a>");
                out.print("</ul>");
//                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="Usuarios">
//                if (!rol.equals("CONSULTA")) {
                out.print("<li><a href='#'>Usuarios</a></li>");

                out.print("<br style='clear: left' />");

            }
            else {
                out.print("<div class='sweet-local' style='opacity: 1.03; display: flex; margin:auto;align-items: center;'>");
                out.print("<fieldset class='popup_local' style='margin-left:-18%;margin-top:-18%;width:35%; height:68%;'>");
                out.print("<br><br><center><b style='color:black'>Iniciar Sesion</b></center>");
                out.print("<form action='sesion?opc=1' method='post'>");
                out.print("<center>");
                out.print("<div style='width: 300px;height: 300px;color: #833471;'>");
                out.print("<br /><br /><br /><input style='background:#e9ffeb;' type='text' name='Txt_user' id='Txt_user' placeholder='Usuario' /><br />");
                out.print("<input style='background:#e9ffeb;' type='password' name='Txt_password' id='Txt_password' placeholder='Contraseña'/>");
                out.print("<div style='float:right;'><img src='Interfaz/Contenido/images/spy.gif' alt='Logo' width='200' height='150' style='margin-right: 40px;' /></div>");
                out.print("</div>");
                out.print("<input type='submit' value='Iniciar'>");
                out.print("</center>");
                out.print("</form>");
                out.print("</fieldset></div>");
            } 
        } catch (Exception e) {
            Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, e);
        }
        return super.doStartTag();

    }

}
