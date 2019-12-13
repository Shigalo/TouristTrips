<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../parts/header.jsp'%>

<div id="content" align="center" style="left: -200px">
    <form action="" method="post">
        <div style="position:relative; padding: 5px"><label>Введите имя : <input type="text" name="username"></label></div>
        <div style="position:relative; padding: 5px"><label>Введите фамилию : <input type="text" name="surname"></label></div>
        <div style="position:relative; padding: 5px"><label>Введите пароль : <input type="password" name="password"></label></div>
        <div style="position:relative; padding: 5px"><label>Подтвердите пароль : <input type="password" name="passwordConfirm"></label></div>
        <div style="position:relative; padding: 5px"><label>Введите контакт для связи</label>
            <input type="tel" name="phone" id="phone" placeholder="(XX) XXX-XX-XX" class="masked" pattern="[(][0-9]{2}[)]\s[0-9]{3}-[0-9]{2}-[0-9]{2}" ></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <span>${massage}</span>
        <div style="position:relative; padding: 5px"><input type="submit" value="Регистрация"/></div>
    </form>
</div>
<script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/3/masking-input.js" data-autoinit="true"></script>
<%@include file='../parts/footer.jsp'%>
