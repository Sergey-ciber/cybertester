import React, {useState} from "react";
import style from './DocHeader.module.css'
import {getDocsWithPaginationAndSort} from "../../../../../redax/calcReducer";

const DocHeader = (props) => {

    let sortBy = (field) => {

        //sort - больше / меньше
        // fieldName - название столбца id

        // Сортировка документов
        if (props.field === null) {
            props.setFieldName(field)
            props.getDocsWithPaginationAndSort(field, "asc", props.currentPage, props.pageSize)
            props.setSort(false)
        } else if (props.field === field) {
            if (props.sort === false) {
                props.getDocsWithPaginationAndSort(field, "desc", props.currentPage, props.pageSize)
                props.setSort(true)
            } else {
                props.getDocsWithPaginationAndSort(field, "asc", props.currentPage, props.pageSize)
                props.setSort(false)
            }
        } else if (props.field !== field) {
            props.getDocsWithPaginationAndSort(field, "asc", props.currentPage, props.pageSize)
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