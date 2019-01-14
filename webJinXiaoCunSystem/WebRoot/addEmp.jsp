<%@page import="club.hellc.pojo.Dept"%>
<%@page import="club.hellc.Biz.DeptBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> <jsp:include page="yes.jsp" flush="true" /> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addEmp.jsp' starting page</title>
    
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
   <form action="addEmployee" method="post">
	<table border="1" cellpadding="2" cellspacing="0">
		<caption><h2>注册员工</h2></caption>
		<tbody>
			<tr>
				<td>姓名：</td>
				<td>
					<input type="text" value="" name="name" />
				</td>
			</tr>
			
			<tr>
				<td>部门</td>
				<td>
					<select name="deptid">
					<%
					DeptBiz dBiz =new DeptBiz();
					
					List<Dept> list=new ArrayList<Dept>();
					list=dBiz.findAll();
					if(list!=null)
					
					
					for(Dept d:list){
					 %>
						<option value="<%=d.getDeptid()%> "><%=d.getName() %> </option>
						<%} %>
					</select>
				</td>
			</tr>
			<tr>
				<td>职位</td>
				<td><input type="text" name="duty" value="" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<input type="radio" name="sex" id="" class="r-sex" value="男" checked="checked" />男
				    <input type="radio" name="sex" id="" class="r-sex"  value="女" />女
				</td>
			</tr>
			<tr>
				<td>身份证：</td>
				<td>
					<input type="text" value="" name="idard" />
				</td>
			</tr>
			<tr>
				<td>生日:</td>
				<td>
					<input type="date" value="" name="borthdate" />
				</td>
			</tr>
			<tr>
				<td>联系电话:</td>
				<td>
					<input type="text" value="" name="phone" />
				</td>
			</tr>
			<tr>
				<td>邮件:</td>
				<td>
					<input type="email" value="" name="email" />
				</td>
			</tr>
			<tr>
				<td>住址：</td>
				<td>
					<input type="text" value="" name="address" />
				</td>
			</tr>
			<tr>
				<td>合同生效期:</td>
				<td>
					<input type="date" value="" name="hiredate" />
				</td>
			</tr>
			<tr>
				<td>合同终止期:</td>
				<td>
					<input type="date" value="" name="maturdate" />
				</td>
			</tr>
			<tr><td></td>
				<td>
					<input type="submit" value="提交" />
				</td>
				
			</tr>
		</tbody>
	</table>
</form>
  </body>
</html>
