package com.example.skillswap.controller;
import org.springframework.ui.Model;

import com.example.skillswap.service.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping
public class DashboardController {


    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin-dashboard";
    }


    @GetMapping("/user/dashboard")
    public String userDashboard(@AuthenticationPrincipal CustomUserDetails userDetails,
                                Model model) {

        return "user-dashboard"; // will render user-dashboard.html
    }
}