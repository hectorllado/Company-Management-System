<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List, br.com.hector.gerenciador.servlet.Empresa, br.com.hector.gerenciador.servlet.ListaEmpresasServlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Form</title>
</head>
<body>
<form action="/javaweb-intro/alteraEmpresa" method="post">

  Nome: <input type="text" name="nome" value=${empresa.nome} />
  ID: <input type="hidden" name="id" value=${empresa.id} />
  <input type="submit" value="Alterar" />
</form>
</body>
</html>