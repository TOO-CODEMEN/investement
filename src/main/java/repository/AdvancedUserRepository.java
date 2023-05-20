package repository;

import model.Expenses;
import model.AdvancedUser;

public interface AdvancedUserRepository {

AdvancedUser getAdvancedUserById(AdvancedUser advancedUser);
Expenses getExpensesById(Expenses expenses);

AdvancedUser addAdvancedUser(AdvancedUser advancedUser);
AdvancedUser updateAdvancedUser(AdvancedUser advancedUser);
AdvancedUser deleteAdvancedUser(AdvancedUser advancedUser);

Expenses addExpenses(Expenses expenses);
Expenses updateExpenses(Expenses expenses);
Expenses deleteExpenses(Expenses expenses);

}
