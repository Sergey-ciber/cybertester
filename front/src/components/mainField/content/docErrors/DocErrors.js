import React from "react";
import style from './DocErrors.module.css'
import {NavLink, useParams} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";

const DocErrors = (props) => {

    let param = useParams();

    const docList = useSelector(state => state.calcTestData.docList)

    let el = () => {
        let docInfo = docList.filter(el => {
            return (el.id === Number(param.id))
        })
        return (docInfo[0]) ? docInfo[0] :
            {
                id: 0,
                recordUqRegistr: 0,
                guidInput: "",
                doCheck: true,
                date: "",
                verified: true,
                message: ""
            }
    }
    let docInfoEl = el()


    return (
        <div className={style.docErrors}>
            <div>ID = {param.id}</div>
            <div>RECORD UQ = {docInfoEl.recordUqRegistr}</div>
            <div>GUID INPUT = {docInfoEl.guidInput}</div>
            <div>Результат расчета {(docInfoEl.calcResult === 1) ? "верный" : "не верный"}</div>
            <div className={style.errInfo}>
                <div>Список ошибок: <br/> {docInfoEl.message}</div>
                <div>Описание кейca: <br/> {docInfoEl.caseDescription}</div>
                <div>
                    <NavLink to={`/test/oldResult/${docInfoEl.id}`} id={1}>Старый результат расчета</NavLink>
                </div>
            </div>
        </div>
    )
}
export default DocErrors;