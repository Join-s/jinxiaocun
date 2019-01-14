package club.hellc.severlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.hellc.Biz.ProductBiz;
import club.hellc.pojo.Product;

public class EsAddProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		Integer producttype = Integer.parseInt(req.getParameter("producttype"));
		String productName = req.getParameter("productName");
		String productSpec = req.getParameter("productSpec");
		String productUnit = req.getParameter("productUnit");

		Integer price = 0;
		try {
			price = Integer.parseInt(req.getParameter("price"));
		} catch (Exception e) {
			price = 0;
		}
		ProductBiz proBiz = new ProductBiz();
		Product pro = new Product();
		pro.setProducttypeid(producttype);
		pro.setName(productName);
		pro.setProductspec(productSpec);
		pro.setProductunit(productUnit);
		pro.setPrice(price);
		try {
			int res = proBiz.add(pro);
			if (res > 0) {
				req.setAttribute("addesPro", "1");
				req.getRequestDispatcher("jinhuoshezhi.jsp").forward(req, resp);
			} else {
				req.setAttribute("addesPro", "0");
				req.getRequestDispatcher("jinhuoshezhi.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			req.setAttribute("addesPro", "0");
			req.getRequestDispatcher("jinhuoshezhi.jsp").forward(req, resp);
		}

	}

}
