<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav id="menu">
<h1>Cadastro NFE</h1>
<ul>
		<li><a href="Index.jsp">Home</a></li>

		
	</ul>
</nav>
	<form method="post" action="CadastrandoNfe">
		
		Id<input type="text" name="id">
		Numero Nfe<input type="text" name="numero">
		Quantidade<input type="text" name="quantidade">
		
		<input type="submit" value="Cadastrar">
	</form>

</body>
</html>