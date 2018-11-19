<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>Shopping Cart Finalize</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
 
</head>
<body>
   <jsp:include page="header.jsp" />
 
   <jsp:include page="menu.jsp" />
 
   <div class="page-title">Finalize</div>
  
   <div class="container">
       <h3>Thanks for the Transaction</h3>
       Your transaction number is: ${lastOrderedCart.transactionNum}
   </div>
 
   <jsp:include page="footer.jsp" />
 
</body>
</html>