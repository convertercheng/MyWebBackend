package com.example.basic_backend.backend.Data_interview.Dao;

import com.example.basic_backend.backend.Bussniss_logic.Entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface baseDao<T> extends  JpaRepository<T, Integer> , JpaSpecificationExecutor<T> {


}
