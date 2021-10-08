package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProfileApplication.class)
@Configuration
@ComponentScan(basePackages = { "com.crossover.*" })
@EnableAutoConfiguration
@EnableAsync
@EnableSwagger2
@WebAppConfiguration
public class CrossoverProfileApplicationTests {

    @Test
    public void contextLoads() {
    }

}
