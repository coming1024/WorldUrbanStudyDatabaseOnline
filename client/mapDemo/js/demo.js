
function doClick(){
    var element = document.getElementById("username").value;
    console.log(element)
    localStorage.setItem("City",element);
}
