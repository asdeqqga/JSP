package kr.co.farmstory1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.farmstory1.bean.ArticleBean;
import kr.co.farmstory1.bean.FileBean;
import kr.co.farmstory1.db.DBCP;
import kr.co.farmstory1.db.DBHelper;
import kr.co.farmstory1.db.Sql;

public class ArticleDAO extends DBHelper {
	
	private static ArticleDAO instance = new ArticleDAO();
	public static ArticleDAO getInstance() {
		return instance;
	}
	private ArticleDAO() {}
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public int insertArticle(ArticleBean ab) {
		
		int parent = 0;
		
		try {
			logger.info("insertArticle...");
			
			conn = getConnection();
			conn.setAutoCommit(false);
			
			psmt = conn.prepareStatement(Sql.INSERT_ARTICLE);
			stmt = conn.createStatement();
			
			psmt.setString(1, ab.getCate());
			psmt.setString(2, ab.getTitle());
			psmt.setString(3, ab.getContent());
			psmt.setInt(4, ab.getFname() == null ? 0 : 1);
			psmt.setString(5, ab.getUid());
			psmt.setString(6, ab.getRegip());			
			psmt.executeUpdate();
			rs = stmt.executeQuery(Sql.SELECT_MAX_NO);
			
			conn.commit();
			
			if(rs.next()){
				parent = rs.getInt(1);
			}
			
			close();			
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return parent;
	}
	
	public void insertFile(int parent, String newName, String fname) {
		try{
			logger.info("insertFile...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_FILE);
			psmt.setInt(1, parent);
			psmt.setString(2, newName);
			psmt.setString(3, fname);
			psmt.executeUpdate();
			close();
		}catch(Exception e){
			logger.error(e.getMessage());
		}
	}
	
	public ArticleBean selectArticle(String no) {
		
		ArticleBean article = null;
		
		try {
			logger.info("selectCountTotal");
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLE);
			psmt.setString(1, no);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				article = new ArticleBean();
				article.setNo(rs.getInt(1));
				article.setParent(rs.getInt(2));
				article.setComment(rs.getInt(3));
				article.setCate(rs.getString(4));
				article.setTitle(rs.getString(5));
				article.setContent(rs.getString(6));
				article.setFile(rs.getInt(7));
				article.setHit(rs.getInt(8));
				article.setUid(rs.getString(9));
				article.setRegip(rs.getString(10));
				article.setRdate(rs.getString(11));
				article.setFno(rs.getInt(12));
				article.setPno(rs.getInt(13));
				article.setNewName(rs.getString(14));
				article.setOriName(rs.getString(15));
				article.setDownload(rs.getInt(16));
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		return article;
	}
	
	public List<ArticleBean> selectArticles(String cate, int start) {
		
		List<ArticleBean> articles = new ArrayList<>();
		
		try {
			logger.info("selectArticles...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ARTICLES);
			psmt.setString(1, cate);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ArticleBean ab = new ArticleBean();
				ab.setNo(rs.getInt(1));
				ab.setParent(rs.getInt(2));
				ab.setComment(rs.getInt(3));
				ab.setCate(rs.getString(4));
				ab.setTitle(rs.getString(5));
				ab.setContent(rs.getString(6));
				ab.setFile(rs.getInt(7));
				ab.setHit(rs.getInt(8));
				ab.setUid(rs.getString(9));
				ab.setRegip(rs.getString(10));
				ab.setRdate(rs.getString(11));
				ab.setNick(rs.getString(12));
						
				articles.add(ab);
			}
			
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return articles;
	}
	
	public List<ArticleBean> selectLatests(String cate1, String cate2, String cate3) {
		
		Map<String, List<ArticleBean>> maps = new HashMap<>();
		List<ArticleBean> latests = new ArrayList<>();
		
		try {
			logger.info("selectLatests...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_LATESTS);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			psmt.setString(3, cate3);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ArticleBean ab = new ArticleBean();
				ab.setNo(rs.getInt(1));
				ab.setTitle(rs.getString(2));
				ab.setRdate(rs.getString(3).substring(2, 10));
				
				latests.add(ab);
			}
			
			close();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return latests;
	}
	
	public synchronized List<ArticleBean> selectLatests(String cate) {
		
		List<ArticleBean> latests = new ArrayList<>();
		
		try {
			logger.info("selectLatests(String)...");
			
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_LATEST);
			psmt.setString(1, cate);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				ArticleBean ab = new ArticleBean();
				ab.setNo(rs.getInt(1));
				ab.setTitle(rs.getString(2));
				ab.setRdate(rs.getString(3).substring(2, 10));
				
				latests.add(ab);
			}
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		logger.info("latests size : " + latests.size());
		
		return latests;
	}
	
	public int selectCountTotal(String cate) {
		
		int total = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_COUNT_TOTAL);
			psmt.setString(1, cate);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return total;		
	}
	public FileBean selectFile(String parent) {
		FileBean fb = null;
		
		try {
			logger.info("selectCountTotal");
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_FILE);
			psmt.setString(1, parent);
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				fb = new FileBean();
				fb.setFno(rs.getInt(1));
				fb.setParent(rs.getInt(2));
				fb.setNewName(rs.getString(3));
				fb.setOriName(rs.getString(4));
				fb.setDownload(rs.getInt(5));
			}
			rs.close();
			psmt.close();
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return fb;
	}
	
	public List<ArticleBean> selectComments(String parent) {
		
		List<ArticleBean> comments = new ArrayList<>();
		
		try {
			logger.info("selectCountTotal");
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COMMENTS);
			psmt.setString(1, parent);
			
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				ArticleBean comment = new ArticleBean();
				comment.setNo(rs.getInt(1));
				comment.setParent(rs.getInt(2));
				comment.setComment(rs.getInt(3));
				comment.setCate(rs.getString(4));
				comment.setTitle(rs.getString(5));
				comment.setContent(rs.getString(6));
				comment.setFile(rs.getInt(7));
				comment.setHit(rs.getInt(8));
				comment.setUid(rs.getString(9));
				comment.setRegip(rs.getString(10));
				comment.setRdate(rs.getString(11));
				comment.setNick(rs.getString(12));
				
				comments.add(comment);
			}
			
			rs.close();
			psmt.close();
			conn.close();
			
		}catch (Exception e) {
		e.printStackTrace();
		logger.error(e.getMessage());
		}
		
		return comments;
	
	}
	
	public void updateArticle(String no, String title, String content) {
		try {
			logger.info("selectCountTotal");
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_ARTICLE);
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setString(3, no);
			
			psmt.executeUpdate();
			
			psmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	public void updateArticleHit(String no) {
		try {
			logger.info("selectCountTotal");
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_ARTICLE_HIT);
			psmt.setString(1, no);
			psmt.executeUpdate();
			psmt.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	public void updateFileDownload(int fno) {
		try {
			logger.info("selectCountTotal");
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_FILE_DOWNLOAD);
			psmt.setInt(1, fno);
			psmt.executeUpdate();
			psmt.close();
			psmt.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	public void deleteArticle(String no) {
		try {
			logger.info("selectCountTotal");
			Connection conn = DBCP.getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.DELETE_ARTICLE);
			psmt.setString(1, no);
			psmt.setString(2, no);
			psmt.executeUpdate();
			psmt.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	public String deleteFile(String no) {
		String newName = null;
		
		try {
			logger.info("selectCountTotal");
			Connection conn = DBCP.getConnection();
			
			conn.setAutoCommit(false);
			PreparedStatement psmt1 = conn.prepareStatement(Sql.SELECT_FILE);
			PreparedStatement psmt2 = conn.prepareStatement(Sql.DELETE_FILE);
			
			psmt1.setString(1, no);
			psmt2.setString(1, no);
			
			ResultSet rs = psmt1.executeQuery();
			psmt2.executeUpdate();
			
			conn.commit();
			
			if(rs.next()) {
				newName = rs.getString(3);
			}
			
			psmt1.close();
			psmt2.close();
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		return newName;
	}

}

