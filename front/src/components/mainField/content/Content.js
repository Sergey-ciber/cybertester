import React from "react";
import style from './Content.module.css'
import DocList from "./docList/DocList";
import DocErrors from "./docErrors/DocErrors";
import {useParams} from "react-router-dom";
import AddDocContainer from "./addDoc/AddDocContainer";
import DocListContainer from "./docList/DocListContainer";
import DocErrorsContainer from "./docErrors/DocErrorsContainer";

const Content = (props) => {

    let param = useParams();
    let el = () => {
        if (param.id === "addDoc") {
            return <AddDocContainer />
        } else {
            return <DocErrorsContainer/>
        }
    }

    return (
        <div className={style.content}>
            <DocListContainer />
            {el()}
        </div>
    )
}
export default Content;