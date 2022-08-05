package com.cybertester.repository.testCalc;

import com.cybertester.entity.testCalc.TestCalcCheckListEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestCalcCheckListRepository extends PagingAndSortingRepository<TestCalcCheckListEntity, Long> {

    // Получаем список сущностей по RECORD_UQ
    List<TestCalcCheckListEntity> getAllByRecordUqRegistr(long recordUqRegistr);

    void deleteAllByRecordUqRegistr(long recordUqRegistr);

    // Получаем первую сущность по RECORD_UQ
    TestCalcCheckListEntity getFirstByRecordUqRegistr(long recordUqRegistr);

    List<TestCalcCheckListEntity> getAllByDoCheck(int doCheck);

    TestCalcCheckListEntity getById(long id);

    List<TestCalcCheckListEntity> findAllByOrderByIdAsc();

    List<TestCalcCheckListEntity> findAll(Sort sort);


//    List<TestCalcCheckListEntity> findAllByCalcResultBefore();
//
//    List<TestCalcCheckListEntity> findAllByCalcResultAfter();

}
