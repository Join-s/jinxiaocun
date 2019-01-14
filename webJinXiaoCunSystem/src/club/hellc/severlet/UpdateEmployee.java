package club.hellc.severlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.hellc.Biz.DeptBiz;
import club.hellc.Biz.EmployeeBiz;
import club.hellc.pojo.Employee;

public class UpdateEmployee extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			String employeeid = request.getParameter("employeeid").trim();
			String name = request.getParameter("name");
			String deptname = request.getParameter("deptid").trim();
			DeptBiz dBiz = new DeptBiz();
			Integer deptid = dBiz.findByName(deptname).getDeptid();
			String duty = request.getParameter("duty");
			String sex = request.getParameter("sex");
			String idard = request.getParameter("idard");
			String borthdate = request.getParameter("borthdate");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String hiredate = request.getParameter("hiredate");
			String maturdate = request.getParameter("maturdate");
			Employee e = new Employee();
			e.setEmployeeid(Integer.parseInt(employeeid));
			e.setName(name);
			e.setDeptid(deptid);
			e.setDuty(duty);
			e.setSex(sex);
			e.setIdard(idard);
			e.setBorthdate(format.parse(borthdate));
			e.setPhone(phone);
			e.setEmail(email);
			e.setAddress(address);
			e.setHiredate(format.parse(hiredate));
			e.setMaturdate(format.parse(maturdate));
			// System.out.println(e);
			EmployeeBiz eBiz = new EmployeeBiz();
			int r = eBiz.updateById(e);
			if (r > 0) {
				out.println("<script>alert('success');location.href='kucunshujuchushihuashezhi.jsp';</script>");
			} else {
				out.println("<script>alert('error');location.href='kucunshujuchushihuashezhi.jsp';</script>");
			}
		} catch (ParseException e1) {
			// e1.printStackTrace();
			out.println("<script>alert('error');location.href='kucunshujuchushihuashezhi.jsp';</script>");
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
