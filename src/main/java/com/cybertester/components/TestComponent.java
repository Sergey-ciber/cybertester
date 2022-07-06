package com.cybertester.components;

import com.cybertester.entity.standardCalc.StandardCalcResultEntity;
import com.cybertester.entity.testCalc.TestCalcResultEntity;
import com.cybertester.repository.standardCalc.StandardCalcResultRepository;
import com.cybertester.service.standardCalc.StandardCalcResultService;
import com.cybertester.service.testCalc.TestCalcResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestComponent {

    private final TestCalcResultService testCalcResultService;
    private final StandardCalcResultService standardCalcResultService;

    public TestComponent(StandardCalcResultService standardCalcResultService, TestCalcResultService testCalcResultService) {
        this.standardCalcResultService = standardCalcResultService;
        this.testCalcResultService = testCalcResultService;
    }


    @PostConstruct
    public void test() {
        System.out.println("Start");
        TestCalcResultEntity t = new TestCalcResultEntity();
        t.setRe
        t.setPeriodBegDay("01.01.2022");
        t.setPeriodEndDay("10.01.2022");
        t.setPrice(100.00);
        t.setRecordUQRegister(123);
        t.setPeriodPercent(100);
        t.setPricesPercent(100.00);
        t.setCountDays(7.0);
        t.setSumma(7000.00);
        t.setRecordUqAlceType(123);
        t.setRecordUqBCC(123131232);
        t.setYearCalc(2022);
        testCalcResultService.create(t);
//        for(StandardCalcResultEntity s : standardCalcResultService.getAllByRecordUQRegister(124113461)){
//            testCalcResultService.create(new TestCalcResultEntity(s.getPeriodBegDay(), s.getPeriodEndDay(), s.getPrice(),
//                    s.getRecordUQRegister(), s.getPeriodPercent(), s.getPricesPercent(), s.getCountDays(), s.getSumma(),
//                    s.getRecordUqAlceType(), s.getRecordUqBCC(), s.getYearCalc()));
//        }
        System.out.println("End");
    }
}
