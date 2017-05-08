let createCarportFields = document.getElementById("create-carport-fields");
let flatRoofButton = document.getElementById("flat-roof-button");
let trapezRoofButton = document.getElementById("trapez-roof-button");
let leftPane = document.getElementById("left-pane");
let rightPane = document.getElementById("right-pane");
let logo = document.getElementById("logo");

function showCreateCarport() {
    createCarportFields.style.display = "block";
    flatRoofButton.style.display = "none";
    trapezRoofButton.style.display = "none";
    logo.style.display = "none";
    rightPane.className = "fog-pink-column right";
}

flatRoofButton.addEventListener("click", showCreateCarport);
