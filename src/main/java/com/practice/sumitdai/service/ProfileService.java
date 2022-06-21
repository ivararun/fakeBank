package com.practice.sumitdai.service;

import com.practice.sumitdai.dao.ProfileDao;
import com.practice.sumitdai.entity.ProfileEntity;
import com.practice.sumitdai.mapper.ProfileMapper;
import com.practice.sumitdai.model.ProfileModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileService {

    @Autowired
    ProfileDao profileDao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public ProfileModel signup(ProfileModel profileModel){
        return profileDao.signup(profileModel);
    }

    public ProfileEntity view(String ssn) {
        return profileDao.view(ssn);
    }

    public ProfileModel update(long id, ProfileModel profileModel) {

        // get the existing data first
        ProfileEntity currentProfile = profileDao.findById(id);

        // If the data for the id doesnt exist, return
        if (currentProfile == null){
            ProfileModel pm = new ProfileModel();
            pm.setMessage("No data for id " + id);
            return pm;
        }


        // Check for all the fields from input parameter thata re not empty.
        // If not empty, update
        String firstName = profileModel.getFirstName();
        if (firstName != null && firstName.length() != 0){
            currentProfile.setFirstName(firstName);
        }



        String lastName = profileModel.getLastName();
        if (lastName != null && lastName.length() != 0){
            currentProfile.setLastName(lastName);
        }


        // replace the current profile
        currentProfile = profileDao.save(currentProfile);
        return ProfileMapper.map(currentProfile);
    }


    }

