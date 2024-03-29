package com.cybertester.components;

import com.cybertester.entity.testCalc.TestCalcCheckListEntity;
import com.cybertester.managers.pvsoManagers.PvsoManagers;
import com.cybertester.seleniumTests.RecalcDocs;
import com.cybertester.service.standardCalc.StandardCalcResultService;
import com.cybertester.service.standardCalc.StandardDxRegistrService;
import com.cybertester.service.testCalc.TestCalcResultService;
import com.cybertester.service.testCalc.TestCalcCheckListService;
import com.cybertester.utils.CalcUtility;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class TestComponent {

    private final TestCalcResultService testCalcResultService;
    private final StandardCalcResultService standardCalcResultService;
    private final StandardDxRegistrService standardDxRegistrService;
    private final TestCalcCheckListService testCalcCheckListService;
    private final PvsoManagers pvsoManagers;
    private final CalcUtility calcUtility;
    private final RecalcDocs recalcDocs;

    public TestComponent(StandardCalcResultService standardCalcResultService, TestCalcResultService testCalcResultService,
                         StandardDxRegistrService standardDxRegistrService, TestCalcCheckListService testCalcCheckListService, PvsoManagers pvsoManagers, CalcUtility calcUtility, RecalcDocs recalcDocs) {
        this.standardCalcResultService = standardCalcResultService;
        this.testCalcResultService = testCalcResultService;
        this.standardDxRegistrService = standardDxRegistrService;
        this.testCalcCheckListService = testCalcCheckListService;
        this.pvsoManagers = pvsoManagers;
        this.calcUtility = calcUtility;
        this.recalcDocs = recalcDocs;
    }


    @PostConstruct
    public void test() throws IOException {
        System.out.println("Start");

        TestCalcCheckListEntity testCalcCheckListEntity = new TestCalcCheckListEntity();
        testCalcCheckListEntity.setDoCheck(1);
        testCalcCheckListEntity.setId(24);
        testCalcCheckListEntity.setCalcResult(1);
        testCalcCheckListEntity.setCheckDate("04.08.2022");
        testCalcCheckListEntity.setGuidInput("333");
        testCalcCheckListEntity.setMessage("Hello");
        testCalcCheckListEntity.setRecordUqRegistr(121212);


//calcUtility.goCalcCheckList();

//        System.out.println(testCalcCheckListService.findDocsWithPaginationAndSort(2, 1, "id", "asc").getContent());

//        calcUtility.addListRecordUqStringToCalcCheckList("124107991,124107990");

//        calcUtility.goCalcCheckList();
        System.out.println("End");
    }
}
