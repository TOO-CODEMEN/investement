package com.too_codemen.application.repository;

import com.too_codemen.application.model.Expenses;

public interface ExpensesRepository {
    Expenses getExpensesById(Long id);
    Expenses addExpenses(Expenses expenses);
    Expenses updateExpensesById(Long id, Expenses expenses);
    Expenses deleteExpensesById(Long id);
}
