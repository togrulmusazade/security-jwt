package com.company.securityjwt;

import com.company.securityjwt.entity.User;
import com.company.securityjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RequiredArgsConstructor
public class SecurityJwtApplication {

    private final UserRepository userRepository;

    @PostConstruct
    public void createUsers(){
        List<User> users = Stream.of(
                new User(1,"togrul", "{noop}password", "togrul@gmail.com"),
                new User(2,"user1", "{noop}user1", "user1@gmail.com"),
                new User(3,"user2", "{noop}user2", "user2@gmail.com"),
                new User(4,"user3", "{noop}user3", "user3@gmail.com")
        ).collect(Collectors.toList());

        userRepository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityJwtApplication.class, args);
    }

}
