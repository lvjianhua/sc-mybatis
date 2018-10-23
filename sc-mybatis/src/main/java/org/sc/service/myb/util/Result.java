package org.sc.service.myb.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author alj
 * 公共返回数据类
 */
@Data
public class Result<T> implements Serializable {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体的内容. */
    private T data;
}
