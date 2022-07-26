import calcReducer from "./calcReducer";

let store = {
    state: {
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
    },
    getState() {
        return this.state
    },
    callSubscriber() {
        console.log("no observer")
    },
    subscribe(observer) {
        this.callSubscriber = observer
    },
    dispatch(action) {

        this.state.calc = calcReducer(this.state.calc, action)

        this.callSubscriber(this.state)
    }
}

export default store
window.store = store