<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>팜스토리</title>
    <link rel="stylesheet" href="/farmstory/css/style.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
    <div id="wrapper">
        <header>
            <a href="/farmstory" class="logo"><img src="/farmstory/img/logo.png" alt="로고"/></a>
            <p>
                <a href="/farmstory">HOME |</a>
                <c:choose>
                	<c:when test="${empty user}">
                		<a href="/farmstory/user/terms">회원가입 |</a>
	                	<a href="/farmstory/user/login">로그인 |</a>
                	</c:when>
                	<c:otherwise>
                		<a href="/farmstory/user/logout">로그아웃 |</a>
                	</c:otherwise>
                </c:choose>
                <a href="#">고객센터</a>
            </p>
            <img src="/farmstory/img/head_txt_img.png" alt="3만원이상 무료배송, 팜카드 10%적립">
            
            <ul class="gnb">
                <li><a href="/farmstory/introduction/greeting">팜스토리소개</a></li>
                <li><a href="/farmstory/board/list?group=market&cate=market"><img src="/farmstory/img/head_menu_badge.png" alt="30%"/>장보기</a></li>
                <li><a href="/farmstory/board/list?group=croptalk&cate=croptalk">농작물이야기</a></li>
                <li><a href="/farmstory/board/list?group=event&cate=event">이벤트</a></li>
                <li><a href="/farmstory/board/list?group=community&cate=notice">커뮤니티</a></li>
            </ul>
        </header>
        