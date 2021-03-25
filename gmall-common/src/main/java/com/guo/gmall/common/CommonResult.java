package com.guo.gmall.common;

/**
 * @Date: 2021/3/25 21:39
 * @Author 郭乐建
 * @Since JDK 1.8
 * @Description:
 */
public class CommonResult {
    private Integer code;

    private String message;

    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    // 默认构造器 必须加不然 jackson报错
    public CommonResult() {}

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public CommonResult(Integer code, Object data) {
        this(code, null, data);
    }

    public CommonResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static CommonResult success(Object data) {
        return new CommonResult(0, data);
    }

    public static CommonResult error(String message, Object data) {
        return new CommonResult(1, message, data);
    }

    public static CommonResult error(String message) {
        return CommonResult.error(message, null);
    }

    public static CommonResult error(Object data) {
        return new CommonResult(1, null, data);
    }
}
