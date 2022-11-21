<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <title>Navbar</title>
    <%--    icons--%>
    <script src="https://kit.fontawesome.com/5c1e7c5892.js" crossorigin="anonymous"></script>
    <%--    bootstrap--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        .navbar{
            background-color: rgb(136, 90, 74)!important;
        }
    </style>
</head>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
<%---------------------Home Button--%>
                    <li class="nav-item ">
                        <a class="nav-link active pe-5 fs-2 fw-bold" aria-current="page" href="/">Dan's Delicious Doughnuts</a>
                    </li>
<%----------------------Profile Button--%>
                    <li class="nav-item ps-5 pe-5">
                        <a class="nav-link fs-4" href="/profile">Profile</a>
                    </li>
<%----------------------Production Button--%>
                    <li class="nav-item ps-5 pe-5">
                        <a class="nav-link fs-4" href="/product">Doughnut Production</a>
                    </li>
<%----------------------Add to Production Button--%>
                    <li class="nav-item ps-5 pe-5">
                        <a class="nav-link fs-4" href="/product/create">Add Doughnut Production</a>
                    </li>
<%----------------------Account Button That changes depending if logged in or not--%>
                    <li class="nav-item dropdown ps-5">
                        <a class="nav-link dropdown-toggle fs-4" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">Account</a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <%--profile update link from dropdown--%>
                            <c:choose>
                                <c:when test="${sessionScope.employee != null}">
                                <li>
                                    <a class="dropdown-item fs-5" aria-current="page" href="/profileupdate">Update Profile</a>
                                </li>
                                </c:when>
                            </c:choose>
                        <%--login link from dropdown--%>
                            <c:choose>
                                <c:when test="${sessionScope.employee == null}">
                                <li>
                                    <a class="dropdown-item fs-5" href="/login">Login</a>
                                </li>
                                </c:when>
                            </c:choose>
                        <%--logout link from dropdown--%>
                            <c:choose>
                                <c:when test="${sessionScope.employee != null}">
                                <li>
                                    <a class="dropdown-item fs-5" href="/logout">Logout</a>
                                </li>
                                </c:when>
                            </c:choose>
                        <%--register link from dropdown--%>
                            <c:choose>
                                <c:when test="${sessionScope.employee == null}">
                                <li>
                                    <a class="dropdown-item fs-5" href="/register">Create Account</a>
                                </li>
                                </c:when>
                            </c:choose>
                        </ul>
                    </li>
<%----------------------END Account Button--%>
                </ul>
            </div>
        </div>
    </nav>





<%--Bootstrap plugin--%>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</header>