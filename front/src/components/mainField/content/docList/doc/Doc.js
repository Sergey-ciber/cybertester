import React from "react";
import style from './Doc.module.css'
import {NavLink} from "react-router-dom";

const Doc = (props) => {debugger

    let checkbox = () => {
        if (props.docEl.doCheck === true) {
           return <input type="checkbox" id="doCheck" name="doCheck" defaultChecked={"checked"}/>
        } else{
            return <input type="checkbox" id="doCheck" name="doCheck" />
        }
    }

    let color = () => {
        if (props.docEl.verified === true) {return style.docLinkBlack} else {
            return style.docLinkRed
        }
    }

    return (
        <div key={props.docEl.id} className={style.doc}>
            <NavLink className={color()} to={`/test/calc/${props.docEl.id}`}>
                <h5>{props.docEl.id}</h5>
                <h5>{props.docEl.recordUq}</h5>
                <h5>{props.docEl.guidInput}</h5>
                <h5>{props.docEl.date}</h5>
            </NavLink>
            <div className={style.checkBox}>
                {checkbox()}
            </div>
        </div>
    )
}
export default Doc;