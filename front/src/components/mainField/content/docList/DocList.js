import React, {useEffect} from "react";
import style from './DocList.module.css'
import DocHeader from "./docHeader/DocHeader";
import Doc from "./doc/Doc";
import axios from "axios";
import DocHeaderContainer from "./docHeader/DocHeaderContainer";


const DocList = (props) => {

    useEffect(() => {
        getDocsWithPaginationAndSort("id", "asc" , 1, 2)
        }, [])

    let pagesCount = props.totalDocsCount / props.pageSize

    let pages = []

    for(let i = 1; i <= pagesCount; i++){
        pages.push(i)
    }

    let getDocsWithPaginationAndSort = (field, sort, currentPage, pageSize) => {
        props.getDocsWithPaginationAndSort(field, sort, currentPage, pageSize)
    }

    let pagination = pages.map(el => {debugger
        return <span onClick={() => {getDocsWithPaginationAndSort("id", "asc", el , 2)}} className={props.currentPage === el ? style.currentPage : style.page}>{el}</span>
    })


    return (
        <div className={style.docList}>
            <DocHeaderContainer/>
            {
                props.docList.map(docEl =>
                    <Doc key={docEl.id} docEl={docEl} updateDoc={props.updateDoc} deleteDoc={props.deleteDoc}/>
                )
            }
            {pagination}
            {/*<div className={style.docsCount}>Всего документов: {props.docsCount}</div>*/}
        </div>
    )
}
export default DocList;