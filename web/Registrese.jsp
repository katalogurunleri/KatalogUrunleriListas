<%-- 
    Document   : Registrese
    Created on : 10/07/2015, 10:55:11 PM
    Author     : Brayan Sosa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div id="centro">
            <center>
                <h1 id="titu">Crea tu cuenta</h1>
                <hr aling=left noshade size:5 width:70px color="#00a383"> 
                <table>
                    <tr>
                        <td id="tex"><b>Nombre*</b></td>
                    </tr>
                    <tr>
                        <td><input type="text" placeholder="Nombre (s)" name="txtnombre" size="20" maxlength="30" /></td>
                        <td><input type="text" placeholder="Apellido (s)" name="txtapellidos" size="20" maxlength="30" /></td>
                    </tr>
                    <tr>
                        <td id="tex"><b>Correo*</b></td>
                        <td id="tex"><b>Cédula*</b></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="txtemail" size="20" maxlength="60" value="@" /></td>
                        <td colspan="2"><input type="text" placeholder="Digite su cédula" name="txtemail" size="20" maxlength="60" /></td>
                    </tr>
                    <tr>
                        <td id="tex"><b>Contraseña*</b></td>
                    </tr>
                    <tr>
                        <td><input type="text" placeholder="Contraseña" name="txtnombre" size="20" maxlength="30" /></td>
                        <td><input type="text" placeholder="Confirmación de contraseña" name="txtapellidos" size="20" maxlength="30" /></td>
                    </tr>
                    <tr>
                        <td id="tex"><b>Teléfono*</b></td>
                        <td id="tex"><b>Dirección*</b></td>
                    </tr>
                    <tr>
                        <td><input type="text" placeholder="Teléfono" name="txtnombre" size="20" maxlength="30" /></td>
                        <td><input type="text" placeholder="Dirección" name="txtapellidos" size="20" maxlength="30" /></td>
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
