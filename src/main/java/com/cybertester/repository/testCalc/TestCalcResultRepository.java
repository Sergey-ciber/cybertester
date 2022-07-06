package com.cybertester.repository.testCalc;

import com.cybertester.entity.testCalc.TestCalcResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCalcResultRepository extends JpaRepository<TestCalcResultEntity, Integer> {


}
