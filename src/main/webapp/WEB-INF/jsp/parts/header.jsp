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
<header>
    <table>
        <tr>
            <td><a href="${pageContext.request.contextPath}/">Главная</a></td>
            <c:if test="${isLogin}">
                <td><a href="${pageContext.request.contextPath}/">Туры</a></td>
                <td><form action="${pageContext.request.contextPath}/logout" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <input type="submit" value="Выход">
                </form></td>
            </c:if>
            <c:if test="${!isLogin}"><td><a href="${pageContext.request.contextPath}/login">Вход</a></td></c:if>

        </tr>
    </table>
</header>
<article>