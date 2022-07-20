package com.cybertester.utils;

import com.cybertester.entity.standardCalc.StandardCalcResultEntity;
import com.cybertester.entity.standardCalc.StandardDxRegistrEntity;
import com.cybertester.entity.testCalc.TestCalcResultEntity;
import com.cybertester.entity.testCalc.TestDocsListEntity;
import com.cybertester.service.standardCalc.StandardCalcResultService;
import com.cybertester.service.standardCalc.StandardDxRegistrService;
import com.cybertester.service.testCalc.TestCalcResultService;
import com.cybertester.service.testCalc.TestDocsListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalcUtility {

    private final TestCalcResultService testCalcResultService;
    private final StandardCalcResultService standardCalcResultService;
    private final StandardDxRegistrService standardDxRegistrService;
    private final TestDocsListService testDocsListService;

    public CalcUtility(TestCalcResultService testCalcResultService, StandardCalcResultService standardCalcResultService, StandardDxRegistrService standardDxRegistrService, TestDocsListService testDocsListService) {
        this.testCalcResultService = testCalcResultService;
        this.standardCalcResultService = standardCalcResultService;
        this.standardDxRegistrService = standardDxRegistrService;
        this.testDocsListService = testDocsListService;
    }

    // Получаем RECORD_UQ по GUID_INPUT из ПВСО БД
//    public long getRecordUq(String guidInput) {
//        return standardDxRegistrService.getFirstByGuidInput(guidInput).getRecordUq();
//    }

    //     Сохраняем результаты расчета из ПВСО БД в тестовую БД
    public void saveCalcResultByRecordUqRegistr(long recordUqRegistr) {


        if (testCalcResultService.getFirstByRecordUqRegistr(recordUqRegistr) != null) {
            System.out.println("\nРезультат будет перезаписан");
            deleteAllTestCalcResultByRecordUqRegistr(recordUqRegistr);
        }
        for (StandardCalcResultEntity s : standardCalcResultService.getAllByRecordUqRegister(recordUqRegistr)) {
            TestCalcResultEntity t = new TestCalcResultEntity();
            t.setRecordUq(s.getRecordUq());
            t.setPeriodBegDay(s.getPeriodBegDay());
            t.setPeriodEndDay(s.getPeriodEndDay());
            t.setPrice(s.getPrice());
            t.setRecordUqRegistr(s.getRecordUqRegister());
            t.setPeriodPercent(s.getPeriodPercent());
            t.setPricesPercent(s.getPricesPercent());
            t.setCountDays(s.getCountDays());
            t.setSumma(s.getSumma());
            t.setRecordUqAlceType(s.getRecordUqAlceType());
            t.setRecordUqBCC(s.getRecordUqBCC());
            t.setYearCalc(s.getYearCalc());
            System.out.println("\nДобавлена новая запись");
            System.out.println(s);
            testCalcResultService.create(t);
        }
    }

    boolean equalsCalcResult(TestCalcResultEntity calcT, StandardCalcResultEntity calcS) {

        if (calcT == null || calcS == null) {
            return false;
        }

        return Double.compare(calcT.getPrice(), calcS.getPrice()) == 0 &&
                calcT.getRecordUqRegistr() == calcS.getRecordUqRegister() &&
                calcT.getPeriodPercent() == calcS.getPeriodPercent() &&
                Double.compare(calcT.getPricesPercent(), calcS.getPricesPercent()) == 0 &&
                Double.compare(calcT.getCountDays(), calcS.getCountDays()) == 0 &&
                Double.compare(calcT.getSumma(), calcS.getSumma()) == 0 &&
                calcT.getRecordUqAlceType() == calcS.getRecordUqAlceType() &&
                calcT.getRecordUqBCC() == calcS.getRecordUqBCC() &&
                calcT.getYearCalc() == calcS.getYearCalc() &&
                calcT.getPeriodBegDay().equals(calcS.getPeriodBegDay()) &&
                calcT.getPeriodEndDay().equals(calcS.getPeriodEndDay());

    }

    public String comparisonCalcResultByRecordUqRegistr(long recordUqRegistr) {

        String result = "";

        // Получаем список результатов расчета по RECORD_UQ_REGISTR
        List<StandardCalcResultEntity> calcS = standardCalcResultService.getAllByRecordUqRegister(recordUqRegistr);

        // Получаем список сохраненных результатов расчетов
        List<TestCalcResultEntity> calcT = testCalcResultService.getAllByRecordUqRegistr(recordUqRegistr);

        // Количество записей
        int coincidenceCount = calcT.size();

        boolean correct = false;

        // Сравниваем количество записей результатов. Если не равны, сразу фолс.
        if (calcS.size() != calcT.size()) {
            result += "В документе RECORD_UQ = " + recordUqRegistr + " не совпвдвет количество строк с эталонным расчетом";
        } else {
            for (TestCalcResultEntity t : calcT) {

                for (int i = 0; i < calcS.size(); i++) {

                    if (equalsCalcResult(t, calcS.get(i))) {

                        coincidenceCount--;
                        correct = true;
                    }
                }
                if (!correct) {
                    if (result.equals("")) {
                        result += "В документе RECORD_UQ = " + recordUqRegistr + " " + " не совпадают данные строки: " + t;
                    } else {
                        result += "\n" + "В документе RECORD_UQ = " + recordUqRegistr + " " + " не совпадают данные строки: " + t;
                    }
                }
                correct = false;
            }
            if (coincidenceCount == 0) {
                result += "Документ RECORD_UQ = " + recordUqRegistr + " расчет верный";
            }
        }
        return result;
    }

    // Удаляем все записи по RECORD_UQ_REGISTR и возвращаем количество удаленных записей
    public void deleteAllTestCalcResultByRecordUqRegistr(long recordUqRegistr) {
        int count = 0;
        List<TestCalcResultEntity> testCalcResultEntityList = testCalcResultService.getAllByRecordUqRegistr(recordUqRegistr);
        for (TestCalcResultEntity t : testCalcResultEntityList) {
            count += testCalcResultService.delete(t.getId());
        }
        System.out.println("\nУдалено " + count + " записей");
    }

    public void createDocByRecordUqRegistr(long recordUqRegistr) {

        TestDocsListEntity tDocs = new TestDocsListEntity();

        StandardDxRegistrEntity s = standardDxRegistrService.getByRecordUq(recordUqRegistr);
    }
}
