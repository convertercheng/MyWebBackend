package com.example.basic_backend.backend.Bussniss_logic.Entity.Request;

import com.google.gson.Gson;
import lombok.Data;

/**
 * @程志豪 时间：2019 08 05 14:23
 * 邮箱：k2160789@163.com
 * 描述：{登陆信息}
 **/
@Data
public class LoginMessage {
    public static final int WEI_XIN = 1;
    public static final int WEB = 2;
    private static Gson gson = new Gson();

    private String username;
    private  Integer source;


    public LoginMessage(String username,Integer source){
        this.username = username;
        this.source = source;
    }
    public static LoginMessage wxLogin(String username){
        return new LoginMessage(username,WEI_XIN);
    }

    public static LoginMessage webLogin(String username){
        return new LoginMessage(username,WEB);
    }
    public String toJson(){
        return gson.toJson(this);
    }

    public static LoginMessage fromJson(String json){
        return gson.fromJson(json, LoginMessage.class);
    }
}
