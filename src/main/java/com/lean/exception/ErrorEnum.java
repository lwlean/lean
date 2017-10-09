package com.lean.exception;

/**
 * Created by llw on 2017/10/1.
 */
public enum ErrorEnum {

    SUCCESS(0, "调用成功"),
    SERVER_ERROR(10000, "服务器错误"),
    PARAMETERS_ERROR(1001, "参数传入错误"),
    FILED_TYPE_MATCH_ERROR(1002,"参数类型匹配错误"),
    RESTTEMPLATE_ERROR(1003,"调用接口错误"),
    RESULT_EXIST_ERROR(1004,"結果已存在");

    private Integer code;

    private String message;

    ErrorEnum(Integer code, String message) {
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
