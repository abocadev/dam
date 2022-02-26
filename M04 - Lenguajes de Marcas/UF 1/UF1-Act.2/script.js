function login(){
    var email = document.getElementById('loginemail').value;
    var password = document.getElementById('passwordlogin').value;

    if(password == 1234 && email == 'ejemplo@gmail.com'){
        alert("USER SUCCESSFULLY LOGGED IN");
    }else{
        alert("INCORRECT EMAIL OR PASSWORD ")
    }
}

function register(){
    var name = document.getElementById('nameregistrer').value;
    var email = document.getElementById('emailregistrer').value;
    var password1 = document.getElementById('passwordregistrer1').value;
    var password2 = document.getElementById('passwordregistrer2').value;

    if(password1 == password2){
        alert("CORRECTLY REGISTERED USER");
    }else{
        alert("DIFFERENT PASSWORDS");
    }
}