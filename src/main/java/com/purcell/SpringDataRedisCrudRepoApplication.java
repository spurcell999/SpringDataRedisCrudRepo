package com.purcell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@EnableJpaRepositories("com.purcell.repo")*/
public class SpringDataRedisCrudRepoApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringDataRedisCrudRepoApplication.class, args);
	}
}
