package com.excellent.knowbookweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(value = "com.excellent.knowbookcommon.dao")
@ComponentScan(value = "com.excellent")
@SpringBootApplication
@EnableCaching
@EnableTransactionManagement
@EnableElasticsearchRepositories("com.excellent.knowbookcommon.repository")
public class KnowbookWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnowbookWebApplication.class, args);

	}


}
