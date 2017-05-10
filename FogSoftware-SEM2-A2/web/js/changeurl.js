
    let width = document.getElementById("width").value;
    let length = document.getElementById("length").value;


function ChangeUrl() {
    if (typeof (history.pushState) != "undefined") {
        var obj = {Title: "view-order", Url: "FrontController?width=" + width + "&length=" + length};
        history.pushState(obj, obj.Title, obj.Url);
    } else {
        alert("Browser does not support HTML5.");
    }
}
ChangeUrl();

