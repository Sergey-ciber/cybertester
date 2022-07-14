package com.cybertester.utils;

import com.cybertester.entity.standardCalc.StandardCalcResultEntity;
import com.cybertester.entity.testCalc.TestCalcResultEntity;
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

    // Получаем RECORD_UQ по GUID_INPUT из ПВСО БД
    public long getRecordUq(String guidInput) {
        return standardDxRegistrService.getFirstByGuidInput(guidInput).getRecordUq();
    }

    // Сохраняем результаты расчета из ПВСО БД в тестовую БД
//    public void saveCalcResult(long recordUqRegistr){
//        System.out.println(testCalcResultService.getFirstByRecordUqRegistr(recordUqRegistr));
//        if(testCalcResultService.getFirstByRecordUqRegistr(recordUqRegistr) != null) {
//            System.out.println("Результат будет перезаписан Да / Нет");
//            testCalcResultService.deleteAllByRecordUqRegistr(recordUqRegistr);
//        }
//            for (StandardCalcResultEntity s : standardCalcResultService.getAllByRecordUQRegister(recordUqRegistr)) {
//                TestCalcResultEntity t = new TestCalcResultEntity();
//                t.setRecordUq(s.getRecordUQ());
//                t.setPeriodBegDay(s.getPeriodBegDay());
//                t.setPeriodEndDay(s.getPeriodEndDay());
//                t.setPrice(s.getPrice());
//                t.setRecordUqRegistr(s.getRecordUQRegister());
//                t.setPeriodPercent(s.getPeriodPercent());
//                t.setPricesPercent(s.getPricesPercent());
//                t.setCountDays(s.getCountDays());
//                t.setSumma(s.getSumma());
//                t.setRecordUqAlceType(s.getRecordUqAlceType());
//                t.setRecordUqBCC(s.getRecordUqBCC());
//                t.setYearCalc(s.getYearCalc());
//                System.out.println("Добавлена новая запись");
//                System.out.println(s);
//                testCalcResultService.create(t);
//            }
//    }

    public boolean comparisonCalcResult(long recordUqRegistr) {

        // Получаем список результатов расчета по RECORD_UQ_REGISTR
        List<StandardCalcResultEntity> standardCalcResultEntityList = standardCalcResultService.getAllByRecordUqRegister(recordUqRegistr);

        // Получаем список сохраненных результатов расчетов
        List<TestCalcResultEntity> testCalcResultEntityList = testCalcResultService.getAllByRecordUq(recordUqRegistr);

        if(standardCalcResultEntityList.size() != testCalcResultEntityList.size()){
            return false;
        } else {
            
        }

        System.out.println(standardCalcResultEntityList);
        return true;
    }

}
