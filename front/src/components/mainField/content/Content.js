import React from "react";
import style from './Content.module.css'
import DocList from "./docList/DocList";
import DocErrors from "./docErrors/DocErrors";
import {useParams} from "react-router-dom";
import AddDoc from "./addDoc/AddDoc";

const Content = (props) => {

    let param = useParams();
    let el = () => {
        if (param.id === "addDoc") {
            return <AddDoc dispatch={props.dispatch} recordUqText={props.calc.recordUqText}/>
        } else {
            return <DocErrors/>
        }
    }

    return (
        <div className={style.content}>
            <DocList calc={props.calc}/>
            {el()}
        </div>
    )
}
export default Content;