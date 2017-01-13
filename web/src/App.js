import React, {Component} from "react";
import Landing from './component/landing';
import "./App.css";

const style = {
    container: {
        width: "100%",
        height: "100%"
    }
};

let search = window.location.search.substring(1);
let query = {};
search.split("&").map((value) => {
   let pair = value.split("=");

   query[pair[0]] = pair[1];
});

class App extends Component {
    render() {
        return (
            <div style={style.container}>
                <Landing score={query['score']} nickName={query['nickName']}/>
            </div>
        );
    }
}

export default App;
