
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value=" Course Edit" scope="application" />

<t:wrapper>
<c:choose>
		<c:when test="${empty dto.id}">
			<h1>Create Course</h1>
		</c:when>
		<c:otherwise>
			<h1> Course Edit #${dto.id}</h1>
		</c:otherwise>
	</c:choose>
	<form class="col s12" method="post" action="/Course">
		<div class="row">
			<input type="hidden" name="id" value="${dto.id}" />
			<div class="row">
				<div class="input-field col s12">  
					<input type="text" name="name" value="${dto.name}" ${empty dto.id ? '' : 'disabled'} > <label for="name">Name</label>
				</div>
			</div>
             <div class="row">
				<div class="input-field col s12">  
					<input type="text" name="address" value="${dto.address}" ${empty dto.id ? '' : 'disabled'} > <label for="address">Address</label>
				</div>
			</div>
            <div class="row">
				<div class="input-field col s12">  
					<input type="text" name="duration" value="${dto.duration}" ${empty dto.id ? '' : 'disabled'} > <label for="duration">Duration</label>
				</div>
			</div>
             <div class="row">
				<div class="input-field col s6">
					<input type="text" name="teacherId" value="${dto.teacherId}"> <label for="teacherId">FIO teacher</label>
				</div>
               <div class="row">
				<div class="input-field col s12">  
					<input type="text" name="start" value="${dto.start}" ${empty dto.id ? '' : 'disabled'} > <label for="start">Start</label>
				</div>
					
				
				</form>
			</div>
			<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="/car"><i class="material-icons left">list</i>back</a>&nbsp;
				<button class="btn waves-effect waves-light" type="submit">
					<i class="material-icons left">save</i>save
				</button>
			</div>
			</div>
		</div>
	</div>
</t:wrapper>