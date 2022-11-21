<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<h1 class="mt-5 mb-5 pt-5 ps-5 pe-5 d-flex justify-content-center">Please Log In</h1>
<div class="d-flex justify-content-center">
    <form action="/login" method="POST" class="w-50">
        <div class="form-group">
            <label for="username"></label>
            <input id="username" name="username" class="form-control fs-3" type="text" placeholder="Username">
        </div>
        <div class="form-group">
            <label for="password"></label>
            <input id="password" name="password" class="form-control fs-3" type="password" placeholder="Password">

            <input type="submit" class="btn btn-dark btn-block mt-5 pt-3 pb-3 fs-3" value="Log In">
            <hr class="mt-5">
            <div class="d-flex flex-row justify-content-center pt-3 fs-4">
                <p>Don't have an account</p>
                <a class="ps-2" href="/register">Sign up</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>
