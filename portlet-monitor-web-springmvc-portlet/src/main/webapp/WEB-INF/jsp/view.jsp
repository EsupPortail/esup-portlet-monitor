<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



	<div class="table-responsive">
		<table align="left" width="100%" class="table table-condensed table-striped table-bordered">
			<tr id="titre">
				<th>Nom Serveur</th>
				<th colspan="3">M&eacute;moire</th>
				<th colspan="3">Sessions</th>
			</tr>
			<tr id="titre2">
				<th></th>
				<th>Maximum (Mo)</th>
				<th>Total (Mo)</th>
				<th>Libre (Mo)</th>
				<th>Total</th>
				<th>Anonymes</th>
				<th>Connect&eacute;s</th>
			</tr>
			<c:forEach var="task" items="${liste_serveurs}">
				<tr id="${task.name}">
	
					<td>${task.name} (${fn:substringBefore(task.url,"/EsupMonitor")})</td>
					<td align="center">${task.memory.max}</td>
					<td align="center">${task.memory.total}</td>
					<td align="center">${task.memory.free}</td>
					<td align="center" id="userTotal">${task.session.total}</td>
					<td align="center" id="userGuest">${task.session.guest}</td>
					<td align="center" id="userconnected">${task.session.connected}
						<c:if
							test="${fn:length(task.users)>1}">
							<img 
								src="/portlet-monitor/media/images/affich.png"
								alt="Afficher la liste des utilisateurs" 
								class="affichListe" />
							<img style="display: none;"
								src="/portlet-monitor/media/images/noAffich.png"
								alt="Ne plus afficher la liste des utilisateurs"
								class="noAffichListe" />	
						</c:if>
					</td>
				</tr>
				<tr style="display: none;" class="trToAffich">
					<td colspan="7">
						<ul class="colonne">
							<c:forEach var="task_users" items="${task.users}">
								<c:forEach var="user_id" items="${task_users}">
								<c:if test="${not (fn:containsIgnoreCase(user_id,'guest'))}">
									<li>> ${user_id}</li>
								</c:if>	
								</c:forEach>
							</c:forEach>
						</ul></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
