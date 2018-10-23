package org.sc.service.myb.services.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sc.service.myb.mapper.StudentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * 测试类
 * 
 * @author lv
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    StudentMapper studentMapper;

    @Test
    public void contextLoads() {

    }
    public static Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);


}
