import React from "react";
import TestFieldHeader from "./TestFieldHeader";
import {checkCalculation, setFieldName} from "../../../redax/calcReducer";
import {connect} from "react-redux";

let mapStateToProps = (state) => {
    return {sort: state.calcTestData.sort,
    field: state.calcTestData.fieldName,
    currentPage: state.calcTestData.currentPage,
        pageSize: state.calcTestData.pageSize}
}

const TestFieldHeaderContainer = connect(mapStateToProps, {checkCalculation})(TestFieldHeader)
export default TestFieldHeaderContainer;