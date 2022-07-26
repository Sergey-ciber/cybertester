import React from "react";
import style from './AddDoc.module.css'

const AddDoc = (props) => {

    let addDocRef = React.createRef();

    let onAddDoc = () => {
        props.addDoc(addDocRef.current.value)
        addDocRef.current.value = ""
    }

    let inputText = () => {
        console.log(addDocRef.current.value)
        props.inputText(addDocRef.current.value)
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