package com.lean.mapper;

import com.lean.domain.Expenses;

import java.util.List;

public interface ExpensesMapper {

    void addExpenses(Expenses expenses);

    List<Expenses> queryExpenses(Expenses expenses);

    int updateExpenses(Expenses expenses);

    int deleteExpenses(Expenses expenses);

}
