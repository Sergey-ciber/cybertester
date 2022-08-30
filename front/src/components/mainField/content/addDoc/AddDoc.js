import React, {useState} from "react";
import style from './AddDoc.module.css'
import TextField from "@mui/material/TextField";
import {addDocsToDocsList, setTextFieldError} from "../../../../redax/calcReducer";
import {useDispatch, useSelector} from "react-redux";


const AddDoc = (props) => {

    const dispatch = useDispatch()
    const textFieldError = useSelector(state => state.calcTestData.textFieldError)
    const fieldName = useSelector(state => state.calcTestData.fieldName)
    const sort = useSelector(state => state.calcTestData.sort)
    const pageSize = useSelector(state => state.calcTestData.pageSize)
    const currentPage  = useSelector(state => state.calcTestData.currentPage)

    const [recordUqText, setRecordUqText] = useState()

    let addDocRef = React.createRef();

    let onAddDoc = () => {
        if (textFieldError !== true && recordUqText !== undefined) {
            dispatch(addDocsToDocsList(recordUqText, fieldName, sort, pageSize, currentPage))
            setRecordUqText("")
        } else {
            setRecordUqText("")
        dispatch(setTextFieldError(false))}
    }

    let updateRecordUqText = (e) => {debugger
        let re = /[a-zA-Z" "а-яА-Я.!@#$%^&*(){}]/
        setRecordUqText(e.target.value);
        dispatch(setTextFieldError(false))
        for (let i = 0; i < e.target.value.length; i++) {
            if (re.test(e.target.value[i])) {
                dispatch(setTextFieldError(true))
            }
        }
    }

    let textField = () => {
        if (textFieldError) {
            return <TextField ref={addDocRef} onChange={(updateRecordUqText)} value={recordUqText}
                              className={style.textField} id="outlined-basic" label="Не корректный символ"
                              variant="outlined"
                              error/>
        } else {
            return <TextField ref={addDocRef} onChange={(updateRecordUqText)} value={recordUqText}
                              className={style.textField} id="outlined-basic" label="Цифры через запятую"
                              variant="outlined" required/>
        }
    }

    return (
        <div className={style.addDoc}>
            <span>Добавить документ в чек лист</span>
            <div className={style.addForm}>
                {
                    textField()
                }
                <div>
                    <button onClick={onAddDoc}>Добавить</button>
                </div>
            </div>
        </div>
    )
}
export default AddDoc;