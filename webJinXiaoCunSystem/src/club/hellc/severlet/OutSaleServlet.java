package club.hellc.severlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.hellc.Biz.AccountingsBiz;
import club.hellc.Biz.OrdersBiz;
import club.hellc.pojo.Accountings;
import club.hellc.pojo.Orders;

public class OutSaleServlet extends HttpServlet {

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

		try {
			String ids = request.getParameter("id");
			OrdersBiz oBiz = new OrdersBiz();
			Orders o = oBiz.findById(Integer.parseInt(ids));

			AccountingsBiz accountingsBiz = new AccountingsBiz();
			Accountings acc = new Accountings();
			acc.setNumber(o.getNumber());
			acc.setPrice(o.getPrice());
			acc.setProductid(o.getProductid());
			int r = accountingsBiz.add(acc);
			o.setIspub("1");

			int r2 = oBiz.updateById(o);
			if (r > 0) {
				request.getSession().setAttribute("outsaleflag", "1");
			} else {
				request.getSession().setAttribute("outsaleflag", "0");
			}
		} catch (Exception e) {
			request.getSession().setAttribute("outsaleflag", "0");
		}
		request.getRequestDispatcher("xiaoshouchuku.jsp").forward(request, response);

	}

}
