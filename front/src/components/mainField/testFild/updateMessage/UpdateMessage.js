import React from 'react'
import style from './UpdateMessage.module.css'
import {useDispatch} from "react-redux";
import {updateMessageSwitch} from "../../../../redax/calcReducer";

const UpdateMessage = () => {

    const dispatch = useDispatch()

    let updateMessageOff = () => {
        dispatch(updateMessageSwitch(false))
    }

    return(
        <div className={style.updateMessage}>
            <span>Результат расчета обновлен</span>
            <button onClick={updateMessageOff}>ОК</button>
        </div>
    )
}
export default UpdateMessage