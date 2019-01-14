package club.hellc.severlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.hellc.Biz.UusersBiz;

public class DeleteUsersServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		UusersBiz uBiz = new UusersBiz();
		Integer id = Integer.parseInt(req.getParameter("id"));
		String type = req.getParameter("type");
		int re = 0;
		String sendURL;
		String[] sendR = { "xitongguanli.jsp", "xiaoshouyuanguanli.jsp", "cangkuyuanguanli.jsp",
				"jinhuoyuanguanli.jsp" };
		try {
			sendURL = sendR[Integer.parseInt(type)];
		} catch (Exception e) {
			sendURL = sendR[0];
		}
		try {
			re = uBiz.deleteById(id);
			if (re > 0) {
				req.setAttribute("deleteuserflag", "1");
				req.getRequestDispatcher(sendURL).forward(req, resp);
			} else {
				req.setAttribute("deleteuserflag", "0");
				req.getRequestDispatcher(sendURL).forward(req, resp);
			}
		} catch (Exception e) {
			req.setAttribute("deleteuserflag", "0");
			req.getRequestDispatcher(sendURL).forward(req, resp);
		}
	}

}