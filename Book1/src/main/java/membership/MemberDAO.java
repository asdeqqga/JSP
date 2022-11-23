package membership;
/*
 * 날짜 : 2022/11/22
 * 이름 : 라성준
 * 내용 : 회원 정보 테이블용 DAO 클래스
 * 
 *  DAO(Data Access Object)
 *   - 데이터베이스의 데이터에 접근하기 위한 객체
 *   - JDBC를 통해 구현, 하나의 테이블에서 수행할 수 있는 CRUD를 전담
 *   
 *  CRUD
 *   - Create(생성), Read(읽기), Update(갱신), Delete(삭제) 작업을 말함
 */
import common.JDBConnect;

public class MemberDAO extends JDBConnect {
	// 명시한 데이터베이스로의 연결이 완료된 MemberDAO 객체를 생성함
	public MemberDAO(String driver, String url, String id, String pwd) {
		super(driver, url, id, pwd);
	}
	
	// 명시한 아이디/패스워드와 일치하는 회원 정보를 반환
	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO(); // 회원 정보 DTO 객체 생성
		// 쿼리문 템플릿
		String query = "select * from `member` where `id`=? and `pass`=?";
		
		try {
			// 쿼리 실행
			psmt = conn.prepareStatement(query); // 동적 쿼리문 준비
			psmt.setString(1, uid);				 // 쿼리문의 첫 번째 인파라미터에 값 설정
			psmt.setString(2, upass);			 // 쿼리문의 두 번째 인파라미터에 값 설정
			rs = psmt.executeQuery();			 // 쿼리문 실행
			
			// 결과 처리
			if (rs.next()) {
				// 쿼리 결과로 얻은 회원 정보를 DTO 객체에 저장
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto; // DTO 객체 반환
	}
}
