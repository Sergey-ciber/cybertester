package com.cybertester.controllers;

import com.cybertester.entity.testCalc.TestCalcCheckListEntity;
import com.cybertester.service.testCalc.TestCalcCheckListService;
import com.cybertester.utils.CalcUtility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calc")
@CrossOrigin
public class CalcController {

    final private CalcUtility calcUtility;
    final private TestCalcCheckListService testCalcCheckListService;

    public CalcController(CalcUtility calcUtility, TestCalcCheckListService testCalcCheckListService) {
        this.calcUtility = calcUtility;
        this.testCalcCheckListService = testCalcCheckListService;
    }

    // Получаем весь список документов
    @GetMapping
    public ResponseEntity<List<TestCalcCheckListEntity>> getDocList() {
        final List<TestCalcCheckListEntity> testCalcCheckListEntities = testCalcCheckListService.findAllByOrderByIdAsc();

        return testCalcCheckListEntities != null && !testCalcCheckListEntities.isEmpty()
                ? new ResponseEntity<>(testCalcCheckListEntities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Проверяем результаты расчетов
    @GetMapping("/checkDocs")
    public ResponseEntity<List<TestCalcCheckListEntity>> checkDocs() {

        calcUtility.goCalcCheckList();
        final List<TestCalcCheckListEntity> testCalcCheckListEntities = testCalcCheckListService.findAllByOrderByIdAsc();

        return testCalcCheckListEntities != null && !testCalcCheckListEntities.isEmpty()
                ? new ResponseEntity<>(testCalcCheckListEntities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Добавляем документы в список
    @GetMapping("/addDocs")
    public ResponseEntity<List<TestCalcCheckListEntity>> addDoc(@RequestParam("recordUqDocs") String recordUqDocs) {
        calcUtility.addListRecordUqStringToCalcCheckList(recordUqDocs);
        final List<TestCalcCheckListEntity> testCalcCheckListEntities = testCalcCheckListService.findAllByOrderByIdAsc();

        return testCalcCheckListEntities != null && !testCalcCheckListEntities.isEmpty()
                ? new ResponseEntity<>(testCalcCheckListEntities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    // Обновляем документ
    @PostMapping(value = "/update/{id}")
    public ResponseEntity<List<TestCalcCheckListEntity>> update(@PathVariable(name = "id") long id,
                                                                @RequestBody TestCalcCheckListEntity testCalcCheckListEntity) {
        testCalcCheckListService.update(testCalcCheckListEntity, id);

        final List<TestCalcCheckListEntity> testCalcCheckListEntities = testCalcCheckListService.findAllByOrderByIdAsc();

        return testCalcCheckListEntities != null && !testCalcCheckListEntities.isEmpty()
                ? new ResponseEntity<>(testCalcCheckListEntities, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
