package club.hellc.severlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.hellc.Biz.AccountingsBiz;
import club.hellc.Biz.EnterStockBiz;
import club.hellc.pojo.Accountings;
import club.hellc.pojo.Enterstock;

public class EnterStockUpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		try {
			req.setAttribute("flag", "0");
			Integer productID = -1;
			Integer number = -1;
			Integer storeHouseID = -1;
			Integer employeeId = -1;
			Integer price = -1;
			String isPub = req.getParameter("isPub");
			if (!req.getParameter("productID").equals(""))
				productID = Integer.parseInt(req.getParameter("productID"));
			if (!req.getParameter("number").equals(""))
				number = Integer.parseInt(req.getParameter("number"));
			if (!req.getParameter("price").equals(""))
				price = Integer.parseInt(req.getParameter("price"));
			if (!req.getParameter("storeHouseID").equals(""))
				storeHouseID = Integer.parseInt(req.getParameter("storeHouseID"));
			if (!req.getParameter("employeeId").equals(""))
				employeeId = Integer.parseInt(req.getParameter("employeeId"));
			Integer enterstockid = Integer.parseInt(req.getParameter("enterstockid"));
			EnterStockBiz esBiz = new EnterStockBiz();
			if (enterstockid != null && enterstockid > 0) {
				if (esBiz.findById(enterstockid) != null) {
					if (!(productID == -1 || number < 0 || storeHouseID == -1 || employeeId == -1 || price < 0)) {
						// EnterStockBiz esBiz = new EnterStockBiz();
						Enterstock es = new Enterstock();
						es.setEnterstockid(enterstockid);
						es.setEmployeeid(employeeId);
						es.setIspub(isPub);
						es.setNumber(number);
						es.setPrice(price);
						es.setProductid(productID);
						es.setStorehouseid(storeHouseID);
						if (esBiz.updateById(es) > 0) {
							AccountingsBiz aBiz = new AccountingsBiz();
							Accountings a = new Accountings();
							a.setNumber(number);
							a.setPrice(-price);
							a.setProductid(productID);
							aBiz.add(a);

							req.setAttribute("updateesflag", "1");
							req.getRequestDispatcher("jinhuoxiugai.jsp").forward(req, resp);
						} else {
							req.setAttribute("updateesflag", "0");
							req.getRequestDispatcher("jinhuoxiugai.jsp").forward(req, resp);
						}
					} else {
						req.setAttribute("updateesflag", "0");
						req.getRequestDispatcher("jinhuoxiugai.jsp").forward(req, resp);
					}
				} else {
					req.setAttribute("updateesflag", "0");
					req.getRequestDispatcher("jinhuoxiugai.jsp").forward(req, resp);
				}
			} else {
				req.setAttribute("updateesflag", "0");
				req.getRequestDispatcher("jinhuoxiugai.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("updateesflag", "0");
			req.getRequestDispatcher("jinhuoxiugai.jsp").forward(req, resp);
		}
	}

}
