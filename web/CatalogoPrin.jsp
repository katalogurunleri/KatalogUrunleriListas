<%@page import="java.util.List"%>
<%@page import="com.KatalogÜrünleri.Entidades.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String men = (String) request.getAttribute("mensaje") != null ? (String) request.getAttribute("mensaje") : "";
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
              <!--  <h5 style="font-family: Arial; margin-bottom: -2%;">Clic en la imagen para mas información del producto</h5></center>-->
            <BR>
            <hr aling=left noshade size:5 width:70px color="#00a383"> 
           <%=men%>
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