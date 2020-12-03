<%--
  Created by IntelliJ IDEA.
  User: 张復华
  Date: 2020/11/26
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/api/v1/shiyan2/addUser">
    姓名：<input type="text" name="name">
    年龄：<input type="text" name="age">
    性别：<input type="text" name="sex">

    <button type="submit">提交</button>
</form>
</body>
</html>
