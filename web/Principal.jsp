<%
    String target = request.getAttribute("target") != null ? (String) request.getAttribute("target") : "FLogin.jsp";
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>     
    </head>
    <body>


        <jsp:include page="<%=target%>" flush="true"/>  

    </body>
</html>
