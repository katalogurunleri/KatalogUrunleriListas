<%@page import="com.KatalogÜrünleri.Entidades.Usuario"%>
<%
    String targetModulo = request.getAttribute("targetModulo") == null ? "datos.jsp" : (String) request.getAttribute("targetModulo");

    Usuario entUsuario = (Usuario) session.getAttribute("usuario");
    String user = entUsuario.usuario;
    String nombre = entUsuario.nombre;
    String perfil = entUsuario.perfil ;
    String estado = entUsuario.estado;
    String foto = entUsuario.foto;
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="fondoMe">       
            <a href="FPrincipal.jsp"><img id="imgMe" src="Imagenes/Logo.png" width="150" height="150"/></a>
            <hr aling=left noshade size:5 width:70px color="#00a383"> 
        </div>
        <div class="menuMe" id="menuMe" >
            <ul id="boton">
                <a href="./UsuarioServlet" id="letra">  <li> <center> Usuarios </center>  </li> </a>
                <a href="./ClienteServlet" id="letra">  <li> <center> Clientes </center>  </li> </a>
                <a href="./ProductoServlet" id="letra">  <li> <center> Productos </center>  </li> </a>
                <a href="#" id="letra">  <li> <center> Pedidos </center>  </li> </a>
                <a href="#" id="letra">  <li> <center> Ventas </center>  </li> </a>

            </ul>
        </div>
        <div id="infoPer">

            <div id="fotoMe">
                <%
                    if (foto == null) {
                        foto = "";
                    }
                    if (foto.equals("")) {
                %>
                <center> <img id="foto" src="ImagePerfil/perfil.jpg" width="80" height="80" /> </center>
                    <% } else {%>
                <center> <img id="foto" src="<%="ImagePerfil/" + foto%>" width="80" height="80"  /> </center>
                    <%}%>
            </div>
            <div id="usuaMe">
                <p>
                    <%=nombre%><BR>
                    <%=perfil%>
                </p>
            </div>

        </div>
        <div id="con">
            <ul class="nav">
                <li id="li">
                    <img id="ima" src="Imagenes/ajustes.png" width="20"  height="20"/>
                    <ul id="ul2">
                        <li><a id="a"><center>Perfil</center></a></li>
                        <li ><a id="a" href="./UsuarioServlet?action=salir"><center>Cerrar sesion</center></a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </body>
    <style type="text/css">

        #imgMe{
            position: absolute;
            margin-left: 4%;
            transition: 2s;
        }
        #imgMe:hover{
            box-shadow: 0px 0px 20px #ddd;
            transition: 2s;
        }
        #fondoMe{
            margin-top: 0%;
            position:absolute;
            background:	#00342A ;
            height: 11%;
            width: 150%;
            margin-left: -1%;
            margin-bottom: 1%;

        }
        hr{
            margin-top: 6.6%; 
        }

        .menuMe{
            margin-left:  20%; 

        }
        #menuMe a li  {
            display: inline;

        }

        #letra{
            position: relative;
            width: 10%;
            margin-top: 40px;
            font-size: 125%;
            text-decoration: none;
            float: left;
            padding: 10px;
            margin-left: 2%;
            background-color:  white;
            color: black;
            font-family: Arial;
            font-size: 14px;
            border-radius: 10px;
            transition: 1s;
            list-style-type:none;
        }
        #letra:hover{
            background: rgba(0,0,0,0);
            color: white;
            transition: 1s;
            box-shadow: 0px 0px 20px #ddd;
            -webkit-transform: scale(1.2);
        }
        #in{
            text-decoration: none;
            position: absolute;
            height: 20%;
            width: 8%;
            background: #5fd3b3;
            margin-left: 19%;
            border-radius: 10px;
            color: white;
        }
        #in:hover{
            background: white;
            color: #00A383;

        }
        #usuaMe{
            margin-top: -20%;
            color: white;
            font-family: Arial;
            font-size: 120%;   
        }
        #foto{
            transition: 2s;
        }
        #foto:hover{
            border-radius: 200px;
            box-shadow: 0px 0px 20px #ddd;
            transition: 2s;
            -webkit-transform: scale(1.2);
        }
        #infoPer{
            margin-top: -0.5%;
            margin-left: 87%;
            position: absolute;
        }
        #con{
            margin-left: 95%;
            width:100px;
            position: absolute;
            z-index: 105;
            margin-top: 2%;
        }
        #ima{
            padding: 2px 2px;
            background: white;
            border-radius: 10px;

        }
        #ima:hover{
            transition: 0.4s;
            box-shadow: 0px 0px 20px #ddd;
        }
        #li{
            margin-left: -65%;
            list-style: none;
            color: black;
            font-family: Arial;
            text-decoration: none;

        }
        #a{
            color:black;
            background: white;
            border-radius: 10px;
            text-decoration: none;
            padding: 10px 15px;
            display: block;
        }
        #a:hover{
            background: #00A383;
            transition: 0.4s;
            box-shadow: inset 0 0 0 1px white;
            color: white;
        }
        .nav > #li{
            float: left;
        }
        .nav #li #ul2 li{
            color: black; 
            text-decoration: none;
            list-style: none;
            padding-bottom: 2px;
        }
        .nav #li #ul2{
            display:none;
            position:absolute;
            min-width:160px;
            margin-left: -180px;
            text-decoration: none;
        }
        .nav #li:hover> #ul2{
            display:block;
        }
    </style>
</html>
