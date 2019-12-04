package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RxJavaExampleApplication {

    private static final Logger logger = LoggerFactory.getLogger(RxJavaExampleApplication.class.getName());

    public static void main(String[] args) {

        SpringApplication.run(RxJavaExampleApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo(ReactiveService service) {

        return (args) -> {

            logger.info("***** getWords *****");
            service.getWords().subscribe(messages ->
                    messages.stream()
                            .forEach(message -> logger.info(message)));

            /*logger.info("***** getNumberedWords *****");
            service.getNumberedWords().subscribe(message ->
                    logger.info(message));*/

            /*logger.info("***** getLetters *****");
            service.getLetters().subscribe(message ->
                    logger.info(message));*/

            /*logger.info("***** getUniqueLetters *****");
            service.getUniqueLetters().subscribe(message ->
                    logger.info(message));*/

            /*logger.info("***** getUniqueSortedLetters *****");
            service.getUniqueSortedLetters().subscribe(message ->
                    logger.info(message));*/
        };
    }
}
