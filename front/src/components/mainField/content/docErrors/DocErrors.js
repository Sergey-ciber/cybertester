import React from "react";
import style from './DocErrors.module.css'
import {useParams} from "react-router-dom";

const DocErrors = (props) => {

    let param = useParams();
    return (
        <div className={style.docErrors}>
            <div>ID = {param.id}</div>
            <div>
                В документе RECORD_UQ = 124107990  не совпадают строки:
                Расчет из тестовой БД
                ИД =101
                record_uq=92693424
                Начало периода ='2022-06-04 00:00:00'
                Конец периода ='2022-06-30 00:00:00'
                Сумма дня =1000.0
                recordUQRegister=124107990
                Процент=100
                Сумма дня с учетом процентов=1000.0
                Количество дней=27.0
                Сумма=27000.01
                Тип пособия =648
                КБК =25442
                Год учета =2022
                Дата создания записи = 2022-07-21 00:00:00.0</div>
        </div>
    )
}
export default DocErrors;