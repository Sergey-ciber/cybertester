import React from "react";
import style from './Doc.module.css'
import {NavLink} from "react-router-dom";

const Doc = (props) => {

    let checkbox = () => {
        if (props.doCheck === true) {
           return <input type="checkbox" id="doCheck" name="doCheck" defaultChecked={"checked"}/>
        } else{
            return <input type="checkbox" id="doCheck" name="doCheck" />
        }
    }

    let color = () => {
        if (props.verified === true) {return style.docLinkBlack} else {
            return style.docLinkRed
        }
    }

    return (
        <div className={style.doc}>
            <NavLink className={color()} to={`/test/calc/${props.id}`}>
                <h5>{props.id}</h5>
                <h5>{props.recordUq}</h5>
                <h5>{props.guidInput}</h5>
                <h5>{props.date}</h5>
            </NavLink>
            <div className={style.checkBox}>
                {checkbox()}
            </div>
        </div>
    )
}
export default Doc;