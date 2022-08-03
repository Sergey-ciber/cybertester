import React from "react";
import style from './DocHeader.module.css'

const DocHeader = (props) => {

    return (
        <div className={style.docHeader}>
            <h4>ID</h4>
            <h4>RECORD UQ</h4>
            <h4>GUID INPUT</h4>
            <h4>Дата запуска</h4>
            <h4>Расчет</h4>
            <h4>Чек лист</h4>
        </div>
    )
}
export default DocHeader;