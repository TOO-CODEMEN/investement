package com.too_codemen.application.service;

import com.too_codemen.application.model.Expenses;
import com.too_codemen.application.repository.ExpensesRepositoryImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpensesServiceImpl {
    @Autowired
    private ExpensesRepositoryImpl expensesRepositoryImpl;

    public Expenses getExpensesById(Long id) {
        return expensesRepositoryImpl.getExpensesById(id);
    }

    public Expenses addExpenses(Expenses expenses) {
        return expensesRepositoryImpl.addExpenses(expenses);
    }

    public Expenses updateExpensesById(Long id, Expenses expenses) {
        return expensesRepositoryImpl.updateExpensesById(id, expenses);
    }

    public Expenses deleteExpensesById(Long id) {
        return expensesRepositoryImpl.deleteExpensesById(id);
    }
}
