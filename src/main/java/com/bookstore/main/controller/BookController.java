package com.bookstore.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.main.dto.BookDTO;
import com.bookstore.main.dto.ResponseDTO;
import com.bookstore.main.service.IBookService;

@RestController
public class BookController {
	@Autowired
	IBookService bookService;
	
	@GetMapping("/getallbooks/{token}")
	public ResponseEntity<ResponseDTO> getAllBook(@PathVariable String token){
		ResponseDTO respDTO = bookService.getAllBooks(token);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@GetMapping("/getbook/{token}/{id}")
	public ResponseEntity<ResponseDTO> getBook(@PathVariable String token,@PathVariable int id){
		ResponseDTO respDTO = bookService.getBooks(token,id);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@PostMapping("/addbook/{token}")
	public ResponseEntity<ResponseDTO> addBook(@PathVariable String token,@RequestBody BookDTO bookDto){
		ResponseDTO respDTO = bookService.addBook(token,bookDto);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@PutMapping("/update/{token}/{id}")
	public ResponseEntity<ResponseDTO> updateBook(@PathVariable String token,@PathVariable int id,@RequestBody BookDTO bookDto){
		ResponseDTO respDTO = bookService.updateBook(token,id,bookDto);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{token}/{id}")
	public ResponseEntity<ResponseDTO> deleteBook(@PathVariable String token,@PathVariable int id){
		ResponseDTO respDTO = bookService.delete(token,id);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@PutMapping("/updatePrice/{token}/{id}")
	public ResponseEntity<ResponseDTO> updatePrice(@PathVariable String token,@PathVariable int id,@RequestParam double price){
		ResponseDTO respDTO = bookService.updatePrice(token,id,price);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@PutMapping("/updateQuanity/{token}/{id}")
	public ResponseEntity<ResponseDTO> updateQuanity(@PathVariable String token,@PathVariable int id,@RequestParam long quantity){
		ResponseDTO respDTO = bookService.updateQuanity(token,id,quantity);
		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
	}
	
	@GetMapping("/verifyBookId/{token}/{id}")
	public Boolean verifyemail(@PathVariable String token,@PathVariable int id) {
		return bookService.verifyBookId(token,id);
	}
}
