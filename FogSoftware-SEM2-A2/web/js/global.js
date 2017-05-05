// Variables
let popupLogin = document.getElementById("login-popup");
let popupSignup = document.getElementById("signup-popup");
let loginButton = document.getElementById("login-button");
let signupButton = document.getElementById("signup-button");
let popupContainer = document.getElementsByClassName("popup-container");
let popupContent = document.getElementsByClassName("popup-content");

for (let i = 0; i < popupContent.length; i++) {
    popupContent[i].insertAdjacentHTML("afterbegin", "<img src='img/close-button.png' class='close-popup' id='close-popup'>");
}

// Functions
function showLogin() {
    popupLogin.style.display = "block";
}

function showSignup() {
    popupSignup.style.display = "block";
}

function removePopup(e) {
    for (let i = 0; i < popupContainer.length; i++) {
        popupContainer[i].style.display = "none";
        e.stopPropagation();
    }
}

// Click events 
loginButton.addEventListener("click", showLogin);
signupButton.addEventListener("click", showSignup);

let closePopup = document.getElementsByClassName("close-popup");
for (let i = 0; i < closePopup.length; i++) {
    closePopup[i].addEventListener("click", removePopup, false);
}

