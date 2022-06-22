package com.practice.sumitdai.dao;

import com.practice.sumitdai.entity.ProfileEntity;
import com.practice.sumitdai.mapper.ProfileMapper;
import com.practice.sumitdai.model.ProfileModel;
import com.practice.sumitdai.repo.ProfileRepo;
import com.practice.sumitdai.validation.ProfileValidate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProfileDao {

    @Autowired
    ProfileRepo profileRepo;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public ProfileModel signup(ProfileModel profileModel) {

        if(profileModel==null){
            return null;
        }

        logger.info("Running signup method");
        String anyError = ProfileValidate.validate(profileModel);
        logger.info("Completed validation");

        if (anyError != null){
            logger.warn("Validation failed with message " + anyError);
            ProfileModel check = new ProfileModel();
            check.setMessage(anyError);
            return check;
        }
        else {
            logger.info("Validation passed");
            // map model to entity
            ProfileEntity profileEntity = ProfileMapper.map(profileModel);

            // save the entity in repo and it is in a entity variable
            logger.info("Saving to database ");
            ProfileEntity saved = profileRepo.save(profileEntity);
            logger.info("Saved to database with id " + saved.getId() );

            // map entity to model to return
            ProfileModel last = ProfileMapper.map(saved);

            logger.info("Completed signup");
            return last;
        }
    }

    public ProfileEntity view(String ssn) {
        return profileRepo.view(ssn);
    }


    public ProfileEntity save(ProfileEntity toSave) {
        return profileRepo.save(toSave);
    }
    public ProfileEntity findById(long id) {

        Optional<ProfileEntity> optional  = profileRepo.findById(id);
        if(optional.isEmpty()) {
            return null;
        } else  {
            return optional.get();
        }
    }
}




//        ProfileEntity e = new ProfileEntity();
//
//        Long id = System.currentTimeMillis();
//
//        String anyError = ProfileValidate.validate(profileModel);
//
//        e.setMessage(anyError);
//
//
//        ProfileEntity xx = new ProfileEntity();
//
//        // if there are errors, then the database need to be set as null
//        if (anyError != null){
//
//
//            xx.setId(id);
//            xx.setMessage(anyError);
//
////            e.setId(0L);
////            e.setPhoneNumber(null);
////
////            e.setFirstName(null);
////            e.setMiddleName(null);
////            e.setLastName(null);
////
////            e.setAddress(null);
////            e.setSsn(null);
////            e.setGender(null);
////            e.setDob(null);
////            e.setEmail(null);
//
//            return profileRepo.save(xx);



        // if there are any errors then set the values given by user as profileModel
//        else {
//            e.setId(id);
//
//            e.setPhoneNumber(profileModel.getPhoneNumber());
//
//            e.setFirstName(profileModel.getFirstName());
//            e.setMiddleName(profileModel.getMiddleName());
//            e.setLastName(profileModel.getLastName());
//
//            e.setAddress(profileModel.getAddress());
//            e.setSsn(profileModel.getSsn());
//            e.setGender(profileModel.getGender());
//            e.setDob(profileModel.getDob());
//            e.setEmail(profileModel.getEmail());
//            return profileRepo.save(e);
//        }






//    public ProfileEntity view(String ssn) {
//        return profileRepo.view(ssn);
//    }

