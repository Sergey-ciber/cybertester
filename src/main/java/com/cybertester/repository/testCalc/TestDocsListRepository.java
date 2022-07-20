package com.cybertester.repository.testCalc;

import com.cybertester.entity.testCalc.TestCalcResultEntity;
import com.cybertester.entity.testCalc.TestDocsListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDocsListRepository extends JpaRepository<TestDocsListEntity, Long> {

    // Получаем список сущностей по RECORD_UQ
    List<TestDocsListEntity> getAllByRecordUqRegistr(long recordUqRegistr);


    void deleteAllByRecordUqRegistr(long recordUqRegistr);


    // Получаем первую сущность по RECORD_UQ
    TestDocsListEntity getFirstByRecordUqRegistr(long recordUqRegistr);


}
