<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Welcome to Dan's Delicious Doughnuts!" />
</jsp:include>
    <style>


        .img {
            height: 60em!important;
            width: 60em!important;
            display: block;
            margin-left: auto;
            margin-right: auto;

        }
    </style>
</head>

<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="img">
        <a href="/login">
            <img src="img/dans_dougnuts.png">
        </a>
    </div>
</body>
</html>