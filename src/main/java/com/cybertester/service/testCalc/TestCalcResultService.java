package com.cybertester.service.testCalc;

import com.cybertester.entity.standardCalc.StandardCalcResultEntity;
import com.cybertester.entity.testCalc.TestCalcResultEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TestCalcResultService {

    void create(TestCalcResultEntity testCalcResultEntity);

    // Получаем список сущностей по RECORD_UQ
    List<TestCalcResultEntity> getAllByRecordUq(long recordUq);

    // Получаем список сущностей по RECORD_UQ_REGISTR
    List<TestCalcResultEntity> getAllByRecordUqRegistr(long recordUqRegistr);

    // Получаем первую сущность по RECORD_UQ_REGISTR
    TestCalcResultEntity getFirstByRecordUqRegistr(long recordUqRegistr);

    // Удаляем все записи по RECORD_UQ_REGISTR
    boolean deleteAllByRecordUqRegistr(long recordUqRegistr);

    //Удаляем запись по ID
    boolean deleteById(long id);






}
