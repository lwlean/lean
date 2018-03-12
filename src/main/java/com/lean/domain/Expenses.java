package com.lean.domain;


import java.math.BigDecimal;
import java.sql.Timestamp;

public class Expenses {

    // 消费金额
    private BigDecimal amount;

    // 消费类型
    private String type;

    // 消费时间
    private Timestamp time;

    // 记录时间
    private Timestamp currentTime;

    // 消费内容
    private String content;

    // 消费总金额
    private BigDecimal totalAmount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Timestamp getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Timestamp currentTime) {
        this.currentTime = currentTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
