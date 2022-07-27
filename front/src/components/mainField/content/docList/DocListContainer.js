import React from "react";
import {connect} from "react-redux";
import DocList from "./DocList";

let mapStateToProps = (state) => {
    return {docList: state.calcTestData.docList}
}

let mapDispatchToProps = (dispatch) => {return{}}

const DocListContainer = connect(mapStateToProps, mapDispatchToProps) (DocList)

export default DocListContainer;