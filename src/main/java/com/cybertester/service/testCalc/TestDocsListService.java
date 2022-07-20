package com.cybertester.service.testCalc;

import com.cybertester.entity.testCalc.TestCalcResultEntity;
import com.cybertester.entity.testCalc.TestDocsListEntity;

import java.util.List;

public interface TestDocsListService {

    void create(TestDocsListEntity testDocsListEntity);

    // Получаем список сущностей по RECORD_UQ
    List<TestDocsListEntity> getAllByRecordUqRegistr(long recordUqRegistr);

    // Получаем первую сущность по RECORD_UQ
    TestDocsListEntity getFirstByRecordUqRegistr(long recordUqRegistr);

    // Удаляем все записи по RECORD_UQ_REGISTR
    void deleteAllByRecordUqRegistr(long recordUqRegistr);

    //Удаляем запись по ID
    boolean deleteById(long id);
}
