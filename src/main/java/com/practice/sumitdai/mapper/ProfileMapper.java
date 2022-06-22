package com.practice.sumitdai.mapper;

import com.practice.sumitdai.entity.ProfileEntity;
import com.practice.sumitdai.model.ProfileModel;
import com.practice.sumitdai.validation.ProfileValidate;

public class ProfileMapper {

    public static ProfileModel map(ProfileEntity profileEntity){

        if(profileEntity == null){
            return null;
        }

        ProfileModel profileModel = new ProfileModel();


        profileModel.setId(profileEntity.getId());

        profileModel.setPhoneNumber(profileEntity.getPhoneNumber());


        profileModel.setSsn(profileEntity.getSsn());

        profileModel.setFirstName(profileEntity.getFirstName());
        profileModel.setMiddleName(profileEntity.getMiddleName());
        profileModel.setLastName(profileEntity.getLastName());

        profileModel.setAddress(profileEntity.getAddress());
        profileModel.setEmail(profileEntity.getEmail());
        profileModel.setGender(profileEntity.getGender());
        profileModel.setDob(profileEntity.getDob());


        return profileModel;

    }

    public static ProfileEntity map(ProfileModel profileModel){

        if(profileModel==null){
            return null;
        }

        ProfileEntity profileEntity = new ProfileEntity();

        String anyError = ProfileValidate.validate(profileModel);


        profileEntity.setId(profileModel.getId());
        profileEntity.setPhoneNumber(profileModel.getPhoneNumber());


        profileEntity.setSsn(profileModel.getSsn());

        profileEntity.setFirstName(profileModel.getFirstName());
        profileEntity.setMiddleName(profileModel.getMiddleName());
        profileEntity.setLastName(profileModel.getLastName());

        profileEntity.setAddress(profileModel.getAddress());
        profileEntity.setDob(profileModel.getDob());
        profileEntity.setGender(profileModel.getGender());
        profileEntity.setEmail(profileModel.getEmail());

        return profileEntity;
    }
}
