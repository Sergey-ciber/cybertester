import React from "react";
import style from './Doc.module.css'
import {NavLink} from "react-router-dom";
import greenCheckMark from '../../../../../assets/greenСheckMark.png'
import redCheckMark from '../../../../../assets/redCheckMark.png'
import trash from '../../../../../assets/trash.png'

const Doc = (props) => {

    let updateDoc = () => {
        let newDoc = {
            id: props.docEl.id,
            guidInput: props.docEl.guidInput,
            doCheck: (props.docEl.doCheck === 1) ? 0 :1,
            recordUqRegistr: props.docEl.recordUqRegistr,
            calcResult: props.docEl.calcResult,
            message: props.docEl.message,
            checkDate: props.docEl.checkDate
        }
        props.updateDoc(newDoc, props.field, props.sort, props.pageSize, props.currentPage)
    }

    let deleteDoc = (id) => {
        props.deleteDoc(id, props.field, props.sort, props.pageSize, props.currentPage)
    }

    let checkbox = () => {
        if (props.docEl.doCheck === 1) {
           return <input type="checkbox" id="doCheck" onChange={() => updateDoc()} name="doCheck" defaultChecked={"checked"}/>
        } else{
            return <input type="checkbox" onChange={() => updateDoc()}  id="doCheck" name="doCheck" />
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
                {checkMarc()}
            </NavLink>
            <div className={style.checkBox}>
                {checkbox()}
            </div>
            <div onClick={() => {deleteDoc(props.docEl.id)}} className={style.trash}>
                <img src={trash}/>
            </div>
        </div>
    )
}
export default Doc;