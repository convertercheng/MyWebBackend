package com.example.basic_backend.backend.Data_interview.Dao.SonDao;

import com.example.basic_backend.backend.Bussniss_logic.Entity.LogData;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/**
 * @程志豪 时间：17:02
 * 描述：{日志表LogData的数据交互曾}
 **/
public interface LogDataDao extends JpaRepository<LogData, Integer> {
    /**
     * 通过名称寻找
     * @param topic
     * @return
     */
    LogData findByTopic(String topic);

    /**
     * 通过数据寻找
     * @param date
     * @return
     */
    List<LogData> findByDate (Long date);
}
