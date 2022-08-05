import React from "react";
import {connect} from "react-redux";
import DocList from "./DocList";
import {getDocsThunkCreator, setDocList, updateDoc} from "../../../../redax/calcReducer";

let mapStateToProps = (state) => {
    return {docList: state.calcTestData.docList, docsCount: state.calcTestData.docsCount}
}

const DocListContainer = connect(mapStateToProps, {setDocList, getDocsThunkCreator, updateDoc})(DocList)

export default DocListContainer;