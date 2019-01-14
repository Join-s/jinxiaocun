package club.hellc.severlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.hellc.Biz.EnterStockBiz;

public class EnterStockDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		EnterStockBiz esBiz = new EnterStockBiz();
		Integer enterstockid = null;
		try {
			enterstockid = Integer.parseInt(req.getParameter("enterstockid"));
		} catch (Exception e) {
		}
		try {
			if (esBiz.deleteById(enterstockid) > 0) {
				req.setAttribute("deleteflag", "1");
				req.getRequestDispatcher("kucunjiaoyan.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			req.getRequestDispatcher("kucunjiaoyan.jsp").forward(req, resp);
		}
	}

}
