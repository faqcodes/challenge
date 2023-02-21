package com.faqcodes.challengue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ChallengueApplication {
    public static void main(String[] args) {
      SpringApplication.run(ChallengueApplication.class, args);
    }
}