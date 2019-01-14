<%@page import="club.hellc.Biz.DeptBiz"%>
<%@page import="club.hellc.pojo.Employee"%>
<%@page import="club.hellc.Biz.EmployeeBiz"%>
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
		<style>
		*{margin: 0;
		padding: 0;}
		
		th,td,input{
		width:100px;
		}
		
		</style>
		<script type="text/javascript" src="js/jquery-2.1.1.min.js" ></script>
		<script  type="text/javascript">
			$(function(){
				
				$(".updateEmpl").click(function(){
					 
					var employeeid=$(this).parent().parent().children().eq(0).children().val();
					var deptid=$(this).parent().parent().children().eq(1).children().val();
					var name=$(this).parent().parent().children().eq(2).children().val();
					var duty=$(this).parent().parent().children().eq(3).children().val();
					var sex=$(this).parent().parent().children().eq(4).children().val();
					var borthdate=$(this).parent().parent().children().eq(5).children().val();
					var hiredate=$(this).parent().parent().children().eq(6).children().val();
					var maturdate=$(this).parent().parent().children().eq(7).children().val();
					var idard=$(this).parent().parent().children().eq(8).children().val();
					var address=$(this).parent().parent().children().eq(9).children().val();
					var phone=$(this).parent().parent().children().eq(10).children().val();
					var email=$(this).parent().parent().children().eq(11).children().val();
					
					var action1=$(this).attr('href');
					
					alert(employeeid+deptid+name+duty+sex+borthdate+hiredate+maturdate+idard+address+phone+email);
					var myform=$("<form></form>");
					myform.attr('target', '_self');
					myform.attr("action",action1);
					myform.attr("method","post");
					var input1 = $("<input type='text' name='employeeid' value='"+employeeid+"'/>");
					myform.append(input1);
					 var input2 = $("<input type='text' name='deptid' value='"+deptid+"' />");
					myform.append(input2);
					var input3 = $("<input type='text' name='name' value='"+name+"' />");
					myform.append(input3);
					myform.append($("<input type='text' name='duty' value='"+duty+"' />"));
					myform.append($("<input type='text' name='sex' value='"+sex+"' />"));
					myform.append($("<input type='text' name='borthdate' value='"+borthdate+"' />"));
					myform.append($("<input type='text' name='hiredate' value='"+hiredate+"' />"));
					myform.append($("<input type='text' name='maturdate' value='"+maturdate+"' />"));
					myform.append($("<input type='text' name='idard' value='"+idard+"' />"));
					myform.append($("<input type='text' name='address' value='"+address+"' />"));
					myform.append($("<input type='text' name='phone' value='"+phone+"' />"));
					myform.append($("<input type='text' name='email' value='"+email+"' />"));
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
<a href="addEmp.jsp">注册</a>
				<table class="table table-bordered">
	
	<caption>员工表</caption>
	<thead>
	<tr>
		<th>员工编号</th>
		<th>部门</th>
		<th>姓名</th>
		<th>职位</th>
		<th>性别</th>
		<th>生日</th>
		<th>合同开始日期</th>
		<th>合同终止日期</th>
		<th>身份证</th>
		<th>住址</th>
		<th>电话</th>
		<th>邮件</th>
		<th>操作</th>
		</tr>
	</thead>
	
	<tbody>
	<%
	Integer row=2;
	Integer currPage=1;
	Integer sumPage=1;
	EmployeeBiz eBiz=new EmployeeBiz();
	DeptBiz dBiz =new DeptBiz();
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	try{
	currPage=Integer.parseInt(request.getParameter("currPage"));
	}catch(Exception e){
	currPage=1;
	}
	sumPage=eBiz.getCountsOfRow(row);
	if(currPage<1) {currPage=1;}
	if(currPage>sumPage){ currPage=sumPage;}
	
	List<Employee> elist = new ArrayList<Employee>();
	elist=eBiz.findAll(currPage,row);
	
	if(elist!=null)
	for(Employee ee:elist){
	 %>
	<tr>
		<td> <input type="text" value="<%=ee.getEmployeeid() %>" readonly="readonly" /></td>
		<td><input type="text" value="<%=dBiz.findById(ee.getDeptid()).getName() %>" readonly="readonly" /></td>
		<td><input type="text" value="<%=ee.getName() %>" readonly="readonly" /></td>
		<td><input type="text" value="<%=ee.getDuty() %>"   /></td>
		<td><input type="text" value="<%=ee.getSex() %>" readonly="readonly" /></td>
		<td><input type="text" value="<%=ee.getBorthdate() %>" readonly="readonly" /></td>
		<td><input type="text" value="<%=ee.getHiredate() %>" readonly="readonly" /></td>
		<td><input type="text" value="<%=ee.getMaturdate() %>" readonly="readonly" /></td>
		<td><input type="text" value="<%=ee.getIdard() %>" readonly="readonly" /></td>
		<td><input type="text" value="<%=ee.getAddress() %>" readonly="readonly" /></td>
		<td><input type="text" value="<%=ee.getPhone() %>"   /></td>
		<td><input type="text" value="<%=ee.getEmail() %>"   /></td>
		<td><a href="updateEmployee" class="updateEmpl">修改</a> | <a href="deleteEmployee?id=<%=ee.getEmployeeid() %>">删除</a></td>
		</tr>
	<% } %>
	
	</tbody>
</table>

<div><p>当前页[<%=currPage %>/<%=sumPage %>] <a href="kucunshujuchushihuashezhi.jsp?currPage=1">首页</a>&nbsp;&nbsp;<a href="kucunshujuchushihuashezhi.jsp?currPage=<%=currPage-1%>">上一下</a>&nbsp;&nbsp;<a href="kucunshujuchushihuashezhi.jsp?currPage=<%=currPage+1%>">下一页 </a>&nbsp;&nbsp;<a href="kucunshujuchushihuashezhi.jsp?currPage=<%=sumPage%>">末页 </a> </p> </div>
	</div></div></div>
	</body>
</html>
