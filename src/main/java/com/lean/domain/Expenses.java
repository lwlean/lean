package com.lean.domain;



import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Expenses {

    // 消费金额
    private BigDecimal amount;

    // 消费类型
    private String type;

    // 消费时间
    private Date time;

    // 记录时间
    private Date currentTime;

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
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
