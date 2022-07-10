package com.cybertester.repository.testCalc;

import com.cybertester.entity.testCalc.TestCalcResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestCalcResultRepository extends JpaRepository<TestCalcResultEntity, Integer> {

//    @Query(value = "")
//    String getResult(@Param("percent") long id) {}
//
//    @Query(value = "SELECT summa FROM StandardCalcResultEntity s WHERE s.pricesPercent = :percent")
//    List<StandardCalcResultEntity> getAllByPeriodPercentLimit(@Param("percent") int percent);


}
