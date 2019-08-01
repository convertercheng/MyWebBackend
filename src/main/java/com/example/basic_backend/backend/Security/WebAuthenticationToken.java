package com.example.basic_backend.backend.Security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author 王宇 623619462@qq.com
 * @version 2.0.1 创建时间: 19-5-9 下午4:01
 * <p>
 * 类说明：
 * ${description}
 */
public class WebAuthenticationToken extends UsernamePasswordAuthenticationToken {

    public WebAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public WebAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
