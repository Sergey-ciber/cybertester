package com.cybertester.components;

import com.cybertester.managers.pvsoManagers.PvsoManagers;
import com.cybertester.service.standardCalc.StandardCalcResultService;
import com.cybertester.service.standardCalc.StandardDxRegistrService;
import com.cybertester.service.testCalc.TestCalcResultService;
import com.cybertester.utils.CalcUtility;
import org.springframework.stereotype.Component;

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

        calcUtility.comparisonCalcResult("E31091222CFCDD74E0530813E00AAEA8");

//        System.out.println(standardDxRegistrService.getGuid(124124901));
//
//        pvsoManagers.deleteDxRegistr("E32136B2A1AFBEA7E0530813E00AD6D0");
//
//        List<StandardCalcResultEntity> standardList = standardCalcResultService.getAllByRecordUQRegister(124123239);
//
//        System.out.println("В базе ПВСО найдено " + standardList.size() + " записей");

//        for(StandardCalcResultEntity s : standardCalcResultService.getAllByRecordUQRegister(124123239)) {
//            TestCalcResultEntity t = new TestCalcResultEntity();
//            t.setPeriodBegDay(s.getPeriodBegDay());
//            t.setPeriodEndDay(s.getPeriodEndDay());
//            t.setPrice(s.getPrice());
//            t.setRecordUQRegister(s.getRecordUQRegister());
//            t.setPeriodPercent(s.getPeriodPercent());
//            t.setPricesPercent(s.getPricesPercent());
//            t.setCountDays(s.getCountDays());
//            t.setSumma(s.getSumma());
//            t.setRecordUqAlceType(s.getRecordUqAlceType());
//            t.setRecordUqBCC(s.getRecordUqBCC());
//            t.setYearCalc(s.getYearCalc());
//            System.out.println("Добавлена новая запись");
//            System.out.println(s);
//            testCalcResultService.create(t);
//        }

//        for(StandardCalcResultEntity s : standardCalcResultService.getAllByRecordUQRegister(124123239)) {
//
//        t.setPeriodBegDay(s.getPeriodBegDay());
//        t.setPeriodEndDay(s.getPeriodEndDay());
//        t.setPrice(s.getPrice());
//        t.setRecordUQRegister(s.getRecordUQRegister());
//        t.setPeriodPercent(s.getPeriodPercent());
//        t.setPricesPercent(s.getPricesPercent());
//        t.setCountDays(s.getCountDays());
//        t.setSumma(s.getSumma());
//        t.setRecordUqAlceType(s.getRecordUqAlceType());
//        t.setRecordUqBCC(s.getRecordUqBCC());
//        t.setYearCalc(s.getYearCalc());
//            System.out.println("Добавилась одна запись");
//        testCalcResultService.create(t);
//        }
//            testCalcResultService.create(new TestCalcResultEntity(s.getPeriodBegDay(), s.getPeriodEndDay(), s.getPrice(),
//                    s.getRecordUQRegister(), s.getPeriodPercent(), s.getPricesPercent(), s.getCountDays(), s.getSumma(),
//                    s.getRecordUqAlceType(), s.getRecordUqBCC(), s.getYearCalc()));
//        }
        System.out.println("End");
    }
}
