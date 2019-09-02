package com.example.basic_backend.backend.Bussniss_logic.Entity.Response;

import com.google.gson.Gson;
import lombok.Data;

/**
 * @程志豪 时间：2019 07 22 15:03
 * 邮箱：k2160789@163.com
 * 描述：{desp}
 **/
@Data
public class Resp<T> {
    T data;
    Integer error_code;
    String error_message;

    public Resp (T data,Integer error_code,String error_message){
        this.data = data;
        this.error_code = error_code;
        this.error_message = error_message;
    }

    public Resp (Integer error_code,String error_message){
        this.data = null;
        this.error_code = error_code;
        this.error_message = error_message;
    }

    public Resp (){
    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
