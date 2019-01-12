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
	<h1>Adicionar hospital</h1>
	<form action="/projetao/hospital" method="post">
		<div>
			<label>Nome:</label> <input type="text" name="nome">
		</div>
		<div>
			<label>cnpj:</label> <input type="text" name="cnpj">
		</div>
		<div>
			<label>Email:</label> <input type="text" name="email">
		</div>
		<div>
			<label>Endereço:</label> <input type="text" name="endereco">
		</div>
		
		<div>
			<label>estado:</label> <input type="text" name="estado">
		</div>
		<div>
			<label>cidade:</label> <input type="text" name="cidade">
		</div>
		
		<div>
			<button type="submit">Adicionar</button>
		</div>
	</form>
</body>
</html>