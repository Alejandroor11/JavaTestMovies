/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tags;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Alejandro
 */
public class alerta extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            //            <editor-fold defaultstate="collapsed" desc="FORMULARIO CAMBIAR CONTRASEÑA">
            if (pageContext.getRequest().getAttribute("Alerta").toString().equals("Cambio_contraseña")) {
                String id_usuario = pageContext.getRequest().getAttribute("idUsuario").toString();
                out.print("<div class='sweet-local' style='opacity: 1.03; display: flex; margin:auto;align-items: center;'>");
                out.print("<fieldset class='popup_local' style='margin-left:-20%;margin-top:-13%;width:45%;'>");
                out.print("<center><b style='color:black;'>Cambiar Contraseña</b></center>");
                out.print("<form action='sesion?opc=2' method='post'>");
                out.print("<center>");
                out.print("<input type='hidden' id='usuario'  name='Id_usuario'Id_usuario value='" + id_usuario + "' />");
                out.print("<input type='password' id='pass-input' class='placeholder-white' placeholder='Nueva Contraseña' style='border-bottom: solid 1px gray; border-left: none;border-right: none;border-top: none;position:relative;top:2px'>&nbsp;&nbsp;&nbsp;");
                out.print("<script>");
                out.print("var validatedObj = new LiveValidation('pass-input');");
                out.print("validatedObj.add(Validate.Password);");
                out.print("validatedObj.add(Validate.Presence);");
                out.print("</script>");
                out.print("<input type='password' id='confpass-input' class='placeholder-white' name='Txt_password' placeholder='Confirmar Contraseña' style='border-bottom: solid 1px gray; border-left: none;border-right: none;border-top: none;position:relative;top:2px' >");
                out.print("<script>");
                out.print("var validatedObj = new LiveValidation('confpass-input');");
                out.print("validatedObj.add(Validate.Password);");
                out.print("validatedObj.add(Validate.Confirmation, { match: 'pass-input' });");
                out.print("</script>");
                out.print("</center>");
                out.print("<div style='float:right;'><img src='Interfaz/Contenido/images/spy.gif' alt='Logo' width='200' height='150' style='margin-right: 40px;' /></div>");
                out.print("<div class='Ayuda'>");
                out.print("<div class='label_info' style='text-align:left'><label style='color:#008063'>El cambio de Contraseña debe contener:<br />"
                        + "-Minimo 8 caracteres<br/>\n"
                        + "-Maximo 15 caracteres<br/>\n"
                        + "-Al menos una letra mayúscula<br/>\n"
                        + "-Al menos una letra minúscula<br/>\n"
                        + "-Al menos un dígito ( Numero )<br/>\n"
                        + "-No espacios en blanco<br/>\n"
                        + "-Al menos 1 caracter especial ( $@$!%*?&#- )</label></div>");
                out.print("</div>");
                out.print("<center>");
                out.print("<br><input type='submit' value='Cambiar'>");
                out.print("</center>");
                out.print("</form>");
                out.print("</fieldset></div>");
            }
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ALERTA USUARIOS">
            if (pageContext.getRequest().getAttribute("Alerta").toString().equals("Registro_usuario")) {
                out.print("<script language='javascript' type='text/javascript'>");
                out.print("swal('Exito','El usuario se ha registrado correctamente.','success');");
                out.print("</script>");
            }

            if (pageContext.getRequest().getAttribute("Alerta").toString().equals("Modificar_usuario")) {
                out.print("<script language='javascript' type='text/javascript'>");
                out.print("swal('Exito','El usuario se ha modificado correctamente.','success');");
                out.print("</script>");
            }
            if (pageContext.getRequest().getAttribute("Alerta").toString().equals("Usuario_no_existe")) {
                out.print("<script language='javascript' type='text/javascript'>");
                out.print("swal('Error','El usuario ingresado no se encuentra registrado.','error');");
                out.print("</script>");
            }
            if (pageContext.getRequest().getAttribute("Alerta").toString().equals("Usuario_desactivado")) {
                out.print("<script language='javascript' type='text/javascript'>");
                out.print("swal('Error','El usuario se encuentra desactivado.','error');");
                out.print("</script>");
            }
            if (pageContext.getRequest().getAttribute("Alerta").toString().equals("Usuario_eliminado")) {
                out.print("<script language='javascript' type='text/javascript'>");
                out.print("swal('Exito','El usuario se ha eliminado correctamente.','success');");
                out.print("</script>");
            }
            if (pageContext.getRequest().getAttribute("Alerta").toString().equals("password_actualizada")) {
                out.print("<script language='javascript' type='text/javascript'>");
                out.print("swal('Exito','La contraseña fue actualizada correctamente.','success');");
                out.print("</script>");
            }  if (pageContext.getRequest().getAttribute("Alerta").toString().equals("password_restablecida")) {
                out.print("<script language='javascript' type='text/javascript'>");
                out.print("swal('Exito','La contraseña fue reestablecida al año en curso.','success');");
                out.print("</script>");
            }
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ALERTAS PELICULA">
            if (pageContext.getRequest().getAttribute("Alerta").toString().equals("Registro_pelicula")) {
                out.print("<script language='javascript' type='text/javascript'>");
                out.print("swal('Exito','La pelicula se ha registrado correctamente.','success');");
                out.print("</script>");
            }
            if (pageContext.getRequest().getAttribute("Alerta").toString().equals("Modificar_pelicula")) {
                out.print("<script language='javascript' type='text/javascript'>");
                out.print("swal('Exito','La pelicula se ha modificado correctamente.','success');");
                out.print("</script>");
            }
            if (pageContext.getRequest().getAttribute("Alerta").toString().equals("Pelicula_eliminada")) {
                out.print("<script language='javascript' type='text/javascript'>");
                out.print("swal('Exito','La pelicula se ha eliminado correctamente.','success');");
                out.print("</script>");
            }
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ARLETA TRAILER">
            if (pageContext.getRequest().getAttribute("Alerta").toString().equals("Registro_trailer")) {
                out.print("<script language='javascript' type='text/javascript'>");
                out.print("swal('Exito','El trailer se ha registrado correctamente.','success');");
                out.print("</script>");
            }

            if (pageContext.getRequest().getAttribute("Alerta").toString().equals("Modificar_trailer")) {
                out.print("<script language='javascript' type='text/javascript'>");
                out.print("swal('Exito','El trailer se ha modificado correctamente.','success');");
                out.print("</script>");
            }
            if (pageContext.getRequest().getAttribute("Alerta").toString().equals("Eliminar_trailer")) {
                out.print("<script language='javascript' type='text/javascript'>");
                out.print("swal('Exito','El trailer se ha eliminado correctamente.','success');");
                out.print("</script>");
            }
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="ARLETA ERRORES">
            if (pageContext.getRequest().getAttribute("Alerta").toString().equals("Error_registro")) {
                out.print("<script language='javascript' type='text/javascript'>");
                out.print("swal('Error','Ha ocurrido un error al registrar.','error');");
                out.print("</script>");
            }
            if (pageContext.getRequest().getAttribute("Alerta").toString().equals("Error_modificar")) {
                out.print("<script language='javascript' type='text/javascript'>");
                out.print("swal('Error','Ha ocurrido un error al modificar.','error');");
                out.print("</script>");
            }
            if (pageContext.getRequest().getAttribute("Alerta").toString().equals("Error_eliminar")) {
                out.print("<script language='javascript' type='text/javascript'>");
                out.print("swal('Error','Ha ocurrido un error al eliminar.','error');");
                out.print("</script>");
            }
            if (pageContext.getRequest().getAttribute("Alerta").toString().equals("Error_estado")) {
                out.print("<script language='javascript' type='text/javascript'>");
                out.print("swal('Error','Ha ocurrido un error al cambiar de estado.','error');");
                out.print("</script>");
            }
            //</editor-fold>
        } catch (Exception e) {
            Logger.getLogger(alerta.class.getName()).log(Level.SEVERE, null, e);
        }
        return super.doStartTag();
    }

}
