<%@ page import="co.edu.ufps.gymproject.negocio.fachada.EntrenadorFacade" %><%--
  Created by IntelliJ IDEA.
  User: CAMILO JAIMES
  Date: 5/06/2022
  Time: 5:40 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="co.edu.ufps.gymproject.datos.dto.EntrenadorDTO"%>
<jsp:useBean id="fachada" class="co.edu.ufps.gymproject.negocio.fachada.EntrenadorFacade"></jsp:useBean>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
    <%
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        EntrenadorDTO e = new EntrenadorDTO();
        e.setEmail(email);
        e.setPassword(password);

        String message = fachada.login(e);
        if(!message.equals("Inicio de sesion")){
            String url = "./login.jsp?email="+email+"&message="+message;
            response.sendRedirect(url);
        }
    %>


</body>
</html>
