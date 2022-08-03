import {applyMiddleware, combineReducers, createStore} from "redux";
import calcReducer from "./calcReducer";
import thunk from "redux-thunk"

let reducers = combineReducers(
    {calcTestData:calcReducer})

let store = createStore(reducers, applyMiddleware(thunk));

export default store;