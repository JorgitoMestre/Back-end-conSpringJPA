package com.springjpa.springJPA;

import com.github.javafaker.Faker;
import com.springjpa.springJPA.entities.User;
//import com.springjpa.springJPA.model.UserModel;
import com.springjpa.springJPA.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaApplication implements ApplicationRunner {

	@Autowired
	private Faker faker;
	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		for (int i=0; i<50; i++){
			User user=new User();
			user.setUsername(faker.name().username());
			user.setPassword(faker.dragonBall().character());
			//user.setProfile(null);
			repository.save(user);
		}
	}
}
