package repository;

import model.Expenses;

public interface UserRepository {

    Expenses getExpenses(Expenses expenses);

    Expenses addExpenses(Expenses expenses);

    Expenses updateExpenses(Expenses expenses);

    Expenses deleteExpenses(Expenses expenses);

}
