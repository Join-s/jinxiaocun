<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="club.hellc.test.*"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
	
	
	<%
	
	if(session.getAttribute("uname")==null){
	
	 %>
	
	
	
		<form action="loginServlet" method="post">
			<table border="0" cellspacing="5" cellpadding="2">
				<tr>
					<td align="right">登陆名：</td>
					<td><input type="text" name="uname" value=""/></td>
				</tr>
				<tr>
					<td align="right">密码：</td>
					<td><input type="password" name="upwd" value=""/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit"  value="登陆"/></td>
				</tr>
			</table>
		</form>
	<%}else{
	
	%>
	
	<%=session.getAttribute("uname") %> ,欢迎登陆！
	
	<%
	
	} %>
		
	</body>
</html>
