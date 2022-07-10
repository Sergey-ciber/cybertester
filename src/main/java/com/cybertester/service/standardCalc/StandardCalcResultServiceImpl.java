package com.cybertester.service.standardCalc;

import com.cybertester.entity.standardCalc.StandardCalcResultEntity;
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
    public List<StandardCalcResultEntity> getAllByRecordUQRegister(long recordUQRegister) {

        return standardCalcResultRepository.getAllByRecordUQRegister(recordUQRegister);
    }
}
