<%@page import="com.KatalogÜrünleri.Entidades.Producto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String cod = request.getParameter("txtcodpro");
    String nom = request.getParameter("txtnombre");
    String des = request.getParameter("txtdescrip");
    String exi = request.getParameter("txtexis");
    String val = request.getParameter("txtvalor");
    String fot = request.getParameter("filefoto");
    String est = request.getParameter("cboestado");
    String cat = request.getParameter("cbocatprin");

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
        cat = datop.getCatprin();
    }// fin si

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div id="centro">
            <center><h1 id="titu"> Producto </h1></center>
            <BR>
            <hr aling=left noshade size:5 width:70px color="#00a383"> 
            <form name="Xfrom" action="./ProductoServlet" method="POST">
                <div id="datop">
                    <fieldset id="borde">
                        <legend id="tibo"><b>DATOS DEL PRODUCTO</b></legend>
                        <table>
                            <tr>
                                <td id="tex"><b>Código*</b></td>
                                <td><input type="text" name="txtcodpro" value="<%=cod != null ? cod : ""%>" size="20" maxlength="6"> </td>
                            </tr>
                            <tr>
                                <td id="tex"><b>Nombre*</b></td>
                                <td><input type="text" name="txtnombre" value="<%=nom != null ? nom : ""%>" size="20" maxlength="50"> </td>
                            </tr>
                            <tr>
                                <td id="tex"><b>Descripción*</b></td>
                                <td> 
                                    <textarea type="text" rows="3" cols="30" name="txtdescrip" value="<%=des != null ? des : ""%>"   maxlength="300"><%=des != null ? des : ""%></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td id="tex"><b>Existencias*</b></td>
                                <td><input type="text" name="txtexis" value="<%=exi != null ? exi : ""%>" size="20" maxlength="50"> </td>
                            </tr>
                            <tr>
                                <td id="tex"><b>Valor*</b></td>
                                <td><input type="text" name="txtvalor" value="<%=val != null ? val : ""%>" size="20" maxlength="7"> </td>
                            </tr>
                            <tr>
                                <%
                                    if (fot == null) {
                                        fot = "";
                                    }
                                    if (fot.equals("")) {
                                %>
                                <td><img id="perfil" src="ImaCatalogo/cat.jpg" width="100" height="100" />
                                    <% } else {%>
                                <td><img id="perfil" src="<%="ImaCatalogo/" + fot%>" width="100" height="100" />
                                    <%}%>
                                </td>
                                <td><input type="file" name="filefoto" value="<%=fot%>" ></td>
                            </tr>
                            <tr>
                                <td id="tex"><b>Estado*</b></td>
                                <td>
                                    <select name="cboestado">
                                        <option value="" >...Seleccione...</option>
                                        <option value="Activo"<%if ("Activo".equals(est)) {%>selected<%}%> >Activo</option>
                                        <option value="Inactivo"<%if ("Inactivo".equals(est)) {%>selected<%}%> >Inactivo</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td id="tex"><b>Catálogo principal*</b></td>
                                <td>
                                    <select name="cbocatprin">
                                        <option value="" >...Seleccione...</option>
                                        <option value="Si"<%if ("Si".equals(cat)) {%>selected<%}%> >Si</option>
                                        <option value="No"<%if ("No".equals(cat)) {%>selected<%}%> >No</option>
                                    </select>
                                </td>
                            </tr>
                            <tr> 
                                <td colspan="2" id="cam">Campos con asterisco (*) son obligatorios</td>
                            </tr>
                        </table> 

                    </fieldset>
                </div>
                <center> <br><br> <jsp:include page="FBotones.jsp" flush="true"/></center>
            </form>
        </div>
        <div id="tblu">
            <center> <h3><%=men%></h3> </center>
            <BR>
            <%if (LP != null) {%>

            <table class="tabla">
                <tr>
                    <td >Código</td>    
                    <td >Nombre</td>    
                    <td >Descripción</td>    
                    <td >Existencias</td>   
                    <td >Valor</td>   
                    <td >Foto</td> 
                    <td >Estado</td> 
                    <td>Buscar</td> 
                </tr>
                <% for (Producto pro : LP) {%>
                <tr >
                    <td ><%=pro.getCodpro()%> </td>    
                    <td ><%=pro.getNombre()%> </td>    
                    <td ><%=pro.getDescripcion()%> </td>    
                    <td ><%=pro.getExistencias()%> </td>    
                    <td ><%=pro.getValor()%> </td>    
                    <td> <img id="perfil" src="ImaCatalogo/<%=pro.getFoto()%>" width="50" height="50"></td>
                    <td ><%=pro.getEstado()%> </td>    
                    <td> <a href="./ProductoServlet?action=buscar&txtcodpro=<%=pro.getCodpro()%>"> <img src="Imagenes/lupa.png"> </a></td>
                </tr>
                <%}%>  
            </table> 
            <%}%>  
        </div>
    </body>
    <style type="text/css">
        body{
            background: white;
        }
        #borde{
            border-color: #00a383;
            height: 40%;
        }
        #tibo{
            font-family: Arial;
            color: #00a383;
            font-size: 23px;

        }
        #datop{
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
            margin-left: 40%;
            width:725px;
            height: 300px;
            margin-top: -39%;
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
