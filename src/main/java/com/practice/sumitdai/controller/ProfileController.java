package com.practice.sumitdai.controller;


import com.practice.sumitdai.entity.ProfileEntity;
import com.practice.sumitdai.model.ProfileModel;
import com.practice.sumitdai.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class ProfileController {

    Logger logger  = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ProfileService profileService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ProfileModel signup(@RequestBody ProfileModel profileModel){
        logger.info("Running method signup");
        return profileService.signup(profileModel);
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ProfileEntity view(@RequestParam String ssn){
        return profileService.view(ssn);
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ProfileModel update(@RequestParam long id, @RequestBody ProfileModel profileModel){
        return profileService.update(id, profileModel);
    }


}
