package com.cybertester.service.testCalc;

import com.cybertester.entity.testCalc.TestCalcCheckListEntity;
import com.cybertester.repository.testCalc.TestCalcCheckListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class TestCalcCheckListServiceImpl implements TestCalcCheckListService {

    private final TestCalcCheckListRepository testCalcCheckListRepository;

    @Autowired
    public TestCalcCheckListServiceImpl(TestCalcCheckListRepository testCalcCheckListRepository) {
        this.testCalcCheckListRepository = testCalcCheckListRepository;
    }

    @Override
    public void create(TestCalcCheckListEntity testCalcCheckListEntity) {

    }

    @Override
    public List<TestCalcCheckListEntity> getAllByRecordUqRegistr(long recordUqRegistr) {
        return testCalcCheckListRepository.getAllByRecordUqRegistr(recordUqRegistr);
    }

    @Override
    public TestCalcCheckListEntity getFirstByRecordUqRegistr(long recordUqRegistr) {
        return testCalcCheckListRepository.getFirstByRecordUqRegistr(recordUqRegistr);
    }

    @Override
    public void deleteAllByRecordUqRegistr(long recordUqRegistr) {
        System.out.println("Записи удалены");
    }


    @Override
    public boolean deleteById(long id) {
        if (testCalcCheckListRepository.existsById(id)) {
            testCalcCheckListRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void update(TestCalcCheckListEntity testCalcCheckListEntity, long id) {
        testCalcCheckListEntity.setId(id);
        testCalcCheckListRepository.save(testCalcCheckListEntity);
    }

    @Override
    public List<TestCalcCheckListEntity> getAllByDoCheck(int doCheck) {
        return testCalcCheckListRepository.getAllByDoCheck(doCheck);
    }


}
