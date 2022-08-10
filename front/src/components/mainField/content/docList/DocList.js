import React, {useEffect} from "react";
import style from './DocList.module.css'
import DocHeader from "./docHeader/DocHeader";
import Doc from "./doc/Doc";
import axios from "axios";
import DocHeaderContainer from "./docHeader/DocHeaderContainer";


const DocList = (props) => {

    useEffect(() => {
        getDocsWithPaginationAndSort("id", "asc", 1, props.pageSize)
    }, [])

    let pagesCount = Math.ceil(props.totalDocsCount / props.pageSize)

    let pages = []

    for (let i = 1; i <= pagesCount; i++) {
        pages.push(i)
    }

    let getDocsWithPaginationAndSort = (field, sort, currentPage, pageSize) => {
        props.getDocsWithPaginationAndSort(field, sort, currentPage, pageSize)
    }

    let pagination = pages.map(el => {
        return <span onClick={() => {
            getDocsWithPaginationAndSort(props.field, props.sort, el, props.pageSize)
        }}
                     className={props.currentPage === el ? style.currentPage : style.page}>{el}</span>
    })


    return (
        <div className={style.docList}>
            <DocHeaderContainer/>
            {
                props.docList.map(docEl =>
                    <Doc key={docEl.id} docEl={docEl} updateDoc={props.updateDoc} deleteDoc={props.deleteDoc}
                    field={props.field} sort={props.sort} pageSize={props.pageSize} currentPage={props.currentPage}/>
                )
            }
            {pagination}
        </div>
    )
}
export default DocList;