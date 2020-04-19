<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/tlds/alerta.tld" prefix="alerta" %>
<%@taglib uri="/tlds/index.tld" prefix="index" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Peliculas</title>
        <jsp:include page="Contenedor_head.jsp"></jsp:include>
        </head>
        <body>
            <div id="templatemo_wrapper">
            <index:index/>
            <alerta:alerta/>
            <div id="popUp2" class="modal2" onclick="javascript:document.getElementById('popUp2').style.display = 'none'">
                <img class="modal2-content" id="imgReq" style="width: auto; height: auto;"/>
            </div>
        </div>
    </body>
</html>