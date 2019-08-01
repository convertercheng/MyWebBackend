package com.example.basic_backend.backend.Bussniss_logic.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @程志豪 时间：20:45
 * 描述：{日志的主体}
 **/
@Data
@Entity
public class LogData {

    @Id
    @GeneratedValue
    public Integer id;

    @Column
    public String topic;        //题目

    @Column
    public String date;         //日期

    @Column
    public String text;         //正文

    public LogData(){

    }           //构造器
    public LogData(String topic, String date, String text){
        this.topic = topic;
        this.text = text;
        this.date = date;
    }
}
