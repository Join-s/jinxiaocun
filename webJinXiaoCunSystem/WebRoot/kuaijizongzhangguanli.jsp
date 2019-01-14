<%@page import="club.hellc.Biz.ProductBiz"%>
<%@page import="club.hellc.pojo.Accountings"%>
<%@page import="club.hellc.Biz.AccountingsBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <jsp:include page="yes.jsp" flush="true" /> 

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
		<script type="text/javascript">
			$(function(){
				$("#selSort").change(function(){
					if($(this).val()=="setYear"){
						$("#year").css("display","");
						$("#month").css("display","none");
						$("#day").css("display","none");
					}else if($(this).val()=="setMonth"){
						$("#year").css("display","none");
						$("#month").css("display","");
						$("#day").css("display","none");
					}
					else if($(this).val()=="setDay"){
						$("#year").css("display","none");
						$("#month").css("display","none");
						$("#day").css("display","");
					}
				});
			});
		</script>
	</head>

	<body>
			<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
		  <form action="findbytimeServlet" method="post">
	时间：<input type="text" value=""name="time" />
	<input type="submit" value="搜索" />
	</form>
				<table class="table table-bordered">
			<thead>
			<tr>
				<th>出货时间</th>
				<th>出货商品</th>
				<th>出货数量</th>
				<th>出货价格</th>
				<th>总计</th>
			</tr>
			</thead>
			<tbody>
			<%
			request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
			AccountingsBiz aBiz = new AccountingsBiz();
			
			ProductBiz pBiz=new ProductBiz();
			List<Accountings> list = new ArrayList<Accountings>();
			Integer curPage=1;
			Integer sumPage=1;
			Integer row=5;
			try{
				curPage=Integer.parseInt(request.getParameter("curPage"));
			
			}catch(Exception e){
			curPage=1;
			}
			sumPage=aBiz.getCountsOfRow(row);
			if(curPage<1){
			curPage=1;}
			if(curPage>sumPage){
			curPage=sumPage;}
			
			if(request.getAttribute("timelist")==null){
			list=aBiz.findAll(curPage, row);
			}else{
				list=(ArrayList<Accountings>)request.getAttribute("timelist");
			}
			
			if(list!=null)
			for(Accountings a :list){
			 %>
			
			<tr>
				<td><%=a.getCreatedate() %> </td>
				<td><%=pBiz.findById(a.getProductid()).getName()  %> </td>
				<td><%=a.getNumber() %></td>
				<td><%=a.getPrice() %></td>
				<td><%=a.getPrice()*a.getNumber() %></td>
			</tr>
			<%} %>
			</tbody>
		</table>
		<p>当前页数:[<%=curPage %>/<%=sumPage %>]&nbsp;&nbsp;
								<a href="kuaijizongzhangguanli.jsp?curPage=1">首页</a> &nbsp;&nbsp;
								<a href="kuaijizongzhangguanli.jsp?curPage=<%=curPage-1 %>">上一页</a>&nbsp;&nbsp;
								<a href="kuaijizongzhangguanli.jsp?curPage=<%=curPage+1 %>">下一页</a>&nbsp;&nbsp;
								<a href="kuaijizongzhangguanli.jsp?curPage=<%=sumPage %>">尾页</a>&nbsp;&nbsp;</p>
		</div></div></div>
		 
	</body>

</html>