import React from "react";
import style from './TestFieldHeader.module.css'
import {NavLink, useParams} from "react-router-dom";

const TestFieldHeader = (props) => {

    let testName = useParams()

    return(
        <div className={style.testFieldHeader}>
            <NavLink to={"/test/calc/addDoc"}>
                <h5>Добавить документ в чек лист</h5>
            </NavLink>
            <h1>{testName.name}</h1>
        </div>
    )
    // return(
    //     <div className={style.testFieldHeader}>
    //         <h1>{testName.name}</h1>
    //     </div>
    // )
}
export default TestFieldHeader;