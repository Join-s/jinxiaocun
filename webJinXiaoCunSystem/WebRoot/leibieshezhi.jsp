<%@page import="club.hellc.pojo.Producttype"%>
<%@page import="club.hellc.Biz.ProducttypeBiz"%>
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
		<title></title><link rel="stylesheet" href="css/bootstrap.css" />
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script><style type="text/css">
		td input[type='text']{
		
		width:100%;
		height: 100%;
		border: 0px;
		}
		
		</style>
	</head>
	<body>
	
	<%
	if(request.getAttribute("addprotypeflag")!=null && request.getAttribute("addprotypeflag").equals("1")){
		request.setAttribute("addprotypeflag", "0");
		out.print("<script>alert('添加成功');</script>");
	}
	
	 %>
			<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
	<form action="addProductType" method="post">
			添加商品类名：<br /><br />
			商品类名：
			<input type="text" value="" name="productTypeName" />
			<input type="submit" value="添加"/>
		</form>
		
		
		<br />
		详细信息：
		<form action="" method="post">
				<table class="table table-bordered">
			
			<thead>
				<tr>
					<th>类别ID</th>
					<th>商品类名</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<%
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				
				ProducttypeBiz ptBiz =new ProducttypeBiz();
				List<Producttype> pList=new ArrayList<Producttype>();
				Integer row=10;
				Integer curPage=1;
				Integer sumPage=1;
				
				try{
					curPage=Integer.parseInt(request.getParameter("curPage")) ;
					
				
				}catch(Exception ex){}
				
				sumPage=ptBiz.getCountsOfRow(row);
				
				if(curPage==null || curPage<1)
				curPage=1;
				if(curPage>sumPage)
					curPage=sumPage;
				pList=ptBiz.findAll(curPage, row);
				if(pList!=null)
				for(Producttype pt : pList){
				 %>
				
				<tr>
					<td>
						<input type="text" readonly="readonly" value="<%=pt.getProducttypeid() %>" name="" />
					</td>
					<td>
						<input type="text" value="<%=pt.getTypename() %>" name="" />
					</td>
					<td>
						<a href="#">修改</a> | <a href="#">删除</a> 
					</td>
				</tr>
				<% } %>
			</tbody>
			</table>
		</form>
		<div id="">
			当前页数:[<%=curPage %>/<%=sumPage %>]&nbsp;&nbsp;
			<a href="leibieshezhi.jsp?curPage=1">首页</a> &nbsp;&nbsp;
			<a href="leibieshezhi.jsp?curPage=<%=curPage-1 %>">上一页</a>&nbsp;&nbsp;
			<a href="leibieshezhi.jsp?curPage=<%=curPage+1 %>">下一页</a>&nbsp;&nbsp;
			<a href="leibieshezhi.jsp?curPage=<%=sumPage %>">尾页</a>
		</div></div></div></div>
	</body>
</html>
