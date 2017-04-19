// Main drawing
var svg = document.getElementById("carport_top");

svg.style.width = "950";
svg.style.height = "600";
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
cWidth.setAttribute("d", "M 285 555 L 650 555");
cWidth.setAttribute("stroke", "#6495ED");
cWidth.setAttribute("stroke-width", "2");
cWidth.setAttribute("stroke-dasharray", "1,3");

cWidthTxt.setAttribute("x", "420");
cWidthTxt.setAttribute("y", "575");
cWidthTxt.setAttribute("fill", "#6495ED");
cWidthTxt.setAttribute("font-family", "Arial");
var textX = document.createTextNode("Width: " + getDimensions("carport_width") + " cm");
cWidthTxt.appendChild(textX);

// Carport height
cLength.setAttribute("d", "M 285 555 V 460 35");
cLength.setAttribute("stroke", "#6495ED");
cLength.setAttribute("stroke-width", "2");
cLength.setAttribute("stroke-dasharray", "1,3");

cLengthTxt.setAttribute("x", "20");
cLengthTxt.setAttribute("y", "520");
cLengthTxt.setAttribute("fill", "#6495ED");
cLengthTxt.setAttribute("font-family", "Arial");
cLengthTxt.setAttribute("transform", "rotate(-90 45 295)");
var textY = document.createTextNode("Length: " + getDimensions("carport_length") + " cm");
cLengthTxt.appendChild(textY);

// Append all elements to the drawing
svg.appendChild(createObject(305, 35, 340, 500, "frame", "rotate(0 0 0)")); // frame
svg.appendChild(createObject(315, 45, 320, 480, "frame", "rotate(0 0 0)")); // inner-frame
svg.appendChild(createObject(305, 35, 340, 135, "frame", "rotate(0 0 0)")); // shed
svg.appendChild(createObject(315, 45, 320, 115, "shed", "rotate(0 0 0)")); // shed inner-frame
svg.appendChild(createObject(305, 35, 16, 16, "pillar", "rotate(0 0 0)"));
svg.appendChild(createObject(469, 35, 16, 16, "pillar", "rotate(0 0 0)"));
svg.appendChild(createObject(629, 35, 16, 16, "pillar", "rotate(0 0 0)"));
svg.appendChild(createObject(305, 159, 16, 16, "pillar", "rotate(0 0 0)"));
svg.appendChild(createObject(469, 159, 16, 16, "pillar", "rotate(0 0 0)"));
svg.appendChild(createObject(629, 159, 16, 16, "pillar", "rotate(0 0 0)"));
svg.appendChild(createObject(305, 255, 16, 16, "pillar", "rotate(0 0 0)"));
svg.appendChild(createObject(629, 255, 16, 16, "pillar", "rotate(0 0 0)"));
svg.appendChild(createObject(305, 519, 16, 16, "pillar", "rotate(0 0 0)"));
svg.appendChild(createObject(629, 519, 16, 16, "pillar", "rotate(0 0 0)"));
var startY = 45;
for (var i = 0; i < 15; i++) 
{
    svg.appendChild(createObject(305, startY, 340, 4, "element", "rotate(0 0 0)"));
    startY += 34;
}
svg.appendChild(cWidth);
svg.appendChild(cWidthTxt);

svg.appendChild(cLength);
svg.appendChild(cLengthTxt);

// Apply styles
var elements = document.getElementsByClassName("element");
var pillars = document.getElementsByClassName("pillar");
var shed = document.getElementsByClassName("shed");
var frames = document.getElementsByClassName("frame");

// Global style
for (var i = 0; i < elements.length; i++) {
    elements[i].style.fill = "white";
    elements[i].style.stroke = "#333";
    elements[i].style.strokeWidth = "2px";
}

for (var i = 0; i < pillars.length; i++) {
    pillars[i].style.fill = "#696969";
    pillars[i].style.stroke = "#333";
    pillars[i].style.strokeWidth = "2px";
}

for (var i = 0; i < frames.length; i++) {
    frames[i].style.fill = "white";
    frames[i].style.stroke = "#333";
    frames[i].style.strokeWidth = "4px";
}

shed[0].style.fill = "#D3D3D3";
shed[0].style.stroke = "#333";
shed[0].style.strokeWidth = "4px";