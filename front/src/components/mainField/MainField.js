import React from "react";
import style from './MainField.module.css'
import TestField from "./testFild/TestField";
import {Route, Routes} from "react-router-dom";

const MainField = (props) => {

    return (
        <div className={style.mainField}>
            <Routes>
                <Route path={"/test/:name"} element={<TestField calc={props.calc}/>}/>
                <Route path={"/test/:name/:id"} element={<TestField calc={props.calc} inputText={props.inputText} addDoc={props.addDoc}/>}/>
            </Routes>
        </div>
    )
}
export default MainField;