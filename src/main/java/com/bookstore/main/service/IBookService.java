package com.bookstore.main.service;

import org.springframework.stereotype.Service;

import com.bookstore.main.dto.BookDTO;
import com.bookstore.main.dto.ResponseDTO;

@Service
public interface IBookService {

	ResponseDTO getAllBooks(String token);

	ResponseDTO getBooks(String token,int id);

	ResponseDTO addBook(String token, BookDTO bookDto);

	ResponseDTO updateBook(String token, int id, BookDTO bookDto);

	ResponseDTO delete(String token, int id);

	ResponseDTO updatePrice(String token, int id, double price);

	ResponseDTO updateQuanity(String token, int id, long quantity);

	Boolean verifyBookId(String token,int id);

}
