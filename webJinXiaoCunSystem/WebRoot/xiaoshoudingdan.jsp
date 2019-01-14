<%@page import="club.hellc.Biz.ProductBiz"%>
<%@page import="club.hellc.pojo.Product"%>
<%@page import="club.hellc.pojo.Customer"%>
<%@page import="club.hellc.Biz.CustomerBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> <jsp:include page="yes.jsp" flush="true" /> 
<%CustomerBiz cBiz=new CustomerBiz(); 
ProductBiz pBiz=new ProductBiz();

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
	<form action="addOrdersServlet" method="post">

				<table class="table table-bordered">
				<tr>
					<th></th>
				</tr>
				<tr>
					<td>下单人：
						<select name="customerid">
					<%
					List<Customer> clist=new ArrayList<Customer>();
					clist=cBiz.findAll();
					if(clist!=null)
					
					for(Customer c : clist){
					
					 %>
							<option value="<%=c.getCustomerid() %>"><%=c.getName() %></option>
							
							<% } %>
						</select>
					</td>
					<td>
						下单商品：
						<select name="productid">
						<%
					List<Product> prolist=new ArrayList<Product>();
					prolist=pBiz.findAll();
					if(prolist!=null)
					
					for(Product pro : prolist){
					
					 %>
							<option value="<%=pro.getProductid() %>"><%=pro.getName() %></option>
							<% } %>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						数量：<input value="" type="text" name="number" />
					</td>
					<td>价格：<input value="" type="text" name="price"/></td>
				</tr>
				
				<tr>
					<td>备注：<input type="text" name="remark" value="" /> </td>
					<td><input type="submit" name="" id="" value="下单" /> </td>
				</tr>
			</table>
		</form>		</div></div></div>
	</body>
</html>
