package com.cybertester.utils;

import com.cybertester.entity.standardCalc.StandardCalcResultEntity;
import com.cybertester.entity.standardCalc.StandardDxRegistrEntity;
import com.cybertester.entity.testCalc.TestCalcCheckListEntity;
import com.cybertester.entity.testCalc.TestCalcResultEntity;
import com.cybertester.service.standardCalc.StandardCalcResultService;
import com.cybertester.service.standardCalc.StandardDxRegistrService;
import com.cybertester.service.testCalc.TestCalcResultService;
import com.cybertester.service.testCalc.TestCalcCheckListService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CalcUtility {

    private final TestCalcResultService testCalcResultService;
    private final StandardCalcResultService standardCalcResultService;
    private final StandardDxRegistrService standardDxRegistrService;
    private final TestCalcCheckListService testCalcCheckListService;

    public CalcUtility(TestCalcResultService testCalcResultService, StandardCalcResultService standardCalcResultService, StandardDxRegistrService standardDxRegistrService, TestCalcCheckListService testCalcCheckListService) {
        this.testCalcResultService = testCalcResultService;
        this.standardCalcResultService = standardCalcResultService;
        this.standardDxRegistrService = standardDxRegistrService;
        this.testCalcCheckListService = testCalcCheckListService;
    }

    // Получаем RECORD_UQ по GUID_INPUT из ПВСО БД
//    public long getRecordUq(String guidInput) {
//        return standardDxRegistrService.getFirstByGuidInput(guidInput).getRecordUq();
//    }

    //     Сохраняем результаты расчета из ПВСО БД в тестовую БД
    public void saveCalcResultByRecordUqRegistr(long recordUqRegistr) {

        List<TestCalcResultEntity> testCalcList = new ArrayList<>();

        if (testCalcResultService.getFirstByRecordUqRegistr(recordUqRegistr) != null) {
            System.out.println("\nРезультат будет перезаписан");
            deleteAllTestCalcResultByRecordUqRegistr(recordUqRegistr);
        }
        for (StandardCalcResultEntity s : standardCalcResultService.getAllByRecordUqRegistr(recordUqRegistr)) {
            TestCalcResultEntity t = new TestCalcResultEntity();
            t.setRecordUq(s.getRecordUq());
            t.setPeriodBegDay(s.getPeriodBegDay());
            t.setPeriodEndDay(s.getPeriodEndDay());
            t.setPrice(s.getPrice());
            t.setRecordUqRegistr(s.getRecordUqRegistr());
            t.setPeriodPercent(s.getPeriodPercent());
            t.setPricesPercent(s.getPricesPercent());
            t.setCountDays(s.getCountDays());
            t.setSumma(s.getSumma());
            t.setRecordUqAlceType(s.getRecordUqAlceType());
            t.setRecordUqBCC(s.getRecordUqBCC());
            t.setYearCalc(s.getYearCalc());
            t.setCreateDate(new Date());
            System.out.println("\nДобавлена новая запись");
            System.out.println(s);
            testCalcList.add(t);
        }
        testCalcResultService.saveAll(testCalcList);
    }

    boolean equalsCalcResult(TestCalcResultEntity calcT, StandardCalcResultEntity calcS) {

        if (calcT == null || calcS == null) {
            return false;
        }

        return Double.compare(calcT.getPrice(), calcS.getPrice()) == 0 &&
                calcT.getRecordUqRegistr() == calcS.getRecordUqRegistr() &&
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

    public void comparisonCalcResultByCheckListElement(TestCalcCheckListEntity checkListElement) {

        TestCalcCheckListEntity checkListEl = checkListElement;

        String result = "";

        // Получаем список результатов расчета по RECORD_UQ_REGISTR
        List<StandardCalcResultEntity> calcS = standardCalcResultService.getAllByRecordUqRegistr(checkListElement.getRecordUqRegistr());

        // Получаем список сохраненных результатов расчетов
        List<TestCalcResultEntity> calcT = testCalcResultService.getAllByRecordUqRegistr(checkListElement.getRecordUqRegistr());

        // Количество записей
        int coincidenceCount = 0;

        boolean correct = false;

        // Сравниваем количество записей результатов. Если не равны, сразу фолс.
        if (calcS.size() != calcT.size()) {
            result += "В документе RECORD_UQ = " + checkListEl.getRecordUqRegistr() + " не совпадает количество строк с сохраненным расчетом";
            checkListEl.setCalcResult(0);
        } else {
            for (TestCalcResultEntity t : calcT) {

                for (int i = 0; i < calcS.size(); i++) {

                    if (equalsCalcResult(t, calcS.get(i))) {

                        coincidenceCount++;
                        correct = true;
                        break;
                    }
                }
                if (!correct) {
                    result += "\nВ документе RECORD_UQ = " + checkListEl.getRecordUqRegistr() + " " + " не совпадают строки: " + t;
                }
                correct = false;
                checkListEl.setCalcResult(0);
            }
            if (coincidenceCount == calcT.size()) {
                result += "\nДокумент RECORD_UQ = " + checkListEl.getRecordUqRegistr() + " расчет верный";
                checkListEl.setCalcResult(1);
            }
        }
        checkListEl.setMessage(result);

        // Дата запуска сравнения
        String checkDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss"));

        checkListEl.setCheckDate(checkDate);

        testCalcCheckListService.update(checkListEl, checkListEl.getId());
    }

    // Удаляем все записи результатов расчетов из тестовой БД по RECORD_UQ_REGISTR
    public void deleteAllTestCalcResultByRecordUqRegistr(long recordUqRegistr) {
        int count = 0;
        List<TestCalcResultEntity> testCalcResultEntityList = testCalcResultService.getAllByRecordUqRegistr(recordUqRegistr);
        for (TestCalcResultEntity t : testCalcResultEntityList) {
            count += 1;
            testCalcResultService.delete(t.getId());
        }
        System.out.println("\nУдалено " + count + " записей");
    }

    public void saveCalcResult(long recordUqRegistr) {
        testCalcResultService.deleteAllByRecordUqRegistr(recordUqRegistr);
    }


    // Добавляе в чек личт элемнт из DX_REGISTR по RECORD_UQ
    public void addDocToCalcCheckList(long recordUqRegistr) {

        StandardDxRegistrEntity sDxRegistr = standardDxRegistrService.getByRecordUq(recordUqRegistr);

        if (sDxRegistr == null) {
            System.out.println("Запись record_uq = '" + recordUqRegistr + "' не найдена");
        } else {
            TestCalcCheckListEntity tc = new TestCalcCheckListEntity();
            tc.setRecordUqRegistr(recordUqRegistr);
            tc.setGuidInput(sDxRegistr.getGuidInput());
            tc.setDoCheck(1);

            TestCalcCheckListEntity t = testCalcCheckListService.getFirstByRecordUqRegistr(recordUqRegistr);

            if (t != null) {
                testCalcCheckListService.delete(t.getId());
            }

            testCalcCheckListService.create(tc);

            saveCalcResultByRecordUqRegistr(recordUqRegistr);
        }
    }

    // Берем элемнты из чек листа с признаком doCheck = 1 и проверяем их
    public void goCalcCheckList() {

        List<TestCalcCheckListEntity> checkList = testCalcCheckListService.getAllByDoCheck(1);
        for (TestCalcCheckListEntity cElement : checkList) {
            if (cElement.getDoCheck() == 1)
                comparisonCalcResultByCheckListElement(cElement);
        }
    }

    // Получаем список документов из DX_REGISTR, преобразуем строку String в массив long
    public long[] convertStringRecordUqRegistrToArr(String recordUqRegistr){

        String[] StringRecordUqRegistrArr = recordUqRegistr.split(",");
        long[] longStringRecordUqRegistrArr = new long[StringRecordUqRegistrArr.length];
        for (int i = 0; i <StringRecordUqRegistrArr.length; i++){
            longStringRecordUqRegistrArr[i] = Long.parseLong(StringRecordUqRegistrArr[i]);
        }
        return longStringRecordUqRegistrArr;
    }

    // Добавляем доки в чек лист из списка по RECORD_UQ_REGISTR
    public void addListRecordUqStringToCalcCheckList(String listRecordUq){

        long[] recordUqArr = convertStringRecordUqRegistrToArr(listRecordUq);

        for (long recordUq : recordUqArr){
            addDocToCalcCheckList(recordUq);
        }
    }
}
