package com.cybertester.service.testCalc;

import com.cybertester.entity.testCalc.TestCalcCheckListEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface TestCalcCheckListService {

    void create(TestCalcCheckListEntity testCalcCheckListEntity);

    TestCalcCheckListEntity findById(long id);

    // Получаем список сущностей по RECORD_UQ
    List<TestCalcCheckListEntity> getAllByRecordUqRegistr(long recordUqRegistr);

    // Получаем первую сущность по RECORD_UQ
    TestCalcCheckListEntity getFirstByRecordUqRegistr(long recordUqRegistr);

    // Удаляем все записи по RECORD_UQ_REGISTR
    void deleteAllByRecordUqRegistr(long recordUqRegistr);

    //Удаляем запись по ID
    boolean deleteById(long id);

    TestCalcCheckListEntity getFirstById(long id);

    List<TestCalcCheckListEntity> getAllByDoCheck(int doCheck);

    // Поиск всех записей с ошибкой
    List<TestCalcCheckListEntity> getAllByCalcResult(int calcResult);

    void deleteByRecordUqRegistr(long recordUqRegistr);

    //Удаляем запись по ID
    boolean delete(long id);

    //Получаем все документы из списка
    List<TestCalcCheckListEntity> getAll();

    // Получаем отсортированный список документов
    List<TestCalcCheckListEntity> findAllWithSort(String field, String sort);

    List<TestCalcCheckListEntity> findAllByOrderByIdAsc();

    void update(TestCalcCheckListEntity testCalcCheckListEntity, long id);

    //Получаем постранично список документов
    Page<TestCalcCheckListEntity> findDocsWithPagination(int pageSize, int offset);

    //Получаем постранично список документов с сортировкой
    Page<TestCalcCheckListEntity> findDocsWithPaginationAndSort(int pageSize, int offset, String field, String sort);

}
