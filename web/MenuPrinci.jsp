<%-- 
    Document   : Menu
    Created on : 08-mar-2015, 20:41:01
    Author     : Familia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>   
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script lang="javascript">
        function abrirVentana() {
            open("init.jsp", "miventana", "toolbar=no, directories=yes, menubar=no, status=no, resizable=yes,scrollbars=no");
        }
    </script>
    <body>

        <div id="fondoMe">       
            <img id="img" src="Imagenes/Logo.png" width="150" height="150"/>
            <hr aling=left noshade size:5 width:70px color="#00a383"> 

        </div>
        <div class="menu" id="menu" >
            <ul id="boton">
                <a href="Inicio.jsp" id="letra" target="Pprincipal">  <li> <center> Inicio </center>  </li> </a>
                <a href="./CatalogoPrinServlet?action=listar" id="letra" target="Pprincipal"> <li>  <center> Catálogo </center>  </li> </a>
                <a href="Contactenos.jsp" id="letra" target="Pprincipal">  <li>  <center> Contáctanos</center> </li> </a>  
                <a href="Registrese.jsp" id="letra" target="Pprincipal">  <li>  <center> Regístrese</center> </li> </a>  
                <a href="#" id="letra" onclick="abrirVentana()">  <li>  <center> Ingresar </center> </li> </a>  
            </ul>
        </div>

       <!-- <a id="in" href=""> 
            <center>  <p id="c"  onclick="abrirVentana()"> INGRESAR </p>  </center> 
        </a>-->
    </body>
    <style type="text/css">

        #img{
            position: absolute;
            margin-left: 7%;
            transition: 2s;
        }
        #img:hover{
            box-shadow: 0px 0px 20px #ddd;
            transition: 2s;
        }

        #fondoMe{
            margin-top: -1.6%;
            position:absolute;
            background:	#00342A ;
            height: 120%;
            width: 150%;
            margin-left: -1%;

        }
        hr{
            margin-top: 6.5%; 
        }

        #menu{
            margin-left:  22%; 

        }
        #menu a li  {
            display: inline;
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
            background-color:  white;
            color: black;
            font-family: Arial;
            font-size: 14px;
            border-radius: 10px;
            transition: 1s;
        }
        #letra:hover{
            background: rgba(0,0,0,0);
            color: white;
            transition: 1s;
            box-shadow: 0px 0px 20px #ddd;
            -webkit-transform: scale(1.2);
        }

        #c{
            position: absolute;
            margin-top: 5px;
            margin-left: 15%;
            font-family: Arial;
            text-decoration: none;
            font-size: 15px;
        }


        #in:hover{
            background: white;
            color: #00A383;

        }


    </style>
</html>
