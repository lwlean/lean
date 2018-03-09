package com.lean.controller;

import com.lean.domain.Expenses;
import com.lean.exception.ErrorEnum;
import com.lean.service.ExpensesService;
import com.lean.util.ResultObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by llw on 2018/3/6.
 */
@RestController
@RequestMapping(value = "expenses")
public class ExpensesController {

    private Logger logger = LoggerFactory.getLogger(ExpensesController.class);

    @Autowired
    private ExpensesService expensesService;

    @PostMapping("addExpenses")
    public ResultObject addExpenses(@RequestBody Expenses expenses) {
        logger.info("add exprenses of amount:{} on date:{}",expenses.getAmount(), expenses.getTime());
        if (expenses.getAmount() == null) return new ResultObject(ErrorEnum.PARAMETERS_ERROR);
        expensesService.addExpenses(expenses);
        return new ResultObject();
    }

    @GetMapping("queryExpensesAll")
    public ResultObject queryExpensesAll() {
        logger.info("query all expenses");
        final List<Expenses> expenses = expensesService.queryExpenses(new Expenses());
        return new ResultObject(expenses);
    }

}
