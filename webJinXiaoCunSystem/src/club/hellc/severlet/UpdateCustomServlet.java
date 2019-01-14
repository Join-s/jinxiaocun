package club.hellc.severlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.hellc.Biz.CustomerBiz;
import club.hellc.pojo.Customer;

public class UpdateCustomServlet extends HttpServlet {

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
		out.println("<!DOCTYPE HTML  ");
		out.println("<HTML>");
		out.println(" <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println(" <BODY>");
		try {
			String Name = request.getParameter("name");
			String Address = request.getParameter("address");
			String Phone = request.getParameter("phone");
			String Fax = request.getParameter("fax");
			String Postalcode = request.getParameter("postalcode");
			String Constactperson = request.getParameter("constactperson");
			CustomerBiz cBiz = new CustomerBiz();

			Customer cus = new Customer();
			cus.setCustomerid(Integer.parseInt(request.getParameter("id")));
			cus.setName(Name);
			cus.setAddress(Address);
			cus.setPhone(Phone);
			cus.setFax(Fax);
			cus.setPostalcode(Postalcode);
			cus.setConstactperson(Integer.parseInt(Constactperson));

			int r = cBiz.updateById(cus);

			if (r > 0) {
				out.println("<script>alert('success');location.href='jiesuanzhanghhushezhi.jsp';</script>");
			} else {
				out.println("<script>alert('error');location.href='jiesuanzhanghhushezhi.jsp';</script>");
			}
		} catch (Exception e) {
			out.println("<script>alert('error');location.href='jiesuanzhanghhushezhi.jsp';</script>");
		}
		out.println(" </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();

	}

}
