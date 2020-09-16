<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sub" class="market">
    <div>
        <img src="/farmstory/img/sub_top_tit2.png" alt="MARKET"/>
    </div>
    <section>
        <aside>
            <img src="/farmstory/img/sub_aside_cate2_tit.png" alt="장보기"/>
            <ul>
                <li class="${cate eq 'market'?'on':''}"><a href="/farmstory/board/list?group=market&cate=market">장보기</a></li>
            </ul>
        </aside>
        <article>
            <nav>
                <img src="/farmstory/img/sub_nav_tit_cate2_${cate}.png" alt="장보기"/>
                <p>
                    HOME > 장보기 > 
                    <c:if test="${cate eq 'market'}"><span>장보기</span></c:if>
                </p>
            </nav>
            <div class="content">
                <!-- 컨텐츠 내용 시작 -->