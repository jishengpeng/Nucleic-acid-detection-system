<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员管理界面</title>

<link rel="stylesheet" href="login.css">

</head>
<body>
<br><br><br><br><br><br>

<center>
<h1>欢迎使用吉林大学核酸系统：用户管理界面</h1>
</center>

<br>
<center>
<h4>请在下方输入你想增加的用户信息:</h4>
</center>
<br>

<form  method="get" action="/BigProjectJSP/Servlet3">
<center>

用户名：<input type="text" name="name"><br><br>

密码：&nbsp;&nbsp;<input type="password" name="password"><br><br>

身份：
<input type="checkbox" name="identify" value="2">大白
<input type="checkbox" name="identify" value="3">上传者
<br><br>

<input type="submit" value="增加">&nbsp;&nbsp;&nbsp;&nbsp;
<a href="login.jsp">
<input type="button" value="结束" onclick="window.location.href('login.jsp')">
</a>&nbsp;&nbsp;&nbsp;&nbsp;


</center>

</form>


</body>
</html>