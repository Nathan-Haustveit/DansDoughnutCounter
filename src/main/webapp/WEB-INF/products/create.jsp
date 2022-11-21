<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Add to Doughnut Production" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="d-flex justify-content-center fs-4">
    <div>
    <h1 class="pt-5 pb-5">Log Your Doughnut Production</h1>
    <form action="/product/create" method="post" class="pt-5">
        <div class="form-group">
            <label for="type">Type</label>
            <select class="form-select form-select-lg pt-3 pb-2 fs-4" aria-label=".form-select-lg example" name="type" id="type">
                <option value=1>Glazed</option>
                <option value=2>Chocolate</option>
                <option value=3>Chocolate Sprinkle</option>
                <option value=4>Maple</option>
                <option value=5>Old Fashioned</option>
                <option value=6>Jelly</option>
            </select>
        </div>
        <div class="form-group fs-4">
            <label for="amount">Amount</label>
            <input id="amount" name="amount" class="form-control" type="text">
        </div>
        <div class="form-group fs-4">
            <label for="production_date">Production Date</label>
            <input id="production_date" name="production_date" class="form-control fs-4" type="text" placeholder="yyyy-mm-dd">
        </div>
        <input type="submit" class="btn btn-block btn-dark pt-3 pb-3 mt-4 fs-3">
    </form>
    </div>
</div>

</body>
</html>
