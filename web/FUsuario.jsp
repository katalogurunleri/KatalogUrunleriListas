<%@page import="java.util.List"%>
<%@page import="com.KatalogÜrünleri.Entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String user = request.getParameter("txtusuario");
    String nombre = request.getParameter("txtnombre");
    String clave = request.getParameter("txtclave");
    String conclave = request.getParameter("txtconclave");
    String perfil = request.getParameter("cboperfil");
    String estado = request.getParameter("cboestado");
    String correo = request.getParameter("txtcorreo");
    String foto = request.getParameter("filefoto");

    String men = (String) request.getAttribute("mensaje") != null ? (String) request.getAttribute("mensaje") : null;

    List<Usuario> LU = (List<Usuario>) request.getAttribute("listado");
//vamos a recibir atributo para la consulta de un dato
    Usuario datou = (Usuario) request.getAttribute("datousuario") != null ? (Usuario) request.getAttribute("datousuario") : null;
    if (datou != null) {
        user = datou.usuario;
        nombre = datou.nombre;
        clave = datou.clave;
        conclave = clave;
        perfil = datou.perfil;
        estado = datou.estado;
        correo = datou.correo;
        foto = datou.foto;
    }// fin si

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset=utf-8 />
    </head>
    <body>
        <div id="centro">
            <center><h1 id="titu"> Usuario </h1></center><br>
            <hr aling=left noshade size:5 width:70px color="#00a383"> 
            <form name="frmusuarios" action="./UsuarioServlet" method="POST">
                <div id="datou">
                    <fieldset id="borde">
                        <legend id="tibo"><b>DATOS DEL USUARIO</b></legend>
                        <table>
                            <tr>
                                <td id="tex"><b>Usuario*</b></td>
                                <td><input type="text" name="txtusuario" value="<%= user != null ? user : ""%>" size="30" maxlength="5" </td>
                            </tr>
                            <tr>
                                <td id="tex"><b>Nombre*</b></td>
                                <td><input type="text" name="txtnombre" value="<%= nombre != null ? nombre : ""%>" size="30" maxlength="30"></td>
                            </tr>
                            <tr>
                                <td id="tex"><b>Contraseña</b>*</td>
                                <td><input type="password" name="txtclave" value="<%= clave != null ? clave : ""%>" size="30" maxlength="16"></td>
                            </tr>
                            <tr>
                                <td id="tex"><b>Confirma la contraseña*</b></td>
                                <td><input type="password" name="txtconclave" value="<%= conclave != null ? conclave : ""%>" size="30" maxlength="16"></td>
                            </tr>
                            <tr>
                                <td id="tex"><b>Perfil*</b> </td>
                                <td>
                                    <select name="cboperfil">
                                        <option value=""> ...Seleccione...</option>
                                        <option value="Administrador"<%if ("Administrador".equals(perfil)) {%> selected<%}%> > Administrador </option>
                                        <option value="Auxiliar"<%if ("Auxiliar".equals(perfil)) {%> selected<%}%>>  Auxiliar</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td id="tex"><b>Estado*</b></td>
                                <td>
                                    <select name="cboestado">
                                        <option value="" >...Seleccione...</option>
                                        <option value="Activo"<%if ("Activo".equals(estado)) {%>selected<%}%> >Activo</option>
                                        <option value="Inactivo"<%if ("Inactivo".equals(estado)) {%>selected<%}%> >Inactivo</option>
                                    </select>
                                </td>
                            </tr>
                            <tr> 
                                <td id="tex"><b>Correo* </b> </td>
                                <td><input type="text" name="txtcorreo" value="<%= correo != null ? correo : ""%>" size="30" maxlength="40"> </td>
                            </tr>
                            <tr>
                                <%
                                    if (foto == null) {
                                        foto = "";
                                    }
                                    if (foto.equals("")) {
                                %>
                                <td><img id="perfil" src="ImagePerfil/perfil.jpg" width="100" height="100" />
                                    <% } else {%>
                                <td><img id="perfil" src="<%="ImagePerfil/" + foto%>" width="100" height="100" />
                                    <%}%>
                                </td>
                                <td><input type="file" name="filefoto" value="<%=foto%>" ></td>
                            </tr>
                            <tr> 
                                <td colspan="2" id="cam">Campos con asterisco (*) son obligatorios</td>
                            </tr>
                        </table> 

                    </fieldset>
                </div> 
                <center> <br><br>  <jsp:include page="FBotones.jsp" flush="true"/> </center>
            </form>
        </div>
        <div id="tblu">
            <center> <h3><%=men%></h3></center> 
        </div>

    </body>
    <style type="text/css">
        body{
            background: white;
        }
        #borde{
            border-color: #00a383
        }
        #tibo{
            font-family: Arial;
            color: #00a383;
            font-size: 23px;

        }
        #datou{
            margin-left: 2%;
            margin-top: 2%;
            width: 35%;
        }
        #centro{
            width: 98%;
            height: 4%;
            margin-left: 1%;
            margin-bottom: 2%;
            margin-top: 5%;
            position:relative;      
            -webkit-box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
            -moz-box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
            box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
        }
        #tex{
            font-family: Arial;
            font-size: 105%;
            color:#00A383;
        }
        #cam{
            color: #00a383;
            font-size: 80%;
            font-family: Arial;
        }
        #titu{
            font-family: Arial;
            color: #00342A;
            font-size: 250%;
            margin-bottom: -7%;
        }
        #imaperfil{
            margin-top: -40%;
            margin-left: 50%;
        }
        h3{
            font-family: Arial;
            color: #00342A;
            margin-bottom: -1%;
        }
        h5{
            margin-top: -1%;
            color: #00a383;
        }
        #tblu{ 
            width:790px;
            height: 400px;
            margin-left: 38%;
            margin-top: -38%;
            position:absolute;
            overflow-x: hidden;
            /*-webkit-box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
            -moz-box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;
            box-shadow:0 0px 4px #777, 0 0 20px #CCC inset;*/
        }
        .tabla {
            margin:0px;padding:0px;
            width:100%;
            box-shadow: 10px 10px 5px #888888;
            border:1px solid #000000;

            -moz-border-radius-bottomleft:9px;
            -webkit-border-bottom-left-radius:9px;
            border-bottom-left-radius:9px;

            -moz-border-radius-bottomright:9px;
            -webkit-border-bottom-right-radius:9px;
            border-bottom-right-radius:9px;

            -moz-border-radius-topright:9px;
            -webkit-border-top-right-radius:9px;
            border-top-right-radius:9px;

            -moz-border-radius-topleft:9px;
            -webkit-border-top-left-radius:9px;
            border-top-left-radius:9px;
        }.tabla table{
            border-collapse: collapse;
            border-spacing: 0;
            width:100%;
            height:100%;
            margin:0px;padding:0px;
        }.tabla tr:last-child td:last-child {
            -moz-border-radius-bottomright:9px;
            -webkit-border-bottom-right-radius:9px;
            border-bottom-right-radius:9px;
        }
        .tabla table tr:first-child td:first-child {
            -moz-border-radius-topleft:9px;
            -webkit-border-top-left-radius:9px;
            border-top-left-radius:9px;
        }
        .tabla table tr:first-child td:last-child {
            -moz-border-radius-topright:9px;
            -webkit-border-top-right-radius:9px;
            border-top-right-radius:9px;
        }.tabla tr:last-child td:first-child{
            -moz-border-radius-bottomleft:9px;
            -webkit-border-bottom-left-radius:9px;
            border-bottom-left-radius:9px;
        }.tabla tr:hover td{
            background: #00a383;
        }
        .tabla tr:nth-child(odd){ background-color:#5fd3b3; }
        .tabla tr:nth-child(even)    { background-color:#ffffff; }.tabla td{
            vertical-align:middle;


            border:1px solid #000000;
            border-width:0px 1px 1px 0px;
            text-align:center;
            padding:9px;
            font-size:12px;
            font-family:Arial;
            font-weight:normal;
            color:#000000;
        }.tabla tr:last-child td{
            border-width:0px 1px 0px 0px;
        }.tabla tr td:last-child{
            border-width:0px 0px 1px 0px;
        }.tabla tr:last-child td:last-child{
            border-width:0px 0px 0px 0px;
        }
        .tabla tr:first-child td{
            background:-o-linear-gradient(bottom, #00a383 5%, #00a383 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #00a383), color-stop(1, #00a383) );
            background:-moz-linear-gradient( center top, #00a383 5%, #00a383 100% );
            filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="#00a383", endColorstr="#00a383");	background: -o-linear-gradient(top,#00a383,00a383);

            background-color:#00a383;
            border:0px solid #000000;
            text-align:center;
            border-width:0px 0px 1px 1px;
            font-size:18px;
            font-family:Arial;
            font-weight:bold;
            color:#ffffff;
        }
        .tabla tr:first-child:hover td{
            background:-o-linear-gradient(bottom, #00a383 5%, #00a383 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #00a383), color-stop(1, #00a383) );
            background:-moz-linear-gradient( center top, #00a383 5%, #00a383 100% );
            filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="#00a383", endColorstr="#00a383");	background: -o-linear-gradient(top,#00a383,00a383);

            background-color:#00a383;
        }
        .tabla tr:first-child td:first-child{
            border-width:0px 0px 1px 0px;
        }
        .tabla tr:first-child td:last-child{
            border-width:0px 0px 1px 1px;
        }
    </style> 
</html>
