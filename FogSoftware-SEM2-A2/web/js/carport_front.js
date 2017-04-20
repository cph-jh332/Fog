// Main drawing
var svg = document.getElementById("carport_front");

svg.style.width = "950";
svg.style.height = "550";
svg.style.border = "solid 4px #999";

var cWidth = document.createElementNS("http://www.w3.org/2000/svg", "path");
var cWidthTxt = document.createElementNS("http://www.w3.org/2000/svg", "text");

var cLength = document.createElementNS("http://www.w3.org/2000/svg", "path");
var cLengthTxt = document.createElementNS("http://www.w3.org/2000/svg", "text");

function createObject(x, y, width, height, eleclass, rotation) 
{
    var object = document.createElementNS("http://www.w3.org/2000/svg", "rect");
    object.setAttribute("x", x);
    object.setAttribute("y", y);
    object.setAttribute("width", width);
    object.setAttribute("height", height);
    object.setAttribute("class", eleclass);
    object.setAttribute("transform", rotation);
    
    return object;
}

function getDimensions(name) 
{
    return document.getElementById(name).innerHTML;
}

// Carport length
cWidth.setAttribute("d", "M 125 450 L 800 450");
cWidth.setAttribute("stroke", "#6495ED");
cWidth.setAttribute("stroke-width", "2");
cWidth.setAttribute("stroke-dasharray", "1,3");

cWidthTxt.setAttribute("x", "420");
cWidthTxt.setAttribute("y", "475");
cWidthTxt.setAttribute("fill", "#6495ED");
cWidthTxt.setAttribute("font-family", "Arial");
var textX = document.createTextNode("Width: " + getDimensions("carport_width") + " cm");
cWidthTxt.appendChild(textX);

// Carport height
cLength.setAttribute("d", "M 125 450 V 450 132");
cLength.setAttribute("stroke", "#6495ED");
cLength.setAttribute("stroke-width", "2");
cLength.setAttribute("stroke-dasharray", "1,3");

cLengthTxt.setAttribute("x", "0");
cLengthTxt.setAttribute("y", "360");
cLengthTxt.setAttribute("fill", "#6495ED");
cLengthTxt.setAttribute("font-family", "Arial");
cLengthTxt.setAttribute("transform", "rotate(-90 45 295)");
var textY = document.createTextNode("Height: 210 cm");
cLengthTxt.appendChild(textY);

// Append all elements to the drawing
svg.appendChild(createObject(175, 160, 25, 240, "front_element", "rotate(0 0 0)")); // pillar
svg.appendChild(createObject(750, 160, 25, 240, "front_element", "rotate(0 0 0)")); // pillar

svg.appendChild(createObject(167, 160, 16, 32, "front_element", "rotate(0 0 0)")); // rem
svg.appendChild(createObject(767, 160, 16, 32, "front_element", "rotate(0 0 0)")); // rem

svg.appendChild(createObject(145, 132, 660, 28, "front_element", "rotate(0 0 0)")); // Waterbord front

svg.appendChild(createObject(200, 160, 550, 174, "front_element", "rotate(0 0 0)")); // shed

var start = 200;
for (var i = 0; i < 22; i++) 
{
    svg.appendChild(createObject(start, 160, 25, 174, "board", "rotate(0 0 0)"));
    start += 25;
}

svg.appendChild(cWidth);
svg.appendChild(cWidthTxt);

svg.appendChild(cLength);
svg.appendChild(cLengthTxt);

// Apply styles
var elements = document.getElementsByClassName("front_element");
var boards = document.getElementsByClassName("board");
var shed = document.getElementsByClassName("shed");

for (var i = 0; i < boards.length; i++) {
    boards[i].style.fill = "white";
    boards[i].style.stroke = "#333";
    boards[i].style.strokeWidth = "1px";
}

// Global style
for (var i = 0; i < elements.length; i++) {
    elements[i].style.fill = "grey";
    elements[i].style.stroke = "#333";
    elements[i].style.strokeWidth = "2px";
}

shed[0].style.fill = "#D3D3D3";
shed[0].style.stroke = "#333";
shed[0].style.strokeWidth = "2px";