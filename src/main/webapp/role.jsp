<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Course list" scope="application" />
<t:wrapper>

			<h1>Role</h1>
			<div class="row">
				<div class="col s12">
					
				</div>
			</div>
			<table>
				<thead>
					<tr>
						<th>№</th>
						<th>Role</th>
                       	<th>Редактировать</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>teacher</td>
						<td><a class="btn-small btn-floating waves-effect waves-light green" title="редактировать" href="role-edit.jsp"><i class="material-icons">edit</i></a></td>
					</tr>
					<tr>
						<td>2</td>
						<td>student</td>
						<td><a class="btn-small btn-floating waves-effect waves-light green" title="редактировать" href="role-edit.jsp"><i class="material-icons">edit</i></a></td>
					</tr>
					
				</tbody>
			</table>

		

</t:wrapper>

