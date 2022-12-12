	<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Person Edit" scope="application" />
<t:wrapper>
	<c:choose>
		<c:when test="${empty dto.id}">
			<h1>Create Person</h1>
		</c:when>
		<c:otherwise>
			<h1> Person Edit #${dto.id}</h1>
		</c:otherwise>
	</c:choose>
	<form class="col s12" method="post" action="/Course2Student">
		<div class="row">
			<input type="hidden" name="id" value="${dto.id}" />
			<div class="row">
				<div class="input-field col s12">  
							<div class="row">
				<div class="input-field col s6">
					<input type="text" name="firstName,lastName,Noun" value="${dto.firstName,lastName,Noun}"> <label for="firstName,lastName,Noun">FIO person</label>
				</div>
						
					<div class="row">
						<div class="col s12">
							This is an inline input field:
							<div class="input-field inline">
								<input id="email_inline" type="email" class="validate"> <label for="email_inline">Email</label> <span class="helper-text" data-error="wrong"
									data-success="right">Helper text</span>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="input-field col s12">
							<select>
								<option value="" disabled selected>Role</option>
								<option value="1">teacher</option>
								<option value="2">student</option>
							
							</select> <label>Role</label>
						</div>
					</div>
				</form>
			</div>
			<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="/person"><i class="material-icons left">list</i>back</a>&nbsp;
				<button class="btn waves-effect waves-light" type="submit">
					<i class="material-icons left">save</i>save
				</button>
			</div>
			</div>
		
	</t:wrapper>