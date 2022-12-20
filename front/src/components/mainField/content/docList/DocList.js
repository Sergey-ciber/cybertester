import React, {useEffect, useState} from "react";
import style from './DocList.module.css'
import DocHeader from "./docHeader/DocHeader";
import Doc from "./doc/Doc";
import {useDispatch, useSelector} from "react-redux";
import {getDocsWithPaginationAndSort} from "../../../../redax/calcReducer";

const DocList = (props) => {

    const [countErrors, setCountErrors] = useState(4);
    const dispatch = useDispatch()
    const totalDocsCount = useSelector(state => state.calcTestData.totalDocsCount)
    const fieldName = useSelector(state => state.calcTestData.fieldName)
    const sort = useSelector(state => state.calcTestData.sort)
    const pageSize = useSelector(state => state.calcTestData.pageSize)
    const currentPage = useSelector(state => state.calcTestData.currentPage)
    const docList = useSelector(state => state.calcTestData.docList)

    useEffect(() => {
        dispatch(getDocsWithPaginationAndSort("id", "asc", 1, pageSize))
    }, [])

    let pagesCount = Math.ceil(totalDocsCount / pageSize)

    let pages = []

    for (let i = 1; i <= pagesCount; i++) {
        pages.push(i)
    }

    let getDocsWithPagAndSort = (field, sort, currentPage, pageSize) => {
        dispatch(getDocsWithPaginationAndSort(field, sort, currentPage, pageSize))
    }

    let pagination = pages.map(el => {
        return <span key={el} onClick={() => {
            dispatch(getDocsWithPaginationAndSort(fieldName, sort, el, pageSize))
        }}
                     className={currentPage === el ? style.currentPage : style.page}>{el}</span>
    })


    return (
        <div className={style.docList}>
            <DocHeader/>
            {
                docList.map(docEl =>
                    <Doc key={docEl.id} docEl={docEl}/>
                )
            }
            {pagination}
            <div className={style.docInfo}>
                {/*<div className={style.countErrors}>Количество ошибок: {countErrors}</div>*/}
                <div className={style.totalDocsCount}>{`Общее количество записей: ${totalDocsCount}`}</div>
            </div>

        </div>
    )
}
export default DocList;