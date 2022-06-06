package com.bank.kuebikofakebank.doa;

import com.bank.kuebikofakebank.entity.LoginEntity;
import com.bank.kuebikofakebank.repo.LoginRepoIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    @Autowired
    LoginRepoIF loginrepo;
    public LoginEntity SignUp(String username, String password)
    {
        LoginEntity de = new LoginEntity();
        long id = System.currentTimeMillis();
        de.setId(id);
        de.setUsername(username);
        de.setPassword(password);
        LoginEntity savedmsg = loginrepo.save(de);
        return savedmsg;
    }

    public Long CheckLogin(String username,String password)
    {
        return loginrepo.chkLogin(username,password);
    }
}
