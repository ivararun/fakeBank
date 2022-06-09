package com.bank.kuebikofakebank.controller;

import com.bank.kuebikofakebank.entity.LoginEntity;
import com.bank.kuebikofakebank.models.LoginModel;
import com.bank.kuebikofakebank.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fakebank")
public class UserController {

    @Autowired
    LoginService ls;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean login(@RequestBody LoginModel model){
        Long id = ls.checkLogin(model.getUsername(),model.getPassword());
        if(id!=null){
            return true;
        }else{
            return false;
        }

    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public LoginEntity signUp(@RequestBody LoginModel model){
        return ls.signUp(model.getUsername(),model.getPassword());
    }

}
