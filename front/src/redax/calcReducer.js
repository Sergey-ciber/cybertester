import axios from "axios";

const UPDATE_RECORD_UQ_TEXT = 'UPDATE-RECORD-UQ-TEXT'
const ADD_DOC = 'ADD-DOC'
const SET_DOC_LIST = 'SET-DOC-LIST'

let initialState = {
    recordUqText: "",
    docList: [
        // {
        //     id: 0,
        //     recordUq: 0,
        //     guidInput: "",
        //     doCheck: true,
        //     date: "",
        //     verified: true
        // }
    ]
}

const calcReducer = (state = initialState, action) => {

    switch (action.type) {
        case SET_DOC_LIST: {
            return {
                ...state,
                docList: action.docList
            }
        }
        case UPDATE_RECORD_UQ_TEXT: {
            return {...state, recordUqText: action.text}
        }
        case ADD_DOC: {
            let newDoc = {
                id: 5,
                recordUqRegistr: Number(state.recordUqText),
                guidInput: "E40F5D1A19CAAA05E0530813E00A865E",
                doCheck: 1,
                date: "2022-07-21",
                calcResult: false
            }
            return {
                ...state,
                recordUqText: "",
                docList: [newDoc, ...state.docList]
            }
        }
        default:
            return state
    }
}

export const updateRecordUqText = (text) => {
    return {type: UPDATE_RECORD_UQ_TEXT, text}
}

export const addDoc = () => {
    return {type: ADD_DOC}
}

export const setDocList = (docList) => {
    return {type: SET_DOC_LIST, docList}
}

export const getDocsThunkCreator = () => {
    return (dispatch) => {
        axios.get("http://localhost:8090/calc").then(response => {
            dispatch(setDocList(response.data))
        })
    }
}

export const addDocsToDocsList = (recordUqText) => {

    return (dispatch) => {
        axios.get(`http://localhost:8090/calc/addDocs?recordUqDocs=${recordUqText}`).then(response => {
            dispatch(setDocList(response.data))
        })
    }
}

export const updateDoc = (doc) => {

    return (dispatch) => {
        axios.post(`http://localhost:8090/calc/update/${doc.id}`, doc).then(response => {
            dispatch(setDocList(response.data))
        })
    }
}

export const checkCalculation = () => {

    return (dispatch) => {
        axios.get("http://localhost:8090/calc/checkDocs").then(response => {
            dispatch(setDocList(response.data))
        })
    }
}

export default calcReducer;