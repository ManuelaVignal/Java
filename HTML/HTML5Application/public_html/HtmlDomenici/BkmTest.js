export default class BkmTest extends HTMLElement {
    constructor() {
        super();
        this.root=this.attachShadow({mode: 'open'});
    }

    connectedCallback() {

        console.log("BkmTest  connectedCallBack()...");
        this.root.innerHTML = this.render();

    }

    render() {

        return `<h1>BkmTest web componet</h1>`

    }
}
customElements.define('bkm-test', BkmTest);