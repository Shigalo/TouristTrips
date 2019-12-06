<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../parts/header.jsp'%>

<div style="text-align: center; position: relative; top: 20%; left: -20%; ">
    <form action="" method="post">
        <div style="position:relative; padding: 5px"><label>target : <input type="text" name="target"></label></div>
        <div style="position:relative; padding: 5px"><label>name : <input type="text" name="name"></label></div>
        <div style="position:relative; padding: 5px"><label>places : <input type="number" name="places"></label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div style="position:relative; padding: 5px"><input type="submit" value="Добавить"/></div>
    </form>
</div>
<%@include file='../parts/footer.jsp'%>
