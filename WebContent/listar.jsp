<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import= "java.util.ArrayList"
import= "Fachada.Fachada"
import= "Produto.Produto"
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav id="menu">
<h1>Lista de Produtos</h1>
<ul>
		<li><a href="Index.jsp">Home</a></li>

		
	</ul>
</nav>
<table border="1">

		<tr>
			<td> Id </td>
			<td> Produto </td>
			<td> Quantidade </td>
		</tr>
	<%
		try{
			ArrayList<Produto> listaProduto=Fachada.getInstance().listarProduto();
			for( Produto produtos:listaProduto){
	%>	
	
			
		<tr>
          <td><%=produtos.getId() %></td> 
          <td><%=produtos.getNome() %></td>
          <td><%=produtos.getQuantidade() %></td>
        </tr>
       
<%	
			}
		}
		catch(Exception e){
			out.println(e);
		
			
			}
%>






</table>

</body>
</html>