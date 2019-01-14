<%@page import="club.hellc.Biz.SaleBiz"%>
<%@page import="club.hellc.pojo.Orders"%>
<%@page import="club.hellc.Biz.OrdersBiz"%>
<%@page import="club.hellc.Biz.CustomerBiz"%>
<%@page import="club.hellc.Biz.ProductBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> <jsp:include page="yes.jsp" flush="true" /> 
 <%CustomerBiz cBiz=new CustomerBiz(); 
ProductBiz pBiz=new ProductBiz();
OrdersBiz oBiz =new OrdersBiz();
SaleBiz sBiz =new SaleBiz();

%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title><meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css/bootstrap.css" />
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
	</head>
	<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<table class="table table-bordered">
			
			<thead>
				
				<th>订单编号</th>
<th>顾客</th>
<th>商品</th>
<th>订单号</th>
<th>数量</th>
<th>价格</th>
<th>备注</th>
<th>操作</th>

			</thead>
			<tbody>
			<%
			if(session.getAttribute("outsaleflag")!=null && session.getAttribute("outsaleflag").equals("1"))
			out.print("<script>alert('出库成功');</script>");
			 %>
			<%
					List<Orders>  olist=new ArrayList<Orders>();
					 olist=oBiz.findAllByIspub("0");
					if( olist!=null)
					for(Orders  o :  olist){
					 %>
				<tr>
					<td><%=o.getOrdersid() %> </td>
					<td><%=cBiz.findById(o.getCustomerid()).getName() %> </td>
					<td><%=pBiz.findById(o.getProductid()).getName() %> </td>
					<td><%=o.getSaleid() %> </td>
					<td><%=o.getNumber() %> </td>
					<td><%=o.getPrice() %> </td>
					<td><%=sBiz.findById(o.getSaleid()).getRemark() %> </td>
					<td><a href="outSaleServlet?id=<%=o.getOrdersid() %> ">确定出库</a> </td>
				</tr>
				<% }
				session.setAttribute("outsaleflag",null);
				 %>
			</tbody>
		</table>
		
				</div></div></div>
		
	</body>
</html>
