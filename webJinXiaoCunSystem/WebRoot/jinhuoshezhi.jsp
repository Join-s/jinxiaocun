<%@page import="club.hellc.pojo.Producttype"%>
<%@page import="club.hellc.Biz.ProducttypeBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <jsp:include page="yes.jsp" flush="true" /> 
 <% ProducttypeBiz protypeBiz=new ProducttypeBiz(); %>

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
		 
		<script>
		function check(){
		return true;
		
		}
		
		</script>
	</head>
	<body>
	添加商品信息:<br/>
	<br/>
	<br/>
	<style>
			input:text{
				
				width: 100%;
				height: 100%;
			}
			table thead tr th{
				border-bottom: 1px solid black;
			}
			table tbody tr td{
				/*border-bottom: 1px solid black;*/
			}
			
		</style>
		<form action="EsAddProductServlet" method="post" onsubmit="return check()">
			
			<table border="0px" cellpadding="0px" cellspacing="0px">
				<thead>
					<tr>
					<th>状 态&nbsp;&nbsp;&nbsp;</th>
					<th>商品种类</th>
					<th>商品名</th>
					<th>规格</th>
					<th>计量单位</th>
					<th>价格</th>
					</tr>
				</thead>
				<tbody>
					
					<tr>
						<td>
							<input type="checkbox" name="" class="checkbox" />
						</td>
						<td>
						
							<select name="producttype">
						<%
						
						List<Producttype> protypeList =new ArrayList<Producttype>(); 
						protypeList=protypeBiz.findAll();
						if(protypeList!=null)
							for(Producttype protype:protypeList){
						 %>
								<option value="<%=protype.getProducttypeid() %>"><%=protype.getTypename() %></option>
								
						<% } %>
							</select>
						</td>
						<td>
							<input type="text" value="" name="productName"/>
						</td>
						<td>
							<input type="text" value="" name="productSpec"/>
						</td>
						<td>
							<input type="text" value="" name="productUnit"/>
						</td>
						<td>
							<input type="text" value="" name="price"/>
						</td>
					
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td>
							<br />
						</td>
						<td></td>
						<td></td>
						
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td>
							<input type="submit" value="确定添加" /> | <input type="reset" value="重新输入" />
						</td>
						<td></td>
						<td></td>
						
					</tr>
					
				</tbody>
			</table>
			
		</form>
		<%if(request.getAttribute("addesPro")!=null && request.getAttribute("addesPro").equals("1")){
		out.print("<script>alert('添加成功');</script>");
		}
		
		 %>
	
	
	</body>
</html>
