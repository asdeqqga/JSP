<%@page import="java.util.List"%>
<%@page import="kr.co.farmstory1.bean.ArticleBean"%>
<%@page import="kr.co.farmstory1.dao.ArticleDAO"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/_header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	String group = request.getParameter("group");
	String cate  = request.getParameter("cate");
	String no  = request.getParameter("no");
	String pg  = request.getParameter("pg");
	
	pageContext.include("/board/_"+group+".jsp");
	
	ArticleDAO dao = ArticleDAO.getInstance();
	
	// 조회수 +1
	dao.updateArticleHit(no);
	
	// 글 가져오기
	ArticleBean article = dao.selectArticle(no);
	
	// 댓글 가져오기
	List<ArticleBean> comments = dao.selectComments(no);
%>
<script>
	$(document).ready(function() {
		
		// 글 삭제
		$('.btnRemove').click(function(){
			let isDelete = confirm('정말 삭제 하시겠습니까?');
			if(isDelete){
				return true;
			}else{
				return false;
		}
		
	});
</script>
        <main id="board">
            <section class="view">
                <table border="0">
                    <caption>글보기</caption>
                    <tr>
                        <th>제목</th>
                        <td><input type="text" name="title" readonly value="<%= article.getTitle() %>" /></td>
                    </tr>
                    <% if(article.getFile() > 0){ %>
                    <tr>
                        <th>파일</th>
                        <td><a href="/Farmstory1/board/proc/download.jsp?parent=<%= article.getNo() %>"><%= article.getOriName() %></a>&nbsp;<span><%= article.getDownload() %></span>회 다운로드</td>
                    </tr>
                   	<% } %>
                    <tr>
                        <th>내용</th>
                        <td>
                            <textarea name="content" readonly><%= article.getContent() %></textarea>
                        </td>
                    </tr>                    
                </table>
                  
                <div>
                	
                    <a href="/Farmstory1/board/proc/deleteProc.jsp?no=<%= article.getNo() %>&pg=<%= pg %>" class="btn btnRemove">삭제</a>
                    <a href="./modify.jsp?group=<%= group %>&cate=<%= cate %>" class="btn btnModify">수정</a>
                   	
                    <a href="./list.jsp?group=<%= group %>&cate=<%= cate %>" class="btn btnList">목록</a>
                </div>
				
                <!-- 댓글목록 -->
                <section class="commentList">
                    <h3>댓글목록</h3>                   

                    <article>
                        <span class="nick">길동이</span>
                        <span class="date">20-05-20</span>
                        <p class="content">댓글 샘플 입니다.</p>                        
                        <div>
                            <a href="#" class="remove">삭제</a>
                            <a href="#" class="modify">수정</a>
                        </div>
                    </article>

                    <p class="empty">등록된 댓글이 없습니다.</p>

                </section>

                <!-- 댓글쓰기 -->
                <section class="commentForm">
                    <h3>댓글쓰기</h3>
                    <form action="#">
                        <textarea name="content">댓글내용 입력</textarea>
                        <div>
                            <a href="#" class="btn btnCancel">취소</a>
                            <input type="submit" value="작성완료" class="btn btnComplete"/>
                        </div>
                    </form>
                </section>

            </section>
        </main>
        </article>
</section>
</div>
<%@ include file="/_footer.jsp" %>