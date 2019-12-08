<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../parts/header.jsp'%>
<div style="text-align: center; position: relative; top: 20%; left: -20%; ">
    <table>
        <tr>
            <td><img src="/tourImage/<c:out value='${tour.id}'/>" style="width: 150px" /><br/></td>
            <td><h3 align="center">${tour.name} - ${tour.target}</h3><p align="justify">${tour.about}</p></td>
        </tr>
    </table>
    <table id="infoTable" border="1">
        <c:forEach items="${infoList}" var="info">
            <tr>
                <td style="width: 100px"><img src="/infoImage/<c:out value='${info.id}'/>" style="width: 150px" /><br/></td>
                <td><h3 align="center">${info.header}</h3><p align="justify">${info.about}</p></td>
            </tr>
        </c:forEach>
    </table>
</div>
<%@include file='../parts/footer.jsp'%>
