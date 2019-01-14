<%@page import="club.hellc.Biz.EmployeeBiz"%>
<%@page import="club.hellc.pojo.Customer"%>
<%@page import="org.glassfish.jersey.internal.inject.Custom"%>
<%@page import="club.hellc.Biz.CustomerBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title></title>
<link rel="stylesheet" href="css/bootstrap.css" /><style type="text/css">
		td input[type='text']{
		
		width:100%;
		height: 100%;
		border: 0px;
		}
		
		</style>
<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript">
	$(function() {

		$(".updateCus").click(function() {

			var id = $(this).parent().parent().children().eq(0).children().val();
			var name = $(this).parent().parent().children().eq(1).children().val();
			var address = $(this).parent().parent().children().eq(2).children().val();
			var phone = $(this).parent().parent().children().eq(3).children().val();
			var fax = $(this).parent().parent().children().eq(4).children().val();
			var postalcode = $(this).parent().parent().children().eq(5).children().val();
			var constactperson = $(this).parent().parent().children().eq(6).children().val();
			var action1 = $(this).attr('href');
			var myform = $("<form></form>");
			myform.attr('target', '_self');
			myform.attr("action", action1);
			myform.attr("method", "post");
			var input1 = $("<input type='text' name='id' value='" + id + "' />");
			myform.append(input1);
			var input2 = $("<input type='text' name='name' value='" + name + "' />");
			myform.append(input2);
			var input3 = $("<input type='text' name='address' value='" + address + "' />");
			myform.append(input3);
			var input4 = $("<input type='text' name='phone' value='" + phone + "' />");
			myform.append(input4);
			var input5 = $("<input type='text' name='fax' value='" + fax + "' />");
			myform.append(input5);
			var input6 = $("<input type='text' name='postalcode' value='" + postalcode + "' />");
			myform.append(input6);
			var input7 = $("<input type='text' name='constactperson' value='" + constactperson + "' />");
			myform.append(input7);
			myform.appendTo(document.body).submit();
			return false;
		});
	});
</script>
</head>
<body>
	<!--查看客户 -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th  >id</th>
							<th  >名称</th>
							<th  >地址</th>
							<th >电话</th>
							<th >传真</th>
							<th >邮件</th>
							<th >联系人</th>
							<th >操作</th>
						</tr>
					</thead>
					<tbody>
						<%
							CustomerBiz cBiz = new CustomerBiz();
							EmployeeBiz eBiz = new EmployeeBiz();
							List<Customer> cuslist = new ArrayList<Customer>();
							cuslist = cBiz.findAll();
							pageContext.setAttribute("cuslist", cuslist);
							if (cuslist != null)
								for (Customer cus : cuslist) {
						%>
						<tr>
							<td><input type="text" readonly="readonly"
								value="<%=cus.getCustomerid()%>" name="id" /></td>
							<td><input type="text" value="<%=cus.getName()%>"
								name="Name" /></td>
							<td><input type="text" value="<%=cus.getAddress()%>"
								name="Address" /></td>
							<td><input type="text" value="<%=cus.getPhone()%>"
								name="Phone" /></td>
							<td><input type="text" value="<%=cus.getFax()%>"
								name="Fax" /></td>
							<td><input type="text" value="<%=cus.getPostalcode()%>"
								name="Postalcode" /></td>
							<td><select name="Constactperson">
									<option value="<%=cus.getConstactperson()%>">
							<%=eBiz.findById(cus.getConstactperson()).getName()%>
							</option>
							</select></td>
							<td><a href="addcus.jsp">添加</a> | <a
								href="updateCustomServlet" class="updateCus">修改</a> | <a
								href="deleteCustomServlet?id=<%=cus.getCustomerid()%>">删除</a></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
