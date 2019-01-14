<%@page import="club.hellc.Biz.EmployeeBiz"%>
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
<title></title><meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="css/bootstrap.css" />
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script><style type="text/css">
		td input[type='text']{
		
		width:100%;
		height: 100%;
		border: 0px;
		}
		
		</style>
<style type="text/css">
* {
	padding: 0px;
	margin: 0px;
}

table tr th {
	font-size: 14px;
	text-align: center;
	line-height: 20px;
}

table tr td {
	font-size: 12px;
	text-align: center;
	height: 25px;
}

table tr td input {
	font-size: 12px;
	text-align: center;
	height: 25px;
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
					<th style="width: 20px;">进货编号</th>
					<th style="width: 130px;">商品名</th>
					<th style="width: 130px;">仓库名</th>
					<th style="width: 116px;">进货员工名</th>
					<th style="width: 80px;">进货数量</th>
					<th style="width: 80px;">单价</th>
					<th style="width: 80px;">总计</th>
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
					<td><input type="text" readonly="readonly" value='<%=proBiz.findById(es.getProductid()).getName()   %>'/></td>
					<td><input type="text" readonly="readonly" value='<%=shBiz.findById(es.getStorehouseid()).getName()     %>'/></td>
					 
					<td><input type="text" readonly="readonly" value='<%=eBiz.findById(es.getEmployeeid()).getName() %>'/></td>
					<td><input type="text" readonly="readonly" value='<%=es.getNumber() %>'/></td>
					<td><input type="text" readonly="readonly" value='<%=es.getPrice() %>'/></td>
					<td><input type="text" readonly="readonly" value='<%=es.getPrice()*es.getNumber() %>'/></td>
					<td><input type="text" readonly="readonly" value='<%=es.getEnterstockdate()  %>'/></td>
					<td><input type="text" readonly="readonly" value='<%=es.getIspub().equals("1")?"已确认":"未确认" %>'/></td>
				</tr>
			<%
				}
			%>
			
			</table>
		</form>
		</div></div></div>
</body>
</html>
