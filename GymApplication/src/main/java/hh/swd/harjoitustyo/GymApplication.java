package hh.swd.harjoitustyo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd.harjoitustyo.domain.Category;
import hh.swd.harjoitustyo.domain.CategoryRepository;
import hh.swd.harjoitustyo.domain.GroupExercise;
import hh.swd.harjoitustyo.domain.GroupExerciseRepository;
import hh.swd.harjoitustyo.domain.User;
import hh.swd.harjoitustyo.domain.UserRepository;


@SpringBootApplication
public class GymApplication {
	private static final Logger log = LoggerFactory.getLogger(GymApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GymApplication.class, args);
	}

	@Bean
	public CommandLineRunner gymDemo(GroupExerciseRepository gRepository, CategoryRepository cRepository, UserRepository userRepository) {
		return (args) -> {

			log.info("save a couple of categories");
			Category cat1 = new Category("Strenght");
			cRepository.save(cat1);
			Category cat2 = new Category("Cardio");
			cRepository.save(cat2);
			Category cat3 = new Category("Body & Mind");
			cRepository.save(cat3); 
			
			gRepository.save(new GroupExercise("Abs, Butt & Thighs", "Tough workout for the lower body and midsection. The workout contains efficient muscle strength exercises that shape your abs, butt, and thighs.", "45 min", "17:00", "17:45", "23.5.2021", cat1));
			gRepository.save(new GroupExercise("HIIT", " HIIT is a powerful interval training workout based on post-workout fat burning and the rapid acceleration of aerobic fitness. ", "30 min", "15:00", "15:30", "20.5.2021", cat2));	
			gRepository.save(new GroupExercise("Yoga", "Improves your endurance, body coordination, balance, mobility, and strength. The class is suitable for everyone.", "60 min", "18:00", "19:00", "13.4.2021", cat3));	

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@email.com", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@email.com", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
			log.info("fetch all group exercises");
			for (GroupExercise groupexercise: gRepository.findAll()) {
				log.info(groupexercise.toString());
			}

		};
	}
}

