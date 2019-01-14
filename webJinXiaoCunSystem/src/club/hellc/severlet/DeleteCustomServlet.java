package club.hellc.severlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.hellc.Biz.CustomerBiz;

public class DeleteCustomServlet extends HttpServlet {

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
			Integer id = Integer.parseInt(request.getParameter("id"));
			CustomerBiz cBiz = new CustomerBiz();

			int r = cBiz.deleteById(id);

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
