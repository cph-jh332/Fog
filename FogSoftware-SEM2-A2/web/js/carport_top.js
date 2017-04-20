// Global variables
var svg = document.getElementById("carport_top");
var baseLength = 780;
var baseWidth = 600;
var lengthScale = getLengthScale();
var widthScale = getWidthScale();
var pillars = parseInt(document.getElementById("pillars").innerHTML) - 1;
var rafters = parseInt(document.getElementById("rafters").innerHTML);

var canvasWidth = 950 * widthScale;
var canvasHeight = 600 * lengthScale;
var carportLength = 500;
var carportWidth = 340;
svg.style.width = canvasWidth;
svg.style.height = canvasHeight;


function getLengthScale()
{
    var length = parseInt(getDimensions("carport_length"));
    return length / baseLength;
}

function getWidthScale()
{
    var width = parseInt(getDimensions("carport_width"));
    return width / baseWidth;
}

function createObject(x, y, width, height, eleclass, rotation)
{
    var object = document.createElementNS("http://www.w3.org/2000/svg", "rect");
    object.setAttribute("x", x * widthScale);
    object.setAttribute("y", y * lengthScale);
    object.setAttribute("width", width * widthScale);
    object.setAttribute("height", height * lengthScale);
    object.setAttribute("class", eleclass);
    object.setAttribute("transform", rotation);

    return object;
}

function createObjectDontScale(x, y, width, height, eleclass, rotation)
{
    var object = document.createElementNS("http://www.w3.org/2000/svg", "rect");
    object.setAttribute("x", x * widthScale);
    object.setAttribute("y", y * lengthScale);
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
var cWidth = document.createElementNS("http://www.w3.org/2000/svg", "path");
var cWidthTxt = document.createElementNS("http://www.w3.org/2000/svg", "text");
cWidth.setAttribute("d", "M " + 270 * widthScale + " " + 555 * lengthScale + "L " + 650 * widthScale + " " + 555 * lengthScale);
cWidth.setAttribute("stroke", "#6495ED");
cWidth.setAttribute("stroke-width", "2");
cWidth.setAttribute("stroke-dasharray", "1,3");

cWidthTxt.setAttribute("x", 420 * widthScale);
cWidthTxt.setAttribute("y", 575 * lengthScale);
cWidthTxt.setAttribute("fill", "#6495ED");
cWidthTxt.setAttribute("font-family", "Arial");
var textX = document.createTextNode("Width: " + getDimensions("carport_width") + " cm");
cWidthTxt.appendChild(textX);

// Carport height
var cLength = document.createElementNS("http://www.w3.org/2000/svg", "path");
var cLengthTxt = document.createElementNS("http://www.w3.org/2000/svg", "text");
cLength.setAttribute("d", "M " + 270 * widthScale + " " + 555 * lengthScale + " V 445 " + 35 * lengthScale);
cLength.setAttribute("stroke", "#6495ED");
cLength.setAttribute("stroke-width", "2");
cLength.setAttribute("stroke-dasharray", "1,3");

cLengthTxt.setAttribute("x", canvasWidth / 3 - 165);
cLengthTxt.setAttribute("y", canvasHeight / 2);
cLengthTxt.setAttribute("fill", "#6495ED");
cLengthTxt.setAttribute("font-family", "Arial");
//cLengthTxt.setAttribute("transform", "rotate(-90 45 295)");
cLengthTxt.setAttribute("transform", "rotate(0 0 0)");
var textY = document.createTextNode("Length: " + getDimensions("carport_length") + " cm");
cLengthTxt.appendChild(textY);

// Append all elements to the drawing
svg.appendChild(createObject(305, 35, 340, 500, "frame", "rotate(0 0 0)")); // frame
svg.appendChild(createObject(315, 45, 320, 480, "frame", "rotate(0 0 0)")); // inner-frame
svg.appendChild(createObject(305, 35, 340, 135, "frame", "rotate(0 0 0)")); // shed
svg.appendChild(createObject(315, 45, 320, 115, "shed", "rotate(0 0 0)")); // shed inner-frame
svg.appendChild(createObjectDontScale(305, 35, 16, 16, "pillar", "rotate(0 0 0)"));
svg.appendChild(createObjectDontScale(469, 35, 16, 16, "pillar", "rotate(0 0 0)"));
svg.appendChild(createObjectDontScale(629, 35, 16, 16, "pillar", "rotate(0 0 0)"));
svg.appendChild(createObjectDontScale(305, 159, 16, 16, "pillar", "rotate(0 0 0)"));
svg.appendChild(createObjectDontScale(469, 159, 16, 16, "pillar", "rotate(0 0 0)"));
svg.appendChild(createObjectDontScale(629, 159, 16, 16, "pillar", "rotate(0 0 0)"));

var startY = 35 + carportLength - 16;
for (var i = 0; i < pillars - 6; i += 2)
{
    svg.appendChild(createObjectDontScale(305, startY, 16, 16, "pillar", "rotate(0 0 0)"));
    svg.appendChild(createObjectDontScale(645 - 16, startY, 16, 16, "pillar", "rotate(0 0 0)"));
    startY -= 250;
}

var startY = 40;
var distance = (500 - 10) / (rafters - 1);
for (var i = 0; i < rafters; i++)
{
    svg.appendChild(createObject(295, startY, 360, 4, "scalable_element", "rotate(0 0 0)"));
    startY += distance;
}
svg.appendChild(cWidth);
svg.appendChild(cWidthTxt);

svg.appendChild(cLength);
svg.appendChild(cLengthTxt);

// Apply styles
var elements = document.getElementsByClassName("scalable_element");
var pillars = document.getElementsByClassName("pillar");
var shed = document.getElementsByClassName("shed");
var frames = document.getElementsByClassName("frame");

// Global style
for (var i = 0; i < elements.length; i++) {
    elements[i].style.fill = "white";
    elements[i].style.stroke = "#333";
    elements[i].style.strokeWidth = 2;
}

for (var i = 0; i < pillars.length; i++) {
    pillars[i].style.fill = "#696969";
    pillars[i].style.stroke = "#333";
    pillars[i].style.strokeWidth = 2;
}

for (var i = 0; i < frames.length; i++) {
    frames[i].style.fill = "white";
    frames[i].style.stroke = "#333";
    frames[i].style.strokeWidth = 4;
}

shed[0].style.fill = "#D3D3D3";
shed[0].style.stroke = "#333";
shed[0].style.strokeWidth = 4;