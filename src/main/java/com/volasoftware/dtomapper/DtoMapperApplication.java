package com.volasoftware.dtomapper;

import com.volasoftware.dtomapper.repository.UserRepository;
import com.volasoftware.dtomapper.util.UserUtil;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class DtoMapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(DtoMapperApplication.class, args);
	}

	@Bean
	public ApplicationRunner initializer(UserRepository userRepository) {
		return args -> userRepository.saveAll(UserUtil.getInitialUsers());
	}
}
