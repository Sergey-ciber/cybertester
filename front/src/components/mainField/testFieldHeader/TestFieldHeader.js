import React from "react";
import style from './TestFieldHeader.module.css'

const TestFieldHeader = (props) => {

    return(
        <div className={style.testFieldHeader}>
            <h1>{props.testName}</h1>
        </div>
    )
}
export default TestFieldHeader;