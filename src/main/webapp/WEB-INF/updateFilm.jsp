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

<form action="updateFilmById.do" method="POST">
	
	<label>Enter Film properties:</label> <br>
	
	<input type="hidden" value ="${film.id}" name="id"> 
	
	<label>Title</label>
	<input type="text" name="title" value="${film.title}">
	
	<label>Description</label>
	<input type="text" name="desc" value="${film.description}">
	
	<label>Release Year</label>
	<input type="text" name="releaseYear" value="${film.releaseYear}">
	
	<label>Rating:</label>
	<select name="rating">
		<option value="${film.rating}"> Keep Current </option> 
		<option value="0">PG</option>
		<option value="1">PG13</option>
		<option value="2">G</option>
		<option value="3">NC17</option>
	</select>
	
	
	<label>Length</label>
	<input type="text" name="length" value="${film.length}">
	
	<label>language Id:</label>
	<input type="text" name="languageId" value="${film.languageId}">
	
	<label>Rental Duration:</label>
	<input type="text" name="rentalDuration" value="${film.rentalDuration} ">
	
	<label>Rental Rate:</label>
	<input type="text" name="rentalRate" value="${film.rentalRate}">
	
	<label>Replacement Cost:</label>
	<input type="text" name="replacementCost" value="${film.replacementCost} ">
	
	 <label>Special Features:</label>
	<select name="specialFeatures">
		<option value="${film.specialFeatures}"> Keep Current </option>
		<option value="0">Trailers</option>
		<option value="1">Commentaries</option>
		<option value="2">Deleted Scenes</option>
		<option value="3">Behind the Scenes</option>
	</select> 
	
	<label>Language:</label>
	<input type="text" name="language" value="${film.language}">
	
	<label>Category:</label>
	<input type="text" name="category" value="${film.category }">
	
	<input type="submit" value="Submit">
	
	
	</form>
</body>
</html>