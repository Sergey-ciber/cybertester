import React from "react";
import {connect} from "react-redux";
import DocHeader from "./DocHeader";
import {getDocsWithSort, setFieldName, setSort} from "../../../../../redax/calcReducer";

let mapStateToProps = (state) => {
    return {
        sort: state.calcTestData.sort,
        fieldName: state.calcTestData.fieldName
    }
}

const DocHeaderContainer = connect(mapStateToProps, {getDocsWithSort, setSort, setFieldName})(DocHeader)

export default DocHeaderContainer;