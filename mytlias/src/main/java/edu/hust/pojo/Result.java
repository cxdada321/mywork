package edu.hust.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public Result() {
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    //增删改 成功响应
    public static Result success() {
        return new Result(1, "success", null);
    }

    //查询 成功响应
    public static Result success(Object data) {
        return new Result(1, "success", data);
    }

    //失败响应
    public static Result error(String msg) {
        return new Result(0, msg, null);
    }


    /**
     * 获取
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 获取
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取
     * @return data
     */
    public Object getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "Result{code = " + code + ", msg = " + msg + ", data = " + data + "}";
    }
}
