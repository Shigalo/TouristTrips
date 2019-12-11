<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../parts/header.jsp'%>

<div id="content">
    <table border="1"><tr>
        <td width="400px"><img style="width: 100%" src="/tourImage/<c:out value='${tour.id}'/>" /><br/></td>
        <td width="800px"><h3 align="center">${tour.name} - ${tour.target}</h3><p align="justify">${tour.about}</p></td>
    </tr></table>
    <label>Осталось мест: ${tour.places}</label>
    <label>Авиаперелёт<br />
        <input type="radio" name="flights" id="with" checked value="with" onclick="setCost()">
        <label for="with">Заказать</label><br>
        <input type="radio" name="flights" id="without" value="without" onclick="setCost()">
        <label for="without">Не заказывать</label><br>
    </label>
    <form action="" method="post">
        <label>Количество билетов:<input id="places" type="number" min="0" value="1" step="1" oninput="setCost()"></label>
        <label><input id="cost" disabled ></label>
        <div id="flightDiv">
            <label for="flight">Вылет из:</label><select id="flight" onchange="setCost()">
            <c:forEach items="${flightList}" var="flight"><option>${flight.out}</option></c:forEach>
        </select>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div style="position:relative; padding: 5px"><input type="submit" value="Подтвердить"/></div>
    </form>
</div>
<script>
    document.getElementById("places").setAttribute("max", ${tour.places});
    document.getElementById("cost").setAttribute("value", ${tour.cost}+${flightList.get(0).cost});
    function setCost() {
        var places = document.getElementById("places");
        var flightCost = 0;
        if(document.getElementById("with").checked) {
            var flightDiv = document.getElementById("flightDiv");
            flightDiv.hidden = false;
            var flight = document.getElementById("flight");
            <c:forEach items="${flightList}" var="flight">
            if('${flight.out}' == flight.options[flight.selectedIndex].innerHTML) {
                flightCost = ${flight.cost};}
            </c:forEach>
        }
        else {
            document.getElementById("flightDiv").hidden = true;
            flightCost = 0;
        }
        document.getElementById("cost").setAttribute("value", places.value*(${tour.cost}+flightCost));
    }
</script>
<%@include file='../parts/footer.jsp'%>
