package com.lean.controller;

import com.lean.domain.Expenses;
import com.lean.util.ResultObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by llw on 2018/3/6.
 */
@RestController
@RequestMapping(value = "expenses")
public class ExpensesController {

    private Logger logger = LoggerFactory.getLogger(ExpensesController.class);

    @PostMapping("addExpenses")
    public ResultObject addExpenses(@RequestBody Expenses expenses) {
        logger.info("add exprenses of amount:{} on date:{}",expenses.getAmount(), expenses.getTime());
        
        return new ResultObject();
    }

}
