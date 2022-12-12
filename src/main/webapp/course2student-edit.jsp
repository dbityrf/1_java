

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Course2Student Edit" scope="application" />
<t:wrapper>

	<c:choose>
		<c:when test="${empty dto.id}">
			<h1>Create Course2Student</h1>
		</c:when>
		<c:otherwise>
			<h1> Course2Student Edit #${dto.id}</h1>
		</c:otherwise>
	</c:choose>
	<form class="col s12" method="post" action="/Course2Student">
		<div class="row">
							<div class="input-field col s6">
					<input type="text" name="studentId" value="${dto.studentId}"> <label for="studentId">FIO student</label>
				</div>
                                     <div class="input-field col s6">
					<input type="text" name="courseId" value="${dto.courseId}"> <label for="courseId">Course Name</label>
				</div>
					</div>

					<div class="row">
						<div class="input-field col s12">
							<select>
								<option value="" disabled selected>Grade</option>
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
								<option value="4">4</option>
								<option value="5">5</option>
								<option value="6">6</option>
								<option value="7">7</option>
								<option value="8">8</option>
								<option value="9">9</option>
								<option value="10">10</option>
							</select> <label>Grade</label>
						</div>
					</div>
				</form>
		
			<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="/course2student"><i class="material-icons left">list</i>back</a>&nbsp;
				<button class="btn waves-effect waves-light" type="submit">
					<i class="material-icons left">save</i>save
				</button>
			</div>
			</div>
		
	
	</t:wrapper>