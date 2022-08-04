import React, {useState} from "react";
import style from './AddDoc.module.css'


const AddDoc = (props) => {

    const [recordUqText, setRecordUqText] = useState()

    let addDocRef = React.createRef();

    let onAddDoc = () => {
        props.addDocsToDocsList(recordUqText)
        setRecordUqText("")
    }

    let updateRecordUqText = (e) => {debugger
        setRecordUqText(e.target.value);
    }

    return (
        <div className={style.addDoc}>
            <span>Добавить документ в чек лист</span>
            <div className={style.addForm}>
                <textarea ref={addDocRef} onChange={(updateRecordUqText)} value={recordUqText}> </textarea>
                <button onClick={onAddDoc}>ADD
                </button>
            </div>
        </div>
    )
}
export default AddDoc;