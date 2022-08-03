const UPDATE_RECORD_UQ_TEXT = 'UPDATE-RECORD-UQ-TEXT'
const ADD_DOC = 'ADD-DOC'
const SET_DOC_LIST = 'SET-DOC-LIST'

let initialState = {
    recordUqText: "",
    docList: [
        // {
        //     id: 1,
        //     recordUq: 124127782,
        //     guidInput: "E40F5D1A19CAAA05E0530813E00A865E",
        //     doCheck: true,
        //     date: "2022-07-21",
        //     verified: true
        // },
        // {
        //     id: 2,
        //     recordUq: 124127782,
        //     guidInput: "E40F5D1A19CAAA05E0530813E00A865E",
        //     doCheck: false,
        //     date: "2022-07-21",
        //     verified: false
        // },
        // {
        //     id: 3,
        //     recordUq: 124127782,
        //     guidInput: "E40F5D1A19CAAA05E0530813E00A865E",
        //     doCheck: true,
        //     date: "2022-07-21",
        //     verified: true
        // },
        // {
        //     id: 4,
        //     recordUq: 124127782,
        //     guidInput: "E40F5D1A19CAAA05E0530813E00A865E",
        //     doCheck: true,
        //     date: "2022-07-21",
        //     verified: false
        // }
    ]
}

const calcReducer = (state = initialState, action) => {

    switch (action.type) {
        case SET_DOC_LIST:{
            return{
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
                recordUq: Number(state.recordUqText),
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

export let updateRecordUqText = (text) => {
    return {type: UPDATE_RECORD_UQ_TEXT, text}
}

export let addDoc = () => {
    return {type: ADD_DOC}
}

export let setDocList = (docList) => {
    return {type: SET_DOC_LIST, docList}
}

export default calcReducer;