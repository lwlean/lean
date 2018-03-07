package com.lean.mapper;

import com.lean.domain.Expenses;

public interface ExpensesMapper {

    void addExpenses(Expenses expenses);

    Expenses queryExpenses(Expenses expenses);

    int updateExpenses(Expenses expenses);

    int deleteExpenses(Expenses expenses);

}
