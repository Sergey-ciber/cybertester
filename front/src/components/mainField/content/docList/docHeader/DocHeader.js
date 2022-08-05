import React, {useState} from "react";
import style from './DocHeader.module.css'

const DocHeader = (props) => {

    let sortBy = (field) => {

        // Сортировка документов
        if (props.fieldName === null) {
            props.setFieldName(field)
            props.getDocsWithSort(field, "asc")
            props.setSort(false)
        } else if (props.fieldName === field) {
            debugger
            if (props.sort === false) {
                props.getDocsWithSort(field, "desc")
                props.setSort(true)
            } else {
                props.getDocsWithSort(field, "asc")
                props.setSort(false)
            }
        } else if (props.fieldName !== field) {
            debugger
            props.getDocsWithSort(field, "asc")
            props.setSort(false)
            props.setFieldName(field)
        }
    }

    return (
        <div className={style.docHeader}>
            <h4 onClick={() => {
                sortBy("id")
            }}>ID</h4>
            <h4 onClick={() => {
                sortBy("recordUqRegistr")
            }}>RECORD UQ</h4>
            <h4 onClick={() => {
                sortBy("guidInput")
            }}>GUID INPUT</h4>
            <h4 onClick={() => {
                sortBy("checkDate")
            }}>Дата запуска</h4>
            <h4 onClick={() => {
                sortBy("calcResult")
            }}>Расчет</h4>
            <h4 onClick={() => {
                sortBy("doCheck")
            }}>Чек лист</h4>
        </div>
    )
}
export default DocHeader;