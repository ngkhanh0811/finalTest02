<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/26/2023
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/update?id=${item.id}">
    <label>Full name:</label><br>
    <input class="border-solid" type="text" name="fullName" value="${item.fullName}" placeholder="Enter full name" required/><br>
    <label>Birth date:</label><br>
    <input class="border-solid" type="date" name="birthDate" value="${item.birthDay}" placeholder="Enter birth date" required/><br>
    <label>Address:</label><br>
    <input class="border-solid" type="text" name="address" value="${item.address}" placeholder="Enter address" required/><br>
    <label>Position:</label><br>
    <input class="border-solid" type="text" name="position" value="${item.position}" placeholder="Enter position" required/><br>
    <label>Department:</label><br>
    <input class="border-solid" type="text" name="department" value="${item.department}" placeholder="Enter department" required/><br>
    <button class="bg-gray" type="submit">Submit</button><br>
</form>
</body>
</html>
