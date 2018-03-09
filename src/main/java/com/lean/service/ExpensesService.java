package com.lean.service;

import com.lean.domain.Expenses;

import java.util.List;

public interface ExpensesService {

    void addExpenses(Expenses expenses);

    List<Expenses> queryExpenses(Expenses expenses);

    int updateExpenses(Expenses expenses);

    int deleteExpenses(Expenses expenses);

}
