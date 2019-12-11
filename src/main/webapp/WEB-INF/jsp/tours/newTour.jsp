<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../parts/header.jsp'%>

<div id="content">
    <form action="" method="post">
        <div style="position:relative; padding: 5px"><label>target : <input type="text" name="target"></label></div>
        <div style="position:relative; padding: 5px"><label>name : <input type="text" name="name"></label></div>
        <div style="position:relative; padding: 5px"><label>places : <input type="number" name="places" step="1"></label></div>
        <div style="position:relative; padding: 5px"><label>date : <input type="datetime-local" name="date"></label></div>
        <div style="position:relative; padding: 5px"><label>type : <input type="text" name="type"></label></div>
        <div style="position:relative; padding: 5px"><label>cost : <input type="number" name="cost" step="0,01"></label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div style="position:relative; padding: 5px"><input type="submit" value="Добавить"/></div>
    </form>
</div>
<%@include file='../parts/footer.jsp'%>
