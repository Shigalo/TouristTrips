<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../parts/header.jsp'%>

<div style="text-align: center; position: relative; top: 20%; left: -20%; ">
    <h3>Авторизация</h3>
    <form action="/login" method="post">

<%--        <c:if test="${param.regSucc == true}">
            <div id="status">
                <spring:message code="message.regSucc">
                </spring:message>
            </div>
        </c:if>
        <c:if test="${param.regError == true}">
            <div id="error">
                <spring:message code="message.regError">
                </spring:message>
            </div>
        </c:if>--%>

        <div style="position:relative; padding: 5px"><label>Логин : <input type="text" name="username"></label></div>
        <div style="position:relative; padding: 5px;"><label>Пароль : <input type="password" name="password"></label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div style="position:relative; padding: 5px"><input type="submit" value="Войти"/></div>
    </form>
    <a href="${pageContext.request.contextPath}/registration">Регистрация</a>
</div>
<%@include file='../parts/footer.jsp'%>