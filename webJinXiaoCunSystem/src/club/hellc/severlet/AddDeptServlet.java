package club.hellc.severlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.hellc.Biz.DeptBiz;
import club.hellc.pojo.Dept;

public class AddDeptServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		DeptBiz dBiz = new DeptBiz();
		try {
			String name = request.getParameter("name");
			String remark = request.getParameter("remark");

			Dept d = new Dept();
			d.setName(name);
			d.setRemark(remark);
			int r = dBiz.add(d);
			if (r > 0) {
				out.println("<script>alert('success');location.href='xitongjichuxinxishezhi.jsp';</script>");
			} else {
				out.println("<script>alert('error');location.href='xitongjichuxinxishezhi.jsp';</script>");
			}
		} catch (Exception e) {
			out.println("<script>alert('error');location.href='xitongjichuxinxishezhi.jsp';</script>");
		}

		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
