//package com.example.skillswap.service;
//
//
//
//import com.example.skillswap.model.Admin;
//import com.example.skillswap.repository.AdminRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AdminService {
//    private final AdminRepository adminRepository;
//
//    public AdminService(AdminRepository adminRepository) {
//        this.adminRepository = adminRepository;
//    }
//
//    public Admin login(String adminName, String password) {
//        Admin admin = adminRepository.findByAdminName(adminName);
//        if (admin != null && admin.getPassword().equals(password)) {
//            return admin;
//        }
//        return null;
//    }
//}
