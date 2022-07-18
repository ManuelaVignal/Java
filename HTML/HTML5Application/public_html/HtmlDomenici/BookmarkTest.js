/* global customElements */

export default class BookmarkTest extends HTMLElement {
    constructor() {
        super();
        this.root=this.attachShadow({mode: 'open'});
    }

    connectedCallback() {

        console.log("BookmarkTest  connectedCallBack()...");
        this.root.innerHTML = this.render();

    }

    render() {

        return `<h1>BookmarkTest web componet</h1>`

    }
}
customElements.define('bookmark-test', BookmarkTest);