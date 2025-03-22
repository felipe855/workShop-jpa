package br.com.felipe.course.config;

import br.com.felipe.course.entities.Category;
import br.com.felipe.course.entities.Order;
import br.com.felipe.course.entities.Product;
import br.com.felipe.course.entities.User;
import br.com.felipe.course.enums.OrderStatus;
import br.com.felipe.course.repository.CategoryRepository;
import br.com.felipe.course.repository.OrderRepository;
import br.com.felipe.course.repository.ProductRepository;
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
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args)  {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User user = new User(null, "Maria", "maria@gmail.com", "9999999", "12345");
        User user2 = new User(null, "Felipe", "felipe@gmail.com", "8888888", "12345");
        userRepository.saveAll(Arrays.asList(user, user2));

        Order order = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID.getCode(),user);
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT.getCode(),user2);
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT.getCode(),user);
        orderRepository.saveAll(asList(order, order2, order3));

    }
}
