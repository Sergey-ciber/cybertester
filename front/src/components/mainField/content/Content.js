import React from "react";
import style from './Content.module.css'
import {useParams} from "react-router-dom";
import AddDoc from "./addDoc/AddDoc";
import DocErrors from "./docErrors/DocErrors";
import DocList from "./docList/DocList";

const Content = (props) => {debugger

    let param = useParams();
    let el = () => {
        if (param.id === "addDoc") {
            return <AddDoc />
        }
        else {
            return <DocErrors/>
        }
    }

    return (
        <div className={style.content}>
            <DocList />
            {el()}
        </div>
    )
}
export default Content;