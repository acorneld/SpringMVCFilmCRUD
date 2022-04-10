<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
<link rel="stylesheet" href="NewFile.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Films</title>
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${! empty film}">
				<ul>
					<li>${film.id}</li>
					<li>${film.title}</li>
					<li>${film.description}</li>
					<li>${film.rating}</li>
<!--  logic to decide if actor list will be displayed-->
					<li>${film.actorList}</li>

					<li>${film.category}</li>
					<li>${film.language}</li>
				</ul>

				<br>
				<div>
				<form action="deleteFilm.do" method="POST">
					<input type="hidden" value="${film.id}" name="id"> <input class="btn btn-primary"
						type="submit" value="Delete Film!">
				</form>
</div> <br>
				<form action="updateFilm.do" method="POST">
					<input type="hidden" value="${film.id}" name="id"> <input class="btn btn-primary"
						type="submit" value="Update Film!">
				</form>

			</c:when>
			<c:when test="${! empty filmList}">

				<c:forEach var="film" items="${filmList}">
					<div class="container">

						<ul>
							<li>${film.id}</li>
							<li>${film.title}</li>
							<%-- <li>${film.description}</li>
					<li>${film.rating}</li>
					<li>${film.actorList}</li>
					<li>${film.category}</li>
					<li>${film.language}</li> --%>
						</ul>

						<br>
						<div>
						<form action="deleteFilm.do" method="POST">
							<input type="hidden" value="${film.id}" name="id"> <input class="btn btn-primary"
								type="submit" value="Delete Film!">
						</form>
							</div>
							<br>
						<form action="updateFilm.do" method="POST">
							<input type="hidden" value="${film.id}" name="id"> <input class="btn btn-primary"
								type="submit" value="Update Film!">
						</form>
					</div>

				</c:forEach>


			</c:when>
			<c:otherwise>
				<p>No film found</p>
			</c:otherwise>
		</c:choose>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>