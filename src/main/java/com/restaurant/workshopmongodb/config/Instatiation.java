package com.restaurant.workshopmongodb.config;

import com.restaurant.workshopmongodb.models.User;
import com.restaurant.workshopmongodb.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instatiation implements CommandLineRunner {

    @Autowired
    private userRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User user1 = new User(null, "Marta Alves", "marta@gmail.com");
        User user2 = new User(null, "Bob", "bobgrey@gmail.com");
        User user3 = new User(null, "Matheus Romano", "matheusromano@gmail.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
