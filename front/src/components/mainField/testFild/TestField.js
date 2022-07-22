import React from "react";
import style from './TestField.module.css'
import TestFieldHeader from "../testFieldHeader/TestFieldHeader";
import Content from "../content/Content";


const TestField = (props) => {

    return(
        <div className={style.testField}>
        <TestFieldHeader testName={props.testName}/>
        <Content/>
        </div>
    )
}
export default TestField;