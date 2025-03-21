package br.com.felipe.course.config;

import br.com.felipe.course.entities.User;
import br.com.felipe.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

import static java.util.Arrays.asList;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        User user = new User(null, "Maria", "maria@gmail.com", "9999999", "12345");
        User user2 = new User(null, "Felipe", "felipe@gmail.com", "8888888", "12345");
        userRepository.saveAll(Arrays.asList(user, user2));

    }
}
