<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../parts/header.jsp'%>
<div id="content">
    <table border="1">
        <tr>
            <td width="400px"><img style="width: 100%" src="/tourImage/<c:out value='${tour.id}'/>" /><br/></td>
            <td width="800px"><h3 align="center">${tour.name} - ${tour.target}</h3><p align="justify">${tour.about}</p></td>
        </tr>
        <tr>
            <td>${tour.length} ${tour.date} ${tour.cost}</td>
            <td>
                <c:if test="${isLogin}">
                <form>
                <a href="<c:url value='/requests/addRequest/${tour.id}'/>">Заказать</a>
                </form>
                </c:if>
                <c:if test="${!isLogin}">
                    Для Заказа необходимо войти
                </c:if>
            </td>
        </tr>
    </table>
    <table id="infoTable" border="1">
        <c:forEach items="${infoList}" var="info">
            <tr>
                <td width="100px"><img src="/infoImage/<c:out value='${info.id}'/>" style="width: 150px" /><br/></td>
                <td width="1050px"><h3 align="center">${info.header}</h3><p align="justify">${info.about}</p></td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@include file='../parts/footer.jsp'%>
