package com.cybertester.service.standardCalc;

import com.cybertester.entity.standardCalc.StandardDxRegistrEntity;
import com.cybertester.repository.standardCalc.StandardDxRegistrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StandardDxRegistrServiceImpl implements StandardDxRegistrService {

    private final StandardDxRegistrRepository standardDxRegistrRepository;

    @Autowired
    public StandardDxRegistrServiceImpl(StandardDxRegistrRepository standardDxRegistrRepository) {
        this.standardDxRegistrRepository = standardDxRegistrRepository;
    }

    @Override
    public String getGuid(long recordUq) {

        return standardDxRegistrRepository.getGuid(recordUq);
    }

    @Override
    public StandardDxRegistrEntity getFirstByGuidInput(String guidInput) {
        return standardDxRegistrRepository.getFirstByGuidInput(guidInput);
    }

    @Override
    public StandardDxRegistrEntity getFirstByRecordUq(long recordUq) {
        return standardDxRegistrRepository.getFirstByRecordUq(recordUq);
    }

    @Override
    public StandardDxRegistrEntity getByRecordUq(long recordUq) {
        return standardDxRegistrRepository.getByRecordUq(recordUq);
    }


}
