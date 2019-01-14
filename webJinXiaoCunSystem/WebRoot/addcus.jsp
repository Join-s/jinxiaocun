<%@page import="club.hellc.pojo.Employee"%>
<%@page import="club.hellc.Biz.EmployeeBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> <jsp:include page="yes.jsp" flush="true" /> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addcus.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <!--新加客户 -->
		<form action="addCustomServlet" method="post">
			<table border="1" cellspacing="0" cellpadding="0">
				<tr>
					<td>名称：</td>
					<td><input type="text" value="" name="Name" /></td>
				</tr>
				<tr>
					<td>地址：</td>
					<td><input type="text" value="" name="Address" /></td>
				</tr>
				<tr>
					<td>电话：</td>
					<td><input type="text" value="" name="Phone" /></td>
				</tr>
				<tr>
					<td>传真：</td>
					<td><input type="text" value="" name="Fax" /></td>
				</tr>
				<tr>
					<td>邮件：</td>
					<td><input type="text" value="" name="Postalcode" /></td>
				</tr>
				<tr>
					<td>联系人：</td>
					<td><select name="Constactperson">
					<%
					EmployeeBiz eBiz =new EmployeeBiz();
					List<Employee> elist = new ArrayList<Employee>();
					elist=eBiz.findAll();
					
					if(elist!=null)
					for(Employee e : elist){
					 %>
							<option value="<%=e.getEmployeeid() %>"><%=e.getName() %> </option>	
							<% } %>
						</select></td>
				</tr>
				
				<tr>
				
				<td><input  type="submit" value="添加"/> </td>
				<td>  </td>
				</tr>
			</table>
		</form>
  </body>
</html>
