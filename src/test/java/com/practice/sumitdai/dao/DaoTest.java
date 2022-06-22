package com.practice.sumitdai.dao;

import com.practice.sumitdai.model.ProfileModel;
import com.practice.sumitdai.repo.ProfileRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class DaoTest {

    @Test
    public void signup_nullModel(){
        ProfileModel null_profileModel = null;

        ProfileModel res_model = new ProfileDao().signup(null_profileModel);
        Assertions.assertEquals(res_model, null_profileModel);
    }

    @Test
    public void signup_model_errorNull(){
        //checking of the model passing on signup method has error msg or not





    }
}
