import React from "react";
import style from './DocList.module.css'
import DocHeader from "./docHeader/DocHeader";
import Doc from "./doc/Doc";

const DocList = (props) => {

    return (
        <div className={style.docList}>
            <DocHeader/>
            {
                props.calc.docList.map(doc =>
                    <Doc id={doc.id} recordUq={doc.recordUq} guidInput={doc.guidInput} doCheck={doc.doCheck}
                         date={doc.date} verified={doc.verified}/>
                )
            }
        </div>
    )
}
export default DocList;