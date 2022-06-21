package com.practice.sumitdai.validation;

import com.practice.sumitdai.model.ProfileModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfileValidate {

    private static Logger logger = LoggerFactory.getLogger(ProfileValidate.class);

    public static String validateSsn(String ssn) {

        if (ssn == null) {
            return "SSN cannot be empty";
        }
        if (ssn.length() != 9) {
            return "SSN needs to be of length 9";
        }
        try {
            int ssnInt = Integer.parseInt(ssn);
        }
        catch (Exception e){
            return "Invalid SSN";
        }

        return null;
    }


    public static String validate(ProfileModel profileModel){

        logger.info("Runing validatation for " + profileModel.toString());
        // first name
        String firstName = profileModel.getFirstName();
        if(firstName == null || firstName.length() == 0){
            return "First name cannot be empty";
        }

        // last name
        String lastName = profileModel.getLastName();
        if(lastName == null || lastName.length() == 0){
            return "Last name cannot be empty";
        }

        // address
        String address = profileModel.getAddress();
        if(address == null || address.length() == 0){
            return "Address cannot be empty";
        }

        // email
        String email = profileModel.getEmail();
        if(email == null || email.length() == 0){
            return "Email cannot be empty";
        }

        // gender
        String gender = profileModel.getGender();
        if ( !gender.equals("M") && !gender.equals("F")){
            return "Gender can only be M or F";
        }


        // ssn
        String ssn = profileModel.getSsn();
        //validateSsn(ssn);
        if (ssn == null) {
            return "SSN cannot be empty";
        }
        if (ssn.length() != 9) {
            return "SSN needs to be of length 9";
        }
        try {
            int ssnInt = Integer.parseInt(ssn);
        }
        catch (Exception e){
            return "Invalid SSN";
        }

        // phone number
        Long phoneNumber = profileModel.getPhoneNumber();
        if(phoneNumber == null){
            return "Phone number cannot be empty";
        }
        if (phoneNumber.toString().length() != 10){
            return "Phone number needs to be of length 10";
        }

        return null;
    }
}
