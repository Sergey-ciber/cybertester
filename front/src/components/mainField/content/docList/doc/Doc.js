import React from "react";
import style from './Doc.module.css'
import {NavLink} from "react-router-dom";

const Doc = (props) => {

    return (
        <NavLink className={style.doc} to={`/calcTest/${props.id}`}>
            <h5>{props.id}</h5>
            <h5>{props.recordUq}</h5>
            <h5>{props.guidInput}</h5>
            <input type="checkbox" id="doCheck" name="doCheck" value={true}/>
            <h5>{props.date}</h5>
        </NavLink>
    )
}
export default Doc;