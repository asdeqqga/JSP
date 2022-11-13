package controller.user4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User4DAO;

public class DeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String seq = req.getParameter("seq");
		
		User4DAO.getInstance().deleteUser4(seq);
		resp.sendRedirect("Ch/09/user4/list.do");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
	

}
