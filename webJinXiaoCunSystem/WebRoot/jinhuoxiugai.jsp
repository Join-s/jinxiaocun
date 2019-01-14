<%@page import="club.hellc.pojo.Enterstock"%>
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
	<%
	try{
	 %>
	
	<form action="EnterStockUpdateServlet" method="post">
				<%
				
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				
				if(request.getAttribute("updateesflag")!=null && request.getAttribute("updateesflag").equals("1")){
					out.print("<script>alert('修改成功')</script>");
				}
				Integer enterstockid=-1;
				Enterstock es=null;
				try{
				    enterstockid=Integer.parseInt(request.getParameter("enterstockid")) ;
					if(enterstockid>0){
					 	es=esBiz.findById(enterstockid);
					} 
				}catch(Exception e){
					if(e.getMessage()==null){
						es=null;
						out.print("错误："+e.getMessage());}
				}
				 %>
			<table border="0px" cellpadding="10px" cellspacing="10px" align="left">
				<caption>进货修改</caption>
				 <tr>
				 <td>
				 	商品编号：
				 	</td>
				 	<td>
				 	<input type="text" value='<%=enterstockid>0?enterstockid:"" %>' name="enterstockid"/>
				 	</td>
				 
				 </tr>
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
							if(es!=null && protype.getProducttypeid()==proBiz.findById(es.getProductid()).getProducttypeid()){
						%>
							<option value='<%=protype.getProducttypeid() %>' selected="selected"><%=protype.getTypename() %></option>
			<% }else{ %>
				
				<option value='<%=protype.getProducttypeid() %>' ><%=protype.getTypename() %></option>
				<% }} %>
							
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
						
						if(es !=null && es.getProductid()==pro.getProductid()){
			%>
							<option value='<%=pro.getProductid() %>' selected="selected"><%=pro.getName() %></option>
			<%
				}else{
				
				%>
				<option value='<%=pro.getProductid() %>'><%=pro.getName() %></option>
				<%
				}}
			%>
						</select></td>
					
					
				</tr>
				<tr>
					<td><label for="goodsnum">商品数量：</label></td>
					<td><input id="goodsnum" type="text" value="<%=es!=null?es.getNumber()!=null?es.getNumber():"":"" %>" name="number"/></td>
					<td>
						<lable>是否上架：</lable>
					</td>
					<td>
						<select name="isPub">
						<%
						if(es !=null && es.getIspub().equals("1")){
						
						 %>
						<option value="1" selected="selected">是</option>
						<option value="0">否</option>
						<%}else{ %>
						<option value="1">是</option>
						<option value="0" selected="selected">否</option>
						
						<%} %>
						</select> 
					</td>
				</tr>
				<tr>
					<!--此处为联动餐单-->
					<td><label for="goodsPrice">商品价格：</label></td>
					<td><input id="goodsPrice" type="text" value='<%=es !=null?es.getPrice():"" %>' name="price"/></td>
					<td>仓库：</td>
					<td>
						<select name="storeHouseID">
			<option value="-1">----------</option>
						<%
						List<Storehouse> shList =new ArrayList<Storehouse>();
						shList=shBiz.findAll();
						if(shList!=null)
						for(Storehouse sh:shList){
						if(es !=null && es.getStorehouseid()==sh.getStorehouseid()){
						%>
							<option value='<%=sh.getStorehouseid() %>' selected="selected"><%=sh.getName() %></option>
						<% } else{
						%>
						<option value='<%=sh.getStorehouseid() %>'><%=sh.getName() %></option>
						
						<% }} %>
							
						</select>
					</td>
				</tr>
				<tr>
					<td><input type="hidden" value="1" name="employeeId" /> </td>
					<td><input type="submit" value="提交" /> </td>
				</tr>
				

			</table>
		</form>
		
		<%
	}catch(Exception e){
	out.print("出错啦！");
	}
	 %>
	</body>
</html>
