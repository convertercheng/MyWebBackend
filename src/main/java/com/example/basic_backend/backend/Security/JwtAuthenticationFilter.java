package com.example.basic_backend.backend.Security;

import com.example.basic_backend.backend.Bussniss_logic.Entity.Request.LoginMessage;
import com.example.basic_backend.backend.Bussniss_logic.Entity.StaticStatus.Status;

import com.example.basic_backend.backend.Bussniss_logic.Service.ServiceImpl.UserDetailsServiceImpl;
import com.example.basic_backend.backend.Util.RespUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Value("${jwt.key}")
    private String jwtKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        if (isProtectedRequest(request))
        {
            String token = request.getHeader("Authorization");
            if (token != null && token.startsWith("Bearer ")) {
                try {
                    Claims body = Jwts.parser().setSigningKey(jwtKey)
                            .parseClaimsJws(token.replaceFirst("Bearer ", ""))
                            .getBody();
                    String json = body.getSubject();
                    val loginMessage = LoginMessage.fromJson(json);
                    Date exp = body.getExpiration();
                    UserDetails user = userDetailsServiceImpl.loadUserByMessage(loginMessage);
                    SecurityContextHolder.getContext().setAuthentication(
                            new UsernamePasswordAuthenticationToken(
                                    user.getUsername(),
                                    user.getPassword(),
                                    user.getAuthorities()
                            )
                    );
                } catch (Exception e) {
                    log.info("login failed 1");
                    e.printStackTrace();
                    response.getWriter().write(RespUtil.errorResp(Status.webError.INVALID_TOKEN.getError_code(), "invalid token").toJson());
                    return;
                }
            }

            if (SecurityContextHolder.getContext().getAuthentication() == null || !SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
                log.info("login failed 2");
                response.getWriter().write(RespUtil.errorResp(Status.webError.INVALID_TOKEN.getError_code(),"invalid token").toJson());
                return;
            }
        }
        //如果jwt令牌通过了检测, 那么就把request传递给后面的RESTful api
        filterChain.doFilter(request, response);
    }

    private boolean isProtectedRequest(HttpServletRequest request) {
//        System.out.println(request.getRequestURI());

            for (String url :RequestWhiteList.get()) {
                AntPathMatcher pathMatcher = new AntPathMatcher();
                if(pathMatcher.match(url, request.getRequestURI())){
                    return false;
                }
            }
        if (request.getMethod().equals("OPTIONS")) {
            return false;
        }
        return true;
    }
}
