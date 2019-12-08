<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='parts/header.jsp'%>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">

<div style="text-align: left; position: relative; top: 18%; left: -14%; ">
    <h3>Компания располагает:</h3>
    <p>пользователи (убрать): ${userList}</p>
    <p>кол-во путей (убрать): ${wayList}</p>
    <p>кол-во заявок (убрать): ${requestList}</p>
    <p>кол-во рейсов (убрать): ${flightList}</p>

    <c:forEach items="${tourService.findAll()}" var="tour">
        <c:if test="${tour.post && tour.places !=0}">
            <table>
                <tr onclick="document.location = '/tours/getTour/${tour.id}'">
                    <td><img src="/tourImage/<c:out value='${tour.id}'/>" style="width: 150px" /><br/></td>
                    <td><h3 align="center">${tour.name} - ${tour.target}</h3><p align="justify">${tour.about}</p></td>
                </tr>
            </table>
        </c:if>
    </c:forEach>
</div>
<%@include file='parts/footer.jsp'%>
