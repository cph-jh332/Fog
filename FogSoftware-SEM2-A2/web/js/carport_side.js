// Main drawing
var svg = document.getElementById("carport_side");

var baseLength = 780;
var baseWidth = 600;
var scale = getScale();
var lengthScale = getLengthScale();
var heightScale = getHeightScale();
var pillars = parseInt(document.getElementById("pillars").innerHTML) - 1;
var canvasWidth = 950;
var canvasHeight = 550;
svg.style.width = canvasWidth;
svg.style.height = canvasHeight;
svg.setAttribute("viewBox", "0 0 " + canvasWidth * lengthScale + " " + canvasHeight * heightScale);

function getScale()
{
    var length = parseInt(getDimensions("carport_length"));
    return length / baseLength;
}

function getHeightScale()
{
    return 1;
}

function getLengthScale()
{
    var length = parseInt(getDimensions("carport_length"));
    return length / baseLength;
}

function createObject(x, y, width, height, eleclass, rotation)
{
    var object = document.createElementNS("http://www.w3.org/2000/svg", "rect");
    object.setAttribute("x", x * lengthScale);
    object.setAttribute("y", y * heightScale);
    object.setAttribute("width", width * lengthScale);
    object.setAttribute("height", height * heightScale);
    object.setAttribute("class", eleclass);
    object.setAttribute("transform", rotation);

    return object;
}

function createObjectChooseScale(object, x, y, width, height, eleclass, rotation, scaleWidth, scaleHeight) 
{
    if (scaleWidth)
        width = width * lengthScale;
    if (scaleHeight)
        height = height * heightScale;
    object.setAttribute("x", x * scale);
    object.setAttribute("y", y * scale);
    object.setAttribute("width", width * scale);
    object.setAttribute("height", height * scale);
    object.setAttribute("class", eleclass);
    object.setAttribute("transform", rotation);
    
    return object;
}

function getDimensions(name)
{
    return document.getElementById(name).innerHTML;
}

// Carport length
var cLength = document.createElementNS("http://www.w3.org/2000/svg", "path");
var cLengthTxt = document.createElementNS("http://www.w3.org/2000/svg", "text");
cLength.setAttribute("d", "M " + 10 * lengthScale + " " + 450 + "L " + 900 * lengthScale + " " + 450);
cLength.setAttribute("stroke", "#6495ED");
cLength.setAttribute("stroke-width", "2");
cLength.setAttribute("stroke-dasharray", "1,3");

cLengthTxt.setAttribute("x", (canvasWidth / 2) * lengthScale - (50 * lengthScale));
cLengthTxt.setAttribute("y", 480);
cLengthTxt.setAttribute("fill", "#6495ED");
cLengthTxt.setAttribute("font-family", "Arial");
cLengthTxt.setAttribute("font-size", 18 * lengthScale);
var textX = document.createTextNode("Length: " + getDimensions("carport_length") + " cm");
cLengthTxt.appendChild(textX);

// Carport height
var cHeight = document.createElementNS("http://www.w3.org/2000/svg", "path");
var cHeightTxt = document.createElementNS("http://www.w3.org/2000/svg", "text");
cHeight.setAttribute("d", "M " + 10 * scale + " " + 450 + "L " + 10 + " " + 100);
cHeight.setAttribute("stroke", "#6495ED");
cHeight.setAttribute("stroke-width", "2");
cHeight.setAttribute("stroke-dasharray", "1,3");

cHeightTxt.setAttribute("x", -300);
cHeightTxt.setAttribute("y", 50 * lengthScale);
cHeightTxt.setAttribute("fill", "#6495ED");
cHeightTxt.setAttribute("font-family", "Arial");
cHeightTxt.setAttribute("font-size", 18 * lengthScale);
cHeightTxt.setAttribute("transform", "rotate(-90 0 0)");
var textY = document.createTextNode("Height: 210 cm");
cHeightTxt.appendChild(textY);

// Append all elements to the drawing
var startX = 55 + 25;
for (var i = 0; i < pillars - 6; i+=2)
{
    svg.appendChild(createObject(startX, 120, 15, 250, "element", "rotate(0 0 0)"));
    startX += 350;
}
svg.appendChild(createObject(850, 140, 15, 230, "element", "rotate(0 0 0)"));
svg.appendChild(createObject(650, 140, 15, 230, "element", "rotate(0 0 0)"));
svg.appendChild(createObject(665, 145, 185, 225, "shed", "rotate(0 0 0)"));
svg.appendChild(createObject(55, 115, 840, 20, "element", "rotate(1 0 0)"));
svg.appendChild(createObject(50, 100, 850, 25, "element", "rotate(1 0 0)"));

svg.appendChild(cLength);
svg.appendChild(cLengthTxt);

svg.appendChild(cHeight);
svg.appendChild(cHeightTxt);

// Apply global styles
var element = document.getElementsByClassName("element");
var shed = document.getElementsByClassName("shed");

for (var i = 0; i < element.length; i++) {
    element[i].style.fill = "white";
    element[i].style.stroke = "#333";
    element[i].style.strokeWidth = "2px";
}

shed[1].style.fill = "#D3D3D3";
shed[1].style.stroke = "#333";
shed[1].style.strokeWidth = 2;