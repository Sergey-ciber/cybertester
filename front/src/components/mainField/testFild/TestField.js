import React from "react";
import style from './TestField.module.css'
import TestFieldHeader from "../testFieldHeader/TestFieldHeader";
import Content from "../content/Content";
import {useParams} from "react-router-dom";


const TestField = (props) => {

    return(
        <div className={style.testField}>
        <TestFieldHeader testName={useParams()}/>
        <Content />
        </div>
    )
}
export default TestField;