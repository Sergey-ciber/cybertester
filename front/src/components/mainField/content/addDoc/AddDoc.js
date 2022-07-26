import React from "react";
import style from './AddDoc.module.css'
import {addDocActionCreator, updateRecordUqTextActionCreator} from "../../../../redax/calcReducer";


const AddDoc = (props) => {

    let addDocRef = React.createRef();

    let onAddDoc = () => {
        props.dispatch(
            addDocActionCreator()
        )
    }

    let updateRecordUqText = () => {
        props.dispatch(
            updateRecordUqTextActionCreator(addDocRef.current.value)
        )
    }

    return (
        <div className={style.addDoc}>
            <span>Добавить документ в чек лист</span>
            <div className={style.addForm}>
                <textarea ref={addDocRef} onChange={(updateRecordUqText)} value={props.recordUqText}> </textarea>
                <button onClick={onAddDoc}>ADD
                </button>
            </div>
        </div>
    )
}
export default AddDoc;