package com.cybertester.utils;

import com.cybertester.entity.standardCalc.StandardCalcResultEntity;
import com.cybertester.service.standardCalc.StandardCalcResultService;
import com.cybertester.service.standardCalc.StandardDxRegistrService;
import com.cybertester.service.testCalc.TestCalcResultService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalcUtility {

    private final TestCalcResultService testCalcResultService;
    private final StandardCalcResultService standardCalcResultService;
    private final StandardDxRegistrService standardDxRegistrService;

    public CalcUtility(TestCalcResultService testCalcResultService, StandardCalcResultService standardCalcResultService, StandardDxRegistrService standardDxRegistrService) {
        this.testCalcResultService = testCalcResultService;
        this.standardCalcResultService = standardCalcResultService;
        this.standardDxRegistrService = standardDxRegistrService;
    }

    public String comparisonCalcResult(String guidInput) {

        // Получаем RECORD_UQ по GUID_INPUT
        long recordUq = standardDxRegistrService.getFirstByGuidInput(guidInput).getRecordUq();

        // Получаем список результатов расчета по RECORD_UQ
        List<StandardCalcResultEntity> standardCalcResultEntityList = standardCalcResultService.getAllByRecordUQRegister(recordUq);

        System.out.println(standardCalcResultEntityList);
        return "standardCalcResultEntityList";
    }

}
