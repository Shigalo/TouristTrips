<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../parts/header.jsp'%>

<div id="content">
    <table border="1"><tr>
        <td width="400px"><img style="width: 100%" src="/tourImage/<c:out value='${tour.id}'/>" /><br/></td>
        <td width="800px"><h3 align="center">${tour.name} - ${tour.target}</h3><p align="justify">${tour.about}</p></td>
    </tr></table>
    <label>Осталось мест: ${tour.places}</label>
    <label>
        <br/>Авиаперелёт<br/>
        <input type="radio" name="flights" id="with" value="with" onclick="setCost()">
        <label for="with">Заказать</label><br>
        <input type="radio" name="flights" id="without" checked value="without" onclick="setCost()">
        <label for="without">Не заказывать</label><br>
    </label>
    <form action="" method="post">
        <label>Количество билетов:<input id="places" type="number" name="places" min="0" value="1" step="1" oninput="setCost()"></label>
        <label><input id="cost" name="cost" value="0" disabled></label>
        <div id="flightDiv" hidden>
            <c:if test="${flightList.size() != 0}">
                <label for="flight">Вылет из:</label>
                <select id="flight" onchange="setCost()">
                    <c:forEach items="${flightList}" var="flight"><option>${flight.out}</option><option hidden>${flight.id}</option></c:forEach>
                </select>
                <div id="flightInfo" >
                    <input name="flightId" hidden value="${flightList.get(0).id}">
                    Вылет: ${flightList.get(0).out}
                    Стоимость билета: ${flightList.get(0).cost}
                    Дата и время: ${flightList.get(0).arrival}
                </div>
            </c:if>
            <c:if test="${flightList.size() == 0}">Рейсы отсутствуют<select id="flight" name="flight" hidden></select></c:if>

            <%--<c:if test="${!isLogin}">
                <form action="/requests/addRequest/${tour.id}" method="post">
                    <input type="tel" name="phone" id="phone" placeholder="(XX) XXX-XX-XX" class="masked" pattern="([0-9]{2}) [0-9]{3}-[0-9]{2}-[0-9]{2}" >
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <input type="submit" value="Заказать">
                </form>
            </c:if>
            <c:if test="${isLogin}">
                Для Заказа необходимо войти
            </c:if>--%>


        </div>
        <p>Дополнительные вопросы</p>
        <textarea name="questions">
            </textarea>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div style="position:relative; padding: 5px"><input type="submit" value="Подтвердить"/></div>
    </form>
</div>
<script>
    document.getElementById("places").setAttribute("max", ${tour.places});
    document.getElementById("cost").setAttribute("value", ${tour.cost});
    function setCost() {
        var places = document.getElementById("places");
        var flightCost = 0;
        <c:if test="${flightList != null}">
        if(document.getElementById("with").checked) {
            var flightDiv = document.getElementById("flightDiv");
            flightDiv.hidden = false;
            var flight = document.getElementById("flight");

            <c:forEach items="${flightList}" var="flight">
            if('${flight.id}' == flight.options[flight.selectedIndex+1].innerHTML) {
                flightCost = ${flight.cost};
                var flightInfo = document.getElementById("flightInfo");
                flightInfo.innerHTML = "<input name=\"flightId\" hidden value=\"${flight.id}\">\n" +
                    "Вылет: ${flight.out}\n" +
                    "Стоимость билета: ${flight.cost}\n" +
                    "Дата и время: ${flight.arrival}"
            }
            </c:forEach>


        }
        else {
            document.getElementById("flightDiv").hidden = true;
            flightCost = 0;
        }
        </c:if>
        document.getElementById("cost").setAttribute("value", places.value*(Number(${tour.cost})+Number(flightCost)));
    }
    setCost();
</script>
<%@include file='../parts/footer.jsp'%>
