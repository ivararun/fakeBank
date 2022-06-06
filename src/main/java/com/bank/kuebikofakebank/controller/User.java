package com.bank.kuebikofakebank.controller;

import com.bank.kuebikofakebank.entity.LoginEntity;
import com.bank.kuebikofakebank.models.LoginModel;
import com.bank.kuebikofakebank.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fakebank")
public class User {

    @Autowired
    LoginService ls;

    @PostMapping
    @RequestMapping("/login")
    public boolean Login(@RequestBody LoginModel model){
        Long id = ls.CheckLogin(model.getUsername(),model.getPassword());
        if(id!=null){
            return true;
        }else{
            return false;
        }

    }

    @PostMapping
    @RequestMapping("/signup")
    public LoginEntity SignUp(@RequestBody LoginModel model){
        return ls.SignUp(model.getUsername(),model.getPassword());
    }

}
