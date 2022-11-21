<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>

    <style>
        .name{
            width: 15em;
        }
        .type{
            width: 15em;
        }
        .amount{
            width: 15em;
        }
        .date{
            width: 15em;
        }
        .edit-type-label{
            margin-left: 10em;
        }
        .edit-type{
            margin-right: 5em;
        }

        .edit-amount{
            margin-left: 5em;
        }
        .edit-date{
            margin-left: 5em;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />


<div class="ms-5">
    <h1 class="mb-5">${sessionScope.employee.username}'s Doughnut Production!</h1>
</div>


    <table class="table caption-top d-flex justify-content-center pb-3">
        <thead>
        <tr>
            <th class="name" scope="col">Name</th>
            <th class="type" scope="col">Type</th>
            <th class="amount" scope="col">Amount</th>
            <th class="date" scope="col">Date</th>
        </tr>
        </thead>
    </table>


<c:forEach var="product" items="${products}">
    <div>
    <table class="table caption-top d-flex justify-content-center">
        <tbody>
            <tr class="pt-5">
                <td class="name">${employee.name}</td>
<%--To display the correct doughnut type based on its ID--%>
                    <c:choose>
                        <c:when test="${product.typeId == 1}">
                            <td class="type">Glazed</td>
                        </c:when>
                        <c:when test="${product.typeId == 2}">
                            <td class="type">Chocolate</td>
                        </c:when>
                        <c:when test="${product.typeId == 3}">
                            <td class="type">Chocolate Sprinkle</td>
                        </c:when>
                        <c:when test="${product.typeId == 4}">
                            <td class="type">Maple</td>
                        </c:when>
                        <c:when test="${product.typeId == 5}">
                            <td class="type">Old Fashioned</td>
                        </c:when>
                        <c:when test="${product.typeId == 6}">
                            <td class="type">Jelly</td>
                        </c:when>
                    </c:choose>
<%--------------------------------------------------------%>
                <td class="amount">${product.amount}</td>
                <td class="date">${product.productionDate}</td>
            </tr>
        </tbody>
    </table>




<div class="d-flex flex-row justify-content-center">
    <div class="d-flex flex-row">
        <form class="edit-type-label" action="/update" method="POST">
            <label for="type">Edit Type</label>
            <select class="edit-type"  name="type" id="type">
                <c:choose>
                    <c:when test="${product.typeId == 1}">
                        <option value=1 selected>Glazed</option>
                    </c:when>
                    <c:otherwise>
                        <option value=1 >Glazed</option>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${product.typeId == 2}">
                        <option value=2 selected>Chocolate</option>
                    </c:when>
                    <c:otherwise>
                        <option value=2 >Chocolate</option>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${product.typeId == 3}">
                        <option value=3 selected>Chocolate Sprinkle</option>
                    </c:when>
                    <c:otherwise>
                        <option value=3>Chocolate Sprinkle</option>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${product.typeId == 4}">
                        <option value=4 selected>Maple</option>
                    </c:when>
                    <c:otherwise>
                        <option value=4>Maple</option>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${product.typeId == 5}">
                        <option value=5 selected>Old Fashioned</option>
                    </c:when>
                    <c:otherwise>
                        <option value=5>Old Fashioned</option>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${product.typeId == 6}">
                        <option value=6 selected>Jelly</option>
                    </c:when>
                    <c:otherwise>
                        <option value=6>Jelly</option>
                    </c:otherwise>
                </c:choose>
            </select>


                <label class="edit-amount" for="amount">Edit Amount</label>
                <input type="text" id="amount" name="amount" value="${product.amount}">



                <label class="edit-date"  for="production_date">Edit Date</label>
                <input  type="text" id="production_date" name="production_date" value="${product.productionDate}">


                <input type="hidden" value="${product.id}" name="update">
                <input type="submit" value="Update">

        </form>
</div>
        <form action="/delete" method="POST">
            <input type="hidden" value="${product.id}" name="delete">
            <input type="submit" value="Delete">
        </form>
</div>
    </c:forEach>



</div>

</body>
</html>
