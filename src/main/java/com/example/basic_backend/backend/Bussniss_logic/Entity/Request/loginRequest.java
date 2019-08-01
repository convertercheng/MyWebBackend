package com.example.basic_backend.backend.Bussniss_logic.Entity.Request;

import com.google.gson.Gson;
import lombok.Data;

/**
 * @程志豪 时间：2019 07 31 15:56
 * 邮箱：k2160789@163.com
 * 描述：{desp}
 **/
@Data
public class loginRequest {

    public static final int WEI_XIN = 1;
    public static final int WEB =2;
    private  static Gson gson = new Gson();

    private String username;
    private Integer source;


    public loginRequest(String username, Integer source) {
        this.username = username;
        this.source = source;
    }

    public static loginRequest wxLogin(String username){
        return new loginRequest(username, WEI_XIN);
    }

    public static loginRequest webLogin(String username){
        return new loginRequest(username, WEB);
    }

    public String toJson(){
        return gson.toJson(this);
    }

    public static loginRequest fromJson(String json){
        return gson.fromJson(json, loginRequest.class);
    }
}
