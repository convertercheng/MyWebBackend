package com.example.basic_backend.backend.Bussniss_logic.Service;

import com.example.basic_backend.backend.Bussniss_logic.Entity.Request.LoginMessage;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @程志豪 时间：2019 09 02 10:26
 * 邮箱：k2160789@163.com
 * 描述：{desp}
 **/
public interface UserService {

    public UserDetails loadUserByUsername(String name);

    public UserDetails loadUserByMessage(LoginMessage loginMessage);
}
