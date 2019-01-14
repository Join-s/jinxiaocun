<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
if(session.getAttribute("uname")!=null){
}else{

out.println("<script>alert('请登录');location.href='login.jsp';</script>");

}

%>

