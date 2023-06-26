<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<html>
<head>
    <title>Create new employee</title>
    <%@include file="../common/resource.jsp"%>
</head>
<body>
<%@include file="../common/sidebar.jsp"%>
<div class="content bg-gray-100">
    <div class="content-heading flex items-center justify-between p-[20px]">
        <div class="content-heading-title">
            <h3 class="font-medium text-xl">Product Management</h3>
        </div>
        <div class="content-heading-breadcrumb">
            <ul class="flex items-center text-xs gap-[4px]">
                <li><a href="#">Home </a></li>
                <li> > </li>
                <li><a href="#" class="active"> Product Management</a></li>
            </ul>
        </div>
    </div>
    <div class="container-fluid flex">
        <div class="content-body bg-white m-[20px] w-[100%] mt-[0] mx-[30px]">
            <form method="post" action="${pageContext.request.contextPath}/create">
                <label>Full name:</label><br>
                <input class="border-solid" type="text" name="fullName" placeholder="Enter full name" required/><br>
                <label>Birth date:</label><br>
                <input class="border-solid" type="date" name="birthDate" placeholder="Enter birth date" required/><br>
                <label>Address:</label><br>
                <input class="border-solid" type="text" name="address" placeholder="Enter address" required/><br>
                <label>Position:</label><br>
                <input class="border-solid" type="text" name="position" placeholder="Enter position" required/><br>
                <label>Department:</label><br>
                <input class="border-solid" type="text" name="department" placeholder="Enter department" required/><br>
                <button class="bg-gray" type="submit">Submit</button><br>
                <button><a href="/finalTest_war_exploded/create">Refresh</a></button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
