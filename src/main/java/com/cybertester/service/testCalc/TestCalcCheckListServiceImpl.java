package com.cybertester.service.testCalc;

import com.cybertester.entity.testCalc.TestCalcCheckListEntity;
import com.cybertester.repository.testCalc.TestCalcCheckListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        testCalcCheckListRepository.save(testCalcCheckListEntity);
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
    public TestCalcCheckListEntity getFirstById(long id) {
        return testCalcCheckListRepository.getById(id);
    }

    @Override
    public List<TestCalcCheckListEntity> getAllByDoCheck(int doCheck) {
        return testCalcCheckListRepository.getAllByDoCheck(doCheck);
    }

    @Override
    public void deleteByRecordUqRegistr(long recordUqRegistr) {
    }

    @Override
    public boolean delete(long id) {
        if (testCalcCheckListRepository.existsById(id)) {
            testCalcCheckListRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<TestCalcCheckListEntity> getAll() {

        return testCalcCheckListRepository.findAll();
    }

    @Override
    public List<TestCalcCheckListEntity> findAllWithSort(String field, String sort) {
        return sort.equals("asc") ?
                testCalcCheckListRepository.findAll(Sort.by(Sort.Direction.ASC, field))
                : testCalcCheckListRepository.findAll(Sort.by(Sort.Direction.DESC, field));
    }


    @Override
    public List<TestCalcCheckListEntity> findAllByOrderByIdAsc() {
        return testCalcCheckListRepository.findAllByOrderByIdAsc();
    }

    @Override
    public void update(TestCalcCheckListEntity testCalcCheckListEntity, long id) {
        if (testCalcCheckListRepository.existsById(id)) {
            testCalcCheckListEntity.setId(id);
            testCalcCheckListRepository.save(testCalcCheckListEntity);
        }
    }

    //Получаем постранично список документов
    public Page<TestCalcCheckListEntity> findDocsWithPagination(int pageSize, int offset) {
        Page<TestCalcCheckListEntity> docsPage = testCalcCheckListRepository.findAll(PageRequest.of(offset, pageSize));
        return docsPage;
    }

    //Получаем постранично список документов с сортировкой
    public Page<TestCalcCheckListEntity> findDocsWithPaginationAndSort(int pageSize, int offset, String field, String sort) {

        return sort.equals("asc") ?
                testCalcCheckListRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC, field)))
                : testCalcCheckListRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.DESC, field)));
    }
}
