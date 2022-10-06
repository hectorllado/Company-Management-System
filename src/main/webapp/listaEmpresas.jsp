<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List, br.com.hector.gerenciador.servlet.Empresa, br.com.hector.gerenciador.servlet.ListaEmpresasServlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Java Standard Taglib</title>
</head>
<body>
Lista de empresas: <br />

<ul>
    <c:forEach items="${empresas}" var="empresa">

        <li>${empresa.nome} <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
            <a href="/javaweb-intro/mostraEmpresa?id=${empresa.id}">  Mostra Empresa</a></li>
            <a href="/javaweb-intro/removeEmpresa?id=${empresa.id}">  Remove Empresa</a></li>

    </c:forEach>

</ul>

<button style="width: 100px; height: 50px" name="Nova Empresa"><a href="formNovaEmpresa.html">Nova Empresa</a></button>

</body>
</html>
