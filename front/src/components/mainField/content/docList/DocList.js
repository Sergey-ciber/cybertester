import React from "react";
import style from './DocList.module.css'
import DocHeader from "./docHeader/DocHeader";
import Doc from "./doc/Doc";

const DocList = () => {

    return (
        <div className={style.docList}>
            <DocHeader/>
            <Doc id={1} recordUq={124127782} guidInput={'E40F5D1A19CAAA05E0530813E00A865E'} doCheck={true} date={'2022-07-21'} checked={false}/>
            <Doc id={2} recordUq={124127782} guidInput={'E40F5D1A19CAAA05E0530813E00A865E'} doCheck={true} date={'2022-07-21'} checked={1}/>
            <Doc id={3} recordUq={124127782} guidInput={'E40F5D1A19CAAA05E0530813E00A865E'} doCheck={true} date={'2022-07-21'} checked={false}/>
            <Doc id={4} recordUq={124127782} guidInput={'E40F5D1A19CAAA05E0530813E00A865E'} doCheck={true} date={'2022-07-21'} checked={1}/>
        </div>
    )
}
export default DocList;