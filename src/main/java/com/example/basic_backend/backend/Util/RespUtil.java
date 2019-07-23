package com.example.basic_backend.backend.Util;

import com.example.basic_backend.backend.Bussniss_logic.Entity.Response.Resp;

/**
 * @程志豪 时间：2019 07 22 15:05
 * 邮箱：k2160789@163.com
 * 描述：{返回信息工具类}
 **/
public class RespUtil {
    public static Resp successResp(){
        Resp resp = new Resp();
        resp.setError_code(200);
        resp.setError_message("请求成功");
        return resp;
    }

    public static<T> Resp<T> successResp (T data){
        Resp resp = new Resp();
        resp.setData(data);
        resp.setError_code(200);
        resp.setError_message("请求成功");
        return resp;
    }


    public static Resp errorResp(Integer errorCode,String errorMsg){
        Resp resp = new Resp();
        resp.setError_code(errorCode);
        resp.setError_message(errorMsg);
        return resp;
    }
}
