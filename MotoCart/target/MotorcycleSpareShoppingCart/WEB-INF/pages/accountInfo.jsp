<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>User Account Info</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">

</head>
<body>


	<jsp:include page="header.jsp" />
	<jsp:include page="menu.jsp" />

	<div class="page-title">User Account Info</div>

	<div class="account-container">


		<ul>
			<li>User Name: ${pageContext.request.userPrincipal.name}</li>
			<li>Role:
				<ul>
					<c:forEach items="${userDetails.authorities}" var="auth">
						<li>${auth.authority }</li>
					</c:forEach>
				</ul>
			</li>
		</ul>
	</div>


	<jsp:include page="footer.jsp" />

</body>
</html>