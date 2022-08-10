import axios from "axios";

const UPDATE_RECORD_UQ_TEXT = 'UPDATE-RECORD-UQ-TEXT'
const ADD_DOC = 'ADD-DOC'
const SET_DOC_LIST = 'SET-DOC-LIST'
const SET_SORT = 'SET-SORT'
const SET_FIELD_NAME = 'SET-FIELD-NAME'
const SET_CURRENT_PAGE = 'SET-CURRENT-PAGE'

let initialState = {
    recordUqText: "",
    fieldName: "id",
    totalDocsCount: 20,
    pageSize: 30,
    currentPage: 1,
    sort: "asc",
    docList: []
}

const calcReducer = (state = initialState, action) => {

    switch (action.type) {

        case SET_CURRENT_PAGE: {
            return {
                ...state,
                currentPage: action.currentPage
            }
        }
        case SET_FIELD_NAME: {
            return {
                ...state,
                fieldName: action.fieldName
            }
        }
        case SET_SORT: {
            return {
                ...state,
                sort: action.sort
            }
        }
        case SET_DOC_LIST: {
            return {
                ...state,
                docList: action.docList,
                totalDocsCount: action.docsCount
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

export const setCurrentPage = (currentPage) => {
    return {type: SET_CURRENT_PAGE, currentPage}
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

export const addDocsToDocsList = (recordUqText, field, sort, pageSize, offset) => {


    return (dispatch) => {
        axios.get(`http://localhost:8090/calc/addDocs?recordUqDocs=${recordUqText}&field=${field}&sort=${sort}&pageSize=${pageSize}&offset=${offset - 1}`)
            .then(response => {
            dispatch(setDocList(response.data.docList, response.data.docsCount))
        })
    }
}

export const updateDoc = (doc, field, sort, pageSize, offset) => {

    return (dispatch) => {
        axios.post(`http://localhost:8090/calc/update/${doc.id}?field=${field}&sort=${sort}&pageSize=${pageSize}&offset=${offset - 1}`, doc)
            .then(response => {
            dispatch(setDocList(response.data.docList, response.data.docsCount))
        })
    }
}

export const checkCalculation = (field, sort, pageSize, offset) => {

    return (dispatch) => {
        axios.get(`http://localhost:8090/calc/checkDocs?field=${field}&sort=${sort}&pageSize=${pageSize}&offset=${offset - 1}`)
            .then(response => {
            dispatch(setDocList(response.data.docList, response.data.docsCount))
        })
    }
}

export const deleteDoc = (docId, field, sort, pageSize, offset) => {
    return (dispatch) => {
        axios.delete(`http://localhost:8090/calc/delete/${docId}?field=${field}&sort=${sort}&pageSize=${pageSize}&offset=${offset - 1}`)
            .then(response => {
                if(response.data.h === "OK") {dispatch(setDocList(response.data.docList, response.data.docsCount))}
                    else{dispatch(setCurrentPage(offset -1))
                    axios.get(`http://localhost:8090/calc/pagination/sort?field=${field}&sort=${sort}&pageSize=${pageSize}&offset=${offset - 2}`)
                        .then(response => {
                            dispatch(setDocList(response.data.docList, response.data.docsCount))
                        })}
            })
    }
}

export const getDocsWithPaginationAndSort = (field, sort, offset, pageSize) => {

    return (dispatch) => {
        axios.get(`http://localhost:8090/calc/pagination/sort?field=${field}&sort=${sort}&pageSize=${pageSize}&offset=${offset - 1}`)
            .then(response => {
                dispatch(setCurrentPage(offset))
                dispatch(setDocList(response.data.docList, response.data.docsCount))
            })
    }
}

export default calcReducer;