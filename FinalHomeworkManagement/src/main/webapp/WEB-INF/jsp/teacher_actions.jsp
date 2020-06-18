<%@ page import="edu.bjtu.javaee.homework.model.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: 10067
  Date: 2020/3/13
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分配作业</title>
</head>
<body>

<form action="/teacherActions">
    <% Teacher teacher = (Teacher) request.getAttribute("teacher"); %>
    <input type="text" name="tid" value="<%=teacher.getId()%>" hidden>
    <label><input type="radio" name="action" value="create">创建作业</label>
    <label><input type="radio" name="action" value="look">查看学生作业</label>
    <button>选择功能</button>
</form>

</body>
</html>
