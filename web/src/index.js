import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import './index.css';

let search = window.location.search.substring(1);
let score = 0;
let queries = {};

if(search.indexOf("?") >= 0) {
    search = search.substring(1).split("&").map((value)=> {
        let query = value.split("=");
        queries[query[0]] = query[1];
    });
}

ReactDOM.render(
  <App score={queries["score"]}/>,
  document.getElementById('root')
);
