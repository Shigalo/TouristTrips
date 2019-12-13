<%@ page language="java" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Туры</title>
</head>
<body>
<div class="log">
    <c:if test="${isLogin}"><form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="submit" value="Выход">
    </form></c:if>
    <c:if test="${!isLogin}"><a href="${pageContext.request.contextPath}/login">Вход</a></c:if>
</div>
<header>
    <a href="${pageContext.request.contextPath}/"><div class="mainHref">
        <div id="mainText"><h2 style="font-style: italic">Главная</h2></div>
        <%--<img src="<c:url value="resources/images/home.png"/>" width="120" height="90">--%>
    </div></a>
    <c:if test="${isAdmin}">
        <table border="1" id="dataHref">
            <tr>
                <td><a href="${pageContext.request.contextPath}/tours">Туры</a></td>
                <td><a href="${pageContext.request.contextPath}/flights">Полёты</a></td>
            </tr>
        </table>
    </c:if>

</header>
<article>