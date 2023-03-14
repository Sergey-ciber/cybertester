import React from "react";
import style from './Content.module.css'
import {useParams} from "react-router-dom";
import AddDoc from "./addDoc/AddDoc";
import DocErrors from "./docErrors/DocErrors";
import DocList from "./docList/DocList";
import OldCalcResultList from "./oldCalcResultList/OldCalcResultList";
import {useSelector} from "react-redux";

const Content = (props) => {

    const oldCalcResultId = useSelector(state => state.oldCalcResultData.selectedOldCalcResultId)

    let param = useParams();
    let elErr = () => {
        if (param.id === "addDoc") {
            return <AddDoc />
        }
        else {
            return <DocErrors/>
        }
    }

    let elDocListOrOldResult = () => {
        if (param.chapter === "calcList") {
            return <DocList />
        }
        else {
            return <OldCalcResultList id={param.id} />
        }
    }

    return (
        <div className={style.content}>
            {elDocListOrOldResult()}
            {elErr()}
        </div>
    )
}
export default Content;