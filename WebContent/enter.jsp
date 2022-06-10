<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javaee.ejb.stateful.remote.MulBy2BeanRemote" %>
<%@ page import="java.util.Hashtable" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大白录入界面</title>

<link rel="stylesheet" href="login.css">

</head>
<body>
<% 
    MulBy2BeanRemote mulBy2R1;
	Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
	jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	try {
    	Context context = new InitialContext(jndiProperties);  
	    final String appName = "";
	    final String moduleName = "BigProjectJSP";
	    final String distinctName = "";
	   System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName +  "/MulBy2Bean!javaee.ejb.stateful.remote.MulBy2BeanRemote?stateful");
	   //生成第一个客户端
	   
	    Object obj = context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName +  "/MulBy2Bean!javaee.ejb.stateful.remote.MulBy2BeanRemote?stateful");
	    mulBy2R1 =(MulBy2BeanRemote)obj;
	    int sum2=mulBy2R1.getsum();
	    System.out.println("这是上传的主页面学生的数量:"+sum2);
	    for(int i=0;i<sum2;i++){
%>
学号：<%=mulBy2R1.getvalue1(i)
%>
姓名：<%=mulBy2R1.getvalue2(i)
%>
序号：<%=mulBy2R1.getvalue3(i)
%>
<br>
<%
	}

	}
	catch (NamingException e) {
	    e.printStackTrace();
	}
%>

<br><br><br><br><br><br>

<center>
<h1>欢迎来到核酸检测样本采集界面</h1>
</center>
<%
session.setAttribute("value1", "qiunannan1");
session.setAttribute("value2", "qiunannan1");
session.setAttribute("value3", "qiunannan1");
session.setAttribute("value4", "qiunannan1");
%>
<br><br>

<form  method="get" action="/BigProjectJSP/Servlet4" >

<center>

试管编号：<input type="text" name="tubeid"><br><br>

学号：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="studentid"><br><br>

<a href="entersubmit.jsp">
<input type="button" value="提交" onclick="window.location.href('entersubmit.jsp')">
</a>&nbsp;&nbsp;&nbsp;&nbsp;


<input type="submit" value="增加">
&nbsp;&nbsp;&nbsp;&nbsp;

<a href="enterdelate.jsp">
<input type="button" value="删除" onclick="window.location.href('enterdelate.jsp')">
</a>&nbsp;&nbsp;&nbsp;&nbsp;

</center>
</form>

</body>
</html>