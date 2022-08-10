import React from "react";
import AddDoc from "./AddDoc";
import {connect} from "react-redux";
import {addDoc, addDocsToDocsList, updateRecordUqText} from "../../../../redax/calcReducer";


let mapStateToProps = (state) => {
    return {
        recordUqText: state.calcTestData.recordUqText,
        field: state.calcTestData.fieldName,
        sort: state.calcTestData.sort,
        pageSize: state.calcTestData.pageSize,
        currentPage: state.calcTestData.currentPage,
    }
}

const AddDocContainer = connect(mapStateToProps, {addDocsToDocsList, updateRecordUqText})(AddDoc)
export default AddDocContainer;