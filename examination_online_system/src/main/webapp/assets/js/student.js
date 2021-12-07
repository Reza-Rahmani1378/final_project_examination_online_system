var z = document.getElementById('back');
z.disabled = true;

var e = document.getElementById('next');
e.disabled = true;


function next(number) {

    //var number = 1;

    var y = document.getElementById(number);
    y.classList.add('hide');

    number++;
    var ss = document.getElementById(number);
    ss.classList.remove('hide');

}


function back(num) {
    var y = document.getElementById(num);
    y.classList.add('hide');
    num--;
    var x = document.getElementById(num);
    x.classList.remove('hide');

}





