<%@page import="club.hellc.pojo.Dept"%>
<%@page import="club.hellc.Biz.DeptBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> <jsp:include page="yes.jsp" flush="true" /> 

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
		<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css/bootstrap.css" />
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
	</head>
	<body>
		<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
	<form action="addDeptServlet" method="post">
			
		部门：<input type="text" value="" name="name" />
		备注：<input type="text" value="" name="remark" />
			<input type="submit"  value="添加"/>
		</form>
				<table class="table table-bordered">
		<caption>添加部门种类</caption>
			<thead>
				<tr>
					<td>编号</td>
					<td>名称</td>
					<td>备注</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
			<% 
			DeptBiz dBiz =new DeptBiz();
			List<Dept> list =new ArrayList<Dept>();
			list=dBiz.findAll();
			if(list!=null)
			for(Dept d:list){			
			 %>
				<tr>
					<td><%=d.getDeptid() %> </td>
					<td><%=d.getName() %> </td>
					<td><%=d.getRemark() %> </td>
					<td><a href="deleteDeptServlet?id=<%=d.getDeptid()%>">删除</a> </td>
				</tr>
				<%} %>
				
			</tbody>
			
		</table>
		
		</div>
		</div>
		</div>
	</body>
</html>
