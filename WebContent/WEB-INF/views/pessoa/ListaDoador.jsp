<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../menu.jsp"></c:import>

	<h1>Lista de receptores</h1>

	<table border="1">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Endereço</th>
				<th>tipo sangue</th>
				<th>ação</th>
				<th>Opção</th>
					<th>id</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pessoa" items="${pessoa }">
				<tr>
					<c:if test="${pessoa.acao == 'Receptor' }">
					<td>${pessoa.nome }</td>
					<td>${pessoa.email }</td>
					<td>${pessoa.endereco }</td>
					<td>${pessoa.tipoSangue }</td>
				 
					<td>${pessoa.acao }</td>
					<td><a href="/projetao/pessoa/lancer?id=${pessoa.id }">pedir doacao para esta pessoa</a></td>
		
<td>${pessoa.id }</td>
				
				
				</tr>
				
			 </c:if>
				
				
				
				
				
				
				 
            
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			</c:forEach>

		</tbody>
	</table>

</body>
</html>
