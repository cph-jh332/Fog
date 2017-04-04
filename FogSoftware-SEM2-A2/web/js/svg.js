// Main drawing
var svg = document.getElementById("carport");

svg.style.width = "950";
svg.style.height = "550";
svg.style.border = "solid 4px #999";

function drawSidePillars(x) {
    // x = total amount of pillars
    return ((x - 1) / 2) - 1;
}



// Create objects
var frontPost = document.createElementNS("http://www.w3.org/2000/svg", "rect");
var middlePost = document.createElementNS("http://www.w3.org/2000/svg", "rect");
var shedPost = document.createElementNS("http://www.w3.org/2000/svg", "rect");
var backPost = document.createElementNS("http://www.w3.org/2000/svg", "rect");
var roof = document.createElementNS("http://www.w3.org/2000/svg", "rect");
var roofSide = document.createElementNS("http://www.w3.org/2000/svg", "rect");
var shed = document.createElementNS("http://www.w3.org/2000/svg", "rect");

var cLength = document.createElementNS("http://www.w3.org/2000/svg", "path");
var cLengthTxt = document.createElementNS("http://www.w3.org/2000/svg", "text");

var cWidth = document.createElementNS("http://www.w3.org/2000/svg", "path");
var cWidthTxt = document.createElementNS("http://www.w3.org/2000/svg", "text");

var cHeight = document.createElementNS("http://www.w3.org/2000/svg", "path");
var cHeightTxt = document.createElementNS("http://www.w3.org/2000/svg", "text");

function createObject(object,x,y,w,h,c,t) {
    object.setAttribute("x", x);
    object.setAttribute("y", y);
    object.setAttribute("width", w);
    object.setAttribute("height", h);
    object.setAttribute("class", c);
    object.setAttribute("transform", t);
    
    return object;
}

function getDimensions(isLength) {
    var carportLength = document.getElementById("carport_length").innerHTML;
    var carportWidth = document.getElementById("carport_width");
    
    y = 0;
    
    if (isLength === true) {
        // get length
        y = parseInt(carportLength);
    } else {
        // get width
        y = parseInt(carportWidth);
    }
    
    return y;
}

// Carport length
cLength.setAttribute("d", "M 10 450 L 900 450");
cLength.setAttribute("stroke", "#6495ED");
cLength.setAttribute("stroke-width", "2");
cLength.setAttribute("stroke-dasharray", "1,3");

cLengthTxt.setAttribute("x", "400");
cLengthTxt.setAttribute("y", "480");
cLengthTxt.setAttribute("fill", "#6495ED");
cLengthTxt.setAttribute("font-family", "Arial");
var textX = document.createTextNode("Length: " + getDimensions(true) + " cm");
cLengthTxt.appendChild(textX);

// Carport height
cHeight.setAttribute("d", "M 19 98 V 460 460");
cHeight.setAttribute("stroke", "#6495ED");
cHeight.setAttribute("stroke-width", "2");
cHeight.setAttribute("stroke-dasharray", "1,3");

cHeightTxt.setAttribute("x", "20");
cHeightTxt.setAttribute("y", "300");
cHeightTxt.setAttribute("fill", "#6495ED");
cHeightTxt.setAttribute("font-family", "Arial");
cHeightTxt.setAttribute("transform", "rotate(-90 45 295)");
var textY = document.createTextNode("Height: 210 cm");
cHeightTxt.appendChild(textY);

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

svg.appendChild(cHeight);
svg.appendChild(cHeightTxt);
//svg.appendChild(createObject(testPost, 10, 10, 15, 300, "element"));

// Apply global styles
var element = document.getElementsByClassName("element");

for (var i = 0; i < element.length; i++) {
    element[i].style.fill = "white";
    element[i].style.stroke = "#333";
    element[i].style.strokeWidth = "2px";
}

shed.style.fill = "#ccc";




