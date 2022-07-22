import './App.css';
import Header from "./components/header/Header";
import React from "react";
import SideBar from "./components/sideBar/SideBar";
import MainField from "./components/mainField/MainField";

function App() {
  return (
    <div className="App">
    <Header/>
    <SideBar/>
    <MainField/>
    </div>
  );
}

export default App;
