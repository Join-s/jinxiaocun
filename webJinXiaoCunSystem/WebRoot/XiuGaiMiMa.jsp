<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <jsp:include page="yes.jsp" flush="true" /> 
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
	<form action="updateUpwdServlet" method="post">
			<table border="0" cellspacing="5" cellpadding="2">
				<tr>
					<td align="right">用户名：</td>
					<td><input type="text" name="uname" value="<%=session.getAttribute("uname") %>" readonly="readonly"/></td>
				</tr>
				<tr>
					<td align="right">密码：</td>
					<td><input type="password" name="upwd" value=""/></td>
				</tr>
				<tr>
					<td align="right">确定密码：</td>
					<td><input type="password" name="" value=""/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit"  value="修改"/></td>
				</tr>
			</table>

		</form>
	
	
	</body>
</html>
