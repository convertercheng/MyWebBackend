package com.example.basic_backend.backend.Bussniss_logic.Service.ServiceImpl;

import com.example.basic_backend.backend.Bussniss_logic.Entity.Request.LoginMessage;
import com.example.basic_backend.backend.Bussniss_logic.Service.CustomUserDetailsService;
import com.example.basic_backend.backend.Bussniss_logic.Service.UserService;
import com.example.basic_backend.backend.Data_interview.Dao.SonDao.UserDao;
import com.example.basic_backend.backend.Data_interview.Dao.SonDao.UserDetailsDao;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @程志豪 时间：2019 08 04 14:37
 * 邮箱：k2160789@163.com
 * 描述：{desp}
 **/
@Service
@Slf4j
public class UserDetailsServiceImpl implements CustomUserDetailsService {
    @Autowired
    private UserDetailsDao userDetailsDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userDetailsDao.findByName(username);
        userDetails.getAuthorities();
        if (userDetails.getUsername().equals(username)) {
            return userDetails;
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    @Override
    @Transactional
    public UserDetails loadUserByMessage(LoginMessage message) throws UsernameNotFoundException{
        if(message.getSource().equals(LoginMessage.WEB)) {
            UserDetails userDetails = userDetailsDao.findByName(message.getUsername());
            if (userDetails!=null) {
                userDetails.getAuthorities();
                return userDetails;
            } else {
                throw new UsernameNotFoundException(message.getUsername());
            }
        }
        if(message.getSource().equals(LoginMessage.WEI_XIN)){
            UserDetails userDetails = userDetailsDao.findByName(message.getUsername());
            if (userDetails!=null) {
                return userDetails;
            } else {
                throw new UsernameNotFoundException(message.getUsername());
            }
        }
        return null;

    }
}
