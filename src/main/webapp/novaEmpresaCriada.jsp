<%
String nomeEmpresa = (String)request.getAttribute("empresa");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Nova Empresa Criada</title>
</head>
<body>
    Empresa <%= nomeEmpresa %> cadastrada com sucesso!<br>

</body>
</html>