<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sub" class="community">
    <div>
        <img src="/farmstory/img/sub_top_tit5.png" alt="COMMUNITY"/>
    </div>
    <section>
        <aside>
            <img src="/farmstory/img/sub_aside_cate5_tit.png" alt="커뮤니티"/>
            <ul>
                <li class="${cate eq 'notice'?'on':''}"><a href="/farmstory/board/list?group=community&cate=notice">공지사항</a></li>
                <li class="${cate eq 'menu'?'on':''}"><a href="/farmstory/board/list?group=community&cate=menu">오늘의식단</a></li>
                <li class="${cate eq 'chef'?'on':''}"><a href="/farmstory/board/list?group=community&cate=chef">나도요리사</a></li>
                <li class="${cate eq 'qna'?'on':''}"><a href="/farmstory/board/list?group=community&cate=qna">고객문의</a></li>
                <li class="${cate eq 'faq'?'on':''}"><a href="/farmstory/board/list?group=community&cate=faq">자주묻는질문</a></li>
            </ul>
        </aside>
        <article>
            <nav>
                <img src="/farmstory/img/sub_nav_tit_cate5_${cate}.png" alt="이벤트"/>
                <p>
                    HOME > 커뮤니티 > 
                    <c:if test="${cate eq 'notice'}"><span>공지사항</span></c:if>
                    <c:if test="${cate eq 'menu'}"><span>오늘의식단</span></c:if>
                    <c:if test="${cate eq 'chef'}"><span>나도요리사</span></c:if>
                    <c:if test="${cate eq 'qna'}"><span>고객문의</span></c:if>
                    <c:if test="${cate eq 'faq'}"><span>자주묻는질문</span></c:if>
                </p>
            </nav>
            <div class="content">
                <!-- 컨텐츠 내용 시작 -->
                