package com.faqcodes.challenge;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ChallengeApplication {
    public static void main(String[] args) {
      SpringApplication.run(ChallengeApplication.class, args);
    }
}