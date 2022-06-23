package com.practice.sumitdai.dao;

import com.practice.sumitdai.entity.ProfileEntity;
import com.practice.sumitdai.model.ProfileModel;
import com.practice.sumitdai.repo.ProfileRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

//@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
public class DaoTest {

    @InjectMocks
    ProfileDao profileDao;

    @Mock
    ProfileRepo profileRepo;

    @Test
    public void signup_null_failure() {

        ProfileModel response = profileDao.signup(null);
        Assertions.assertNull(response);

    }

    @Test
    public void signup_validation_fail() {

        ProfileModel inputModel = new ProfileModel();
        ProfileModel response = profileDao.signup(inputModel);
        Assertions.assertEquals("First name cannot be empty", response.getMessage());

    }

    private ProfileModel getModel() {
        ProfileModel inputModel = new ProfileModel();
        inputModel.setFirstName("kjk");
        inputModel.setMiddleName("kjddd");
        inputModel.setLastName("last");
        inputModel.setEmail("email");
        inputModel.setSsn("123456789");
        inputModel.setAddress("jgj");
        inputModel.setGender("M");
        inputModel.setPhoneNumber(1234567890L);
        return inputModel;
    }

    @Test
    public void signup_success() {

        // when repo calls save methods, return yourn own data
        ProfileEntity simulatedResponseFromDb = new ProfileEntity();
        simulatedResponseFromDb.setId(123l);

        Mockito.when(profileRepo.save(Mockito.any()))
                .thenReturn(simulatedResponseFromDb);

        ProfileModel respones_model = profileDao.signup(getModel());
        Assertions.assertNotNull(respones_model.getId());

    }

    @Test
    public void findById_id_null() {

        long passed_id = 123l;

        Mockito.when(profileRepo.findById(passed_id))
                .thenReturn(Optional.empty());
        ProfileEntity entity = profileDao.findById(passed_id);
        Assertions.assertNull(entity);


    }

    @Test
    public void findById_id_sucess() {

        long passed_id = 123l;

        Mockito.when(profileRepo.findById(passed_id))
                .thenReturn(Optional.of(new ProfileEntity()));

        ProfileEntity entity = profileDao.findById(passed_id);
        Assertions.assertNotNull(entity);


    }

    //save method
    @Test
    public void save_sucess(){
        ProfileEntity en = new ProfileEntity();

        Mockito.when(profileRepo.save(en))
                .thenReturn(new ProfileEntity());
        ProfileEntity savedEnt= profileDao.save(en);

        Assertions.assertNotNull(savedEnt);
    }


}
