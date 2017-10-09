package com.lean;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by llw on 2017/10/10.
 */
@SpringBootApplication
@MapperScan("com.lean.mapper")
public class LeanApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeanApplication.class, args);
    }

}
