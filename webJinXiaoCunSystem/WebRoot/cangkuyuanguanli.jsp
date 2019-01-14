<%@page import="club.hellc.pojo.Uusers"%>
<%@page import="club.hellc.Biz.UusersBiz"%>
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
<style type="text/css">
* {
	padding: 0px;
	margin: 0px;
}

table tr th {
	font-size: 20px;
	text-align: center;
	line-height: 20px;
}

table tr td {
	text-align: center;
	height: 30px;
}

table tr td input {
	text-align: center;
	height: 30px;
}
</style><style type="text/css">
		td input[type='text']{
		
		width:100%;
		height: 100%;
		border: 0px;
		}
		
		</style>
<script type="text/javascript" src="js/jquery-2.1.1.min.js" ></script>
		<script  type="text/javascript">
			$(function(){
				
				$(".updateUser").click(function(){
					 
					var id=$(this).parent().parent().children().eq(1).children().val();
					var name=$(this).parent().parent().children().eq(2).children().val();
					var pwd=$(this).parent().parent().children().eq(3).children().val();
					var action1=$(this).attr('href');
					var myform=$("<form></form>");
					myform.attr('target', '_self');
					myform.attr("action",action1);
					myform.attr("method","post");
					var input1 = $("<input type='text' name='id' />");
					input1.attr("value",id);
					myform.append(input1);
					 var input2 = $("<input type='text' name='pwd' value='"+pwd+"' />");
					myform.append(input2);
					var input3 = $("<input type='text' name='name' value='"+name+"' />");
					myform.append(input3);
					var input4 = $("<input type='text' name='type' value='2' />");
					myform.append(input4);
					myform.appendTo(document.body).submit();  
					return false;
				});
			});
		</script>
</head>

<body>
		<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
<form action="addUsers" method="post">
			添加管理员：&nbsp;&nbsp;&nbsp;
			登陆名：
			<input type="text" value="" name="name" />&nbsp;&nbsp;&nbsp;
			密码：
			<input type="password" value="" name="pwd" />&nbsp;&nbsp;&nbsp;
			<input type="hidden" value="2" name="type" />&nbsp;&nbsp;&nbsp;
			<input type="submit" value="添加"/>
		</form><br/><br/>
				<table class="table table-bordered">
			<tr>
				<th>状态</th>
				<th>员工编号</th>
				<th>姓名</th>
				<th>密码</th>
				<th>职务</th>
				<th>创建日期</th> 
				<th>操作</th>
				
				</tr>
			<%
			
				Integer row=3;
				Integer curPage=1;
				Integer sumPage=1;
				UusersBiz uBiz =new UusersBiz();
				try{
					curPage=Integer.parseInt(request.getParameter("curPage")) ;
				}catch(Exception ex){}
				
				sumPage=uBiz.getCountsOfRow("2",row);
				
				if(curPage==null || curPage<1)
				curPage=1;
				if(curPage>sumPage)
					curPage=sumPage;
			List<Uusers> ulist =new ArrayList<Uusers>();
			
			ulist=uBiz.findAll("2", curPage, row);
			if(ulist!=null)
			
			for(Uusers u:ulist){
			
			%>
			<tr>
				<td><input type="checkbox" class="cangKuUser checkbox" /></td>
				<td><input type="text" value='<%=u.getUusersid() %>' readonly="readonly" /></td>
				<td><input type="text"
					value='<%=u.getName()%>' /></td>
				<td><input type="text"
					value='<%=u.getPsw()%> ' /></td>
				<td><input type="text"
					value='<%=u.getType().equals("2")?"仓库管理员":""%>'  readonly="readonly" /></td>
				<td><input type="text"
					value='<%=u.getCreatedate()%>'  readonly="readonly" /></td>
				<td>
				<a href="updateUsersServlet" onclick="return confirm('确定修改？')"  class="updateUser">修改</a> &nbsp;&nbsp;|&nbsp;&nbsp; 
				<a href="deleteUsersServlet?id=<%=u.getUusersid() %>&type=<%=u.getType()%>" onclick="return confirm('确定删除？')" >删除</a></td>
			</tr>
			<% } %>
			<tr >
				<td colspan="7" align="right" style="text-align: right;">
							当前页数:[<%=curPage %>/<%=sumPage %>]&nbsp;&nbsp;
								<a href="cangkuyuanguanli.jsp?curPage=1">首页</a> &nbsp;&nbsp;
								<a href="cangkuyuanguanli.jsp?curPage=<%=curPage-1 %>">上一页</a>&nbsp;&nbsp;
								<a href="cangkuyuanguanli.jsp?curPage=<%=curPage+1 %>">下一页</a>&nbsp;&nbsp;
								<a href="cangkuyuanguanli.jsp?curPage=<%=sumPage %>">尾页</a>&nbsp;&nbsp;
				</td>
			</tr>
		</table></div></div></div>
</body>

</html>