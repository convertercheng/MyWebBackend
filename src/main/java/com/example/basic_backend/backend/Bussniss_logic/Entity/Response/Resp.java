package com.example.basic_backend.backend.Bussniss_logic.Entity.Response;

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
}
