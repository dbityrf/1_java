
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Edit item" scope="application" />
<t:wrapper>



			<h1>Person</h1>
			<div class="row">
				<div class="col s12">
					<div class="center-align">
						<a class="btn-floating btn-large waves-effect waves-light" href="person-edit.jsp"><i class="material-icons">add</i></a>
					</div>
				</div>
			</div>
			<table>
				<thead>
					<tr>
						<th>№</th>
						<th>ФИО</th>
						<th>Email</th>
                        <th>Role</th>
                       	<th>Редактировать</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>Сетько Елена Александровна</td>
						<td>Elena@mail.ru</td>
                        <td>teacher</td>

						<td><a class="btn-small btn-floating waves-effect waves-light green" title="редактировать" href="person-edit.jsp"><i class="material-icons">edit</i></a></td>
					</tr>
					<tr>
						<td>2</td>
						<td>Левченко Наталья Александровна</td>
						<td>nataly@mail.ru</td>
                        <td>teacher</td>
						<td><a class="btn-small btn-floating waves-effect waves-light green" title="редактировать" href="person-edit.jsp"><i class="material-icons">edit</i></a></td>
					</tr>
					<tr>
						<td>3</td>
						<td>Богдель Анна Александровна</td>
						<td>dbityrf@mail.ru</td>
                        <td>student</td>
						<td><a class="btn-small btn-floating waves-effect waves-light green" title="редактировать" href="person-edit.jsp"><i class="material-icons">edit</i></a></td>
					</tr>
					<tr>
						<td>4</td>
						<td>Опекун Елена Владимировна</td>
						<td>sdfl@mail.ru</td>
                        <td>teacher</td>
						<td><a class="btn-small btn-floating waves-effect waves-light green" title="редактировать" href="person-edit.jsp"><i class="material-icons">edit</i></a></td>
					</tr>
					<tr>
						<td>5</td>
						<td>Иванов Иван Иванович</td>
						<td>ivanushka@mail.ru</td>
                        <td>student</td>
						<td><a class="btn-small btn-floating waves-effect waves-light green" title="редактировать" href="person-edit.jsp"><i class="material-icons">edit</i></a></td>
					</tr>
				</tbody>
			</table>

	</t:wrapper>

	
