import React from "react";
import style from './TestFieldHeader.module.css'
import {NavLink, useParams} from "react-router-dom";

const TestFieldHeader = (props) => {

    let testName = useParams()

    return(
        <div className={style.testFieldHeader}>
            <NavLink to={"/test/calc/addDoc"} className={style.navLink}>
                <h5>Добавить документ в чек лист</h5>
            </NavLink>
            <div className={style.testName}>
            <h1>{testName.name}</h1>
            </div>
        </div>
    )
    // return(
    //     <div className={style.testFieldHeader}>
    //         <h1>{testName.name}</h1>
    //     </div>
    // )
}
export default TestFieldHeader;