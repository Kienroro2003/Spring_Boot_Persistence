package com.bookstore.repository;

import com.bookstore.dto.AuthorDto;
import java.util.List;
import com.bookstore.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT new com.bookstore.dto.AuthorDto(a.name, a.age) from Author AS a")
    List<AuthorDto> findByGenre(String genre);

    @Transactional(readOnly = true)
    @Query(value = "SELECT new com.bookstore.dto.AuthorDto(a.name, a.age, a.genre) from Author AS a")
    List<AuthorDto> fetchAuthors();
}
