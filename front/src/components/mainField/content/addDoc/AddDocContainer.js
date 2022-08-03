import React from "react";
import AddDoc from "./AddDoc";
import {connect} from "react-redux";
import {addDoc, addDocsToDocsList, updateRecordUqText} from "../../../../redax/calcReducer";


let mapStateToProps = (state) => {
    return {recordUqText: state.calcTestData.recordUqText}
}
// let mapDispatchToProps = (dispatch) => {
//     return {
//         onAddDoc: () => {dispatch(addDoc())},
//         updateRecordUqText: (text) => {dispatch(updateRecordUqText(text))}
//     }
// }

const AddDocContainer = connect(mapStateToProps, {addDocsToDocsList, updateRecordUqText}) (AddDoc)
export default AddDocContainer;