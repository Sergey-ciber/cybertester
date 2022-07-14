package com.cybertester.service.standardCalc;

import com.cybertester.entity.standardCalc.StandardCalcResultEntity;
import com.cybertester.entity.testCalc.TestCalcResultEntity;

import java.util.List;

public interface StandardCalcResultService {

    // Получаем список сущностей по RECORD_UQ_REGISTR
    List<StandardCalcResultEntity> getAllByRecordUqRegister(long recordUQRegister);

    // Получаем список сущностей по RECORD_UQ
    List<StandardCalcResultEntity> getAllByRecordUq(long recordU);

    // Получаем первую сущность по RECORD_UQ
    StandardCalcResultEntity getFirstByRecordUq(long record_uq);

}
