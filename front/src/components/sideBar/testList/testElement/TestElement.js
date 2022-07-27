import React from "react";
import style from './TestElement.module.css'
import {NavLink} from "react-router-dom";

const TestElement = (props) => {

    return(
        <div className={style.testElement}>
            <NavLink to={props.link} >{props.testName}</NavLink>
        </div>
    )
}
export default TestElement;