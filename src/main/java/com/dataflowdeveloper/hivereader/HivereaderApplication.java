package com.dataflowdeveloper.hivereader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class HivereaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(HivereaderApplication.class, args);
	}

	// https://cwiki.apache.org/confluence/display/Hive/HiveServer2+Clients#HiveServer2Clients-JDBC

	    @Value("${hiveuri}")
	    private String databaseUri;
	    
	    @Value("${hiveusername}")
	    private String username;
	    
		@Bean
		public DataSource dataSource() {
			
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setUrl(databaseUri);
			dataSource.setDriverClassName("org.apache.hive.jdbc.HiveDriver");
			dataSource.setUsername(username);
			
			return dataSource;
		}
	}
