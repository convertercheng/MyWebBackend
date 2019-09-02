package com.example.basic_backend.backend.Security;

import com.example.basic_backend.backend.Bussniss_logic.Entity.StaticStatus.Status;
import com.example.basic_backend.backend.Util.RespUtil;
import com.google.gson.Gson;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class RestAuthenticationAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        Gson gson = new Gson();
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(gson.toJson(RespUtil.errorResp(Status.webError.AUTH_FAILD.getError_code(), Status.webError.AUTH_FAILD.getError_message())));
    }

}