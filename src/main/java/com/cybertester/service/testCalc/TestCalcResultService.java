package com.cybertester.service.testCalc;

import com.cybertester.entity.testCalc.TestCalcResultEntity;
import java.util.List;

public interface TestCalcResultService {

    void create(TestCalcResultEntity testCalcResultEntity);

    // Сохраняем список записей
    void saveAll(List<TestCalcResultEntity> testCalcResultList);

    // Получаем список сущностей по RECORD_UQ
    List<TestCalcResultEntity> getAllByRecordUq(long recordUq);

    // Получаем список сущностей по RECORD_UQ_REGISTR
    List<TestCalcResultEntity> getAllByRecordUqRegistr(long recordUqRegistr);

    // Получаем первую сущность по RECORD_UQ_REGISTR
    TestCalcResultEntity getFirstByRecordUqRegistr(long recordUqRegistr);

    // Удаляем все записи по RECORD_UQ_REGISTR
    void deleteAllByRecordUqRegistr(long recordUqRegistr);

    //Удаляем запись по ID
    boolean delete(long id);
}
