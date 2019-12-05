<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='parts/header.jsp'%>

<a href="${pageContext.request.contextPath}/requests/addRequest">Подать новую заявку</a>

<div style="text-align: center; position: relative; top: 20%; left: -20%; ">
    <c:if test="${empty requestList}"><h2>На данный момент вы не оставляли заявок</h2></c:if>
    <c:if test="${!empty requestList}">
        <table border="1">
            <caption>Список заявок пользователя</caption>
            <tr>
                <c:if test="${isAdmin}"><th>ID Запроса</th></c:if>
                <th>ID поездки</th>
                <th>Поездка</th>
                <c:if test="${isAdmin}"><th>Пользователь</th></c:if>
            </tr>

            <c:forEach items="${requestList}" var="request">
                <tr id="${request.id}">
                    <c:if test="${isAdmin}"><td>${request.id}</td></c:if>
                    <td>${request.tour.id}</td>
                    <td>${request.tour.target}</td>
                    <c:if test="${isAdmin}"><td>${request.user.name}</td></c:if>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
<%@include file='parts/footer.jsp'%>
