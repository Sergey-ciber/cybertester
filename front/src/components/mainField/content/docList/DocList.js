import React from "react";
import style from './DocList.module.css'
import DocHeader from "./docHeader/DocHeader";
import Doc from "./doc/Doc";
import axios from "axios";

let docs = [
    {
        id: 9,
        recordUq: 9999999999,
        guidInput: "E40F5D1A19CAAA05E0530813E00A865E",
        doCheck: true,
        date: "2022-07-21",
        verified: false
    }
]

const DocList = (props) => {

    if (props.docList.length === 0) {

        axios.get("http://localhost:8090/calc").then(response => {
            props.setDocList(response.data)
        })
    }

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