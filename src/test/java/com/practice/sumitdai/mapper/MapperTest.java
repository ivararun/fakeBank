package com.practice.sumitdai.mapper;

import com.practice.sumitdai.entity.ProfileEntity;
import com.practice.sumitdai.model.ProfileModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class MapperTest {

    // Entity to Model

    @Test
    public void map_null_entity(){

        // passing null entity
        ProfileModel response_pf = ProfileMapper.map((ProfileEntity) null);
        Assertions.assertEquals(null, response_pf);
    }

    @Test
    public void map_null_params_entity(){

        ProfileEntity entity = new ProfileEntity();
        entity.setId(1L);
        entity.setPhoneNumber(6878L);

        ProfileModel res_obj = ProfileMapper.map(entity);

        //id
        Assertions.assertEquals(res_obj.getId(), entity.getId());

        //phone number
        Assertions.assertEquals(res_obj.getPhoneNumber(), entity.getPhoneNumber());


    }


    //Model to entity
    @Test
    public void map_null_model(){

        // passing null entity
        ProfileEntity response_en = ProfileMapper.map((ProfileModel) null);
        Assertions.assertEquals(null, response_en);
    }

    @Test
    public void map_null_params_model(){

        ProfileModel md= new ProfileModel();
        md.setId(2L);
        md.setPhoneNumber(788L);


        ProfileEntity res_ent_obj = ProfileMapper.map(md);

        //id
        Assertions.assertEquals(res_ent_obj.getId(), md.getId());

        //phone number
        Assertions.assertEquals(res_ent_obj.getPhoneNumber(), md.getPhoneNumber());


    }

}
