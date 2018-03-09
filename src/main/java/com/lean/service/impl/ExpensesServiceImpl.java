package com.lean.service.impl;

import com.lean.domain.Expenses;
import com.lean.mapper.ExpensesMapper;
import com.lean.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesServiceImpl implements ExpensesService{

    @Autowired
    private ExpensesMapper expensesMapper;

    @Override
    public void addExpenses(Expenses expenses) {
        expensesMapper.addExpenses(expenses);
    }

    @Override
    public List<Expenses> queryExpenses(Expenses expenses) {
        return expensesMapper.queryExpenses(expenses);
    }


    @Override
    public int updateExpenses(Expenses expenses) {
        return expensesMapper.updateExpenses(expenses);
    }

    @Override
    public int deleteExpenses(Expenses expenses) {
        return expensesMapper.deleteExpenses(expenses);
    }
}
