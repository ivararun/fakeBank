package com.bank.kuebikofakebank.service;

import com.bank.kuebikofakebank.doa.UserDao;
import com.bank.kuebikofakebank.entity.LoginEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class LoginService {
    @Autowired
    UserDao userdao;
    public Long CheckLogin(String username,String password){
        return userdao.CheckLogin(username,password);
    }

    public LoginEntity SignUp(String username,String password){
        return userdao.SignUp(username,password);
    }
}
