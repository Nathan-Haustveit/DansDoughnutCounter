<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<div>
<h1 class="d-flex justify-content-center pt-5 pb-5">Please input your information</h1>
<div class="d-flex justify-content-center">
    <form action="/register" method="post" class="w-50">
        <div class="form-group">
            <label for="name"></label>
            <input id="name" name="name" class="form-control pb-3 fs-3" type="text" placeholder="Name">
        </div>
        <div class="form-group">
            <label for="username"></label>
            <input id="username" name="username" class="form-control pb-3 fs-3" type="text" placeholder="Username">
        </div>
        <div class="form-group">
            <label for="password"></label>
            <input id="password" name="password" class="form-control pb-3 fs-3" type="password" placeholder="Password">
        </div>
        <div class="form-group">
            <label for="confirm_password"></label>
            <input id="confirm_password" name="confirm_password pb-3" class="form-control fs-3" type="password" placeholder="Confirm Password">
        </div>
        <input type="submit" class="btn btn-dark btn-block mt-3 pt-2 pb-2 fs-2" value="Create Account">
    </form>
</div>
</div>
</body>
</html>