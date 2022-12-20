import axios from "axios";

const UPDATE_RECORD_UQ_TEXT = 'UPDATE-RECORD-UQ-TEXT'
const UPDATE_CASE_DESCRIPTION = 'UPDATE-CASE-DESCRIPTION'
// const ADD_DOC = 'ADD-DOC'
const SET_DOC_LIST = 'SET-DOC-LIST'
const SET_SORT = 'SET-SORT'
const SET_FIELD_NAME = 'SET-FIELD-NAME'
const SET_CURRENT_PAGE = 'SET-CURRENT-PAGE'
const SET_TEXT_FIELD_ERROR = 'SET-TEXT-FIELD-ERROR'
const SET_PRELOADER = 'SET-PRELOADER'
const UPDATE_CALC_RESULT = 'UPDATE-CALC-RESULT'
const UPDATE_MESSAGE_SWITCH = 'UPDATE-MESSAGE-SWITCH'

let initialState = {
    caseDescription: "",
    updateMessageSwitch: false,
    preloader: false,
    textFieldError: false,
    recordUqText: "",
    fieldName: "id",
    totalDocsCount: 20,
    pageSize: 25,
    currentPage: 1,
    sort: "asc",
    docList: []
}

const calcReducer = (state = initialState, action) => {

    switch (action.type) {
        case UPDATE_MESSAGE_SWITCH: {
            return {
                ...state,
                updateMessageSwitch: action.updateMessageSwitch
            }
        }
        case SET_PRELOADER: {
            return {
                ...state,
                preloader: action.preloader
            }
        }
        case SET_TEXT_FIELD_ERROR: {
            return {
                ...state,
                textFieldError: action.textFieldError
            }
        }
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
        case UPDATE_CASE_DESCRIPTION: {
            return {
                ...state, caseDescription: action.caseDescription
            }
        }
        // case ADD_DOC: {
        //     let newDoc = {
        //         id: 5,
        //         recordUqRegistr: Number(state.recordUqText),
        //         guidInput: "E40F5D1A19CAAA05E0530813E00A865E",
        //         doCheck: 1,
        //         date: "2022-07-21",
        //         calcResult: false
        //     }
        //     return {
        //         ...state,
        //         recordUqText: "",
        //         docList: [newDoc, ...state.docList]
        //     }
        // }
        default:
            return state
    }
}

export const updateCaseDescription = (caseDescription) => {
    return {type: UPDATE_CASE_DESCRIPTION, caseDescription}
}

export const updateMessageSwitch = (updateMessageSwitch) => {
    return {type: UPDATE_MESSAGE_SWITCH, updateMessageSwitch}
}

export const setPreloader = (preloader) => {
    return {type: SET_PRELOADER, preloader}
}

export const setTextFieldError = (textFieldError) => {
    return {type: SET_TEXT_FIELD_ERROR, textFieldError}
}

export const updateRecordUqText = (text) => {
    return {type: UPDATE_RECORD_UQ_TEXT, text}
}

// export const addDoc = () => {
//     return {type: ADD_DOC}
// }
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

export const updateCalcResult = (recordUQ) => {
    return (dispatch) => {
        dispatch(setPreloader(true))
        axios.get(`http://localhost:8090/calc/updateCalcResult?recordUQ=${recordUQ}`).then(response => {
            if (response.data === 'OK') {
                dispatch(updateMessageSwitch(true))
                dispatch(setPreloader(false))
            }
        })
    }
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

// export const addDocsToDocsList = (recordUqText, field, sort, pageSize, offset) => {
//
//     return (dispatch, getState) => {
//         console.log(getState().caseDescription)
//         dispatch(setPreloader(true))
//         axios.get(`http://localhost:8090/calc/addDocs?recordUqDocs=${recordUqText}&caseDescription=${"this.caseDescription"}&field=${field}&sort=${sort}&pageSize=${pageSize}&offset=${offset - 1}`)
//             .then(response => {
//                 dispatch(setDocList(response.data.docList, response.data.docsCount))
//                 dispatch(setPreloader(false))
//             })
//     }
// }

export const addDocsToDocsList = (recordUqText, field, sort, pageSize, offset) => (dispatch, getState) => {
    let caseDescription = getState().calcTestData.caseDescription
    let recordUqText = getState().calcTestData.recordUqText
    console.log(caseDescription)
    console.log(recordUqText)
    dispatch(setPreloader(true))
    axios.get(`http://localhost:8090/calc/addDocs?recordUqDocs=${recordUqText}&caseDescription=${caseDescription}&field=${field}&sort=${sort}&pageSize=${pageSize}&offset=${offset - 1}`)
        .then(response => {
            dispatch(setDocList(response.data.docList, response.data.docsCount))
            dispatch(setPreloader(false))
        })
}

export const updateDoc = (doc, field, sort, pageSize, offset) => {

    return (dispatch) => {
        dispatch(setPreloader(true))
        axios.post(`http://localhost:8090/calc/update/${doc.id}?field=${field}&sort=${sort}&pageSize=${pageSize}&offset=${offset - 1}`, doc)
            .then(response => {
                dispatch(setDocList(response.data.docList, response.data.docsCount))
                dispatch(setPreloader(false))
            })
    }
}

export const checkCalculation = (field, sort, pageSize, offset) => {

    return (dispatch) => {
        dispatch(setPreloader(true))
        axios.get(`http://localhost:8090/calc/checkDocs?field=${field}&sort=${sort}&pageSize=${pageSize}&offset=${offset - 1}`)
            .then(response => {
                dispatch(setDocList(response.data.docList, response.data.docsCount))
                dispatch(setPreloader(false))
            })
    }
}

export const deleteDoc = (docId, field, sort, pageSize, offset) => {
    return (dispatch) => {
        dispatch(setPreloader(true))
        axios.delete(`http://localhost:8090/calc/delete/${docId}?field=${field}&sort=${sort}&pageSize=${pageSize}&offset=${offset - 1}`)
            .then(response => {
                if (response.data.h === "OK") {
                    dispatch(setDocList(response.data.docList, response.data.docsCount))
                    dispatch(setPreloader(false))
                } else {
                    dispatch(setCurrentPage(offset - 1))
                    axios.get(`http://localhost:8090/calc/pagination/sort?field=${field}&sort=${sort}&pageSize=${pageSize}&offset=${offset - 2}`)
                        .then(response => {
                            dispatch(setDocList(response.data.docList, response.data.docsCount))
                            dispatch(setPreloader(false))
                        })
                }
            })
    }
}

export const getDocsWithPaginationAndSort = (field, sort, offset, pageSize) => {

    return (dispatch) => {
        dispatch(setPreloader(true))
        axios.get(`http://localhost:8090/calc/pagination/sort?field=${field}&sort=${sort}&pageSize=${pageSize}&offset=${offset - 1}`)
            .then(response => {
                dispatch(setCurrentPage(offset))
                dispatch(setDocList(response.data.docList, response.data.docsCount))
                dispatch(setPreloader(false))
            })
    }
}

export default calcReducer;