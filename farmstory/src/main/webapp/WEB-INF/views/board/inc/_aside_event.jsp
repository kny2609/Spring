<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sub" class="event">
    <div>
        <img src="/farmstory/img/sub_top_tit4.png" alt="EVENT"/>
    </div>
    <section>
        <aside>
            <img src="/farmstory/img/sub_aside_cate4_tit.png" alt="이벤트"/>
            <ul>
                <li class="${cate eq 'event'?'on':''}"><a href="/farmstory/board/list?group=event&cate=event">이벤트</a></li>
            </ul>
        </aside>
        <article>
            <nav>
                <img src="/farmstory/img/sub_nav_tit_cate4_${cate}.png" alt="이벤트"/>
                <p>
                    HOME > 이벤트 >
                    <c:if test="${cate eq 'event'}"><span>이벤트</span></c:if>
                </p>
            </nav>
            <div class="content">
                <!-- 컨텐츠 내용 시작 -->