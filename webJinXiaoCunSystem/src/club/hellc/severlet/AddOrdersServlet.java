package club.hellc.severlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.hellc.Biz.OrdersBiz;
import club.hellc.Biz.SaleBiz;
import club.hellc.pojo.Orders;
import club.hellc.pojo.Sale;

public class AddOrdersServlet extends HttpServlet {

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
		Integer number = 0;
		Integer productid = 0;
		Integer price = 0;
		Integer customerid = 0;
		String remark = request.getParameter("remark");
		try {
			customerid = Integer.parseInt(request.getParameter("customerid"));
			productid = Integer.parseInt(request.getParameter("productid"));
			number = Integer.parseInt(request.getParameter("number"));
			price = Integer.parseInt(request.getParameter("price"));
		} catch (Exception e) {
		}
		try {
			OrdersBiz oBiz = new OrdersBiz();
			SaleBiz saleBiz = new SaleBiz();
			Orders o = new Orders();
			o.setCustomerid(customerid);
			o.setNumber(number);
			o.setOrdersid(customerid);
			o.setPrice(price);
			o.setProductid(productid);
			Date date = new Date();
			Random r = new Random();
			String saleid = "" + (date.getYear() + 1900) + (date.getMonth() + 11) + date.getDate() + date.getHours()
					+ date.getMinutes() + date.getSeconds() + date.getDay() + r.nextInt(9);
			System.out.println("[saleid]---->" + saleid);
			o.setSaleid(saleid);

			Sale sale = new Sale();
			sale.setNumber(number);
			sale.setPrice(price);
			sale.setRemark(remark);
			sale.setSaleid(saleid);
			int r1 = saleBiz.add(sale);
			int r2 = oBiz.add(o);
			if (r1 > 0 && r2 > 0) {
				out.println("<script>alert('success');location.href='xiaoshoudingdan.jsp';</script>");
			} else {
				out.println("<script>alert('error');location.href='xiaoshoudingdan.jsp';</script>");
			}

		} catch (Exception e) {
			out.println("<script>alert('error');location.href='xiaoshoudingdan.jsp';</script>");
		}

		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
