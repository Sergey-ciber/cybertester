import React from "react";
import {connect} from "react-redux";
import DocList from "./DocList";
import {getDocsThunkCreator, setDocList} from "../../../../redax/calcReducer";

let mapStateToProps = (state) => {
    return {docList: state.calcTestData.docList}
}

const DocListContainer = connect(mapStateToProps, {setDocList, getDocsThunkCreator})(DocList)

export default DocListContainer;