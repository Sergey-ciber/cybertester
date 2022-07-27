import {combineReducers, createStore} from "redux";
import calcReducer from "./calcReducer";

let reducers = combineReducers(
    {calcTestData:calcReducer})

let store = createStore(reducers);

export default store;