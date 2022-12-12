<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Course list" scope="application" />
<t:wrapper>


			<h1>Course list</h1>
			<div class="row">
				<div class="col s12">
					<div class="center-align">
						<a class="btn-floating btn-large waves-effect waves-light" href="course-edit.jsp"><i class="material-icons">add</i></a>
					</div>
				</div>
			</div>
			<table>
				<thead>
					<tr>
						<th>№</th>
						<th>Название курса</th>
						<th>ФИО преподавателя</th>
                        <th>Дата начала</th>
                        <th>Продолжительность курса</th>
                        <th>Адрес</th>
						<th>Редактировать</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>Высшая математика</td>
						<td>Сетько Елена Александровна</td>
                        <td>12/08/2022</td>
                        <td> 3 месяца</td>
                        <td>Гаспадарчая,23</td>
						<td><a class="btn-small btn-floating waves-effect waves-light green" title="редактировать" href="course-edit.jsp"><i class="material-icons">edit</i></a></td>
					</tr>
					<tr>
						<td>2</td>
						<td>Криптография</td>
						<td>Копать Дмитрий Александрович</td>
						<td>15/08/2022</td>
						<td>2 месяца</td>
						<td>Гаспадарчая, 23</td>
						<td><a class="btn-small btn-floating waves-effect waves-light green" title="редактировать" href="course-edit.jsp"><i class="material-icons">edit</i></a></td>
					</tr>
					<tr>
						<td>3</td>
						<td>Английский язык</td>
						<td>Левченко Наталья Александровна</td>
						<td>25/08/2022</td>
						<td> 6 месяцев </td>
						<td>Гаспадарчая, 23</td>
						<td><a class="btn-small btn-floating waves-effect waves-light green" title="редактировать" href="course-edit.jsp"><i class="material-icons">edit</i></a></td>
					</tr>
					<tr>
						<td>4</td>
						<td>Статистика</td>
						<td>Селюжицкая Татьяна Владимировна</td>
						<td>30/08/2022</td>
						<td>4 месяца</td>
						<td>Гаспадарчая, 23</td>
						<td><a class="btn-small btn-floating waves-effect waves-light green" title="редактировать" href="course-edit.jsp"><i class="material-icons">edit</i></a></td>
					</tr>
					<tr>
						<td>5</td>
						<td>Основы бизнеса и права</td>
						<td>Опекун Елена Владимировна</td>
						<td>10/08/2022</td>
						<td>3 месяца</td>
						<td>Гаспадарчая, 23</td>
						<td><a class="btn-small btn-floating waves-effect waves-light green" title="редактировать" href="course-edit.jsp"><i class="material-icons">edit</i></a></td>
					</tr>
				</tbody>
			</table>

		
</t:wrapper>
