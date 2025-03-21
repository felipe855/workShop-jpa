package br.com.felipe.course.config;

import br.com.felipe.course.entities.Order;
import br.com.felipe.course.entities.User;
import br.com.felipe.course.enums.OrderStatus;
import br.com.felipe.course.repository.OrderRepository;
import br.com.felipe.course.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

import static java.util.Arrays.asList;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User user = new User(null, "Maria", "maria@gmail.com", "9999999", "12345");
        User user2 = new User(null, "Felipe", "felipe@gmail.com", "8888888", "12345");
        userRepository.saveAll(Arrays.asList(user, user2));

        Order order = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,user);
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT,user2);
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,user);
        orderRepository.saveAll(asList(order, order2, order3));

    }
}
