// Variables
let popupLogin = document.getElementById("login-popup");
let popupSignup = document.getElementById("signup-popup");
let signupButton = document.getElementById("signup-button");

let popupContainer = document.getElementsByClassName("popup-container");
let popupContent = document.getElementsByClassName("popup-content");
let loginButton = document.getElementsByClassName("login-button");

for (let i = 0; i < popupContent.length; i++) {
    popupContent[i].insertAdjacentHTML("afterbegin", "<img src='img/close-button.png' class='close-popup' id='close-popup'>");
}

// Functions
function showLogin(e) {
    popupLogin.style.display = "block";
    e.preventDefault();
}

function showSignup() {
    popupSignup.style.display = "block";
}

function removePopup(e) {
    for (let i = 0; i < popupContainer.length; i++) {
        popupContainer[i].style.display = "none";
        e.preventDefault();
    }
}

// Click events 
signupButton.addEventListener("click", showSignup);

let closePopup = document.getElementsByClassName("close-popup");
for (let i = 0; i < closePopup.length; i++) {
    closePopup[i].addEventListener("click", removePopup, false);
}

for (let i = 0; i < loginButton.length; i++) {
    loginButton[i].addEventListener("click", showLogin, false);
}

