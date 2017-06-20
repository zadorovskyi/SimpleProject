function valid() {
    var password = document.getElementById("password");
    var reppassword = document.getElementById("reppassword");
    if (password != reppassword) {
        alert("Password don't match");
    }
    return false;
}
