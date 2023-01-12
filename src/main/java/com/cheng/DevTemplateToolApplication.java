package com.cheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author chengwuchao
 * @date 2022/3/18
 */
@EnableOpenApi
@SpringBootApplication
public class DevTemplateToolApplication {
    public static void main(String[] args) {
        SpringApplication.run(DevTemplateToolApplication.class, args);
    }
}
