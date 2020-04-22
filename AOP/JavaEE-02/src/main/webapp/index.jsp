<%--
  Created by IntelliJ IDEA.
  User: 10067
  Date: 2020/3/11
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录</title>
</head>
<body>
<form action="/login">
  <label><input type="radio" name="user_type" value="teacher">老师</label>
  <label><input type="radio" name="user_type" value="student">学生</label>
  <label>姓名：<input type="text" name="name" ></label>
  <label>密码：<input type="password" name="password"></label>
  <button id="login_btn">登录</button>
</form>

<form action="/register">
  <label><input type="radio" name="user_type" value="teacher">老师</label>
  <label><input type="radio" name="user_type" value="student">学生</label>
  <label>姓名：<input type="text" name="name"></label>
  <label>密码：<input type="password" name="password"></label>
  <button id="register_btn">注册</button>
</form>

</body>
</html>

