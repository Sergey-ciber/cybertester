package com.cybertester.repository.standardCalc;

import com.cybertester.entity.standardCalc.StandardCalcResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StandardCalcResultRepository extends JpaRepository<StandardCalcResultEntity, Integer> {

    List<StandardCalcResultEntity> getAllByRecordUQRegister(int register);
}
