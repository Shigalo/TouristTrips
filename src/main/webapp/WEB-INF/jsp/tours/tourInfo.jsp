<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file='../parts/header.jsp'%>

<script>
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {

                var blah = document.getElementById("blah");
                blah.setAttribute("src", e.target.result);
                blah.style.setProperty("width", "150");
                blah.style.setProperty("height", "200");


               /* $('#blah')
                    .attr('src', e.target.result)
                    .width(150)
                    .height(200);*/
            };

            reader.readAsDataURL(input.files[0]);
        }
    }</script>

<div style="text-align: center; position: relative; top: 20%; left: -20%; ">
    <div style="position:relative; padding: 5px"><label>id : ${tour.id}</label></div>

    <input type="file" name="myImage" accept="image/*" onchange="readURL(this)" />
    <img id="blah" src="#" alt="your image" />
</div>
<%@include file='../parts/footer.jsp'%>
