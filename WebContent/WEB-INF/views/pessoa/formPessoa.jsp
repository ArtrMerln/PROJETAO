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
	<h1>Adicionar pessoa</h1>
	<form action="/projetao/pessoa" method="post">
		<div>
			<label>Nome:</label> <input type="text" name="nome">
		</div>
		<div>
			<label>cpf:</label> <input type="text" name="cpf">
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
			<label>Sexo:</label> <input type="text" name="sexo">
		</div>
		<div>
			<label>acao:</label> <input type="text" name="acao">
		</div>
		<div>
			<label>tipo sanguineo:</label> <input type="text" name="tipoSangue">
		</div>
		
		<h2>
			vinculado ao hospital: <select name="vainculoHospital">
				<c:forEach var="hospital" items="${hospital }">
					<option value="${hospital.id }">${hospital.nome }</option>
				
		

				</c:forEach>
				
				
				
			</select>
		</h2>
		
		<div>
			<button type="submit">Adicionar</button>
		</div>
	</form>
	
</body>
</html>