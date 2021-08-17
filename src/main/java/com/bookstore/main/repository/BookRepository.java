package com.bookstore.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.main.model.BookModel;
@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer>{

}
