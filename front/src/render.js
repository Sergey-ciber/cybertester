import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import{BrowserRouter} from 'react-router-dom';
import {addDoc, inputText} from './redax/state';
import state from "./redax/state";

const root = ReactDOM.createRoot(document.getElementById('root'));

export let rerenderEntireTree = () => {
    root.render(
        <BrowserRouter>
            <App calc={state.calc} inputText={inputText} addDoc={addDoc}/>
        </BrowserRouter>
    );
}

