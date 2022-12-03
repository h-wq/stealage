package com.xupt.stealage.common.result;

import lombok.Data;

@Data
public class JsonResult<T> {

    private Boolean isSuccess;
    private int code;
    private String msg;
    private T data;

    public static JsonResult success() {
        return success((Object)null);
    }

    public static <T> JsonResult<T> success(T data) {
        JsonResult<T> result = new JsonResult();
        result.setIsSuccess(true);
        result.setCode(0);
        result.setMsg("ok");
        result.setData(data);
        return result;
    }

    public static JsonResult fail(String msg) {
        return fail(-1, msg);
    }

    public static JsonResult fail(int code, String msg) {
        JsonResult result = new JsonResult();
        result.setIsSuccess(false);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public boolean isSuccess() {
        return Boolean.TRUE.equals(this.isSuccess);
    }
}
