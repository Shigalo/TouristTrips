<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='parts/header.jsp'%>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">

<div style="text-align: left; position: relative; top: 18%; left: -14%; ">
    <label>some text</label>
    <h3>Компания располагает:</h3>
    <p>пользователи (убрать): ${userList}</p>
    <p>кол-во путей (убрать): ${wayList}</p>
    <p>кол-во заявок (убрать): ${requestList}</p>
    <p>кол-во рейсов (убрать): ${flightList}</p>
</div>
<%@include file='parts/footer.jsp'%>
