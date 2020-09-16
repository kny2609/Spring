<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sub" class="croptalk">
    <div>
        <img src="/farmstory/img/sub_top_tit3.png" alt="CROP TALK"/>
    </div>
    <section>
        <aside>
            <img src="/farmstory/img/sub_aside_cate3_tit.png" alt="농작물이야기"/>
            <ul>
                <li class="${cate eq 'croptalk'?'on':''}"><a href="/farmstory/board/list?group=croptalk&cate=croptalk">농작물이야기</a></li>
                <li class="${cate eq 'grow'?'on':''}"><a href="/farmstory/board/list?group=croptalk&cate=grow">텃밭가꾸기</a></li>
                <li class="${cate eq 'school'?'on':''}"><a href="/farmstory/board/list?group=croptalk&cate=school">귀농학교</a></li>
            </ul>
        </aside>
        <article>
            <nav>
                <img src="/farmstory/img/sub_nav_tit_cate3_${cate}.png" alt="농작물이야기"/>
                <p>
                    HOME > 농작물이야기 > 
                    <c:if test="${cate eq 'croptalk'}"><span>농작물이야기</span></c:if>
                    <c:if test="${cate eq 'grow'}"><span>텃밭가꾸기</span></c:if>
                    <c:if test="${cate eq 'school'}"><span>귀농학교</span></c:if>
                </p>
            </nav>
            <div class="content">
                <!-- 컨텐츠 내용 시작 -->