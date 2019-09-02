package com.example.basic_backend.backend.Application_Represent.Controller;

import com.example.basic_backend.backend.Bussniss_logic.Entity.LogData;
import com.example.basic_backend.backend.Bussniss_logic.Entity.Request.LogDataRequest;
import com.example.basic_backend.backend.Bussniss_logic.Entity.Response.Resp;
import com.example.basic_backend.backend.Bussniss_logic.Entity.StaticStatus.Status;
import com.example.basic_backend.backend.Bussniss_logic.Service.DataService;
import com.example.basic_backend.backend.Util.RespUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @程志豪 时间：16:53
 * 描述：{博客/日志控制器}
 **/

@RestController
@RequestMapping(value = "/data")
@Slf4j
public class DataController {


    @Autowired
    public DataService dataService;



    @PostMapping(value = "index")
    public Resp showDataIndex(LogDataRequest logDataRequest){


    return RespUtil.successResp();
    }

    @PostMapping(value = "add")
    public Resp addLogData(LogDataRequest logDataRequest) {

        if (logDataRequest.text.isEmpty() || logDataRequest.text == null) {
            return RespUtil.errorResp(Status.webError.TEXT_MISSED.getError_code(), Status.webError.TEXT_MISSED.getError_message());
        }
        if (logDataRequest.topic.isEmpty() || logDataRequest.topic == null) {
            return RespUtil.errorResp(Status.webError.TOPIC_MISSED.getError_code(), Status.webError.TOPIC_MISSED.getError_message());
        }
        try{
            dataService.add(logDataRequest);
        }catch (Exception e){
            log.info(Status.webError.ADD_LOGDATA_ERROR.getError_message());
            return RespUtil.errorResp(Status.webError.ADD_LOGDATA_ERROR.getError_code(),Status.webError.ADD_LOGDATA_ERROR.getError_message());
        }
        return RespUtil.successResp();
    }
}
