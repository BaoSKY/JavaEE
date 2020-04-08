<%@ page import="com.model.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: 10067
  Date: 2020/3/13
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加作业</title>
</head>
<body>

<form action="/createHomework">
    <% Teacher teacher = (Teacher) request.getAttribute("teacher"); %>
    <input type="text" name="tid" value="<%=teacher.getId()%>" hidden>
    <label>标题：<input type="text" name="title"></label>
    <label>要求：<input type="text" name="requirement"></label>
    <input type="submit" value="提交">
</form>

</body>
</html>
