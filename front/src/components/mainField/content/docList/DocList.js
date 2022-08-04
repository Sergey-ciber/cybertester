import React, {useEffect} from "react";
import style from './DocList.module.css'
import DocHeader from "./docHeader/DocHeader";
import Doc from "./doc/Doc";
import axios from "axios";


const DocList = (props) => {

    useEffect(() => {
        props.getDocsThunkCreator()
    }, [])


    return (
        <div className={style.docList}>
            <DocHeader/>
            {
                props.docList.map(docEl =>
                    <Doc key={docEl.id} docEl={docEl} updateDoc={props.updateDoc}/>
                )
            }
        </div>
    )
}
export default DocList;