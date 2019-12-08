<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../parts/header.jsp'%>

<script>
    if(${tour.post}) { alert(${tour.post}); /*document.getElementById("post").setAttribute("checked", "checked"); */}

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                var blah = input.parentElement.children[0];
                blah.setAttribute("src", e.target.result);
                blah.style.setProperty("width", "150px");
            };
            reader.readAsDataURL(input.files[0]);
        }
    }
    function addInfo() {
        var table = document.getElementById("infoTable");
        var row = table.insertRow(-1);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        cell1.innerHTML = "<img src=\"#\"/><br/>" +
            "<input type=\"file\" accept=\"image/*\" onchange=\"readURL(this)\" name=\"image\" />";
        cell2.innerHTML = "<textarea name=\"header\" placeholder=\"Заголовок\"></textarea>";
        cell3.innerHTML = "<textarea name=\"about\" placeholder=\"Описание\"></textarea>";
    }
    function remove(element) {
        alert(element.parentElement.parentElement.innerHTML);
        element.parentElement.parentElement.remove();
    }
</script>

<div style="text-align: center; position: relative; top: 20%; left: -20%; ">
    <div style="position:relative; padding: 5px"><label>id : ${tour.id}</label></div>

    <form action="" method="post" enctype="multipart/form-data">
        <input type="submit" value="Сохранить"><br>
        <input id="post" type="checkbox" name="posting" />Опубликовать<br>
        <input type="button" onclick="addInfo()" value="Добавить строку"><br>
        <table id="infoTable" border="1">
            <c:forEach items="${infoList}" var="info">
                <tr>
                    <td style="width: 100px">
                        <img src="infoImage/<c:out value='${info.id}'/>" style="width: 150px" /><br/>
                        <input type="file" accept="image/*" onchange="readURL(this)" name="image" />
                    </td>
                    <td><textarea name="header" placeholder="Заголовок">${info.header}</textarea></td>
                    <td><textarea name="about" placeholder="Описание">${info.about}</textarea></td>
                    <td><input type="button" onclick="remove(this)" value="Удалить"></td>
                    <td hidden><input type="number" name="sequence" value="${info.sequence}"></td>
                </tr>
            </c:forEach>
        </table>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>
</div>
<%@include file='../parts/footer.jsp'%>
