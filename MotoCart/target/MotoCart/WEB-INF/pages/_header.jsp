<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href='https://fonts.googleapis.com/css?family=Aldrich'
	rel='stylesheet'>

<div class="header-container">

	<div class="site-name">MotoCart Online Shop</div>

	<div class="header-bar">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
        Hello
           <a href="${pageContext.request.contextPath}/accountInfo">
				${pageContext.request.userPrincipal.name} </a>
         &nbsp;|&nbsp;
           <a href="${pageContext.request.contextPath}/logout">Logout</a>

		</c:if>
		<c:if test="${pageContext.request.userPrincipal.name == null}">
			<a href="${pageContext.request.contextPath}/login">Login</a>
		</c:if>
		<a href="${pageContext.request.contextPath}/"> <img
			src="${pageContext.request.contextPath}/app_images/cart.png"
			height="30" width="30" />
		</a> 
	</div>
</div>