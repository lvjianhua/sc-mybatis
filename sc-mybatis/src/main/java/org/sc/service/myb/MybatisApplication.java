package org.sc.service.myb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@MapperScan("org.sc.service.myb.mapper")
@SpringBootApplication
@EnableSwagger2
public class MybatisApplication {

    public static void main(String[] args) {
    	new SpringApplicationBuilder(MybatisApplication.class).web(true).run(args);
    }
}
