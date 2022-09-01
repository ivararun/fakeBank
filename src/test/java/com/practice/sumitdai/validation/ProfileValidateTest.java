package com.practice.sumitdai.validation;

import com.practice.sumitdai.entity.ProfileEntity;
import com.practice.sumitdai.mapper.ProfileMapper;
import com.practice.sumitdai.model.ProfileModel;
import com.practice.sumitdai.repo.ProfileRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.security.PublicKey;


@ExtendWith(SpringExtension.class)
public class ProfileValidateTest {


    @Test
    public void validateSsn_test_good_ssn() {

        String ssn = "123456789";
        String response = ProfileValidate.validateSsn(ssn);
        // we expect the response to be numm because ssn is good
        // response == null
        Assertions.assertNull(response);
    }

    @Test
    public void validateSsn_test_null_ssn() {

        String ssn = null;
        String response = ProfileValidate.validateSsn(ssn);
        Assertions.assertEquals("SSN cannot be empty", response);

    }

    @Test
    public void validateSsn_test_short_ssn() {

        String ssn = "123";
        String response = ProfileValidate.validateSsn(ssn);
        Assertions.assertEquals("SSN needs to be of length 9", response);

    }

    @Test
    public void validateSsn_test_bad_short_ssn() {

        String ssn = "abc";
        String response = ProfileValidate.validateSsn(ssn);

        Assertions.assertEquals("SSN needs to be of length 9", response);

    }

    @Test
    public void validateSsn_test_bad_ssn() {

        String ssn = "abcdefgh1";
        String response = ProfileValidate.validateSsn(ssn);

        Assertions.assertEquals("Invalid SSN", response);

    }

    @Test
    public void  validate_null_pfofile() {

        String response = ProfileValidate.validate(null);
        Assertions.assertEquals("Profile cannot be empty", response);
    }

    @Test
    public void  validate_null_firstname() {

        ProfileModel testModel = new ProfileModel();

        String response = ProfileValidate.validate(testModel);
        Assertions.assertEquals("First name cannot be empty", response);
    }

    @Test
    public void  validate_null_lastName() {

        ProfileModel testModel = new ProfileModel();
        testModel.setFirstName("A");
        String response = ProfileValidate.validate(testModel);
        Assertions.assertEquals("Last name cannot be empty", response);
    }

    @Test
    public void validate_null_address(){

        ProfileModel md = new ProfileModel();
        md.setFirstName("a");
        md.setLastName("g");

        String response = ProfileValidate.validate(md);
        Assertions.assertEquals("Address cannot be empty", response);
    }

    @Test
    public void validate_null_email(){
        ProfileModel md = new ProfileModel();
        md.setFirstName("a");
        md.setLastName("g");
        md.setAddress("Nepal");

        String res = ProfileValidate.validate(md);
        Assertions.assertEquals("Email cannot be empty", res);
    }

    @Test
    public void validte_gender_null(){
        ProfileModel md = new ProfileModel();
        md.setFirstName("a");
        md.setLastName("g");
        md.setAddress("Nepal");
        md.setEmail("iu@ih");

        String res = ProfileValidate.validate(md);
        Assertions.assertEquals("Gender cannot be empty", res);

    }

    @Test
    public void validate_gender_M_F(){
        ProfileModel md = new ProfileModel();
        md.setFirstName("a");
        md.setLastName("g");
        md.setAddress("Nepal");
        md.setEmail("iu@ih");
        md.setGender("X");

        String res = ProfileValidate.validate(md);
        Assertions.assertEquals("Gender can only be M or F", res);
    }

    //SSN
    @Test
    public void validate_null_SSN(){
        ProfileModel md = new ProfileModel();
        md.setFirstName("a");
        md.setLastName("g");
        md.setAddress("Nepal");
        md.setEmail("iu@ih");
        md.setGender("M");

        String expected_res = ProfileValidate.validate(md);
        Assertions.assertEquals("SSN cannot be empty", expected_res);
    }

    @Test
    public void validate_SSN_ifInt(){
        ProfileModel md = new ProfileModel();
        md.setFirstName("a");
        md.setLastName("g");
        md.setAddress("Nepal");
        md.setEmail("iu@ih");
        md.setGender("M");
        md.setSsn("abc");

        String expected_res= ProfileValidate.validate(md);
        Assertions.assertEquals("Invalid SSN", expected_res);

    }

    @Test
    public void validate_SSN_length(){
        ProfileModel md = new ProfileModel();
        md.setFirstName("a");
        md.setLastName("g");
        md.setAddress("Nepal");
        md.setEmail("iu@ih");
        md.setGender("M");
        md.setSsn("123");

        String expected_response = ProfileValidate.validate(md);
        Assertions.assertEquals("SSN needs to be of length 9", expected_response);
    }

    @Test
    public void validate_null_phoneNum(){
        ProfileModel md = new ProfileModel();
        md.setFirstName("a");
        md.setLastName("g");
        md.setAddress("Nepal");
        md.setEmail("iu@ih");
        md.setGender("M");
        md.setSsn("123456789");

        String expected_response = ProfileValidate.validate(md);
        Assertions.assertEquals("Phone number cannot be empty", expected_response);

    }

    @Test
    public void validate_phnNum_length(){
        ProfileModel md = new ProfileModel();
        md.setFirstName("a");
        md.setLastName("g");
        md.setAddress("Nepal");
        md.setEmail("iu@ih");
        md.setGender("M");
        md.setSsn("123456789");
        md.setPhoneNumber(898L);    //L is because 898 is Long

        String resp = ProfileValidate.validate(md);
        Assertions.assertEquals("Phone number needs to be of length 10", resp);
    }


    // If the passed model is correct
    // And validate return null
    @Test
    public void  validate_retunString(){
        ProfileModel md = new ProfileModel();
        md.setFirstName("a");
        md.setLastName("g");
        md.setAddress("Nepal");
        md.setEmail("iu@ih");
        md.setGender("M");
        md.setSsn("123456789");
        md.setPhoneNumber(1234567890L);


        String expectedReturn = null;
        String response= ProfileValidate.validate(md);
        Assertions.assertEquals(expectedReturn, response);
    }





}
