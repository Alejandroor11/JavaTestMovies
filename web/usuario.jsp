<%-- 
    Document   : usuario
    Created on : 17-abr-2020, 21:04:39
    Author     : Alejandro
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/tlds/index.tld" prefix="index" %>
<%@taglib uri="/tlds/usuario.tld" prefix="usuario" %>
<%@taglib uri="/tlds/alerta.tld" prefix="alerta"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Peliculas</title>
        <jsp:include page="Contenedor_head.jsp"></jsp:include>
            <script type="text/javascript">
                 history.pushState(null, null, 'usuario.jsp');
                window.addEventListener('popstate', function (event) {
                    history.pushState(null, null, 'usuario.jsp');
                });
                
            </script>
        </head>
        <body id="subpage">
            <div id="templatemo_wrapper">
            <index:index/>
            <alerta:alerta/>
            <usuario:usuario/>
        </div>
    </body>
</html>
