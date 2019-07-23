package com.example.basic_backend.backend.Bussniss_logic.Service.ServiceImpl;

import com.example.basic_backend.backend.Bussniss_logic.Entity.Request.LogDataRequest;
import com.example.basic_backend.backend.Bussniss_logic.Entity.Response.Resp;
import com.example.basic_backend.backend.Bussniss_logic.Entity.StaticStatus.Status;
import com.example.basic_backend.backend.Bussniss_logic.Service.DataService;
import com.example.basic_backend.backend.Util.RespUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @程志豪 时间：15:16
 * 描述：{desp}
 **/
@Service
@Slf4j
public class DataServiceImpl implements DataService {
    public Resp add(LogDataRequest logDataRequest){
        Long timestemp = System.currentTimeMillis();
        Date date = new Date(timestemp);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String finaldate = simpleDateFormat.format(date);
        logDataRequest.date = finaldate;




        return RespUtil.successResp();
    }

    public Resp del(LogDataRequest logDataRequest){
        return RespUtil.successResp();
    }

    public Resp show(LogDataRequest logDataRequest){
        return RespUtil.successResp();
    }

    public Resp edit(LogDataRequest logDataRequest){
        return RespUtil.successResp();
    }
}
