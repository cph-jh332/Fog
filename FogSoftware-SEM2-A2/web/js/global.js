// Variables
let popupLogin = document.getElementById("login-popup");
let popupSignup = document.getElementById("signup-popup")
let loginButton = document.getElementById("login-button");
let signupButton = document.getElementById("signup-button");

// Functions
function showLogin() {
    popupLogin.style.display = "block";
}

function showSignup() {
    popupSignup.style.display = "block";
}

// Click events
loginButton.addEventListener("click", showLogin);
signupButton.addEventListener("click", showSignup);