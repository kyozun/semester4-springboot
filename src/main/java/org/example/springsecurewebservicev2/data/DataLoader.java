package org.example.springsecurewebservicev2.data;

import org.example.springsecurewebservicev2.entity.*;
import org.example.springsecurewebservicev2.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Component
public class DataLoader {

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, BookRepository bookRepository, PublisherRepository publisherRepository, BookPublisherRepository bookPublisherRepository) {
        return args -> {
            Role adminRole = new Role();
            adminRole.setName("ADMIN");
            roleRepository.save(adminRole);

            Role employeeRole = new Role();
            employeeRole.setName("EMPLOYEE");
            roleRepository.save(employeeRole);

            Role publicRole = new Role();
            publicRole.setName("PUBLIC");
            roleRepository.save(publicRole);

            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("123"));
            admin.setRoles(Set.of(adminRole));
            userRepository.save(admin);

            User employee = new User();
            employee.setUsername("employee");
            employee.setPassword(passwordEncoder.encode("123"));
            employee.setRoles(Set.of(employeeRole));
            userRepository.save(employee);

            User user = new User();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("123"));
            user.setRoles(Set.of(publicRole));
            userRepository.save(user);

            Book book = new Book();
            book.setName("Doraemon");
            bookRepository.save(book);

            Book book2 = new Book();
            book2.setName("Black jack");
            bookRepository.save(book2);

            Publisher publisher = new Publisher();
            publisher.setName("NXB Kim Đồng");
            publisherRepository.save(publisher);

            Publisher publisher2 = new Publisher();
            publisher2.setName("NXB Trẻ");
            publisherRepository.save(publisher2);

            BookPublisher bookPublisher = new BookPublisher();
            bookPublisher.setBook(book);
            bookPublisher.setPublisher(publisher);
            bookPublisher.setPublishedDate(LocalDateTime.now());
            bookPublisherRepository.save(bookPublisher);


            BookPublisher bookPublisher2 = new BookPublisher();
            bookPublisher2.setBook(book2);
            bookPublisher2.setPublisher(publisher2);
            bookPublisher2.setPublishedDate(LocalDateTime.now());
            bookPublisherRepository.save(bookPublisher2);

            BookPublisher bookPublisher3 = new BookPublisher();
            bookPublisher3.setBook(book);
            bookPublisher3.setPublisher(publisher2);
            bookPublisher3.setPublishedDate(LocalDateTime.now());
            bookPublisherRepository.save(bookPublisher3);


        };
    }
}
