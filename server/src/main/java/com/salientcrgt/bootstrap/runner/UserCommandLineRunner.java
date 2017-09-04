package com.salientcrgt.bootstrap.runner;

import com.salientcrgt.bootstrap.dao.UserRepository;
import com.salientcrgt.bootstrap.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    private final UserRepository repository;

    public UserCommandLineRunner(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Stream.of("Pramod", "Neal", "Jonh").forEach(name -> repository.save(new User(name)));

        repository.findAll().forEach(System.out::println);
    }
}
