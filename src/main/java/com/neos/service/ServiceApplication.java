package com.neos.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EntityScan(basePackages = {
    "com.neos.service.core.entity",
    "com.neos.service.core2.entity" // Se escanea opcionalmente si se activa el perfil
})
public class ServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(ServiceApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ServiceApplication.class, args);
		logger.info("USERS MICROSERVICE STARTED SUCCESSFULLY");

		Environment env = context.getEnvironment();
			String[] activeProfiles = env.getActiveProfiles();

			if (activeProfiles.length == 0) {
					logger.info("ACTIVE PROFILE: default (no profile explicitly set)");
			} else {
					logger.info("ACTIVE PROFILE(S): {}", String.join(", ", activeProfiles));
			}
	}

}