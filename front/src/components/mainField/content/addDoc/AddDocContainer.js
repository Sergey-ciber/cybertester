import React from "react";
import {addDocActionCreator, updateRecordUqTextActionCreator} from "../../../../redax/calcReducer";
import AddDoc from "./AddDoc";
import {connect} from "react-redux";


// const AddDocContainer = (props) => {
//
//     let onAddDoc = () => {
//         props.dispatch(
//             addDocActionCreator()
//         )
//     }
//
//     let updateRecordUqText = (text) => {
//         props.dispatch(
//             updateRecordUqTextActionCreator(text)
//         )
//     }
//
//     return (
//         <AddDoc updateRecordUqText={updateRecordUqText} onAddDoc={onAddDoc} recordUqText={props.recordUqText}/>
//     )
// }

let mapStateToProps = (state) => {
    return {recordUqText: state.calcTestData.recordUqText}
}
let mapDispatchToProps = (dispatch) => {
    return {
        onAddDoc: () => {dispatch(addDocActionCreator())},
        updateRecordUqText: (text) => {dispatch(updateRecordUqTextActionCreator(text))}
    }
}

const AddDocContainer = connect(mapStateToProps, mapDispatchToProps) (AddDoc)
export default AddDocContainer;