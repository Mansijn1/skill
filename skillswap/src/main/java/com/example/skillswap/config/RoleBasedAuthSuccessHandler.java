package com.example.skillswap.config;



import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


@Component
public class RoleBasedAuthSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String redirectUrl = "/";
        for (GrantedAuthority auth : authentication.getAuthorities()) {
            String role = auth.getAuthority(); // e.g., ROLE_ADMIN or ROLE_USER
            if ("ROLE_ADMIN".equals(role)) {
                redirectUrl = "/admin-dashboard";
                break;
            } else if ("ROLE_USER".equals(role)) {
                redirectUrl = "/user-dashboard";
            }
        }
        response.sendRedirect(redirectUrl);
    }
}