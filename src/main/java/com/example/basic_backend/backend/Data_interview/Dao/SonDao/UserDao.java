package com.example.basic_backend.backend.Data_interview.Dao.SonDao;

import com.example.basic_backend.backend.Bussniss_logic.Entity.User;
import com.example.basic_backend.backend.Data_interview.Dao.baseDao;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * @程志豪 时间：17:00
 * 描述：{desp}
 **/
public interface UserDao extends JpaRepository<User,Integer> {

    User findByName(String name);

}
