package org.sc.service.myb.util;


import java.util.List;

import org.sc.service.myb.enums.ResultEnum;


public class ResultUtil {

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(ResultEnum resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }

    public static Result error(int code,String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    /**
     * 分页查询成功
     * @param count
     * @param object
     * @return
     */
    public static PageUtil success(long count,Object object){
        PageUtil pageUtil=new PageUtil();
        pageUtil.setCode(ResultEnum.SUCCESS.getCode());
        pageUtil.setMsg(ResultEnum.SUCCESS.getMsg());
        pageUtil.setCount(count);
        pageUtil.setData(object);
        return pageUtil;
    }

    public static Result success(int code,String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static PageUtil error(){
        PageUtil pageUtil=new PageUtil();
        pageUtil.setCode(ResultEnum.FIND_ERROR.getCode());
        pageUtil.setMsg(ResultEnum.FIND_ERROR.getMsg());
        return pageUtil;
    }
}
