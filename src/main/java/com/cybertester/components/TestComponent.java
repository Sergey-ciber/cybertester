package com.cybertester.components;

import com.cybertester.entity.standardCalc.StandardCalcResultEntity;
import com.cybertester.entity.testCalc.TestCalcResultEntity;
import com.cybertester.managers.pvsoManagers.PvsoManagers;
import com.cybertester.service.standardCalc.StandardCalcResultService;
import com.cybertester.service.standardCalc.StandardDxRegistrService;
import com.cybertester.service.testCalc.TestCalcResultService;
import com.cybertester.utils.CalcUtility;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class TestComponent {

    private final TestCalcResultService testCalcResultService;
    private final StandardCalcResultService standardCalcResultService;
    private final StandardDxRegistrService standardDxRegistrService;
    private final PvsoManagers pvsoManagers;
    private final CalcUtility calcUtility;

    public TestComponent(StandardCalcResultService standardCalcResultService, TestCalcResultService testCalcResultService,
                         StandardDxRegistrService standardDxRegistrService, PvsoManagers pvsoManagers, CalcUtility calcUtility) {
        this.standardCalcResultService = standardCalcResultService;
        this.testCalcResultService = testCalcResultService;
        this.standardDxRegistrService = standardDxRegistrService;
        this.pvsoManagers = pvsoManagers;
        this.calcUtility = calcUtility;
    }


    @PostConstruct
    public void test() {
        System.out.println("Start");

        System.out.println(testCalcResultService.getAllByRecordUqRegistr(124104296).size());
        System.out.println("----------------------------------");
        System.out.println(standardCalcResultService.getAllByRecordUqRegister(124104296).size());


//        calcUtility.saveCalcResult(124104296);

//        calcUtility.comparisonCalcResult( 124126597);

//        System.out.println(standardDxRegistrService.getGuid(124124901));
//
//        pvsoManagers.deleteDxRegistr("E32136B2A1AFBEA7E0530813E00AD6D0");
//
//        List<StandardCalcResultEntity> standardList = standardCalcResultService.getAllByRecordUQRegister(124123239);
//
//        System.out.println("В базе ПВСО найдено " + standardList.size() + " записей");


        System.out.println("End");
    }
}
