/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tags;

import Controlador.PeliculaJpaController;
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
public class pelicula extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            //<editor-fold defaultstate="collapsed" desc="VARIABLES">
            HttpSession sesion = pageContext.getSession();
            PeliculaJpaController jpa_peli = new PeliculaJpaController();
            List lst_pelis = null;
            lst_pelis = jpa_peli.consultaPelicula();
            String cadena = "";
            int idAccion = Integer.parseInt(pageContext.getRequest().getAttribute("idAccion").toString());
//</editor-fold>
            if (pageContext.getRequest().getAttribute("Accion").equals("Registro_pelicula")) {
                //<editor-fold defaultstate="collapsed" desc="REGISTRAR">
                out.print("<div class='sweet-local' tabindex='-1' name='FormReg' id='emergente1' style='opacity: 1.03; display:none;'>");
                out.print("<fieldset class='popup_local  scrollbar' id='styleScroll' style='width:75%; height:62%; position: absolute;top:10%; left:10%; text-align:left; padding:20px;'>");
                out.print("<a href='pelicula?opc=1&idAccion=0'><img src='Interfaz/Contenido/Iconos/Delete.png' width='20px' height='20px' alt='edit' title='Volver al inicio' style='margin-top:-1%; margin-left:99%;'/></a>");
                out.print("<legend>Registrar Pelicula</legend>");
                out.print("<div style=' overflow:scroll; width:101%; height:95%; float:left;'>");

                out.print("<form action='pelicula?opc=2' name='FormReg' method='post'>");
                out.print("<div style='width:100%; float:left;'>");
                out.print("<b style='color:#2F3640'>Descripción :</b><br>");
                out.print("<textarea name='Txt_descripcion' id='descripcion-id' style='width:600px; height:450px;'>"
                        + "<b style='color:#42FF33'>Nombre/Descripcion</b><div contenteditable='true'><p></p></div><hr>"
                        + "<b style='color:#42FF33'>Imagen</b><div contenteditable='true'><p></p></div><hr>"
                        + "<b style='color:#42FF33'>Url Trailer</b><div contenteditable='true'><p></p></div></textarea>");
                out.print("</div><br>");
                out.print("<br><div style='width:25%; height:48%; float:left;'>");
                out.print("<b style='color:#2F3640'>Categoria</b><br>");
                out.print("<select name='Cbx_categoria' id='Cbx_categoria' title='Categoria'>");
                out.print("<option value='0' style='display:none' selected>Seleccionar</option>");
                out.print("<option value='Accion'>Accion</option>");
                out.print("<option value='Drama'>Drama</option>");
                out.print("<option value='Comedia'>Comedia</option>");
                out.print("<option value='Terror'>Terror</option>");
                out.print("</select>"
                        + "<script type='text/javascript'>var mySelect = new LiveValidation('Cbx_categoria');"
                        + "mySelect.add(Validate.Exclusion, { within: ['0'], failureMessage: \"\"});</script>&bnsp");
                out.print("<div style='margin-left:95%; margin-top:-12%'>");
                out.print("<input type='submit' value='Registrar'>");
                out.print("</div>");
                out.print("</div>");

                out.print("</form>");
                out.print("</fieldset></div>");
                //</editor-fold>
            } else if (pageContext.getRequest().getAttribute("Accion").equals("Modificar_pelicula")) {
                //<editor-fold defaultstate="collapsed" desc="MODIFICAR">
                lst_pelis = jpa_peli.consultaPeliculaId(idAccion);
                Object[] obj_peli = (Object[]) lst_pelis.get(0);
                out.print("<div class='sweet-local' tabindex='-1' id='emergente' style='opacity: 1.03; display:block;'>");
                out.print("<fieldset class='popup_local  scrollbar' id='styleScroll' style='width:75%; height:65%; position: absolute;top:10%; left:10%; text-align:left; padding:20px;'>");

                out.print("<a href='pelicula?opc=1&idAccion=0'><img src='Interfaz/Contenido/Iconos/Delete.png' width='20px' height='20px' alt='edit' title='Volver al inicio' style='margin-top:-1%; margin-left:99%;'/></a>");
                out.print("<legend>Modificar Pelicula</legend>");
                out.print("<div style=' overflow:scroll; width:101%; height:95%; float:left;'>");
                out.print("<form action='pelicula?opc=3' method='post'>");
                out.print("<b style='color:#2F3640'>Descripción :</b><br>");
                out.print("<input type='hidden' name='idAccion' value='" + obj_peli[0] + "'>");
                out.print("<textarea name='Txt_descripcionM' id='descripcion-id' style='width:600px; height:400px;'>" + obj_peli[2].toString().replace("<div>", "<div contenteditable='true'>") + "</textarea>");
                out.print("<br><div style='width:25%; height:48%; float:left;'>");
                out.print("<b style='color:#2F3640'>Categoria</b><br>");
                out.print("<select name='Cbx_categoria' id='Cbx_categoria' title='Categoria'>");
                out.print("<option selected>" + obj_peli[1] + "</option>");
                out.print("<option value='Accion'>Accion</option>");
                out.print("<option value='Drama'>Drama</option>");
                out.print("<option value='Comedia'>Comedia</option>");
                out.print("<option value='Terror'>Terror</option>");
                out.print("</select>"
                        + "<script type='text/javascript'>var mySelect = new LiveValidation('Cbx_categoria');"
                        + "mySelect.add(Validate.Exclusion, { within: ['0'], failureMessage: \"\"});</script>&bnsp");
                out.print("<div style='margin-left:95%; margin-top:-20%'>");
                out.print("<br><input type='submit' value='Modificar'>");
                out.print("</div>");
                out.print("</div>");
                out.print("</form>");
                out.print("</fieldset></div>");
                //</editor-fold>
            }
            //<editor-fold defaultstate="collapsed" desc="CONSULTAR">
            out.print("<div id='content_sin'>");
            out.print("<div style='margin-right:10%;'>");
            out.print("<h3><a href='#' onclick=\"mostrar(\'1\')\"><img id='cambiar' src='Interfaz/Contenido/Iconos/Plus.png' width='20px' height='20px' title='Registrar'/>Registrar</h3></a>");
            out.print("</div><br>");
            lst_pelis = jpa_peli.consultaPelicula();
            //<editor-fold defaultstate="collapsed" desc="CONSULTA TABLA">
            Object[] obj_activo = (Object[]) lst_pelis.get(0);
            out.print("<div align='left' id='NavPosicion'></div>");
            out.print("<div style='float: right; margin: 15px;'>&nbsp;&nbsp;<input id='Txt_filtro' type='text' onkeyup='Filtrartodo()' placeholder='Buscar' onchange='javascript:this.value=this.value.toUpperCase();' /></div>");
            out.print("<table id='resultados0' class='table' style='width:100%'>");
            out.print("<tr>");
            out.print("<th>Imagen Actual</th>");
            out.print("<th>Descripcion/Categoria</th>");
            out.print("<th>Opc</th>");
//            if (!rol.equals("CONSULTA")) {
//                out.print("<th colspan='2'>Opc</th>");
//            }
            out.print("</tr>");
            if (lst_pelis == null) {
                out.print("<tr><td colspan='8' align='center'>");
                out.print("<img src='Interfaz/Contenido/Iconos/Alert.png' style=' width:100.5px;height:80.75px' alt='edit' title='No se encontraron datos' /><br />");
                out.print("<br><b>No se encontraron Peliculas</b>");
                out.print("</td></tr>");
                out.print("</table>");
            } else {
//                Object[] obj_activo = (Object[]) lst_pelis.get(0);
                for (int i = 0; i < lst_pelis.size(); i++) {
//                 if (Integer.parseInt(obj_activo[6].toString()) == id_area) {
                    Object[] obj_pelis = (Object[]) lst_pelis.get(i);
                    //<editor-fold defaultstate="collapsed" desc="DESCRIPCIÓN/FOTO/ORDEN COMPRA">
                    String contenido = obj_pelis[2].toString();
                    String contenido2 = obj_pelis[2].toString();
                    String[] partes = contenido.split("<hr />");
                    String[] partes2 = contenido2.split("<hr />");
                    //</editor-fold>       
                    out.print("<tr>");
//                    out.print("<td align='center' style='width:1%'>ID:<b> " + obj_pelis[0] + "</b><hr>");

                    out.print("<td valign='top' style='width:15%'>");
                    if (partes[2].contains("a href=")) {
                        out.print("<a title='" + partes[0] + "' href='" + partes[2] + "'><img style='width:200px; height:200px;' src='" + partes[1] + "'<br></a>");
//                        out.print("" + partes[2] + "<br>");
                    }
                    out.print("<td valign='top' style='width:30%'>");
                    if (partes[0] == null || partes[0] == "") {
                        out.print("NINGUNA");
                    } else if (partes[0].toString().contains("<img")) {
                        String[] arg_img = partes[0].toString().split("<img");
                        for (int k = 0; k < arg_img.length; k++) {
                            if (k == 0) {
                                cadena = arg_img[k];
                            } else {
                                cadena = cadena + "<img style='width:20px; height:20px;' class='content_sin' id='Img_0" + k + "' onclick=\"Abrir_img_act('Img_0" + k + "');\" " + arg_img[k];
                            }
                        }
                        out.print("" + cadena);
                    } else {
                        out.print("" + partes[0]);
                    }
                    if (partes[1].contains("<img") || partes[1].contains("a href=")) {
                        if (partes[1] == null || partes[1] == "") {
                            out.print("NINGUNA");
                        } else if (partes[1].toString().contains("<img")) {
                            String[] arg_img = partes[1].toString().split("<img");
                            for (int k = 0; k < arg_img.length; k++) {
                                if (k == 0) {
                                    cadena = arg_img[k];
                                } else {
                                    cadena = cadena + "<img style='width:20px; height:20px;' class='content_sin' id='Img_1" + k + "' onclick=\"Abrir_img_act('Img_1" + k + "');\" " + arg_img[k];
                                }
                            }
                            out.print("<hr />" + cadena);
                        } else {
                            out.print("<hr />" + partes[1]);
                        }
                    }
                    if (partes2[2].contains("<img") || partes2[2].contains("a href=")) {
                        if (partes[2] == null || partes[2] == "") {
                            out.print("NINGUNA");
                        } else if (partes[2].toString().contains("<img")) {
                            String[] arg_img = partes[2].toString().split("<img");
                            for (int k = 0; k < arg_img.length; k++) {
                                if (k == 0) {
                                    cadena = arg_img[k];
                                } else {
                                    cadena = cadena + "<img style='width:20px; height:20px;' class='content_sin' id='Img_2" + k + "' onclick=\"Abrir_img_act('Img_2" + k + "');\" " + arg_img[k];
                                }
                            }
                            out.print("<hr />" + cadena);
                        } else {
                            out.print("<hr />" + partes[2]);
                        }
                    }
                    out.print("<b>Categoria: </b>" + obj_pelis[1] + "</td>");
                    //<editor-fold defaultstate="collapsed" desc="OPCIONES">
                    out.print("<td valign='center' align='center' style='width:15%'>");
                    out.print("<a href='pelicula?opc=4&idAccion="+ obj_pelis[0] +"'><img src='Interfaz/Contenido/Iconos/Trash.png' width='20px' height='20px' title='Eliminar'/></h3></a>"
                            + "<hr><a href='pelicula?opc=1&idAccion=" + obj_pelis[0] + "'><img src='Interfaz/Contenido/Iconos/Edit.png' width='25px' height='25px' alt='edit' title='Editar' /></a>");
                    out.print("</td'>");

                    //</editor-fold>
                }
                out.print("</tr>");
//            }
                out.print("</table>");
                out.print("<script type='text/javascript'>");
                out.print("var pager = new Pager('resultados', 10);");
                out.print("pager.init();");
                out.print("pager.showPageNav('pager','NavPosicion');");
                out.print("pager.showPage(1);");
                out.print("</script>");
                out.print("</div> <!-- END of content -->");
                out.print("<div class='cleaner'></div>");
                //</editor-fold>
            }
            //</editor-fold>
        } catch (Exception e) {
            Logger.getLogger(pelicula.class.getName()).log(Level.SEVERE, null, e);
        }
        return super.doStartTag();
    }

}
