import React from "react";
import style from './TestFieldHeader.module.css'
import {NavLink, useParams} from "react-router-dom";
import {checkCalculation} from "../../../redax/calcReducer";

const TestFieldHeader = (props) => {

    let testName = useParams()

    return(
        <div className={style.testFieldHeader}>
            <NavLink to={"/test/calc/addDoc"} className={style.addDocNavLink}>
                <div>Добавить документ в чек лист</div>
            </NavLink>
            <div className={style.checkButton} onClick={() => {props.checkCalculation()}}>Проверить расчет</div>
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