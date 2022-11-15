package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterContriller extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Farmstory1/register.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid 	= req.getParameter("uid");
		String pass = req.getParameter("pass");
		String nick = req.getParameter("nick");
		String email = req.getParameter("email");
		String hp = req.getParameter("hp");
		String grade = req.getParameter("grade");
		String zip = req.getParameter("zip");
		String addr1 = req.getParameter("add1");
		String addr2 = req.getParameter("addr2");
		String regip = req.getParameter("regip");
		String rdate = req.getParameter("rdate");
		
	}

	
}
