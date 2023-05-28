package com.too_codemen.application.controller;

import com.too_codemen.application.calculations.Results;
import com.too_codemen.application.model.Expenses;
import com.too_codemen.application.pdf.AddTextToPdf;
import com.too_codemen.application.pdf.Convertor;
import com.too_codemen.application.service.ExpensesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {

    @Autowired
    private  ExpensesServiceImpl expensesService;

    private static final String PDF_FOLDER = "src\\main\\resources\\";

    @GetMapping
    public List<Expenses> getAllExpenses() {
        return expensesService.getAllExpenses();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Expenses> getExpensesById(@PathVariable Long id) {
        Expenses expenses = expensesService.getExpensesById(id);
        if (expenses != null) {
            return ResponseEntity.ok(expenses);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Results addExpenses(@RequestBody Expenses expenses) throws FileNotFoundException {
        expensesService.addExpenses(expenses);
        Results results = new Results();
        results.resultCount(expenses);
        results.getTypeOfORG(expenses);
        results.staffCount(expenses);
        results.realEstateCount(expenses);
        results.taxesCount(expenses);
        results.servicesCount(expenses);
        results.sumMedicineCount(expenses);
        results.sumPensionCount(expenses);

        AddTextToPdf addTextToPdf = new AddTextToPdf();
        addTextToPdf.addTextToPdf(results, expenses);
        Convertor convertor = new Convertor();
        convertor.convertor();

        return results;
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadPdf() throws IOException {

        try{
            String pdfFilePath = PDF_FOLDER + "results.pdf";

            // Создание объекта Resource для представления PDF-файла
            Resource resource = new FileSystemResource(pdfFilePath);

            if (resource.exists()) {
                // Проверка существования файла

                // Получение пути к файлу
                Path pdfPath = Paths.get(pdfFilePath);

                // Получение содержимого файла в виде массива байтов
                byte[] pdfContent = Files.readAllBytes(pdfPath);

                // Настройка заголовков ответа
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=отчет.pdf");

                // Возвращение ResponseEntity с содержимым PDF, заголовками и статусом ОК (200)
                return ResponseEntity.ok()
                        .headers(headers)
                        .contentType(MediaType.APPLICATION_PDF)
                        .contentLength(pdfContent.length)
                        .body(resource);
            } else {
                // Обработка случая, когда PDF-файл не найден
                return ResponseEntity.notFound().build();
            }
        } finally {

        }

    }



//    @GetMapping("/printResults")
//    public Results

//    @PutMapping("/{id}")
//    public ResponseEntity<Expenses> updateExpensesById(@PathVariable Long id, @RequestBody Expenses expenses) {
//        Expenses updatedExpenses = expensesService.updateExpensesById(id, expenses);
//        if (updatedExpenses != null) {
//            return ResponseEntity.ok(updatedExpenses);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteExpensesById(@PathVariable Long id) {
//        Expenses expenses = expensesService.deleteExpensesById(id);
//        if (expenses != null) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
}

