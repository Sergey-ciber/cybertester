package com.cybertester.service.standardCalc;

import com.cybertester.entity.standardCalc.StandardDxRegistrEntity;

public interface StandardDxRegistrService {

    String getGuid(long recordUq);

    StandardDxRegistrEntity getFirstByGuidInput(String guidInput);

    StandardDxRegistrEntity getFirstByRecordUq(long recordUq);

    StandardDxRegistrEntity getByRecordUq(long recordUq);
}
