import React from "react";
import style from './TestFieldHeader.module.css'
import {NavLink, useParams} from "react-router-dom";
import {checkCalculation} from "../../../redax/calcReducer";
import {useDispatch, useSelector} from "react-redux";

const TestFieldHeader = (props) => {

    const dispatch = useDispatch()
    const fieldName = useSelector(state => state.calcTestData.fieldName)
    const sort = useSelector(state => state.calcTestData.sort)
    const pageSize = useSelector(state => state.calcTestData.pageSize)
    const currentPage  = useSelector(state => state.calcTestData.currentPage)

    let testName = useParams()

    let checkThisCalculation = () => {
        dispatch(checkCalculation(fieldName, sort, pageSize, currentPage))
    }

    return(
        <div className={style.testFieldHeader}>
            <NavLink to={"/test/calc/addDoc"} className={style.addDocNavLink}>
                <div>Добавить документ в чек лист</div>
            </NavLink>
            <div className={style.checkButton} onClick={() => {checkThisCalculation()}}>Проверить расчет</div>
            <div className={style.testName}>
            <h1 id={"TestName"}>{testName.name}</h1>
            </div>
        </div>
    )
}
export default TestFieldHeader;