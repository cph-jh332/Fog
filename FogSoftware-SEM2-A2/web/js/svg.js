// Main drawing
var svg = document.getElementById("carport");

svg.style.width = "950";
svg.style.height = "550";
svg.style.border = "solid 4px #999";

function drawSidePillars(x) {
    // x = total amount of pillars
    return ((x - 1) / 2) - 1;
}

// First element
var frontPost = document.createElementNS("http://www.w3.org/2000/svg", "rect");
var middlePost = document.createElementNS("http://www.w3.org/2000/svg", "rect");
var shedPost = document.createElementNS("http://www.w3.org/2000/svg", "rect");
var backPost = document.createElementNS("http://www.w3.org/2000/svg", "rect");
var roof = document.createElementNS("http://www.w3.org/2000/svg", "rect");
var roofSide = document.createElementNS("http://www.w3.org/2000/svg", "rect");
var shed = document.createElementNS("http://www.w3.org/2000/svg", "rect");

var cLength = document.createElementNS("http://www.w3.org/2000/svg", "path");
var cLengthTxt = document.createElementNS("http://www.w3.org/2000/svg", "text");

function createObject(o,x,y,w,h,c,t) {
    o.setAttribute("x", x);
    o.setAttribute("y", y);
    o.setAttribute("width", w);
    o.setAttribute("height", h);
    o.setAttribute("class", c);
    o.setAttribute("transform", t);
    
    return o;
}

// Position specifications
cLength.setAttribute("d", "M 50 450 L 900 450");
cLength.setAttribute("y", "900");
cLength.setAttribute("width", "900");
cLength.setAttribute("stroke", "lightblue");
cLength.setAttribute("stroke-width", "2");
cLength.setAttribute("stroke-dasharray", "1,3");

cLengthTxt.setAttribute("x", "400");
cLengthTxt.setAttribute("y", "480");
cLengthTxt.setAttribute("fill", "lightblue");
cLengthTxt.setAttribute("font-family", "Arial");
var texty = document.createTextNode("Length: 780cm");
cLengthTxt.appendChild(texty);

// Append all elements to the drawing
svg.appendChild(createObject(frontPost, 120, 120, 15, 250, "element", "rotate(0 0 0)"));
svg.appendChild(createObject(middlePost, 400, 130, 15, 240, "element", "rotate(0 0 0)"));
svg.appendChild(createObject(backPost, 850, 140, 15, 230, "element", "rotate(0 0 0)"));
svg.appendChild(createObject(shedPost, 650, 140, 15, 230, "element", "rotate(0 0 0)"));
svg.appendChild(createObject(roofSide, 55, 115, 840, 20, "element", "rotate(2 50 50)"));
svg.appendChild(createObject(shed, 665, 145, 185, 225, "element", "rotate(0 0 0)"));
svg.appendChild(createObject(roof, 50, 100, 850, 25, "element", "rotate(2 50 50)"));

svg.appendChild(cLength);
svg.appendChild(cLengthTxt);
//svg.appendChild(createObject(testPost, 10, 10, 15, 300, "element"));

// Apply global styles
var element = document.getElementsByClassName("element");

for (var i = 0; i < element.length; i++) {
    element[i].style.fill = "white";
    element[i].style.stroke = "#333";
    element[i].style.strokeWidth = "2px";
}

shed.style.fill = "#ccc";




