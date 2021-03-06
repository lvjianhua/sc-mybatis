package org.sc.service.myb.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;

/**
 * 扫描dao或者是Mapper接口
 * 
 * @author lv
 *
 */
@Configuration
@MapperScan("org.sc.service.myb.dao*")
public class MybatisPlusConfig {
    /**mybatis-plus 分页插件*/
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");// 设置方言
        return page;
    }

}