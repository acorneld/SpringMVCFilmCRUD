<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Home</title>

</head>
<body>

<div class="container">


	<h1 class="text-center">SD Film Database</h1>
	<div class="container-sm">
	<button class="btn btn-primary" onclick="document.location='findFilmById.html'">Find Film By Id</button>
	<!-- <a href="findFilmById.html"> Get film form Id</a> -->
	</div>
	<br>
	
	<div class="container-sm">
	<button class="btn btn-primary" onclick="document.location='addFilm.html'">Add A Film</button>
	<!-- <a href="addFilm.html"> Add a film</a> -->
	</div>
	<br>
	
	<div class="container-sm">
	<button class="btn btn-primary" onclick="document.location='findFilmByKeyword.html'">Find Film by Keyword/Pattern</button>
	<!-- <a href="findFilmByKeyword.html"> Find film by keyword/pattern</a> -->
	</div>
	<br>



</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>