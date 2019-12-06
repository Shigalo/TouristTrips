<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../parts/header.jsp'%>

<a href="${pageContext.request.contextPath}/tours/add">Добавить</a>

<div style="text-align: center; position: relative; top: 20%; left: -20%; ">
    <c:if test="${empty tourList}"><h2>Извините, услуги не предоставляются</h2></c:if>
    <c:if test="${!empty tourList}">
        <table>
            <caption>Предложения</caption>
            <tr>
                <th>ID</th>
                <th>name</th>
                <th>target</th>
                <th>places</th>
            </tr>

            <c:forEach items="${tourList}" var="tour">
                <tr id="${tour.id}">
                    <td>${tour.id}</td>
                    <td>${tour.name}</td>
                    <td>${tour.target}</td>
                    <td>${tour.places}</td>
                    <%--<td>
                        <form action="/tours/tourView/${tour.id}" method="get">
                            <input type="submit" value="Подробнее">
                        </form>
                    </td>--%>
                    <%--<c:if test="${isAdmin}">--%>
                        <td><a href="<c:url value='/tours/remove/${tour.id}'/>">Удалить</a></td>
                    <%--</c:if>--%>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
<%@include file='../parts/footer.jsp'%>

