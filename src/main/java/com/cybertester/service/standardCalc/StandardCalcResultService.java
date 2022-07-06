package com.cybertester.service.standardCalc;

import com.cybertester.entity.standardCalc.StandardCalcResultEntity;

import java.util.List;

public interface StandardCalcResultService {

List<StandardCalcResultEntity> getAllByRecordUQRegister(int recordUQRegister);

}
