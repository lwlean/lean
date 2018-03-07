package com.lean.service;

import com.lean.domain.Expenses;

public interface ExpensesService {

    void addExpenses(Expenses expenses);

    Expenses queryExpenses(Expenses expenses);

    int updateExpenses(Expenses expenses);

    int deleteExpenses(Expenses expenses);

}
