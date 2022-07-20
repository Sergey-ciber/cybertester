package com.cybertester.service.testCalc;

import com.cybertester.entity.testCalc.TestCalcCheckListEntity;

import java.util.List;

public interface TestCalcCheckListService {

    void create(TestCalcCheckListEntity testCalcCheckListEntity);

    // Получаем список сущностей по RECORD_UQ
    List<TestCalcCheckListEntity> getAllByRecordUqRegistr(long recordUqRegistr);

    // Получаем первую сущность по RECORD_UQ
    TestCalcCheckListEntity getFirstByRecordUqRegistr(long recordUqRegistr);

    // Удаляем все записи по RECORD_UQ_REGISTR
    void deleteAllByRecordUqRegistr(long recordUqRegistr);

    //Удаляем запись по ID
    boolean deleteById(long id);

    void update(TestCalcCheckListEntity testCalcCheckListEntity, long id);

    List<TestCalcCheckListEntity> getAllByDoCheck(int doCheck);
}
