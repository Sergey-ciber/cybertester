package com.cybertester.service.testCalc;

import com.cybertester.config.CyberTesterConfig;
import com.cybertester.entity.testCalc.TestCalcResultEntity;
import com.cybertester.repository.testCalc.TestCalcResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
//@Transactional
public class TestCalcResultServiceImpl implements TestCalcResultService{

    private final TestCalcResultRepository testCalcResultRepository;

    @Autowired
    public TestCalcResultServiceImpl(TestCalcResultRepository testCalcResultRepository) {
        this.testCalcResultRepository = testCalcResultRepository;
    }


    @Override
    public void create(TestCalcResultEntity testCalcResultEntity) {
        testCalcResultRepository.save(testCalcResultEntity);
    }

    @Override
    public void saveAll(List<TestCalcResultEntity> testCalcResultList) {
        testCalcResultRepository.saveAll(testCalcResultList);
    }

    @Override
    public List<TestCalcResultEntity> getAllByRecordUq(long recordUq) {
        return null;
    }

    @Override
    public List<TestCalcResultEntity> getAllById(long id) {
        return testCalcResultRepository.getAllById(id);
    }

    @Override
    public List<TestCalcResultEntity> getAllByRecordUqRegistr(long recordUqRegistr) {
        return testCalcResultRepository.getAllByRecordUqRegistr(recordUqRegistr);
    }

    @Override
    public TestCalcResultEntity getFirstByRecordUqRegistr(long recordUqRegistr) {
        return testCalcResultRepository.getFirstByRecordUqRegistr(recordUqRegistr);
    }

    @Override
    public void deleteAllByRecordUqRegistr(long recordUqRegistr) {
    }

    @Override
    public boolean delete(long id) {
        if (testCalcResultRepository.existsById(id)) {
            testCalcResultRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
