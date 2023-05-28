package com.too_codemen.application.service;

import com.too_codemen.application.model.Expenses;
import org.springframework.stereotype.Component;

@Component
public interface ExpensesService {
    Expenses getExpensesById(Long id);
    Expenses addExpenses(Expenses expenses);
    Expenses updateExpensesById(Long id, Expenses expenses);
    Expenses deleteExpensesById(Long id);
}
