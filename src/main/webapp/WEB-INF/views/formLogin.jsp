<%--
  Created by IntelliJ IDEA.
  User: hector.llado
  Date: 06/10/2022
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List, br.com.hector.gerenciador.modelo.Empresa, br.com.hector.gerenciador.servlet.ListaEmpresasServlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Form</title>
</head>
<body>
<form action="${linkEntradaServlet}" method="post">

  Login: <input type="text" name="login"/>
  Senha: <input type="password" name="senha"/>

  <input type="hidden" name="acao" value="Login"/>

  <input type="submit" value="Acessar" />
</form>
</body>
</html>
