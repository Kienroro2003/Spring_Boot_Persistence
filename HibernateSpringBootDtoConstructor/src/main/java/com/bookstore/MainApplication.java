package com.bookstore;

import com.bookstore.dto.AuthorDto;
import java.util.List;
import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\n\n Fetch authors by Genre:");
            System.out.println("-----------------------------------------------------------------------------");

            List<AuthorDto> authors = bookstoreService.fetchByGenre();

            System.out.println("Number of authors:" + authors.size());

            for (AuthorDto author : authors) {
                System.out.println("Author name: " + author.getName()
                        + " | Age: " + author.getAge());
            }

            System.out.println("\n\n Fetch all Authors:");
            System.out.println("-----------------------------------------------------------------------------");

            List<AuthorDto> allAuthors = bookstoreService.fetchAllAuthors();

            System.out.println("Number of authors:" + allAuthors.size());

            for (AuthorDto author : allAuthors) {
                System.out.println("Author name: " + author.getName()
                        + " | Age: " + author.getAge());
            }
        };
    }
}
