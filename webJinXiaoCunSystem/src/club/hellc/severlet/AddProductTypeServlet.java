package club.hellc.severlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.hellc.Biz.ProducttypeBiz;
import club.hellc.pojo.Producttype;

public class AddProductTypeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		try {

			String typename = req.getParameter("productTypeName");
			ProducttypeBiz ptBiz = new ProducttypeBiz();
			if (ptBiz.findByName(typename) <= 0) {
				Producttype pt = new Producttype();
				pt.setTypename(typename);
				System.out.println("[typename]-------->" + typename);
				if (ptBiz.add(pt) > 0) {
					req.setAttribute("addprotypeflag", "1");
					req.getRequestDispatcher("leibieshezhi.jsp").forward(req, resp);
				} else {
					req.setAttribute("addprotypeflag", "0");
					req.getRequestDispatcher("leibieshezhi.jsp").forward(req, resp);
				}
			} else {
				req.setAttribute("addprotypeflag", "0");
				req.getRequestDispatcher("leibieshezhi.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("addprotypeflag", "0");
			req.getRequestDispatcher("leibieshezhi.jsp").forward(req, resp);
		}

	}

}
