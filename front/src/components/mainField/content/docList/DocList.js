import React, {useEffect} from "react";
import style from './DocList.module.css'
import DocHeader from "./docHeader/DocHeader";
import Doc from "./doc/Doc";
import axios from "axios";
import DocHeaderContainer from "./docHeader/DocHeaderContainer";


const DocList = (props) => {

    useEffect(() => {
        props.getDocsThunkCreator()
    }, [])


    return (
        <div className={style.docList}>
            <DocHeaderContainer/>
            {
                props.docList.map(docEl =>
                    <Doc key={docEl.id} docEl={docEl} updateDoc={props.updateDoc}/>
                )
            }
            <div className={style.docsCount}>Всего документов: {props.docsCount}</div>
        </div>
    )
}
export default DocList;