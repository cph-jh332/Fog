<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Carport 2D SVG drawing</h1>
<p hidden id="carport_length"><c:out value="${length}"/></p>
<p hidden id="carport_width"><c:out value="${width}"/></p>
<p hidden id="pillars"><c:out value="${pillars}"/></p>
<p hidden id="rafters"><c:out value="${rafters}"/></p>

<h3>Top-view</h3>
<div class="svg-container">
    <svg viewBox="0 0 0 0" version="1.1" xmlns="https://www.w3.org/2000/svg" id="carport_top"></svg>
</div>

<h3>Side-view</h3>
<div class="svg-container">
    <svg version="1.1" xmlns="https://www.w3.org/2000/svg" id="carport_side"></svg>
</div>

<h3>Front-view</h3>
<div class="svg-container">
    <svg version="1.1" xmlns="https://www.w3.org/2000/svg" id="carport_front"></svg>
</div>

<script src="js/carport_top.js"></script>
<script src="js/carport_side.js"></script>
<script src="js/carport_front.js"></script>


