package com.fei.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaUtilTest {

    @Resource
    KafkaUtil kafkaUtil;

    @Test
    public void testSend() {
        kafkaUtil.send("wj0jddu6-default","fei spring boot ut producer");
    }

}
