import React, {useEffect} from "react";
import style from './DocList.module.css'
import DocHeader from "./docHeader/DocHeader";
import Doc from "./doc/Doc";
import axios from "axios";


const DocList = (props) => {

    useEffect(() => {
        props.getDocsThunkCreator()
    }, [])
    console.log("useEffect")


    return (
        <div className={style.docList}>
            <DocHeader/>
            {
                props.docList.map(docEl =>
                    <Doc key={docEl.id} docEl={docEl}/>
                )
            }
        </div>
    )
}
export default DocList;