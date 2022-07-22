import React from "react";
import style from './SideBar.module.css'
import Heading from "./heading/Heading";
import TestList from "./testList/TestList";

const SideBar = () => {

    return(
        <div className={style.sideBar}>
        <Heading/>
        <TestList/>
        </div>
    )
}
export default SideBar;