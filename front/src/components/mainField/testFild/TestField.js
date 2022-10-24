import React from "react";
import style from './TestField.module.css'
import TestFieldHeader from "../testFieldHeader/TestFieldHeader";
import Content from "../content/Content";
import {useSelector} from "react-redux";
import duc from '../../../assets/duc.gif'
import UpdateMessage from "./updateMessage/UpdateMessage";

const TestField = (props) => {

    const preloader = useSelector(state => state.calcTestData.preloader)
    const updateMessageSwitch = useSelector(state => state.calcTestData.updateMessageSwitch)

    // Прелоадер
    let preloaderEl = () => {
        return (
            <div className={style.preloader}>
                <img src={duc}/>
            </div>
        )
    }

    // Окно с сообщением об обновлении результата рассчета

    return (
        <div className={style.testField}>
            {preloader && preloaderEl()}
            {updateMessageSwitch && <UpdateMessage/>}
            <TestFieldHeader/>
            <Content/>
        </div>
    )
}
export default TestField;