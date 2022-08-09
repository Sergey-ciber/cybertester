package com.cybertester.controllers;

import com.cybertester.components.CalcAPIResponse;
import com.cybertester.entity.testCalc.TestCalcCheckListEntity;
import com.cybertester.service.testCalc.TestCalcCheckListService;
import com.cybertester.utils.CalcUtility;
import org.springframework.data.domain.Page;
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
    public CalcAPIResponse<List<TestCalcCheckListEntity>> checkDocs() {

        calcUtility.goCalcCheckList();
        final List<TestCalcCheckListEntity> testCalcCheckListEntitiesList = testCalcCheckListService.findAllByOrderByIdAsc();

        return testCalcCheckListEntitiesList != null && !testCalcCheckListEntitiesList.isEmpty()
                ? new CalcAPIResponse<>(testCalcCheckListEntitiesList.size(), testCalcCheckListEntitiesList, HttpStatus.OK)
                : new CalcAPIResponse<>(0, null, HttpStatus.NOT_FOUND);
    }

    // Добавляем документы в список
    @GetMapping("/addDocs")
    public CalcAPIResponse<List<TestCalcCheckListEntity>> addDoc(@RequestParam("recordUqDocs") String recordUqDocs) {
        calcUtility.addListRecordUqStringToCalcCheckList(recordUqDocs);
        final List<TestCalcCheckListEntity> testCalcCheckListEntitiesList = testCalcCheckListService.findAllByOrderByIdAsc();

        return testCalcCheckListEntitiesList != null && !testCalcCheckListEntitiesList.isEmpty()
                ? new CalcAPIResponse<>(testCalcCheckListEntitiesList.size(), testCalcCheckListEntitiesList, HttpStatus.OK)
                : new CalcAPIResponse<>(0, null, HttpStatus.NOT_FOUND);
    }


    // Обновляем документ
    @PostMapping(value = "/update/{id}")
    public CalcAPIResponse<List<TestCalcCheckListEntity>> update(@PathVariable(name = "id") long id,
                                                                 @RequestBody TestCalcCheckListEntity testCalcCheckListEntity) {
        testCalcCheckListService.update(testCalcCheckListEntity, id);

        final List<TestCalcCheckListEntity> testCalcCheckListEntitiesList = testCalcCheckListService.findAllByOrderByIdAsc();

        return testCalcCheckListEntitiesList != null && !testCalcCheckListEntitiesList.isEmpty()
                ? new CalcAPIResponse<>(testCalcCheckListEntitiesList.size(), testCalcCheckListEntitiesList, HttpStatus.OK)
                : new CalcAPIResponse<>(0, null, HttpStatus.NOT_FOUND);
    }

    // Удаляем документ
    @DeleteMapping("/delete/{id}")
    public CalcAPIResponse<List<TestCalcCheckListEntity>> delete(@PathVariable(name = "id") long id) {
        testCalcCheckListService.delete(id);

        final List<TestCalcCheckListEntity> testCalcCheckListEntitiesList = testCalcCheckListService.findAllByOrderByIdAsc();

        return testCalcCheckListEntitiesList != null && !testCalcCheckListEntitiesList.isEmpty()
                ? new CalcAPIResponse<>(testCalcCheckListEntitiesList.size(), testCalcCheckListEntitiesList, HttpStatus.OK)
                : new CalcAPIResponse<>(0, null, HttpStatus.NOT_FOUND);
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
        List<TestCalcCheckListEntity> docList = testCalcCheckListService.findDocsWithPaginationAndSort(
                pageSize, offset, field, sort).getContent();


        return docList != null && !docList.isEmpty()
                ? new CalcAPIResponse<>(testCalcCheckListService.getAll().size(), docList, HttpStatus.OK)
                : new CalcAPIResponse<>(0, null, HttpStatus.NOT_FOUND);
    }
}
