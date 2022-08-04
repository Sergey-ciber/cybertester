import React from "react";
import TestFieldHeader from "./TestFieldHeader";
import {checkCalculation} from "../../../redax/calcReducer";
import {connect} from "react-redux";

let mapStateToProps = (state) => {
    return {obj: "a"}
}

const TestFieldHeaderContainer = connect(mapStateToProps, {checkCalculation})(TestFieldHeader)
export default TestFieldHeaderContainer;