import axios from "axios";

const UPDATE_RECORD_UQ_TEXT = 'UPDATE-RECORD-UQ-TEXT'
const ADD_DOC = 'ADD-DOC'
const SET_DOC_LIST = 'SET-DOC-LIST'
const SET_SORT = 'SET-SORT'
const SET_FIELD_NAME = 'SET-FIELD-NAME'

let initialState = {
    recordUqText: "",
    fieldName: null,
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

        case SET_FIELD_NAME: {
            return {
                ...state,
                fieldName:action.fieldName
            }
        }
        case SET_SORT: {
            return {
                ...state,
               sort:action.sort
            }
        }
        case SET_DOC_LIST: {
            return {
                ...state,
                docList: action.docList,
                docsCount: action.docsCount
            }
        }
        case UPDATE_RECORD_UQ_TEXT: {
            return {
                ...state, recordUqText: action.text
            }
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
export const setSort = (sort) => {
    return {type: SET_SORT, sort}
}
export const setFieldName = (fieldName) => {
    return {type: SET_FIELD_NAME, fieldName}
}

export const setDocList = (docList, docsCount) => {
    return {type: SET_DOC_LIST, docList, docsCount}
}

export const getDocsWithSort = (field, sort) => {
    return (dispatch) => {
        axios.get(`http://localhost:8090/calc/sort?field=${field}&sort=${sort}`).then(response => {
            dispatch(setDocList(response.data.docList, response.data.docsCount))
        })
    }
}



export const getDocsThunkCreator = () => {
    return (dispatch) => {
        axios.get("http://localhost:8090/calc").then(response => {
            dispatch(setDocList(response.data.docList, response.data.docsCount))
        })
    }
}

export const addDocsToDocsList = (recordUqText) => {

    return (dispatch) => {
        axios.get(`http://localhost:8090/calc/addDocs?recordUqDocs=${recordUqText}`).then(response => {
            dispatch(setDocList(response.data.docList, response.data.docsCount))
        })
    }
}

export const updateDoc = (doc) => {

    return (dispatch) => {
        axios.post(`http://localhost:8090/calc/update/${doc.id}`, doc).then(response => {
            dispatch(setDocList(response.data.docList, response.data.docsCount))
        })
    }
}

export const checkCalculation = () => {

    return (dispatch) => {
        axios.get("http://localhost:8090/calc/checkDocs").then(response => {
            dispatch(setDocList(response.data.docList, response.data.docsCount))
        })
    }
}

export default calcReducer;