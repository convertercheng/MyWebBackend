package com.example.basic_backend.backend.Data_interview.Dao.SonDao;

import com.example.basic_backend.backend.Bussniss_logic.Entity.LogData;
import com.example.basic_backend.backend.Data_interview.Dao.baseDao;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/**
 * @程志豪 时间：17:02
 * 描述：{desp}
 **/
public interface LogDataDao<T extends LogData> extends JpaRepository<LogData, Integer> {
    LogDataDao findByName(String name);

    List<LogDataDao> findByData (Long date);
}
