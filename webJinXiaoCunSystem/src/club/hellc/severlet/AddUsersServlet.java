package club.hellc.severlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import club.hellc.Biz.UusersBiz;
import club.hellc.pojo.Uusers;

public class AddUsersServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		UusersBiz uBiz = new UusersBiz();
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String type = req.getParameter("type");
		Uusers u = new Uusers();
		u.setName(name);
		u.setPsw(pwd);
		u.setType(type);
		int re = -1;
		String[] sendR = { "xitongguanli.jsp", "xiaoshouyuanguanli.jsp", "cangkuyuanguanli.jsp",
				"jinhuoyuanguanli.jsp" };
		String sendURL = sendR[Integer.parseInt(type)];
		try {
			re = uBiz.add(u);
			if (re > 0) {
				req.setAttribute("updateuserflag", "1");
				req.getRequestDispatcher(sendURL).forward(req, resp);
			} else {
				req.setAttribute("updateuserflag", "0");
				req.getRequestDispatcher(sendURL).forward(req, resp);
			}
		} catch (Exception e) {
			req.setAttribute("updateuserflag", "0");
			req.getRequestDispatcher(sendURL).forward(req, resp);
		}
	}

}
