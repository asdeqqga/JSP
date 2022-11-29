package kr.co.jboard2.dao;

import kr.co.jboard2.db.DBHelper;
import kr.co.jboard2.db.Sql;
import kr.co.jboard2.vo.FileVO;

public class FileDAO extends DBHelper {
	public void insertFile(int parent, String newName, String fname) {
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_FILE);
			psmt.setInt(1, parent);
			psmt.setString(2, newName);
			psmt.setString(3, fname);
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			
		}
	}
	// read
	/**
	 * 해당 게시물의 파일 정보 가져오기
	 * @param no
	 * @return
	 */
	public FileVO selectFileData(String no) {
		FileVO vo = new FileVO();
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_FILE);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setFno(rs.getInt("fno"));
				vo.setParent(rs.getInt("parent"));
				vo.setNewName(rs.getString("newName"));
				vo.setOriName(rs.getString("oriName"));
				vo.setDownload(rs.getInt("download"));
			}
			close();
		} catch (Exception e) {
			
		}
		return vo;
	}
	
	
	// upload
	/**
	 * 파일 다운로드 횟수 증가
	 * @param fno
	 */
	public void updateDownloadCount(int fno) {
		try {
			
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_FILE_DOWNLOAD);
			psmt.setInt(1, fno);
			psmt.executeUpdate();
			close();
		} catch (Exception e) {
			
		}
	}
	
	
}