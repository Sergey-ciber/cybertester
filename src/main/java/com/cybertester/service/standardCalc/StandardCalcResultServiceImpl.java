package com.cybertester.service.standardCalc;

import com.cybertester.entity.standardCalc.StandardCalcResultEntity;
import com.cybertester.entity.testCalc.TestCalcResultEntity;
import com.cybertester.repository.standardCalc.StandardCalcResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardCalcResultServiceImpl implements StandardCalcResultService {

    private final StandardCalcResultRepository standardCalcResultRepository;

    @Autowired
    public StandardCalcResultServiceImpl(StandardCalcResultRepository standardCalcResultRepository) {
        this.standardCalcResultRepository = standardCalcResultRepository;
    }

    @Override
    public List<StandardCalcResultEntity> getAllByRecordUqRegistr(long recordUqRegistr) {

        return standardCalcResultRepository.getAllByRecordUqRegistr(recordUqRegistr);
    }

    @Override
    public List<StandardCalcResultEntity> getAllByRecordUq(long recordU) {
        return null;
    }

    @Override
    public StandardCalcResultEntity getFirstByRecordUq(long record_uq) {
        return null;
    }


}
