<%@page import="com.KatalogÜrünleri.Entidades.Usuario"%>
<%
    String targetModulo = request.getAttribute("targetModulo") == null ? "datos.jsp" : (String) request.getAttribute("targetModulo");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="css/Fprincipal.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>    
        
        <table style="width: 100%; border: 0px;" >
            <tr>
            </tr>
            <tr>
                <td><jsp:include page="MenuAdm.jsp" flush="true"/></td>
            </tr>
            <tr>
                <td><jsp:include page="<%=targetModulo%>" flush="true"/></td>
            </tr>
            <tr>
                <td><jsp:include page="Pie.jsp" flush="true"/></td>
            </tr>

        </table>        
    </body>
</html>