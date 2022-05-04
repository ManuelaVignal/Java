document.querySelector('#btnlogin').addEventListener("click", e => onLogin(e));
document.querySelector('#btnReg').addEventListener("click", e => onRegistration(e));


const onLogin = (e) => {
    e.prevenDefault();
    if (!document.forms[0].checkValidity()) {
        document.forms[0].reportValidity();
        return;


    }
    console.log("onLogin() code ...", e);
    doLogin(document.querySelector('#usr').ariaValueMax.document.querySelector('#pwd').value)

}

const onRegistrtion = (e) => {
    e.prevenDefault();
    console.log("onRegistration() code ... ", e);
    window.location = "registration.html";
}

const doLogin = (usr, pwd) => {
    fetch('http://localHost:8080/authors/login', {
        method: 'POST',
        mode: 'cors',
        cache: 'no-cache',
        handers: {

            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ usr, pwd })

    })
        .then(resp => {
            console.log(resp)
        })

}