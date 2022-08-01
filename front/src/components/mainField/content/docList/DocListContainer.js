import React from "react";
import {connect} from "react-redux";
import DocList from "./DocList";
import {setDocList} from "../../../../redax/calcReducer";

let mapStateToProps = (state) => {
    return {docList: state.calcTestData.docList}
}

let mapDispatchToProps = (dispatch) => {
    return {
        setDocList: (docList) => dispatch(setDocList(docList))
    }
}

const DocListContainer = connect(mapStateToProps, mapDispatchToProps)(DocList)

export default DocListContainer;