import React from "react";
import style from './TestFieldHeader.module.css'
import {NavLink, useParams} from "react-router-dom";
import {checkCalculation} from "../../../redax/calcReducer";

const TestFieldHeader = (props) => {

    let testName = useParams()

    let checkCalculation = () => {
        props.checkCalculation(props.field, props.sort, props.pageSize, props.currentPage)
    }

    return(
        <div className={style.testFieldHeader}>
            <NavLink to={"/test/calc/addDoc"} className={style.addDocNavLink}>
                <div>Добавить документ в чек лист</div>
            </NavLink>
            <div className={style.checkButton} onClick={() => {checkCalculation()}}>Проверить расчет</div>
            <div className={style.testName}>
            <h1>{testName.name}</h1>
            </div>
        </div>
    )
}
export default TestFieldHeader;