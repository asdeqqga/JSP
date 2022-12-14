package kr.co.farmstory2.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory2.service.ArticleService;
import kr.co.farmstory2.vo.ArticleVO;

@WebServlet("/board/list.do")
public class ListController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private ArticleService service = ArticleService.INSTANCE;
	
	@Override
	public void init() throws ServletException {	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("ListController...");
		String cate = req.getParameter("cate");
		String group = req.getParameter("group");
		String pg = req.getParameter("pg");
		String search = req.getParameter("search");
		
		logger.debug("");
		int total = service.selectCountTotal(search, cate);
		
		logger.debug("2");
		int lastPageNum = service.getLastPageNum(total);
	
		logger.debug("3");
		int currentPage = service.getCurrentPage(pg);
		
		logger.debug("4");
		int limitStart = service.getLimitStart(currentPage);
		
		logger.debug("5");
		int[] result = service.getPageGroupNum(currentPage, lastPageNum);
		
		logger.debug("6");
		int pageStartNum = service.getPageStartNum(total, limitStart);
		
		logger.debug("7");
		int start = service.getStartNum(currentPage);
		
		logger.debug("8");
		List<ArticleVO> articles = null;
		
		logger.debug("9");
		if(search == null) {
			
			logger.debug("10");
			articles = service.selectArticles(cate, start);
		} else {
			
			logger.debug("11");
			articles = service.selectArticlesByKeyword(search, start);
		}
				
		req.setAttribute("cate", cate);
		req.setAttribute("group", group);
		req.setAttribute("articles", articles);
		req.setAttribute("limitStart", limitStart);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("total", total);
		req.setAttribute("lastPageNum", lastPageNum);
		req.setAttribute("pageGroupStart", result[0]);
		req.setAttribute("pageGroupEnd", result[1]);
		req.setAttribute("pageStartNum", pageStartNum+1);
		req.setAttribute("search", search);
		
		logger.debug("12");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/list.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
	}
}
