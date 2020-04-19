<%-- 
    Document   : pelicula
    Created on : 17-abr-2020, 21:05:16
    Author     : Alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/tlds/index.tld" prefix="index" %>
<%@taglib uri="/tlds/pelicula.tld" prefix="pelicula" %>
<%@taglib uri="/tlds/alerta.tld" prefix="alerta"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Peliculas</title>
        <jsp:include page="Contenedor_head.jsp"></jsp:include>
            <script type="text/javascript">
                history.pushState(null, null, 'pelicula.jsp');
                window.addEventListener('popstate', function (event) {
                    history.pushState(null, null, 'pelicula.jsp');
                });

                function SeleccionFechas(tfc) {
                    document.getElementById('Txt_filtro_fecha').value = "" + tfc;
                }
            </script>
            <script type="text/javascript">
                function Filtrartodo() {
                    Filtrar();
                }
                function Abrir_img_pel(imgs) {
                    var img = document.getElementById(imgs);
                    var modal = document.getElementById('popUp2');
                    var modalImg = document.getElementById("imgReq");
                    modal.style.display = "block";
                    modalImg.src = img.src;
                }
            </script>

        </head>
        <body id="subpage">
            <div id="templatemo_wrapper">
            <index:index/>
            <pelicula:pelicula/>
            <alerta:alerta/>
            <div id="popUp2" class="modal2" onclick="javascript:document.getElementById('popUp2').style.display = 'none'">
                <img class="modal2-content" id="imgReq" style="width: auto; height: auto;"/>
            </div>
        </div>
    </body>
</html>
