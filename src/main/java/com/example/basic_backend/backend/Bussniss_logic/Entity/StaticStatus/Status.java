package com.example.basic_backend.backend.Bussniss_logic.Entity.StaticStatus;

import lombok.Data;

/**
 * @程志豪 时间：2019 07 22 15:07
 * 邮箱：k2160789@163.com
 * 描述：{desp}
 **/
public class Status {

    public enum webError {


        UNKNOW_ERROR(0000,"发生未知错误"),
        ADD_LOGDATA_ERROR(0001,"增加日志错误"),
        TEXT_MISSED(1000,"日志正文丢失"),
        TOPIC_MISSED(1001,"日志标题丢失");

        private Integer error_code;
        private String error_message;

        webError(Integer error_code, String error_message) {
            this.error_code = error_code;
            this.error_message = error_message;
        }

        public Integer getError_code() {
            return error_code;
        }
        public String getError_message(){
            return error_message;
        }
    }


}
