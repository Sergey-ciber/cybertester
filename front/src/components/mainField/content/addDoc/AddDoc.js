import React from "react";
import style from './AddDoc.module.css'

const AddDoc = (props) => {debugger

    let addDocRef = React.createRef();

    let onAddDoc = () => {
        props.dispatch({type: 'ADD-DOC'})
    }

    let inputText = () => {
        props.dispatch({type: 'UPDATE-RECORD-UQ-TEXT', text: addDocRef.current.value})
    }

    return (
        <div className={style.addDoc}>
            <span>Добавить документ в чек лист</span>
            <div className={style.addForm}>
                <textarea ref={addDocRef} onChange={(inputText)}  value={props.recordUqText}> </textarea>
                <button onClick={onAddDoc}>ADD
                </button>
            </div>
        </div>
    )
}
export default AddDoc;