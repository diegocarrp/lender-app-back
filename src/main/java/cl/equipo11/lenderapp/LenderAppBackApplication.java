package cl.equipo11.lenderapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class LenderAppBackApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LenderAppBackApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {

    }
}
