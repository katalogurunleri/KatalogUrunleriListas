<%@page import="java.util.List"%>
<%@page import="com.KatalogÜrünleri.Entidades.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String cod = request.getParameter("");
    String nom = request.getParameter("");
    String des = request.getParameter("");
    String exi = request.getParameter("");
    String val = request.getParameter("");
    String fot = request.getParameter("");
    String est = request.getParameter("");

    String men = (String) request.getAttribute("mensaje") != null ? (String) request.getAttribute("mensaje") : "";

    List<Producto> LP = (List<Producto>) request.getAttribute("listado");
//vamos a recibir atributo para la consulta de un dato
    Producto datop = (Producto) request.getAttribute("datoproducto") != null ? (Producto) request.getAttribute("datoproducto") : null;
    if (datop != null) {
        cod = datop.getCodpro();
        nom = datop.getNombre();
        des = datop.getDescripcion();
        exi = datop.getExistencias();
        val = datop.getValor();
        fot = datop.getFoto();
        est = datop.getEstado();
    }// fin si

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="jq/jquery-ui.css">
        <script src="jq/jquery-1.10.2.js"></script>
        <script src="jq/jquery-ui.js"></script>
        <link rel="stylesheet" href="/resources/demos/style.css">

    </head>

    <div id="centro">
        <form name="Xfrom" action="./ProductoServlet?action=listar" method="POST">
            <center><h1 id="titu"> Catálogo </h1>
                <h5 style="font-family: Arial; margin-bottom: -2%;">Clic en la imagen para mas información del producto</h5></center>
            <BR>
            <hr aling=left noshade size:5 width:70px color="#00a383"> 
            <%if (LP != null) {%>
            <% for (Producto pro : LP) {%>
            <%if (pro.getCatprin().equals("Si")) {%>
            
            <script>
                
                $(function() {
                    $("#dialog").dialog({
                        modal: true,
                        autoOpen: false,
                        show: {
                            effect: "blind",
                            duration: 1000
                        },
                        hide: {
                            effect: "explode",
                            duration: 1000
                        }
                    });

                    $("#<%=pro.getCodpro()%>").click(function() {
                        $(".<%=pro.getCodpro()%>").dialog("open");
                    });
                    $("#zoom").elevateZoom({tint: true, tintColour: '#033', tintOpacity: 0.5});
                });


            </script>
            <div id="dialog" class="<%=pro.getCodpro()%>"  title="<%=pro.getNombre()%>">
                <center> <img id="zoom" src="ImaCatalogo/<%=pro.getFoto()%>" height="250" width="250"  id="opener"/>  </center>
                <p width="50%"><b>Código:</b> <%=pro.getCodpro()%> <br> <b>Descripción:</b> <%=pro.getDescripcion()%></p>

            </div>
            <div class="menu" id="menu" >
                <ul id="boton">
                    <li id="letra"> 
                    <center><img id="<%=pro.getCodpro()%>" id="img" src="ImaCatalogo/<%=pro.getFoto()%>" width="80" height="80">
                        <br>
                        <p id="txtcat"><b><%=pro.getNombre()%></b></p>  </center>
                    </li> 
            </div>
            <%}%>  
            <%}%>  
            <%}%>  
            <style type="text/css">
                ul li img{
                    opacity: 1;
                    -webkit-transition: all .6s ease;
                }
                ul li img:hover{
                    border-radius: 200px;
                    box-shadow: 0px 0px 20px #ddd;
                    transition: 2s;
                    -webkit-transform: scale(1.2);
                }

                #img{
                    border-radius: 5%;
                }

                #menu  li  {
                    display: inline;
                    margin-bottom: 2%;
                    margin-top: -0.2%;
                }

                #letra{
                    position: relative;
                    width: 10%;
                    height: 15%;
                    margin-top: 40px;
                    font-size: 125%;
                    text-decoration: none;
                    float: left;
                    padding: 10px;
                    margin-left: 2%;
                    background-color:  #00a383;
                    color: black;
                    font-family: Arial;
                    font-size: 14px;
                    border-radius: 10px;
                }
                #txtcat{
                    font-family: Arial;
                    font-size: 110%;
                }
                #titu{
                    font-family: Arial;
                    color: #00342A;
                    font-size: 250%;
                    margin-bottom: -2%;
                }
                #centro{
                    width: 96%;
                    margin-left: 1%;
                    margin-bottom: 2%;
                    margin-top: 1%;
                    position: absolute;      
                    -webkit-box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
                    -moz-box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
                    box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
                }
            </style>

        </form>
    </div>
</html>