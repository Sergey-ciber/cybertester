import React from "react";
import style from './Content.module.css'
import DocList from "./docList/DocList";
import DocErrors from "./docErrors/DocErrors";

const Content = () => {

    return (
        <div className={style.content}>
            <DocList/>
            <DocErrors/>
        </div>
    )
}
export default Content;