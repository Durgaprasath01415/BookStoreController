package com.bookstore.main.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookstore.main.dto.BookDTO;
import com.bookstore.main.dto.ResponseDTO;
import com.bookstore.main.exceptions.BookExceptions;
import com.bookstore.main.model.BookModel;
import com.bookstore.main.repository.BookRepository;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	BookRepository bookRepository;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	RestTemplate restTemplate;
	
	
	@Override
	public ResponseDTO getAllBooks(String token) {
		boolean verify = restTemplate.getForObject("http://bookstoreuser-client/verifyemail/" + token,
				Boolean.class);
		if (verify) {
			List<BookModel> bookList = bookRepository.findAll();
			return new ResponseDTO("List of all books ",bookList);
		}else {
			throw new BookExceptions(400, "User not logged in");
		}
	}


	@Override
	public ResponseDTO getBooks(String token,int id) {
		boolean verify = restTemplate.getForObject("http://bookstoreuser-client/verifyemail/" + token,
				Boolean.class);
		if (verify) {
		Optional<BookModel> isUserPresent = bookRepository.findById(id);
		return new ResponseDTO("User of id:" + id, isUserPresent);
	}else {
		throw new BookExceptions(400, "User not logged in");
	}
	}


	@Override
	public ResponseDTO addBook(String token, BookDTO bookDto) {
		boolean verify = restTemplate.getForObject("http://bookstoreuser-client/verifyemail/" + token,
				Boolean.class);
		if (verify) {
			BookModel AddDetails = modelMapper.map(bookDto, BookModel.class);
			bookRepository.save(AddDetails);
		return new ResponseDTO("Book is added successfully",AddDetails);
		}else {
			throw new BookExceptions(400, "User not logged in");
		}
	}


	@Override
	public ResponseDTO updateBook(String token, int id,BookDTO bookDto) {
		boolean verify = restTemplate.getForObject("http://bookstoreuser-client/verifyemail/" + token,
				Boolean.class);
		if (verify) {
			Optional<BookModel> isUserPresent = bookRepository.findById(id);
			if (isUserPresent.isPresent()) {
				isUserPresent.get().setBookName(bookDto.getBookName());
				isUserPresent.get().setBookAuthor(bookDto.getBookAuthor());
				isUserPresent.get().setBookDescription(bookDto.getBookDescription());
				isUserPresent.get().setBookName(bookDto.getBookLogo());
				isUserPresent.get().setBookPrice(bookDto.getBookPrice());
				isUserPresent.get().setBookQuantity(bookDto.getBookQuantity());
				bookRepository.save(isUserPresent.get());
				return new ResponseDTO("Book details is successfully updated",isUserPresent.get());
			}else {
				throw new BookExceptions(400, "Book id not present");
			}
		}else {
			throw new BookExceptions(400, "User not logged in");
		}
	}


	@Override
	public ResponseDTO delete(String token, int id) {
		boolean verify = restTemplate.getForObject("http://bookstoreuser-client/verifyemail/" + token,
				Boolean.class);
		if (verify) {
			Optional<BookModel> isUserPresent = bookRepository.findById(id);
			if (isUserPresent.isPresent()) {
				bookRepository.deleteById(id);
				return new ResponseDTO("Book details is successfully Deleted",isUserPresent.get());
			}else {
				throw new BookExceptions(400, "Book id not present");
			}
		}else {
			throw new BookExceptions(400, "User not logged in");
		}
	}


	@Override
	public ResponseDTO updatePrice(String token, int id, double price) {
		boolean verify = restTemplate.getForObject("http://bookstoreuser-client/verifyemail/" + token,
				Boolean.class);
		if (verify) {
			Optional<BookModel> isUserPresent = bookRepository.findById(id);
			if (isUserPresent.isPresent()) {
				isUserPresent.get().setBookPrice(price);
				bookRepository.save(isUserPresent.get());
			return new ResponseDTO("Book Price is successfully updated",isUserPresent.get());
		}else {
			throw new BookExceptions(400, "Book id not present");
		}
	}else {
		throw new BookExceptions(400, "User not logged in");
	}
	}


	@Override
	public ResponseDTO updateQuanity(String token, int id, long quantity) {
		boolean verify = restTemplate.getForObject("http://bookstoreuser-client/verifyemail/" + token,
				Boolean.class);
		if (verify) {
			Optional<BookModel> isUserPresent = bookRepository.findById(id);
			if (isUserPresent.isPresent()) {
				isUserPresent.get().setBookQuantity(quantity);
				bookRepository.save(isUserPresent.get());
			return new ResponseDTO("Book Quanity is successfully updated",isUserPresent.get());
		}else {
			throw new BookExceptions(400, "Book id not present");
		}
	}else {
		throw new BookExceptions(400, "User not logged in");
	}
	}


	@Override
	public Boolean verifyBookId(String token,int id) {
		boolean verify = restTemplate.getForObject("http://bookstoreuser-client/verifyemail/" + token,
				Boolean.class);
		if (verify) {
			Optional<BookModel> isBookPresent = bookRepository.findById(id);
			if(isBookPresent != null) {
			return true;
			}else {
				return false;
			}
		}
		return null;
	}
}
