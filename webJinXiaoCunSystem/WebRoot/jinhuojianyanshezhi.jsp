<%@page import="club.hellc.pojo.Enterstock"%>
<%@page import="club.hellc.Biz.StorehouseBiz"%>
<%@page import="club.hellc.Biz.EnterStockBiz"%>
<%@page import="club.hellc.Biz.ProductBiz"%>
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
		<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css/bootstrap.css" />
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script> 
			 <style type="text/css">
		td input[type='text']{
		
		width:100%;
		height: 100%;
		border: 0px;
		}
		
		</style>
	</head>
	<body>
				<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
		<form action="" method="post">
				<table class="table table-bordered">
				<tr>
					<th style="width: 40px;">进货编号</th>
					<th style="width: 40px;">商品编号</th>
					<th style="width: 130px;">商品名</th>
					<th style="width: 130px;">仓库编号</th>
					<th style="width: 116px;">进货员工编号</th>
					<th style="width: 80px;">进货数量</th>
					<th style="width: 80px;">单价</th>
					<th style="width: 116px;">进货时间</th>
					<th style="width: 116px;">是否确认</th>
				</tr>
				
				
			<%
			List<Enterstock> esList =new ArrayList<Enterstock>();
						esList=esBiz.findAll();
						if(esList!=null)
						for(Enterstock es:esList){
			%>
			<tr>
					<td><input type="text" readonly="readonly" value='<%=es.getEnterstockid() %>'/></td>
					<td><input type="text" readonly="readonly" value='<%=es.getProductid()  %>'/></td>
					<td><input type="text" readonly="readonly" value='<%=proBiz.findById(es.getProductid()).getName()   %>'/></td>
					<td><input type="text" readonly="readonly" value='<%=es.getStorehouseid()  %>'/></td>
					<td><input type="text" readonly="readonly" value='<%=es.getEmployeeid() %>'/></td>
					<td><input type="text" readonly="readonly" value='<%=es.getNumber() %>'/></td>
					<td><input type="text" readonly="readonly" value='<%=es.getPrice() %>'/></td>
					<td><input type="text" readonly="readonly" value='<%=es.getEnterstockdate()  %>'/></td>
					<td><input type="text" readonly="readonly" value='<%=es.getIspub().equals("1")?"确认":"未确认" %>'/></td>
				</tr>
			<%
				}
			%>
			
			</table>
		</form>
		</div>
		</div>
		</div>
	</body>
</html>
