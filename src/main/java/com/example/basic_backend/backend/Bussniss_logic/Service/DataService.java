package com.example.basic_backend.backend.Bussniss_logic.Service;

import com.example.basic_backend.backend.Bussniss_logic.Entity.Request.LogDataRequest;
import com.example.basic_backend.backend.Bussniss_logic.Entity.Response.Resp;

/**
 * @程志豪 时间：15:16
 * 描述：{desp}
 **/
public interface DataService {

    /**
     *
     * @return
     */
    Resp add(LogDataRequest logDataRequest);
    Resp del(LogDataRequest logDataRequest);
    Resp edit(LogDataRequest logDataRequest);
    Resp show(LogDataRequest logDataRequest);
}
