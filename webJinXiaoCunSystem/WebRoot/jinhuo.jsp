<%@page import="club.hellc.pojo.Employee"%>
<%@page import="club.hellc.Biz.EmployeeBiz"%>
<%@page import="club.hellc.Biz.StorehouseBiz"%>
<%@page import="club.hellc.pojo.Storehouse"%>
<%@page import="club.hellc.Biz.ProductBiz"%>
<%@page import="club.hellc.pojo.Product"%>
<%@page import="club.hellc.pojo.Producttype"%>
<%@page import="club.hellc.Biz.EnterStockBiz"%>
<%@page import="club.hellc.Biz.ProducttypeBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <jsp:include page="yes.jsp" flush="true" /> 
<%
ProducttypeBiz protypBiz =new ProducttypeBiz();
ProductBiz proBiz =new ProductBiz();
EnterStockBiz esBiz =new EnterStockBiz();
StorehouseBiz shBiz=new StorehouseBiz();
EmployeeBiz eBiz=new EmployeeBiz();

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
		<title></title>
	</head>

	<body>
	

			
		<form action="EnterStockServlet" method="post">
			<table border="0px" cellpadding="10px" cellspacing="10px" align="left">
				<caption>进货操作</caption>
				
				<tr>
				<td>商品大类：</td>
					<td>
						<select name="">
						
			<option value="--">----------</option>
						<%
						List<Producttype> protypList=new ArrayList<Producttype>();
						protypList=protypBiz.findAll();
						if(protypList!=null)
						for(Producttype protype:protypList){
						
			%>
							<option value='<%=protype.getProducttypeid() %>'><%=protype.getTypename() %></option>
			<%
				}
			%>
							
						</select>
					</td>
					<td><label for="goodsName">商品名称：</label></td>
					<td><select name="productID">
						
			<option value="-1">----------</option>
						<%
						List<Product> proList =new ArrayList<Product>();
						proList=proBiz.findAll();
						if(proList!=null)
						for(Product pro:proList){
			%>
							<option value='<%=pro.getProductid() %>'><%=pro.getName() %></option>
			<%
				}
			%>
							
						</select></td>
					
					
				</tr>
				<tr>
					<td><label for="goodsnum">商品数量：</label></td>
					<td><input id="goodsnum" type="text" value="" name="number"/></td>
					<td>
						<lable>是否上架：</lable>
					</td>
					<td>
						<select name="isPub">
						<option value="1">是</option>
						<option value="0">否</option>
						</select> 
					</td>
				</tr>
				<tr>
					<!--此处为联动餐单-->
					<td><label for="goodsPrice">商品价格：</label></td>
					<td><input id="goodsPrice" type="text" value="" name="price"/></td>
					<td>仓库：</td>
					<td>
						<select name="storeHouseID">
			<option value="-1">----------</option>
						<%
						List<Storehouse> shList =new ArrayList<Storehouse>();
						shList=shBiz.findAll();
						if(shList!=null)
						for(Storehouse sh:shList){
						%>
							<option value='<%=sh.getStorehouseid() %>'><%=sh.getName() %></option>
						<% } %>
							
						</select>
					</td>
				</tr>
				<tr>
					<td>
					进货人：
					<select name="employeeId">
					<%
					List<Employee> elist =new ArrayList();
					elist=eBiz.findAll();
					if(elist!=null)
					for(Employee e:elist){
					 %>
					<option value="<%=e.getEmployeeid()%>"><%=e.getName() %></option>
					
					<%
					} %>
					</select>
					
					<input type="hidden" value="1" name="employeeId" /> </td>
					<td><input type="submit" value="提交" /> </td>
				</tr>
				
				<%
				try{
				String flag=  request.getAttribute("flag").toString();
				if(flag!=null)
				if(flag.equals("0")){
				out.print("<script>alert('添加失败！');</script>");
				} else{
				out.print("<script>alert('添加成功！');</script>");
				
				}
				}catch(Exception e){}
				 %>

			</table>
		</form>
	</body>

</html>