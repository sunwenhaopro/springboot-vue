package com.cxxj.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.cxxj.mapper")
public class MybatisConfig {

}

