package com.cybertester.service.testCalc;

import com.cybertester.entity.standardCalc.StandardCalcResultEntity;
import com.cybertester.entity.testCalc.TestCalcResultEntity;

import java.util.List;

public interface TestCalcResultService {

List<TestCalcResultEntity> getAllByRecordUQRegister(int recordUQRegister);

    void create(TestCalcResultEntity testCalcResultEntity);

}
