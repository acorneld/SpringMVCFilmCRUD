<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
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
					<li>${film.title}</li>
					<li>${film.description}</li>
					<li>${film.rating}</li>
					<li>${film.actorList}</li>
					 <li>${film.category}</li> 
					<li>${film.language}</li>
				</ul>
			</c:when>
			<c:otherwise>
				<p>No film found</p>
			</c:otherwise>
		</c:choose>

	</div>
</body>
</html>


<!-- private int releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> actorList;
	private String language;
	private String category; -->