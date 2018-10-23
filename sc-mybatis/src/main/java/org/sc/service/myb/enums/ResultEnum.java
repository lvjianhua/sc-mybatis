package org.sc.service.myb.enums;

/**
 * 提示信息枚举
 * 
 * @author lv
 *
 */
public enum ResultEnum {
    UNKNOWN_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    ERROR(1,"失败"),
    LOGIN_ERROR(2,"用户名或密码错误"),
    ADD_ERROR(3,"添加失败"),
    UPDATE_ERROR(4,"修改失败"),
    DELETE_ERROR(5,"删除失败"),
    FIND_ERROR(6,"查询无果，暂无信息"),
    ;

    private Integer code;//状态码

    private String msg;//获得提示信息

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}