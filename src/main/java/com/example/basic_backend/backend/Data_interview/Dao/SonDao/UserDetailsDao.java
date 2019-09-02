package com.example.basic_backend.backend.Data_interview.Dao.SonDao;

import com.example.basic_backend.backend.Data_interview.Dao.baseDao;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @程志豪 时间：2019 09 02 10:58
 * 邮箱：k2160789@163.com
 * 描述：{desp}
 **/

public interface UserDetailsDao<T extends UserDetails> extends baseDao {
    UserDetails findByName(String name);
}
