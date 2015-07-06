<%-- 
    Document   : FBotones
    Created on : 21/05/2014, 08:06:56 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/botones.css">
<table><tr>
        <td id="espa"><button id="fboton" class="bot" type="submit" name="action" value="nuevo">Nuevo</button> </td>

        <td id="espa"><button id="fboton" class="bot" type="submit" name="action" value="guardar">Guardar</button> </td>     

        <td id="espa"><button id="fboton" class="bot" type="submit" name="action" value="buscar">Buscar</button> </td>    

        <td id="espa"><button id="fboton" class="bot" type="submit" name="action" value="editar">Actualizar</button> </td>   

        <td id="espa"><button id="fboton" class="bot" type="submit" name="action" value="listar">Listar</button> </td>     

    </tr></table>
<br>
<style type="text/css">



    #fboton{
        background: #00342A;
        font-family: Arial;
        height: 40px;
        width: 100px;
        color:  white;
        font-size: 80%;
        border: none;
        border-radius: 10px 10px;
        padding-left: 2%;
        padding-right: 2%;
        padding-top: 2%;
        padding-bottom: 2%;
        margin-left:10%;       
        transition: 1s;


    }
    #fboton:hover{
        color: white;
        background: #00A383;
        font-size: 120%;
        transition: 1s;
        box-shadow: inset 0 0 0 1px black;
        -webkit-transform: scale(1.1);
    }
</style>
