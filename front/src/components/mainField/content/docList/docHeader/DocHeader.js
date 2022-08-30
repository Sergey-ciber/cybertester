import React, {useState} from "react";
import style from './DocHeader.module.css'
import {getDocsWithPaginationAndSort, setFieldName, setSort} from "../../../../../redax/calcReducer";
import {useDispatch, useSelector} from "react-redux";

const DocHeader = (props) => {

    const dispatch = useDispatch()
    const fieldName = useSelector(state => state.calcTestData.fieldName)
    const pageSize = useSelector(state => state.calcTestData.pageSize)
    const currentPage  = useSelector(state => state.calcTestData.currentPage)
    const sort = useSelector(state => state.calcTestData.sort)

    let sortBy = (SortField) => {

        //sort - больше / меньше
        // fieldName - название столбца id

        // Сортировка документов
        if (fieldName === null) {
            dispatch(setFieldName(SortField))
            dispatch(getDocsWithPaginationAndSort(SortField, "asc", currentPage, pageSize))
            dispatch(setSort(false))
        } else if (fieldName === SortField) {
            if (sort === false) {
                dispatch(getDocsWithPaginationAndSort(SortField, "desc", currentPage, pageSize))
                dispatch(setSort(true))
            } else {
                dispatch(getDocsWithPaginationAndSort(SortField, "asc", currentPage, pageSize))
                dispatch(setSort(false))
            }
        } else if (fieldName !== SortField) {
            dispatch(getDocsWithPaginationAndSort(SortField, "asc",currentPage, pageSize))
            dispatch(setSort(false))
            dispatch(setFieldName(SortField))
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