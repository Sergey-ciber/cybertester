const UPDATE_RECORD_UQ_TEXT = 'UPDATE-RECORD-UQ-TEXT'
const ADD_DOC = 'ADD-DOC'

const calcReducer = (state, action) => {

    switch (action.type) {
        case UPDATE_RECORD_UQ_TEXT: {
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