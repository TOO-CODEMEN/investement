package com.too_codemen.application.controller;

import com.too_codemen.application.calculations.Results;
import com.too_codemen.application.model.Expenses;
import com.too_codemen.application.service.ExpensesServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {

    @Autowired
    private  ExpensesServiceImpl expensesService;

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
    public ResponseEntity<Expenses> addExpenses(@RequestBody Expenses expenses) {
        Expenses createdExpenses = expensesService.addExpenses(expenses);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExpenses);
    }

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

