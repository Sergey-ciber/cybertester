package com.cybertester.repository.testCalc;

import com.cybertester.config.CyberTesterConfig;
import com.cybertester.entity.standardCalc.StandardDxRegistrEntity;
import com.cybertester.entity.testCalc.TestCalcResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TestCalcResultRepository extends JpaRepository<TestCalcResultEntity, Long> {

    // Получаем список сущностей по RECORD_UQ
    List<TestCalcResultEntity> getAllByRecordUq(long recordUq);

    // Получаем список сущностей по RECORD_UQ_REGISTER
    List<TestCalcResultEntity> getAllByRecordUqRegistr(long recordUqRegistr);




    // Получаем первую сущность по RECORD_UQ
    TestCalcResultEntity getFirstByRecordUqRegistr(long recordUqRegistr);


}
