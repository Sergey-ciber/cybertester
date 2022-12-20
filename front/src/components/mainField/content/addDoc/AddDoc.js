import React, {useState} from "react";
import style from './AddDoc.module.css'
import TextField from "@mui/material/TextField";
import {
    addDocsToDocsList,
    setTextFieldError,
    updateCaseDescription,
    updateRecordUqText
} from "../../../../redax/calcReducer";
import {useDispatch, useSelector} from "react-redux";


const AddDoc = (props) => {

    const dispatch = useDispatch()
    const textFieldError = useSelector(state => state.calcTestData.textFieldError)
    const fieldName = useSelector(state => state.calcTestData.fieldName)
    const sort = useSelector(state => state.calcTestData.sort)
    const pageSize = useSelector(state => state.calcTestData.pageSize)
    const currentPage = useSelector(state => state.calcTestData.currentPage)
    const caseDescription = useSelector(state => state.calcTestData.caseDescription)
    const recordUqText = useSelector(state => state.calcTestData.recordUqText)

    //Use state

    let addDocRef = React.createRef();

    let onAddDoc = () => {
        if (textFieldError !== true && recordUqText !== undefined) {
            dispatch(addDocsToDocsList(recordUqText, fieldName, sort, pageSize, currentPage))
            dispatch(updateRecordUqText(""))
            dispatch(updateCaseDescription(""))
        } else {
            dispatch(updateRecordUqText(""))
            dispatch(updateCaseDescription(""))
            dispatch(setTextFieldError(false))
        }
    }

    let onUpdateCaseDescription = (e) => {
        dispatch(updateCaseDescription(e.target.value))
    }

    let onUpdateRecordUqText = (e) => {
        let re = /[a-zA-Z" "а-яА-Я.!@#$%^&*(){}]/
        dispatch(updateRecordUqText(e.target.value))
        dispatch(setTextFieldError(false))
        for (let i = 0; i < e.target.value.length; i++) {
            if (re.test(e.target.value[i])) {
                dispatch(setTextFieldError(true))
            }
        }
    }

    let textField = () => {
        if (textFieldError) {
            return <TextField ref={addDocRef} onChange={(onUpdateRecordUqText)} value={recordUqText}
                              className={style.textField} id="outlined-basic" label="Не корректный символ"
                              variant="outlined"
                              error/>
        } else {
            return <TextField ref={addDocRef} onChange={(onUpdateRecordUqText)} value={recordUqText}
                              className={style.textField} id="outlined-basic" label="Цифры через запятую"
                              variant="outlined" required/>
        }
    }

    return (
        <div className={style.addDoc}>
            <h3>Добавить документ в чек лист:</h3>
            <div className={style.addForm}>
                <div className={style.addRecordUq}>
                    <span>RecordUq документа:</span>
                    {
                        textField()
                    }
                </div>
                <div>
                    <span>Описание:</span>
                    <div className={style.desciptionField}>
                        <TextField ref={addDocRef} onChange={(onUpdateCaseDescription)} value={caseDescription}
                                   className={style.textField} id="outlined-basic" label="Описание кейса"
                                   variant="outlined" required/>
                    </div>
                </div>
                <div>
                    <button onClick={onAddDoc}>Добавить</button>
                </div>
            </div>
        </div>
    )
}
export default AddDoc;