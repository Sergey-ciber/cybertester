import React from "react";
import {connect} from "react-redux";
import DocList from "./DocList";
import {
    deleteDoc,
    getDocsThunkCreator,
    getDocsWithPaginationAndSort,
    setDocList,
    updateDoc
} from "../../../../redax/calcReducer";

let mapStateToProps = (state) => {
    return {docList: state.calcTestData.docList, totalDocsCount: state.calcTestData.totalDocsCount,
    pageSize: state.calcTestData.pageSize, currentPage: state.calcTestData.currentPage}
}

const DocListContainer = connect(mapStateToProps, {setDocList, getDocsThunkCreator,
    updateDoc, deleteDoc, getDocsWithPaginationAndSort
})(DocList)

export default DocListContainer;