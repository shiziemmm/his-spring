package cn.gson.hisspring.model.utli;

import lombok.Data;

@Data
public class CustomError extends RuntimeException {
    //异常错误编码
    private int code;
    //异常信息
    private String message;

    public CustomError() {
    }

    public CustomError(CustomErrorType exceptionTypeEnum, String message) {
        this.code = exceptionTypeEnum.getCode();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
