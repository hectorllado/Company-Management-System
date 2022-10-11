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
<c:import url="logout-parcial.jsp"/>
<form action="${linkEntradaServlet}" method="post">

  Nome: <input type="text" name="nome" value=${empresa.nome} />
  <input type="hidden" name="id" value=${empresa.id} />
  <input type="hidden" name="acao" value="AlteraEmpresa"/>
  <input type="submit" value="Alterar" />
</form>
</body>
</html>