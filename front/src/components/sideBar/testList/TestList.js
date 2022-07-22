import React from "react";
import style from './TestList.module.css'
import TestElement from "./testElement/TestElement";

const TestList = () => {

    return(
        <div className={style.testList}>
            <TestElement link={"/calcTest"} testName={"Тест расчета"}/>
            <TestElement link={"/loadTest"} testName={"Тест загрузки"}/>
        </div>
    )
}
export default TestList;