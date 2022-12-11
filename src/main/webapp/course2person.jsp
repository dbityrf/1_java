<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Course list" scope="application" />
<t:wrapper>
			<h1>Course_2_student</h1>
			<div class="row">
				<div class="col s12">
					<div class="center-align">
						<a class="btn-floating btn-large waves-effect waves-light" href="edit.html"><i class="material-icons">add</i></a>
					</div>
				</div>
			</div>
			<table>
				<thead>
					<tr>
						<th>№</th>
						<th>Название курса</th>
						<th>ФИО студента</th>
                        <th>Оценка </th>
                       	<th>Редактировать</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>Высшая математика</td>
						<td>Богдель Анна Александровна</td>
                        <td>9</td>

						<td><a class="btn-small btn-floating waves-effect waves-light green" title="редактировать" href="edit.html"><i class="material-icons">edit</i></a></td>
					</tr>
					<tr>
                        <td>1</td>
						<td>Высшая математика</td>
						<td>Иванов Иван Иванович</td>
                        <td>7</td>
						<td><a class="btn-small btn-floating waves-effect waves-light green" title="редактировать" href="edit.html"><i class="material-icons">edit</i></a></td>
					</tr>
					<tr>
						<td>1</td>
						<td>Английский</td>
						<td>Богдель Анна Александровна</td>
                        <td>8</td>
						<td><a class="btn-small btn-floating waves-effect waves-light green" title="редактировать" href="edit.html"><i class="material-icons">edit</i></a></td>
					</tr>
					
				</tbody>
			</table>


</t:wrapper>
