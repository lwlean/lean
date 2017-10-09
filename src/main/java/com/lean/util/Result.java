package com.lean.util;

/**
 * Created by llw on 2017/10/1.
 */
public class Result {

    private Integer code;

    private String message;

    public Result() {
        this.code = 0;
        this.message = "success";
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
