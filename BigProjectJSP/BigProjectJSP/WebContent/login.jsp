<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>

<link rel="stylesheet" href="login.css">

</head>

<body>

<br><br><br><br><br><br>

<center>
<h1>欢迎使用吉林大学核酸系统：登录</h1>
</center>

<br><br>

<form  method="get" action="/BigProjectJSP/Servlet1">
<center>

用户名：<input type="text" name="name"><br><br>

密码：&nbsp;&nbsp;<input type="password" name="password"><br><br>

身份：
<input type="checkbox" name="identify" value="1">管理员
<input type="checkbox" name="identify" value="2">大白
<input type="checkbox" name="identify" value="3">上传者
<input type="checkbox" name="identify" value="4">学生
<br><br>

<input type="submit" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;
<a href="register.jsp">
<input type="button" value="注册" onclick="window.location.href('register.jsp')">
</a>&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" value="取消">

</center>

</form>

</body>
</html>