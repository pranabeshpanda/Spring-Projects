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

	<div class="page-title">Transaction List</div>

	<div>Total Transaction Count: ${paginationResult.totalRecords}</div>

	<table border="1" style="width: 100%">
		<tr>
			<th>Transaction Num</th>
			<th>Transaction Date</th>
			<th>Customer Name</th>
			<th>Customer Address</th>
			<th>Customer Email</th>
			<th>Amount</th>
			<th>View</th>
		</tr>
		<c:forEach items="${paginationResult.list}" var="transactionInfo">
			<tr>
				<td>${transactionInfo.transactionNum}</td>
				<td><fmt:formatDate value="${transactionInfo.transactionDate}"
						pattern="dd-MM-yyyy HH:mm" /></td>
				<td>${transactionInfo.customerName}</td>
				<td>${transactionInfo.customerAddress}</td>
				<td>${transactionInfo.customerEmail}</td>
				<td style="color: red;"><fmt:formatNumber
						value="${transactionInfo.amount}" type="currency" /></td>
				<td><a
					href="${pageContext.request.contextPath}/transaction?transactionId=${transactionInfo.transactionId}">
						View</a></td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${paginationResult.totalPages > 1}">
		<div class="page-navigator">
			<c:forEach items="${paginationResult.navigationPages}" var="page">
				<c:if test="${page != -1 }">
					<a href="orderList?page=${page}" class="nav-item">${page}</a>
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