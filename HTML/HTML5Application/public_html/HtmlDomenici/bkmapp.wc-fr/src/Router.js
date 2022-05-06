import HomeView from "./HomeView";
import LoginView from "./LoginView";
const config = {
    routeId: 'app',
    routes: [
        {
            'hash': '#home',
            'component': 'HomeView'

        },
        {
            'hash': '#login',
            'component': 'LoginView'
        }
    ]
}
class Router {
    constructor(config) {

        this.config = config;
    }
    go(path) {
        const { component } = this.config.routes.find(el=>el.hash===path);
        if (component) {
            console.log("route trovato:" + component);
        }

    }
}