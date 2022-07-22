import React from "react";
import style from './TestElement.module.css'
import {Link} from "react-router-dom";

const TestElement = (props) => {

    return(
        <div className={style.testElement}>
            <Link to={props.link} activeClassName={style.activeLink}>{props.testName}</Link>
        </div>
    )
}
export default TestElement;