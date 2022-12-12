
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value=" Role Edit" scope="application" />
<t:wrapper>
			<h1> Role Edit </h1>


			<div class="row">
				<form class="col s12">
					
                <div class="col s6">
					<label for="roleId">Role ID</label> 
					<select name="roleId" class="browser-default" required>
						<option value="">--select roleID--</option>
						<c:forEach items="${allRoles}" var="role">
							<option value="${role.id}" <c:if test="${model.id eq dto.roleId}">selected="selected"</c:if>>${role.name}</option>
						</c:forEach>
					</select>
				</div>
				

					 <div class="col s6">
					<label for="role">Role</label> 
					<select name="role" class="browser-default" required>
						<option value="">--select role--</option>
						<c:forEach items="${allRoles}" var="role">
							<option value="${role.id}" <c:if test="${model.id eq dto.roleId}">selected="selected"</c:if>>${role.name}</option>
						</c:forEach>
					</select>
				</div>
				
			<div class="row">
				<div class="col s12 input-field center-align">
					<a class="btn waves-effect waves-light red" href="role.jsp"><i class="material-icons left">list</i>к списку</a> <a
						class="btn waves-effect waves-light green" href="#"><i class="material-icons left">save</i>Сохранить</a>
				</div>
			</div>
		
		</t:wrapper>