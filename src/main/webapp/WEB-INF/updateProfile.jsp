



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Update Profile" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<h1 class="container d-flex justify-content-center mt-5 pt-5 mb-5">Edit Account Information for ${sessionScope.employee.username}</h1>
<form class="container w-25 mt-5" action="/profileupdate" method="POST">
    <div class="form-group">
        <label for="name">Name</label>
        <input id="name" name="name" class="form-control" type="text" value="${employee.name}">
    </div>
    <div class="form-group">
        <label for="username">Username</label>
        <input id="username" name="username" class="form-control" type="text" value="${employee.username}">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input id="password" name="password" class="form-control" type="password">
    </div>
    <div class="form-group">
        <label for="confirm_password">Confirm Password</label>
        <input id="confirm_password" name="confirm_password" class="form-control" type="password">
    </div>
    <input type="hidden" value="${employee.id}" name="update">
    <input type="submit" value="Update Profile">
</form>


</body>
</html>