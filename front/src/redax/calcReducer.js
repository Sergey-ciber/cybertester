const UPDATE_RECORD_UQ_TEXT = 'UPDATE-RECORD-UQ-TEXT'
const ADD_DOC = 'ADD-DOC'

let initialState = {
        recordUqText: "",
        docList: [
            {
                id: 1,
                recordUq: 124127782,
                guidInput: "E40F5D1A19CAAA05E0530813E00A865E",
                doCheck: true,
                date: "2022-07-21",
                verified: true
            },
            {
                id: 2,
                recordUq: 124127782,
                guidInput: "E40F5D1A19CAAA05E0530813E00A865E",
                doCheck: false,
                date: "2022-07-21",
                verified: false
            },
            {
                id: 3,
                recordUq: 124127782,
                guidInput: "E40F5D1A19CAAA05E0530813E00A865E",
                doCheck: true,
                date: "2022-07-21",
                verified: true
            },
            {
                id: 4,
                recordUq: 124127782,
                guidInput: "E40F5D1A19CAAA05E0530813E00A865E",
                doCheck: true,
                date: "2022-07-21",
                verified: false
            }
        ]
}

const calcReducer = (state = initialState, action) => {

    switch (action.type) {
        case UPDATE_RECORD_UQ_TEXT: {debugger
        state.recordUqText = action.text
            break
        }
        case ADD_DOC: {
            let newDoc = {
                id: 5,
                recordUq: Number(state.recordUqText),
                guidInput: "E40F5D1A19CAAA05E0530813E00A865E",
                doCheck: true,
                date: "2022-07-21",
                verified: false
            }
            state.docList.push(newDoc)
            state.recordUqText = ""
            break
        }
    }

    return state
}

export let updateRecordUqTextActionCreator = (text) => {
    return {type: UPDATE_RECORD_UQ_TEXT, text: text}
}

export let addDocActionCreator = () => {
    return {type: ADD_DOC}
}

export default calcReducer;