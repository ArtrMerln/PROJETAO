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

	<h1>lista de hospitais</h1>

	<table border="1">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Endereço</th>
							</tr>
		</thead>
		<tbody>
			<c:forEach var="hospital" items="${hospital }">
				<tr>
					<td>${hospital.nome }</td>
					<td>${hospital.email }</td>
					<td>${hospital.endereco }</td>

					<td><a href="/agendaspring/contatos/remover?id=${contato.id }">Remover</a></td>
					<td><a href="/agendaspring/contatos/selecionar?id=${contato.id }">Alterar</a></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>




