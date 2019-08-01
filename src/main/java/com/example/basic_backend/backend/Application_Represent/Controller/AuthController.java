package com.example.basic_backend.backend.Application_Represent.Controller;

import com.example.basic_backend.backend.Bussniss_logic.Entity.Response.Resp;
import com.example.basic_backend.backend.Bussniss_logic.Entity.StaticStatus.Constant;
import com.example.basic_backend.backend.Bussniss_logic.Entity.StaticStatus.Status;
import com.example.basic_backend.backend.Bussniss_logic.Entity.User;
import com.example.basic_backend.backend.Bussniss_logic.Entity.Request.loginRequest;
import com.example.basic_backend.backend.Security.WebAuthenticationToken;
import com.example.basic_backend.backend.Util.RespUtil;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

/**
 * @程志豪 时间：2019 07 31 15:41
 * 邮箱：k2160789@163.com
 * 描述：{desp}
 **/
@RestController
@Slf4j
public class AuthController {
    @Value("${jwt.key}")
    private String jwtKey;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/auth/login")
    public Resp login(User user){
        log.info(user.getName()+"登陆");

        Authentication authentication;
        try{
            authentication = authenticationManager.authenticate(
                    new WebAuthenticationToken(
                            user.getName(),
                            user.getPassword()
                    )
            );
        }catch (AuthenticationException e){
            log.info("登陆失败");
            e.printStackTrace();
            return RespUtil.errorResp(Status.webError.AUTH_ERROR.getError_code(),Status.webError.AUTH_ERROR.getError_message());
        }
        String json = loginRequest.webLogin(((UserDetails) authentication.getPrincipal()).getUsername()).toJson();
        String token = Jwts.builder()
                .setSubject(json)

//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 3600 * 24 * 10))
                .setExpiration(new Date(System.currentTimeMillis() + Constant.TOKEN_EXPIRE_TEXT))
                .signWith(SignatureAlgorithm.HS512, jwtKey)
                .compact();
        val result = new HashMap<String, Object>() {{
            put("token", token);
            put("user",authentication.getPrincipal());
        }};
        return RespUtil.successResp(result);
    }

    @RequestMapping(value = "/auth/accessDenied")
    public Resp accessDenied(){
        return RespUtil.errorResp(Status.webError.AUTH_DENIED.getError_code(),Status.webError.AUTH_DENIED.getError_message());
    }
}
