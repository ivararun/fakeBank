package com.bank.kuebikofakebank.doa;

import com.bank.kuebikofakebank.entity.LoginEntity;
import com.bank.kuebikofakebank.repo.LoginRepoIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginDao {

    @Autowired
    LoginRepoIF loginRepoIF;
    public LoginEntity signUp(String username, String password)
    {
        LoginEntity de = new LoginEntity();
        long id = System.currentTimeMillis();
        de.setId(id);
        de.setUsername(username);
        de.setPassword(password);
        LoginEntity savedmsg = loginRepoIF.save(de);
        return savedmsg;
    }

    public Long checkLogin(String username, String password)
    {
        return loginRepoIF.chkLogin(username,password);
    }
}
