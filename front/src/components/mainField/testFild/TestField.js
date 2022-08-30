import React from "react";
import style from './TestField.module.css'
import TestFieldHeader from "../testFieldHeader/TestFieldHeader";
import Content from "../content/Content";
import {useSelector} from "react-redux";
import duc from '../../../assets/duc.gif'

const TestField = (props) => {

    const preloader = useSelector(state => state.calcTestData.preloader)

    //Прелоадер
    let preloaderEl = () => {
        return (
            <div className={style.preloader}>
                <img src={duc}/>
            </div>
        )
    }

    return (
        <div className={style.testField}>
            {preloader && preloaderEl()}
            <TestFieldHeader/>
            <Content/>
        </div>
    )
}
export default TestField;