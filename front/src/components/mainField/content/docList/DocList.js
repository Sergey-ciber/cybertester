import React from "react";
import style from './DocList.module.css'
import DocHeader from "./docHeader/DocHeader";
import Doc from "./doc/Doc";

const DocList = (props) => {

    return (
        <div className={style.docList}>
            <DocHeader/>
            {
                props.docList.map(docEl =>
                    <Doc docEl={docEl}/>
                )
            }
        </div>
    )
}
export default DocList;