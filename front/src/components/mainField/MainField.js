import React from "react";
import style from './MainField.module.css'
import TestField from "./testFild/TestField";
import {Route, Routes} from "react-router-dom";
import OldCalcResultList from "./content/oldCalcResultList/OldCalcResultList";

const MainField = (props) => {

    return (
        <div className={style.mainField}>
            <Routes>
                <Route path={"/test/:chapter"} element={<TestField />}/>
                <Route path={"/test/:chapter/:id"} element={<TestField />}/>
            </Routes>
        </div>
    )
}
export default MainField;