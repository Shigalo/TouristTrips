<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../parts/header.jsp'%>

<div id="content">
    <h3>Авторизация</h3>
    <form action="" method="post">
        <div style="position:relative; padding: 5px"><label>Пункт отправки : <input type="text" name="out"></label></div>
        <div style="position:relative; padding: 5px"><label>Конечный пункт : <input type="text" name="target"></label></div>
        <div style="position:relative; padding: 5px"><label>Стоимость : <input type="number" step="0,01" name="cost"></label></div>
        <div style="position:relative; padding: 5px"><label>Отправка : <input type="datetime-local" name="departure"></label></div>
        <div style="position:relative; padding: 5px"><label>Прибытие : <input type="datetime-local" name="arrival"></label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div style="position:relative; padding: 5px"><input type="submit" value="Добавить"/></div>
    </form>
</div>
<%@include file='../parts/footer.jsp'%>
