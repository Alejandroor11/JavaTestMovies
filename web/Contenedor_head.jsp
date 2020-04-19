<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="image/png" href="Interfaz/Contenido/images/MoviesLogo.png" rel="icon" >
<link  rel="stylesheet" type="text/css" href="Interfaz/Contenido/Css/CSS_Principal.css" />
<!--Validaciones-->
<script type="text/javascript" src="Interfaz/Validacion/LiveValidation.js"></script>
<link rel="stylesheet" type="text/css" href="Interfaz/Validacion/StyleSheetLiveValidation.css">
<!--  ALERTAS  --->
<script src="Interfaz/Alertas/dist/sweetalert.min.js" type="text/javascript"></script>
<link href="Interfaz/Alertas/dist/sweetalert2018.css" rel="stylesheet" type="text/css"/>
<!--Paginacion-->
<script type="text/javascript" src="Interfaz/Paginas/paging.js"></script>
<!--Filtrar-->
<script type="text/javascript" src="Interfaz/Paginas/filtro.js"></script>
<!-- CSS Menu -->
<link rel="stylesheet" type="text/css" href="Interfaz/Contenido/Css/CSS_Menu.css" />
<link rel="stylesheet" type="text/css" href="Interfaz/Tabs/tabs.css" />
<link rel="stylesheet" type="text/css" href="Interfaz/Checkbox/magic-input.css" />
<!-- JQuery desplega menu -->
<script type="text/javascript" src="Interfaz/Contenido/Scripts/JS_Menu_Min.js"></script>
<!-- JQuery desplega menu -->
<script type="text/javascript" src="Interfaz/Contenido/Scripts/JS_Menu.js"></script>
<!-- Menu flotante -->
<script src="Interfaz/Contenido/Scripts/jquery-1.10.2.js"></script>
<!--CALENDARIOS-->
<script src="Interfaz/Calendarios/moment.js" type="text/javascript"></script>
<link href="Interfaz/Calendarios/pikaday.css" rel="stylesheet" type="text/css"/>
<script src="Interfaz/Calendarios/pikaday.js" type="text/javascript"></script>
<!--EDITOR-->
<script language="javascript" type = "text/javascript" src = "tinyfck/tiny_mce.js"></script>
<script language="javascript" type = "text/javascript" src = "tinyfck/HTMLEditor.js"></script>
<!-- JavaScript desplega menu -->
<script type="text/javascript">
    ddsmoothmenu.init({
        mainmenuid: "templatemo_menu", //menu DIV id
        orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
        classname: 'ddsmoothmenu', //class added to menu's outer DIV
        //customtheme: ["#1c5a80", "#18374a"],
        contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
    });
</script>
<script type="text/javascript">
    function mostrar(id, idProceso, activoUsado) {
        if (document.getElementById("emergente" + id).style.display === "none") {
            document.getElementById("emergente" + id).style.display = "block";
            document.getElementById("idProcesoM").value = idProceso;
            document.getElementById("activoUsado").value = activoUsado;
        } else if (document.getElementById("emergente" + id).style.display === "block") {
            document.getElementById("emergente" + id).style.display = "none";
        }
        for (i = 0; i < document.form1.elements.length; i++) {
            if (document.form1.elements[i].type === "checkbox") {
                var contenido = document.form1.elements[i].value;
                if (activoUsado.includes(contenido)) {
                    document.form1.elements[i].checked = 1;
                }
            }
        }
    }
    function mostrarVentana(id) {
        if (document.getElementById("Ventana" + id).style.display === "none") {
            document.getElementById("Ventana" + id).style.display = "block";
        } else if (document.getElementById("Ventana" + id).style.display === "block") {
            document.getElementById("Ventana" + id).style.display = "none";
        }
    }
    
</script>
<script type="text/javascript" language="javascript">
    function ReestablecerPass(idUsuario) {
        swal({
            title: "Restablecer!",
            text: "Seguro que desea restablecer contraseña?",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#42ff33",
            confirmButtonText: "Aceptar",
            cancelButtonText: "Cancelar",
            closeOnConfirm: false
        },
                function () {
                    location.href = 'usuario?opc=5&idUser=' + idUsuario + '';
                });
    }
    
</script>

