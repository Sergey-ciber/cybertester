let rerenderEntireTree;

let state = {

    calc: {
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
}

export const addDoc = () => {
    let newDoc = {
        id: 5,
        recordUq: Number(state.calc.recordUqText),
        guidInput: "E40F5D1A19CAAA05E0530813E00A865E",
        doCheck: true,
        date: "2022-07-21",
        verified: false
    }
    state.calc.docList.push(newDoc)
    state.calc.recordUqText = ""
    rerenderEntireTree(state)
}
export const inputText = (text) => {
    state.calc.recordUqText = text
    rerenderEntireTree(state)
}

export const subscribe = (observer) => {
    rerenderEntireTree = observer
}
export default state;