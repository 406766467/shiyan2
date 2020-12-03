<%--
  Created by IntelliJ IDEA.
  User: 张復华
  Date: 2020/11/26
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script typet="text/javascript" src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
    <script>
        window.onload = function(){
            $.ajax({
                url:"<%=request.getContextPath()%>/api/v1/shiyan2/showUser",
                datatype:"json",
                type:"GET",
                success:function(data) {
                    $.each($.parseJSON(data), function (n, item) {  //.parseJSON（）方法把JSON字符串转换为javascript对象，不转换的话将会抛出错误。
                        $(".myTable").append("<" +
                            "tr><th>" + item.id + "</th><th>" + item.name + "</th><th>" + item.age + "</th><th>" + item.sex + "</th></tr>");//控制输出的数据格式
                    })
                }
            })
        }
    </script>
</head>
<body>
<p style="color: red">${state}</p>
    <table border="1" class="myTable">
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
        </tr>

    </table>

    <a href="<%=request.getContextPath()%>/api/v1/shiyan2/addPage">添加User</a>
</body>
</html>
