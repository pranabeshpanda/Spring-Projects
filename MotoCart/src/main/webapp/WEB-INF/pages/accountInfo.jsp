<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>Account Info</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
 
</head>
<body>
 
 
   <jsp:include page="_header.jsp" />
   <jsp:include page="_menu.jsp" />
 
   <div class="page-title">Account Info</div>
 
   <div class="account-container">
 
 
       <ul>
           <li class="body-product-list">User Name: ${pageContext.request.userPrincipal.name}</li>
           <li class="body-product-list">Role:
               
                   <c:forEach items="${userDetails.authorities}" var="auth">
                       <li class="body-product-list">${auth.authority}</li>
                   </c:forEach>
               
           </li>
       </ul>
   </div>
 
 
   <jsp:include page="_footer.jsp" />
 
</body>
</html>