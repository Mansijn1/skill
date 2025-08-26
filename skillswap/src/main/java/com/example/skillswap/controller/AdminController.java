//package com.example.skillswap.controller;
//
//import com.example.skillswap.model.Admin;
//import com.example.skillswap.service.AdminService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminController {
//    private final AdminService adminService;
//
//    public AdminController(AdminService adminService) {
//        this.adminService = adminService;
//    }
//
//    @GetMapping("/login")
//    public String adminLoginForm() {
//        return "admin";
//    }
//
//    @PostMapping("/login")
//    public String adminLogin(@RequestParam String adminName, @RequestParam String password, Model model) {
//        Admin admin = adminService.login(adminName, password);
//        if (admin != null) {
//            model.addAttribute("adminName", admin.getAdminName());
//            return "index";
//        }
//        model.addAttribute("error", "Invalid admin credentials");
//        return "admin";
//    }
//}
