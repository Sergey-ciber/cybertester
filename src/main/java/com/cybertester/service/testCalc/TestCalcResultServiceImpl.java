package com.cybertester.service.testCalc;

import com.cybertester.entity.standardCalc.StandardCalcResultEntity;
import com.cybertester.entity.testCalc.TestCalcResultEntity;
import com.cybertester.repository.standardCalc.StandardCalcResultRepository;
import com.cybertester.repository.testCalc.TestCalcResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCalcResultServiceImpl implements TestCalcResultService{

    private final TestCalcResultRepository testCalcResultRepository;

    @Autowired
    public TestCalcResultServiceImpl(TestCalcResultRepository testCalcResultRepository) {
        this.testCalcResultRepository = testCalcResultRepository;
    }


    @Override
    public List<TestCalcResultEntity> getAllByRecordUQRegister(int recordUQRegister) {
        return null;
    }

    @Override
    public void create(TestCalcResultEntity testCalcResultEntity) {
        testCalcResultRepository.save(testCalcResultEntity);
    }
}
