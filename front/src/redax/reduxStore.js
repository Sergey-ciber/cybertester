import {applyMiddleware, combineReducers, createStore} from "redux";
import calcReducer from "./calcReducer";
import thunk from "redux-thunk"
import oldCalcResultReducer from "./oldCalcResultReducer";


let reducers = combineReducers(
    {calcTestData:calcReducer,
    oldCalcResultData: oldCalcResultReducer})

let store = createStore(reducers, applyMiddleware(thunk));

export default store;