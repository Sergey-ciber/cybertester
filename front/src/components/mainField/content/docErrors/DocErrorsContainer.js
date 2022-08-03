import React from "react";
import {connect} from "react-redux";
import DocErrors from "./DocErrors";

let mapStateToProps = (state) => {
    return {docList: state.calcTestData.docList    }
}

const DocErrorsContainer = connect(mapStateToProps, {})(DocErrors);
export default DocErrorsContainer