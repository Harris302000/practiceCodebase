function onclicklogin(){
    var username = document.getElementById('Username').value;
    var password = document.getElementById('Password').value;

    if(username == ''){
        alert('Kindly Fill Username');
        return false;
    }

    if(password == ''){
        alert('Kindly Fill Password');
        return false;
    }
}