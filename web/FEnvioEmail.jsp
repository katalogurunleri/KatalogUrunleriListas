<%
    String men = (String) request.getAttribute("mensaje") != null ? (String) request.getAttribute("mensaje") : null;
%>
<title>Recordar Contraseña</title>
<script language="JavaScript">
    window.moveTo(0, 0);
    window.resizeTo(700, 250);
</script>
<body>
    <form id="fondoformulario" name ="xForm" method="POST" action="./CorreoServlet">
        <div id="fondo">

        </div>
        <center>
            <div id="inf">
                <img src="Imagenes/Logo.png" width="100" height="100" >
                <table>
                    <tr>
                        <td id="text">Email</td>
                        <td> <input type="text"  name="txtemail"   id ="estilo" size="30"></td>     
                        <td><button type="submit" class="btn1" name="action" value="envio" > Envio</button></td>
                    </tr>
                </table>
                <%if (men != null) {%>
                <%=men%>
                <%}%>
            </div>
        </center>
    </form>
</body>
<style type="text/css">
    body{
        background-image: url(Imagenes/fondo.png);  
    }
    #text{
        font-family: Arial;
        font-size: 105%;
    }
    #inf{
        position: absolute;
        margin-left: 27%;
    }
    #fondo{
        background: white;
        opacity: 0.5;
        position: absolute;
        width: 50%;
        height: 80%;
        margin-left: 25%;
        margin-top: 0.5%;
        position: absolute;      
        -webkit-box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
        -moz-box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
        box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
    }
    
</style>
<!--  Melany estuvo aqui -->