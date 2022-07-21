package com.cybertester.components;

import com.cybertester.entity.testCalc.TestCalcCheckListEntity;
import com.cybertester.managers.pvsoManagers.PvsoManagers;
import com.cybertester.service.standardCalc.StandardCalcResultService;
import com.cybertester.service.standardCalc.StandardDxRegistrService;
import com.cybertester.service.testCalc.TestCalcResultService;
import com.cybertester.service.testCalc.TestCalcCheckListService;
import com.cybertester.utils.CalcUtility;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestComponent {

    private final TestCalcResultService testCalcResultService;
    private final StandardCalcResultService standardCalcResultService;
    private final StandardDxRegistrService standardDxRegistrService;
    private final TestCalcCheckListService testCalcCheckListService;
    private final PvsoManagers pvsoManagers;
    private final CalcUtility calcUtility;

    public TestComponent(StandardCalcResultService standardCalcResultService, TestCalcResultService testCalcResultService,
                         StandardDxRegistrService standardDxRegistrService, TestCalcCheckListService testCalcCheckListService, PvsoManagers pvsoManagers, CalcUtility calcUtility) {
        this.standardCalcResultService = standardCalcResultService;
        this.testCalcResultService = testCalcResultService;
        this.standardDxRegistrService = standardDxRegistrService;
        this.testCalcCheckListService = testCalcCheckListService;
        this.pvsoManagers = pvsoManagers;
        this.calcUtility = calcUtility;
    }


    @PostConstruct
    public void test() {
        System.out.println("Start");

//        calcUtility.addListRecordUqStringToCalcCheckList("124107991,124107990");

        calcUtility.goCalcCheckList();
        System.out.println("End");
    }
}
