import './App.css';
import Header from "./components/header/Header";
import React from "react";
import SideBar from "./components/sideBar/SideBar";
import MainField from "./components/mainField/MainField";

function App(props) {

    return (
        <div className="App">
            <Header/>
            <SideBar/>
            <MainField calc={props.calc} inputText={props.inputText} addDoc={props.addDoc}/>
        </div>
    );
}

export default App;
