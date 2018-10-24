<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles.css">

</head>
<body>

	<jsp:include page="header.jsp" />
	<jsp:include page="menu.jsp" />

	<fmt:setLocale value="en_US" scope="session" />

	<div class="page-title">Transaction Info</div>

	<div class="customer-info-container">
		<h3>Customer Information:</h3>
		<ul>
			<li>Name: ${transactionInfo.customerName}</li>
			<li>Email: ${transactionInfo.customerEmail}</li>
			<li>Phone: ${transactionInfo.customerPhone}</li>
			<li>Address: ${transactionInfo.customerAddress}</li>
		</ul>
		<h3>Transaction Summary:</h3>
		<ul>
			<li>Total: <span class="total"> <fmt:formatNumber
						value="${transactionInfo.amount}" type="currency" />
			</span></li>
		</ul>
	</div>

	<br />

	<table border="1" style="width: 100%">
		<tr>
			<th>Product Code</th>
			<th>Product Name</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Amount</th>
		</tr>
		<c:forEach items="${transactionInfo.details}" var="transactionDetailInfo">
			<tr>
				<td>${transactionInfo.productCode}</td>
				<td>${transactionInfo.productName}</td>
				<td>${transactionInfo.quanity}</td>
				<td><fmt:formatNumber value="${transactionInfo.price}"
						type="currency" /></td>
				<td><fmt:formatNumber value="${transactionInfo.amount}"
						type="currency" /></td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${paginationResult.totalPages > 1}">
		<div class="page-navigator">
			<c:forEach items="${paginationResult.navigationPages}" var="page">
				<c:if test="${page != -1 }">
					<a href="transactionList?page=${page}" class="nav-item">${page}</a>
				</c:if>
				<c:if test="${page == -1 }">
					<span class="nav-item"> ... </span>
				</c:if>
			</c:forEach>

		</div>
	</c:if>




	<jsp:include page="footer.jsp" />

</body>
</html>