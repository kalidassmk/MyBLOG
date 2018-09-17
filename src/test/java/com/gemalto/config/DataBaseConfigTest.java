package com.gemalto.config;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * com.gemalto.config
 *
 * @author Kalidass Mahalingam
 * 17/9/2018
 */
public class DataBaseConfigTest {
    DataBaseConfig dataBaseConfig = new DataBaseConfig();

    @Test
    public void testMongoTemplate() throws Exception {
        MongoTemplate result = dataBaseConfig.mongoTemplate();
        Assert.assertNotNull( result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme