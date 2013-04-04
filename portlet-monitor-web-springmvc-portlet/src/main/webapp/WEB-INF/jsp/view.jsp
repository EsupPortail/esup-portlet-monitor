<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:renderURL var="renderRefreshUrl" />

<div class="portlet-title">
	<h2>esup-monitor</h2>
</div>

<div class="portlet-section-body">

	<ul>
		<c:forEach var="task" items="${liste_serveurs}">
			<li><spring:message code="view.NomServeur"
					arguments="${task.name}" />
			</li>
			<li><spring:message code="view.urlServeur"
					arguments="${task.url}" />
			</li>
			<li><spring:message code="view.MemoireLibre"
					arguments="${task.memory.free}" />
			</li>
			<li><spring:message code="view.MemoireMax"
					arguments="${task.memory.max}" />
			</li>
			<li><spring:message code="view.MemoireTotale"
					arguments="${task.memory.total}" />
			</li>
			<ul>
				<c:forEach var="task_users" items="${task.users}">
					<c:forEach var="user_id" items="${task_users}">
						<li><spring:message code="view.User" arguments="${user_id}" />
						</li>
					</c:forEach>
				</c:forEach>
			</ul>
		</c:forEach>
	</ul>

</div>
