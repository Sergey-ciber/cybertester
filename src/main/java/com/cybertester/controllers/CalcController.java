package com.cybertester.controllers;

import com.cybertester.components.CalcAPIResponse;
import com.cybertester.entity.testCalc.TestCalcCheckListEntity;
import com.cybertester.seleniumTests.RecalcDocs;
import com.cybertester.service.testCalc.TestCalcCheckListService;
import com.cybertester.utils.CalcUtility;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/calc")
@CrossOrigin
public class CalcController {

    final private RecalcDocs recalcDocs;
    final private CalcUtility calcUtility;
    final private TestCalcCheckListService testCalcCheckListService;

    public CalcController(RecalcDocs recalcDocs, CalcUtility calcUtility, TestCalcCheckListService testCalcCheckListService) {
        this.recalcDocs = recalcDocs;
        this.calcUtility = calcUtility;
        this.testCalcCheckListService = testCalcCheckListService;
    }

    private CalcAPIResponse<List<TestCalcCheckListEntity>> getDocsWithPaginationAndSortNew(
            String field, String sort, int pageSize, int offset) {

        List<TestCalcCheckListEntity> docList = testCalcCheckListService.findDocsWithPaginationAndSort(
                pageSize, offset, field, sort).getContent();

        return docList != null && !docList.isEmpty()
                ? new CalcAPIResponse<>(testCalcCheckListService.getAll().size(), docList, HttpStatus.OK)
                : new CalcAPIResponse<>(0, null, HttpStatus.NOT_FOUND);
    }

    // Получаем все документы без сортировки
    @GetMapping
    public CalcAPIResponse<List<TestCalcCheckListEntity>> getAllDocs() {

        final List<TestCalcCheckListEntity> testCalcCheckListEntitiesList = testCalcCheckListService.findAllByOrderByIdAsc();

        return testCalcCheckListEntitiesList != null && !testCalcCheckListEntitiesList.isEmpty()
                ? new CalcAPIResponse<>(testCalcCheckListEntitiesList.size(), testCalcCheckListEntitiesList, HttpStatus.OK)
                : new CalcAPIResponse<>(0, null, HttpStatus.NOT_FOUND);
    }

    //     Получаем отсортированный список документов
    @GetMapping("/sort")
    public CalcAPIResponse<List<TestCalcCheckListEntity>> getDocListWithSort(@RequestParam("field") String field,
                                                                             @RequestParam("sort") String sort) {

        final List<TestCalcCheckListEntity> testCalcCheckListEntitiesList = testCalcCheckListService.findAllWithSort(field, sort);

        return testCalcCheckListEntitiesList != null && !testCalcCheckListEntitiesList.isEmpty()
                ? new CalcAPIResponse<>(testCalcCheckListEntitiesList.size(), testCalcCheckListEntitiesList, HttpStatus.OK)
                : new CalcAPIResponse<>(0, null, HttpStatus.NOT_FOUND);
    }


    // Проверяем результаты расчетов
    @GetMapping("/checkDocs")
    public CalcAPIResponse<List<TestCalcCheckListEntity>> checkDocs(@RequestParam("field") String field,
                                                                    @RequestParam("sort") String sort,
                                                                    @RequestParam("pageSize") int pageSize,
                                                                    @RequestParam("offset") int offset
    ) throws IOException {
        recalcDocs.recalcDocs();
        calcUtility.goCalcCheckList();

        return getDocsWithPaginationAndSortNew(field, sort, pageSize, offset);
    }

    // Обновляем результаты расчетов
    @GetMapping("/updateCalcResult")
    public String updateCalcResult(@RequestParam("recordUQ") long recordUQ) {

        calcUtility.saveCalcResultByRecordUqRegistr(recordUQ);
        return "OK";
    }

    // Добавляем документы в список
    @GetMapping("/addDocs")
    public CalcAPIResponse<List<TestCalcCheckListEntity>> addDoc(@RequestParam("recordUqDocs") String recordUqDocs,
                                                                 @RequestParam("field") String field,
                                                                 @RequestParam("sort") String sort,
                                                                 @RequestParam("pageSize") int pageSize,
                                                                 @RequestParam("offset") int offset) {

        calcUtility.addListRecordUqStringToCalcCheckList(recordUqDocs);
        return getDocsWithPaginationAndSortNew(field, sort, pageSize, offset);
    }


    // Обновляем документ
    @PostMapping(value = "/update/{id}")
    public CalcAPIResponse<List<TestCalcCheckListEntity>> update(@PathVariable(name = "id") long id,
                                                                 @RequestBody TestCalcCheckListEntity testCalcCheckListEntity,
                                                                 @RequestParam("field") String field,
                                                                 @RequestParam("sort") String sort,
                                                                 @RequestParam("pageSize") int pageSize,
                                                                 @RequestParam("offset") int offset) {

        testCalcCheckListService.update(testCalcCheckListEntity, id);

        return getDocsWithPaginationAndSortNew(field, sort, pageSize, offset);
    }

    // Удаляем документ
    @DeleteMapping("/delete/{id}")
    public CalcAPIResponse<List<TestCalcCheckListEntity>> delete(@PathVariable(name = "id") long id,
                                                                 @RequestParam("field") String field,
                                                                 @RequestParam("sort") String sort,
                                                                 @RequestParam("pageSize") int pageSize,
                                                                 @RequestParam("offset") int offset) {

        testCalcCheckListService.delete(id);
        return getDocsWithPaginationAndSortNew(field, sort, pageSize, offset);
    }

    @GetMapping("/pagination/{pageSize}/{offset}")
    public Page<TestCalcCheckListEntity> getDocsWithPagination(@PathVariable(name = "offset") int offset,
                                                               @PathVariable(name = "pageSize") int pageSize) {

        Page<TestCalcCheckListEntity> docPage = testCalcCheckListService.findDocsWithPagination(pageSize, offset);

        return docPage;
    }

    // Получаем отсортированный список документов постранично
    @GetMapping("pagination/sort")
    public CalcAPIResponse<List<TestCalcCheckListEntity>> findDocsWithPaginationAndSort(@RequestParam("field") String field,
                                                                                        @RequestParam("sort") String sort,
                                                                                        @RequestParam("pageSize") int pageSize,
                                                                                        @RequestParam("offset") int offset
    ) {
        return getDocsWithPaginationAndSortNew(field, sort, pageSize, offset);
    }
}
