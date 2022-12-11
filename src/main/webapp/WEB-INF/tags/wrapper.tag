
<%@tag description="Page template" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title><c:out value="${pageTitle}" /></title>

<!-- Compiled and minified CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script>
	document.addEventListener('DOMContentLoaded', function() {
		M.FormSelect.init(document.querySelectorAll('select'), {});
	});
</script>
<script src="js/helpers.js"></script>
</head>

	<nav class="light-green lighten-1" role="navigation">
		<div class="nav-wrapper container">
			<a id="logo-container" href="#" class="brand-logo">Courses</a>
			<ul class="right hide-on-med-and-down">
				<li><a href="course.jsp">Courses</a></li>
				<li><a href="person.jsp">Person</a></li>
                <li><a href="Role.jsp">Role</a></li>
                <li><a href="course2person.jsp">Course_2_student</a></li>
			</ul>
		</div>s
	</nav>

<div class="section no-pad-bot" id="index-banner">
	<div class="container">
		<jsp:doBody />
		<!-- Page body will be here -->
	</div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>
