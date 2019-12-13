<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../parts/header.jsp'%>

<div id="content">

    <a href="${pageContext.request.contextPath}/flights/add">Добавить</a>

    <c:if test="${empty flightList}"><h2>Ма</h2></c:if>
    <c:if test="${!empty flightList}">
        <table>
            <caption>Предложения</caption>
            <tr>
                <th>ID</th>
                <th>out</th>
                <th>Цельевой пункт</th>
                <th>departure</th>
                <th>arrival</th>
                <th>cost</th>
            </tr>

            <c:forEach items="${flightList}" var="flight">
                <tr id="${flight.id}">
                    <td>${flight.id}</td>
                    <td>${flight.out}</td>
                    <td>${flight.tour.target}</td>
                    <td>${flight.tour.date}</td>
                    <td>${flight.arrival}</td>
                    <td>${flight.cost}</td>
                    <%--<td>
                        <form action="/tours/tourView/${flight.id}" method="get">
                            <input type="submit" value="Подробнее">
                        </form>
                    </td>--%>
                    <%--<c:if test="${isAdmin}">--%>
                        <td><a href="<c:url value='/flights/remove/${flight.id}'/>">Удалить</a></td>
                    <%--</c:if>--%>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
<%@include file='../parts/footer.jsp'%>

