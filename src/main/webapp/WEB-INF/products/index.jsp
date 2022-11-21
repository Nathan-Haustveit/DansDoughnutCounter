<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All Doughnut Production" />
    </jsp:include>
    <link type="text/css" rel="stylesheet" href="/css/style.css">
    <style>
        .table-labels {
            margin-left: 10em;
        }

        .table-rows {
            margin-left: 10em;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>


<table class="table-labels table caption-top w-75">
    <thead>
    <tr>
        <th class="w-25" scope="col">Name</th>
        <th class="w-25" scope="col">Type</th>
        <th class="w-25" scope="col">Amount</th>
        <th class="w-25" scope="col">Date</th>
    </tr>
    </thead>
</table>

<c:forEach var="product" items="${products}">
<table class="table-rows table caption-top w-75">
    <tbody>
    <tr class="pt-5">
        <td class="w-25">${product.employeeId}</td>

        <c:choose>
            <c:when test="${product.typeId == 1}">
                <td class="w-25">Glazed</td>
            </c:when>
            <c:when test="${product.typeId == 2}">
                <td class="w-25">Chocolate</td>
            </c:when>
            <c:when test="${product.typeId == 3}">
                <td class="w-25">Chocolate Sprinkle</td>
            </c:when>
            <c:when test="${product.typeId == 4}">
                <td class="w-25">Maple</td>
            </c:when>
            <c:when test="${product.typeId == 5}">
                <td class="w-25">Old Fashioned</td>
            </c:when>
            <c:when test="${product.typeId == 6}">
                <td class="w-25">Jelly</td>
            </c:when>
        </c:choose>
        <td class="w-25">${product.amount}</td>
        <td class="w-25">${product.productionDate}</td>
    </tr>
    </tbody>
</table>
    <input type="hidden" value="${employee.id}" name="update">

</c:forEach>
</body>
</html>
