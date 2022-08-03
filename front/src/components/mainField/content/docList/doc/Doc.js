import React from "react";
import style from './Doc.module.css'
import {NavLink} from "react-router-dom";
import greenCheckMark from '../../../../../assets/greenСheckMark.png'
import redCheckMark from '../../../../../assets/redCheckMark.png'

const Doc = (props) => {

    let checkbox = () => {
        if (props.docEl.doCheck === 1) {
           return <input type="checkbox" id="doCheck" name="doCheck" defaultChecked={"checked"}/>
        } else{
            return <input type="checkbox" id="doCheck" name="doCheck" />
        }
    }

    let checkMarc = () => {
        if (props.docEl.calcResult === 1) {return <img src={greenCheckMark}/>} else {
            return <img src={redCheckMark}/>
        }
    }

    return (
        <div key={props.key} className={style.doc}>
            <NavLink className={style.docLink} to={`/test/calc/${props.docEl.id}`}>
                <h5>{props.docEl.id}</h5>
                <h5>{props.docEl.recordUqRegistr}</h5>
                <h5>{props.docEl.guidInput}</h5>
                <h5>{props.docEl.checkDate}</h5>
                <h5>{props.docEl.date}</h5>
                {checkMarc()}
            </NavLink>
            <div className={style.checkBox}>
                {checkbox()}
            </div>
        </div>
    )
}
export default Doc;