package com.cybertester.service.standardCalc;

import com.cybertester.entity.standardCalc.StandardDxRegistrEntity;
import org.springframework.data.repository.query.Param;

public interface StandardDxRegistrService {

    String getGuid(long recordUq);

    StandardDxRegistrEntity getFirstByGuidInput(String guidInput);

}
