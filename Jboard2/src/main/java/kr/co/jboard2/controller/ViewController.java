package kr.co.jboard2.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import kr.co.jboard2.service.ArticleService;
import kr.co.jboard2.vo.ArticleVO;
import kr.co.jboard2.vo.UserVO;

@WebServlet("/view.do")
public class ViewController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ArticleService service = ArticleService.INSTANCE;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = req.getParameter("no");
		
		Map<String, Object> vos = service.selectArticle(no);
		ArticleVO avo = (ArticleVO)vos.get("avo");
		
		if(!((UserVO)req.getSession().getAttribute("sessUser")).getUid().equals(avo.getUid())){
			
			service.updateHitCount(no);
		}
		
		req.setAttribute("avo", avo);
		req.setAttribute("avo2", service.selectArticleComment(no));
		req.setAttribute("fvo", (FileVO)vos.get("fvo"));
		
		req.getRequestDispatcher("/view.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		logger.info("ViewController...");
		resp.setContentType("text/html;charset=UTF-8");
		
		String content = req.getParameter("content");
		String no = req.getParameter("no");
		String parent = req.getParameter("prent");
		String type = req.getParameter("type");
		UserVO uvo = (UserVO)req.getSession().getAttribute("sessUser");
		
		logger.debug(type);
		
		ArticleVO vo = new ArticleVO();
		vo.setParent(no);
		vo.setContent(content);
		vo.setRegip(req.getRemoteAddr());
		vo.setUid(uvo.getUid());
		
		ArticleVO vo2 = new ArticleVO();
		int result = 0;
		
		JsonObject json = new JsonObject();
	}
}