import React from "react";
import style from './AddDoc.module.css'
import {addDocActionCreator, updateRecordUqTextActionCreator} from "../../../../redax/calcReducer";


const AddDoc = (props) => {debugger

    let addDocRef = React.createRef();

    let onAddDoc = () => {
        props.onAddDoc()
    }

    let updateRecordUqText = () => {
        props.updateRecordUqText(addDocRef.current.value);
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