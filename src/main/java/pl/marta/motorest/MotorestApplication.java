package pl.marta.motorest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MotorestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotorestApplication.class, args);
    }
}
