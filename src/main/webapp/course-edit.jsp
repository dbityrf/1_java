

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Edit item" scope="application" />
<t:wrapper>



	<h1> Course Edit</h1>


			<div class="row">
				<form class="col s12">
					<div class="row">
						<div class="input-field col s6">
							<input id="name" type="text" class="validate"> <label for="name"> Name</label>
						</div>
						<div class="input-field col s6">
							<input id="address" type="text" class="validate"> <label for="address">Address</label>
						</div>
						<div class="input-field col s6">
							<input id="duration" type="text" class="validate"> <label for="duration">Duration</label>
						</div>
						<div class="input-field col s6">
							<input id="FIO teacher" type="text" class="validate"> <label for="FIO teacher">FIO teacher</label>
						</div>
						<div class="input-field col s6">
							<input id="Start" type="text" class="validate"> <label for="Start">Start</label>
						</div>
					</div>
					
				</form>
			</div>
			<div class="row">
				<div class="col s12 input-field center-align">
					<a class="btn waves-effect waves-light red" href="index.html"><i class="material-icons left">list</i>к списку</a> <a
						class="btn waves-effect waves-light green" href="#"><i class="material-icons left">save</i>Сохранить</a>
				</div>
			</div>
		</div>
	</div>
</t:wrapper>