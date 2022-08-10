import React from "react";
import {connect} from "react-redux";
import DocHeader from "./DocHeader";
import {getDocsWithPaginationAndSort, getDocsWithSort, setFieldName, setSort} from "../../../../../redax/calcReducer";

let mapStateToProps = (state) => {
    return {
        sort: state.calcTestData.sort,
        field: state.calcTestData.fieldName,
        currentPage: state.calcTestData.currentPage,
        pageSize: state.calcTestData.pageSize
    }
}

const DocHeaderContainer = connect(mapStateToProps, {getDocsWithSort, setSort,
    setFieldName,getDocsWithPaginationAndSort})(DocHeader)

export default DocHeaderContainer;