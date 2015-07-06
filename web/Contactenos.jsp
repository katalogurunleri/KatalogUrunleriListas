<%-- 
    Document   : Contactenos
    Created on : 04-jun-2015, 10:33:44
    Author     : Familia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="centro">
            <center>
                <h1 id="titu"> Contáctanos </h1>
                <hr aling=left noshade size:5 width:70px color="#00a383"> 
                <table>
                    <tr>
                        <td id="tex"><b>Nombre completo*</b></td>
                    <td><input type="text" name="txtnombre" size="30" maxlength="30" /></td>
                    </tr>
                    <tr>
                        <td id="tex"><b>Correo electrónico*</b></td>
                    <td><input type="password" name="txtclave" size="30" maxlength="30" /></td>
                    </tr>
                    <tr>
                        <td id="tex"><b>Déjanos <br>tu mensaje*</b></td>
                    <td><textarea type="text" rows="3" cols="30" name="txtdescrip"  maxlength="300"></textarea></td>
                    </tr>
                    <tr> 
                        <td colspan="2" id="cam">Campos con asterisco (*) son obligatorios</td>
                    </tr> 
                    <tr> 
                        <td colspan="2"> <center> <button  style="cursor: pointer" id="Ingresar" type="submit" name="action"  value="enviar" class="btn1" > Enviar </button> </center> </td>
                    </tr>
                </table>
            </center>
        </div>

    </body>



    <style type="text/css">
        #centro{
            width: 50%;
            margin-left: 25%;
            margin-bottom: 2%;
            margin-top: 1%;
            position: absolute;      
            -webkit-box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
            -moz-box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
            box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
        }
        #titu{
            font-family: Arial;
            color: #00342A;
            font-size: 250%;
            margin-bottom: -2%;
        }
        #tex{
            font-family: Arial;
            font-size: 105%;
            color:#00A383;
        }
        #Ingresar{
            background: #00342A;
            font-family: Arial;
            width: 25%; 
            height: 40px;
            color:  white;
            font-size: 80%;
            border: none;
            border-radius: 10px 10px;
            margin-left: 2%;
            margin-bottom: 2%;

        }
        #Ingresar:hover{
            color: white;
            background: #00A383;
            font-size: 120%;
            transition: 0.6s;
            box-shadow: inset 0 0 0 1px black;
            -webkit-transform: scale(1.1);
        }
        #cam{
            color: #00a383;
            font-size: 80%;
            font-family: Arial;
        }
    </style>
</html>
