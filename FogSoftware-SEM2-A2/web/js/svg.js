// Main drawing
var svg = document.getElementById("carport");

svg.style.width = "950";
svg.style.height = "550";
svg.style.border = "solid 4px #999";

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


// Position elements
frontPost.setAttribute("x", "120");
frontPost.setAttribute("y", "120");
frontPost.setAttribute("width", "15");
frontPost.setAttribute("height", "250");
frontPost.setAttribute("class", "element");

middlePost.setAttribute("x", "400");
middlePost.setAttribute("y", "130");
middlePost.setAttribute("width", "15");
middlePost.setAttribute("height", "240");
middlePost.setAttribute("class", "element");

shedPost.setAttribute("x", "650");
shedPost.setAttribute("y", "140");
shedPost.setAttribute("width", "15");
shedPost.setAttribute("height", "230");
shedPost.setAttribute("class", "element");

backPost.setAttribute("x", "850");
backPost.setAttribute("y", "140");
backPost.setAttribute("width", "15");
backPost.setAttribute("height", "230");
backPost.setAttribute("class", "element");

roof.setAttribute("x", "50");
roof.setAttribute("y", "100");
roof.setAttribute("width", "850");
roof.setAttribute("height", "25");
roof.setAttribute("class", "element");
roof.setAttribute("transform", "rotate(2 50 50)");

roofSide.setAttribute("x", "55");
roofSide.setAttribute("y", "115");
roofSide.setAttribute("width", "840");
roofSide.setAttribute("height", "20");
roofSide.setAttribute("class", "element");
roofSide.setAttribute("transform", "rotate(2 50 50)");

shed.setAttribute("x", "665");
shed.setAttribute("y", "145");
shed.setAttribute("width", "185");
shed.setAttribute("height", "225");
shed.setAttribute("class", "element");

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
svg.appendChild(frontPost);
svg.appendChild(middlePost);
svg.appendChild(backPost);
svg.appendChild(shedPost);
svg.appendChild(roofSide);
svg.appendChild(shed);
svg.appendChild(roof);
svg.appendChild(cLength);
svg.appendChild(cLengthTxt);

// Apply global styles
var element = document.getElementsByClassName("element");

for (var i = 0; i < element.length; i++) {
    element[i].style.fill = "white";
    element[i].style.stroke = "#333";
    element[i].style.strokeWidth = "2px";
}

shed.style.fill = "#ccc";




