/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tags;

import Controlador.UsuarioJpaController;
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
public class usuario extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            HttpSession sesion = pageContext.getSession();
            //<editor-fold defaultstate="collapsed" desc="Variables">
            int idAccion = Integer.parseInt(pageContext.getSession().getAttribute("idAccion").toString());
            UsuarioJpaController jpa_usuario = new UsuarioJpaController();
            List lst_usuarios = null;
//</editor-fold>
            if (sesion.getAttribute("Documento") != null || sesion.getAttribute("Nombres") != null || sesion.getAttribute("NombreRol") != null) {
                int idUsuario = Integer.parseInt(pageContext.getSession().getAttribute("idUsuario").toString());
                String nombre = (String) sesion.getAttribute("Nombres");
                String rol = (String) sesion.getAttribute("NombreRol");
                out.print("<div style=\"float:right; margin-top:14px; margin-right:10px;\"><a  style='font-size: 12.2px;color: #fff;text-decoration: none;Font-weight: 700;outline: none;text-align: center;' href='#' onclick=\"ReestablecerPass('" + idUsuario + "');\">Restablecer contraseña</a></div>");
            } else {
       

            }
        } catch (Exception e) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, e);
        }
        return super.doStartTag();

    }

}
