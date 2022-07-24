import React from "react";
import style from './MainField.module.css'
import TestField from "./testFild/TestField";
import {Route, Routes} from "react-router-dom";

const MainField = () => {

    return (
        <div className={style.mainField}>
            <Routes>
                <Route path={"/calcTest"} element={<TestField testName={"Тест расчетов"}/>}/>
                <Route path={"/loadTest"} element={<TestField testName={"Тест загрузки"}/>}/>
                <Route path={"/calcTest/3"} element={<div>Test</div>}/>
            </Routes>
        </div>
    )
}
export default MainField;