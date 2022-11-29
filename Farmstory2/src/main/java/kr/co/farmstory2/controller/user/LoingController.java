package kr.co.farmstory2.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.farmstory2.service.UserService;
import kr.co.farmstory2.vo.UserVO;

@WebServlet("/user/login.do")
public class LoingController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserService service = UserService.INSTANCE;
	
	@Override
	public void init() throws ServletException {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String success = req.getParameter("success");
		req.setAttribute("success", success);
		
		HttpSession sess = req.getSession();
		
		UserVO sessUser = (UserVO)sess.getAttribute("sessUser");
		
		if(sessUser != null) {
			
			resp.sendRedirect("/Farmstory2/list.do");
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/user/login.jsp");
			dispatcher.forward(req, resp);
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
