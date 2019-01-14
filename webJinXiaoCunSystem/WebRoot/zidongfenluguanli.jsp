<%@page import="club.hellc.pojo.Autoclass"%>
<%@page import="club.hellc.Biz.ProductBiz"%>
<%@page import="club.hellc.pojo.Accountings"%>
<%@page import="club.hellc.Biz.AccountingsBiz"%>
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
		   <form action="zidongfenluguanli.jsp" method="post">
		时间：<input type="text" value=""name="time" />
	<input type="submit" value="查询" />
	</form>
	
	<%
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			AccountingsBiz aBiz = new AccountingsBiz();
			String  time=request.getParameter("time");
			if(time==null)
				time="2018";
			List<Autoclass> aclist =new ArrayList<Autoclass>();
			aclist=aBiz.findAllByTimeAuto(time);
			%>
				<table class="table table-bordered">
			<tr>
				<th>时间</th>
				<th>支出</th>
				<th>收入</th>
				<th>总计</th>
			</tr>
			<% 
			if(aclist!=null) 
			for(Autoclass ac:aclist){ %>
			<tr>
				<td><%=ac.getDate() %> </td>
				<td><%=ac.getZhi() %> </td>
				<td><%=ac.getShou() %> </td>
				<td><%=ac.getZong() %></td>
			</tr>
			<%} %>
		</table>	</div></div></div>
	</body>

</html>