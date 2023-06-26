<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<html>
<head>
    <title>Title</title>
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
            <div class="flex flex-columns">
                <button class="p-[32px]"><a href="/finalTest02_war_exploded/create">Create new employees</a></button>
            </div>
            <table class="m-[20px] mt-[0] w-[97%]">
                <tr class="text-left pl-[20px] h-[52px]">
                    <th class="w-[40px] font-normal">ID</th>
                    <th class="text-left w-[300px] font-normal">Full Name</th>
                    <th class="w-[200px] font-normal">Birth Date</th>
                    <th class="w-[200px] font-normal">Address</th>
                    <th class="w-[300px] font-normal">Position</th>
                    <th class="w-[300px] font-normal">Department</th>
                    <th class="w-[300px] font-normal">Action</th>
                </tr>
                <c:forEach var="item" items="${employees}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.fullName}</td>
                        <td>${item.birthDay}</td>
                        <td>${item.address}</td>
                        <td>${item.position}</td>
                        <td>${item.department}</td>
                        <td>
                            <ul class="flex gap-[20px] items-center">
                                <li><button><a href="/finalTest02_war_exploded/employee?id=${item.id}">Details</a></button></li>
                                <li><button><a href="/finalTest02_war_exploded/update?id=${item.id}">Edit</a></button></li>
                                <li><form method="post" action="/delete">
                                    <button type="submit"><a href="/finalTest02_war_exploded/employee?id=${item.id}">Delete</a></button>
                                </form></li>
                            </ul>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
