package com.parameters.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParametersServiceApplication {
//	@Autowired
//	RepoM267 repo;
	public static void main(String[] args) {
		SpringApplication.run(ParametersServiceApplication.class, args);

	}
	
//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

//
//	@PostConstruct
//	public void postconstruct() {
//		repo.save(new M267(1,"TR-C4-V13VBN-00050",72.5,17.5,70,0));
//	}

}
