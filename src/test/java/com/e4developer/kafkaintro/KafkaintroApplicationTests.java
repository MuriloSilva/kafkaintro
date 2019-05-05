package com.e4developer.kafkaintro;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaintroApplicationTests {
	
	private Logger logger = LoggerFactory.getLogger("log");

    @Test
    public void contextLoads() {
    	logger.info("Só {} Murilo de {}", "vai", "Paula");
    }

}
