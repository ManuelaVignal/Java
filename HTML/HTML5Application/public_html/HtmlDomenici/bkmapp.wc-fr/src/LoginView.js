import Router from "./Router.js"
export default class LoginView extends HTMLElement {
    constructor() {
        super();
        this.root = this.attachShadow({ mode: 'open' });
    }

    connectedCallback() {

        console.log("BkmTest  connectedCallBack()...");
        this.root.innerHTML = this.render();
        const cmdLogin = this.root.querySelector("button");
        cmdLogin.addEventListener("click", e => this.onLogin(e));

    }

    render() {

        return `
            <h1>Bkmtest web component</h1>
            <form action ="">
                <input type="text" name="usr" id="usr">
                <input type="password" name="pwd" id="pwd">
                <button >Invia</button>
                    </form>
                    `
    }
                    onLogin(e){
                        e.preventDefault();
                    console.log("onLogin()...")
    }

    
}
    customElements.define('bkm-login', LoginView);

    