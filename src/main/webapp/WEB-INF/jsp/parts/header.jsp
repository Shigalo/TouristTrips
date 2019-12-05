<%@ page language="java" pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Поставки</title>
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
        <div style="padding-top: 70px">Главная</div>
        <%--<img src="<c:url value="resources/images/home.png"/>" width="120" height="90">--%>
    </div></a>
    <table border="1">
        <tr>
            <td><a href="${pageContext.request.contextPath}/">Туры</a></td><%----%><%----%><%--wtf--%>
        </tr>
    </table>

</header>
<article>