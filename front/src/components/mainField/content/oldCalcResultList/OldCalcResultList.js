import React, {useEffect, useState} from "react";
import style from './OldCalcResultList.module.css'
import {useDispatch, useSelector} from "react-redux";
import {getDocsWithPaginationAndSort} from "../../../../redax/calcReducer";
import {getOldCalcResultById} from "../../../../redax/oldCalcResultReducer";


const OldCalcResultList = (props) => {

    const dispatch = useDispatch()
    const oldCalcResulArr = useSelector(state => state.oldCalcResultData.oldCalcResult)

    // let resultElements = oldCalcResulArr.map(el => {
    //     return <div>
    //         <h5>{`Начало периода нетрудоспособности: ${el.periodBegDay}`}</h5>
    //         <h5>{`Конец периода нетрудоспособности: ${el.periodEndDay}`}</h5>
    //         <h5>{`Процент стажа: ${el.periodPercent}`}</h5>
    //         <h5>{`Сумма дня: ${el.price}`}</h5>
    //         <h5>{`Сумма дня по стажу: ${el.pricesPercent}`}</h5>
    //         <h5>{`RecordUQ КБК: ${el.recordUqBCC}`}</h5>
    //         <h5>{`Сумма рассчитанная: ${el.summa}`}</h5>
    //         <h5>{`Год расчета: ${el.yearCalc}`}</h5>
    //         <br/>
    //     </div>
    // })

    let resultElements = oldCalcResulArr.map(el => {
        return <tr key={el.id}>
            <td>{el.periodBegDay.substr(0, 10)}</td>
            <td>{el.periodEndDay.substr(0, 10)}</td>
            <td>{el.periodPercent}</td>
            <td>{el.price}</td>
            <td>{el.pricesPercent}</td>
            <td>{el.countDays}</td>
            <td>{el.recordUqBCC}</td>
            <td>{el.summa}</td>
            <td>{el.yearCalc}</td>
        </tr>
    })

    useEffect(() => {
        dispatch(getOldCalcResultById(props.id))
    }, [])

    // return (
    //     <div className={style.oldCalcResultList}>
    //         <h3>{`Старый результат расчета id = ${props.id}`}</h3>
    //         <div>{resultElements}</div>
    //
    //     </div>
    // )

    return (
        <div className={style.oldCalcResultList}>
            <table>
                <thead>
                <tr>
                    <th>Начало периода</th>
                    <th>Конец периода</th>
                    <th>Процент стажа</th>
                    <th>Сумма дня</th>
                    <th>Сумма дня по стажу</th>
                    <th>Дни</th>
                    <th>RecordUQ КБК</th>
                    <th>Сумма рассчитанная</th>
                    <th>Год расчета</th>
                </tr>
                </thead>
                <tbody>
                {resultElements}
                </tbody>
            </table>
        </div>
    )

}
export default OldCalcResultList;