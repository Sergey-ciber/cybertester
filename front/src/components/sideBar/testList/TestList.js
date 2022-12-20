import React from "react";
import style from './TestList.module.css'
import TestElement from "./testElement/TestElement";

const TestList = () => {

    return(
        <div className={style.testList}>
            <TestElement link={"/test/calc"} id={"CalcTest"} testName={"Тест расчета"}/>
            <TestElement link={"/test/load"} id={"loadTest"} testName={"Тест загрузки"}/>
        </div>
    )
}
export default TestList;