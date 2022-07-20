package com.cybertester.service.testCalc;

import com.cybertester.entity.testCalc.TestCalcResultEntity;
import com.cybertester.entity.testCalc.TestDocsListEntity;
import com.cybertester.repository.testCalc.TestCalcResultRepository;
import com.cybertester.repository.testCalc.TestDocsListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class TestDocsListServiceImpl implements TestDocsListService{

    private final TestDocsListRepository testDocsListRepository;

    @Autowired
    public TestDocsListServiceImpl(TestDocsListRepository testDocsListRepository) {
        this.testDocsListRepository = testDocsListRepository;
    }

    @Override
    public void create(TestDocsListEntity testDocsListEntity) {

    }

    @Override
    public List<TestDocsListEntity> getAllByRecordUqRegistr(long recordUqRegistr) {
        return testDocsListRepository.getAllByRecordUqRegistr(recordUqRegistr);
    }

    @Override
    public TestDocsListEntity getFirstByRecordUqRegistr(long recordUqRegistr) {
        return testDocsListRepository.getFirstByRecordUqRegistr(recordUqRegistr);
    }

    @Override
    public void deleteAllByRecordUqRegistr(long recordUqRegistr) {
        System.out.println("Записи удалены");
    }


    @Override
    public boolean deleteById(long id) {
        if (testDocsListRepository.existsById(id)) {
            testDocsListRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
