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
    public CommandLineRunner demo(ReactiveController controller) {

        return (args) -> {

            logger.info("***** getWords *****");
            controller.getWords().subscribe(messages ->
                    messages.stream()
                            .forEach(message -> logger.info(message)));

            /*logger.info("***** getNumberedWords *****");
            controller.getNumberedWords().subscribe(message ->
                    logger.info(message));*/

            /*logger.info("***** getLetters *****");
            controller.getLetters().subscribe(message ->
                    logger.info(message));*/

            /*logger.info("***** getUniqueLetters *****");
            controller.getUniqueLetters().subscribe(message ->
                    logger.info(message));*/

            /*logger.info("***** getUniqueSortedLetters *****");
            controller.getUniqueSortedLetters().subscribe(message ->
                    logger.info(message));*/
        };
    }
}
