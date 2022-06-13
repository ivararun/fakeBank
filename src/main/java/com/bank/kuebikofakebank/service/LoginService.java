package com.bank.kuebikofakebank.service;

import com.bank.kuebikofakebank.doa.LoginDao;
import com.bank.kuebikofakebank.entity.LoginEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {

    LoginDao loginDao;

    @Autowired
    public LoginService(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    public Long checkLogin(String username, String password){
        return loginDao.checkLogin(username,password);
    }

    public LoginEntity signUp(String username, String password){
        return loginDao.signUp(username,password);
    }
}
