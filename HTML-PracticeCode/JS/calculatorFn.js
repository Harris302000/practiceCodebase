function setInput(value) {

    var data = document.getElementById("display").value + value;

    document.getElementById("display").value = data;

}

function clearData() {

    document.getElementById("display").value = '';

}


function calculate() {

    var userInput = document.getElementById("display").value;

    document.getElementById("display").value = eval(userInput);


}


function clearDataSingle() {

    var userInput = document.getElementById("display").value;


    if (userInput.length != 0) {
        userInput = userInput.substring(0, userInput.length - 1);
    }

    document.getElementById("display").value = userInput;
}