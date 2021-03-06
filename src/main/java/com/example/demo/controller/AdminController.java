package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    AdminRepository adminRepository;
    @PostMapping("admin")
    public void addAdmin(@RequestBody Admin admin){
        adminRepository.save(admin);
    }
    @GetMapping("admin/{username}/{password}")
    @ResponseBody
    public Boolean signIn(@PathVariable("username")String username,@PathVariable("password")String password){
        Admin admin=adminRepository.findByPasswordAndAndUsername(password,username);
        System.out.println(username + password);
        if(admin!=null){
            return true;
        }
        else{
            return false;
        }

    }
}