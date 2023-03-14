import axios from "axios";
import calcReducer, {setCurrentPage, setDocList, setPreloader} from "./calcReducer";

const SET_OLD_CALC_RESULT_BY_ID = 'SET-OLD-CALC-RESULT-BY-ID'

let initialState = {
    oldCalcResult: [],
    selectedOldCalcResult: 0
}

let a = [{First: 1}, {Second: 2}]

const oldCalcResultReducer = (state = initialState, action) => {

    switch (action.type) {
        case SET_OLD_CALC_RESULT_BY_ID: {
            return {
                ...state,
                oldCalcResult: action.oldCalcResultArr
            }
        }
        default:
            return state
    }
}
export const setOldCalcResult = (oldCalcResultArr) => {
    return {type: SET_OLD_CALC_RESULT_BY_ID, oldCalcResultArr}
}

export const getOldCalcResultById = (id) => (dispatch) => {
    axios.get(`http://localhost:8090/calc/oldCalcResult?id=${id}`)
        .then(response => {
            if (response.data.oldCalcResultArr != null) {
                dispatch(setOldCalcResult(response.data.oldCalcResultArr))
            } else {
                console.log("Данные по старым результатам расчетов не найдены")
                dispatch(setOldCalcResult([{
                        periodBegDay: 'данные не найдены',
                        periodEndDay: 'данные не найдены',
                        periodPercent: 'данные не найдены',
                        price: 'данные не найдены',
                        pricesPercent: 'данные не найдены',
                        countDays: 'данные не найдены',
                        recordUqBCC: 'данные не найдены',
                        summa: 'данные не найдены',
                        yearCalc: 'данные не найдены'
                    }])
                )
            }
        })
}

export default oldCalcResultReducer;