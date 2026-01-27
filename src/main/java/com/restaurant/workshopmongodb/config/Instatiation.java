package com.restaurant.workshopmongodb.config;

import com.restaurant.workshopmongodb.models.Post;
import com.restaurant.workshopmongodb.models.User;
import com.restaurant.workshopmongodb.repositories.PostRepository;
import com.restaurant.workshopmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instatiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();

        User user1 = new User(null, "Marta Alves", "marta@gmail.com");
        User user2 = new User(null, "Bob", "bobgrey@gmail.com");
        User user3 = new User(null, "Matheus Romano", "matheusromano@gmail.com");


        Post p1 = new Post(null, sdf.parse("26/01/2026"), "Partiu viaigem", "Destino de hoje é SP!", user1);
        Post p2 = new Post(null, sdf.parse("25/01/2026"), "Bom dia!", "Já vamo codar logo cedo...",  user3);

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
        postRepository.saveAll(Arrays.asList(p1, p2));

    }
}
