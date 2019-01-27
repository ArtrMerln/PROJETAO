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
			Sexo: <input type="radio" name="sexo" value="M">Masculino <input
				type="radio" name="sexo" value="F">Feminino
		</div>

		<div>
			Tipo Sanguíneo: <select name="tipoSangue">

				<option value="A+">A+</option>
				<option value="A-">A-</option>
				<option value="B+">B+</option>
				<option value="B-">B-</option>
				<option value="AB+">AB+</option>
				<option value="AB-">AB-</option>
				<option value="O+">O+</option>
				<option value="O-">O-</option>

			</select>
		</div>
		<div>
			<input type="radio" name="acao" value="Doador">Doador <input
				type="radio" name="acao" value="Receptor">Receptor
		</div>

		<h2> 
			vinculado ao hospital: <select name="hospital.id">
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