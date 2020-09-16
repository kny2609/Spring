<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../_header.jsp" %>
<jsp:include page="./inc/_aside_${group}.jsp" />
<section id="board" class="list">
    <h3>글목록</h3>
    <article>
        <table border="0">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>글쓴이</th>
                <th>날짜</th>
                <th>조회</th>
            </tr>
            <c:forEach var="board" items="${boards}">
	            <tr>
	                <td>${count=count-1}</td>
	                <td><a href="/farmstory/board/view?group=${group}&cate=${cate}">${board.title}</a>&nbsp;[${board.comment}]</td>
	                <td>${board.uid}</td>
	                <td>${board.rdate.substring(2, 10)}</td>
	                <td>${board.hit}</td>
	            </tr>
            </c:forEach>
        </table>
    </article>

    <!-- 페이지 네비게이션 -->
    <div class="paging">
    	<c:if test="${groupStart > 1}">
        <a href="/farmstory/board/list?group=${group}&cate=${cate}&pg=${groupStart-1}" class="prev">이전</a>
        </c:if>
        
        <c:forEach var="i" begin="1" end="${pageEnd}">
        <a href="/farmstory/board/list?group=${group}&cate=${cate}&pg=${i}" class="num ${currentPg == i ? 'current':''}">${i}</a>  
        </c:forEach>
        
        <c:if test="${groupEnd < pageEnd}">
        <a href="/farmstory/board/list?group=${group}&cate=${cate}&pg=${groupEnd+1}" class="next">다음</a>
        </c:if>
    </div>

    <!-- 글쓰기 버튼 -->
    <a href="/farmstory/board/write?group=${group}&cate=${cate}" class="btnWrite">글쓰기</a>

</section>

<%@ include file="./inc/_aside_tail.jsp" %>
<%@ include file="../_footer.jsp" %>