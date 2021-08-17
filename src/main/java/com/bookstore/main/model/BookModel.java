package com.bookstore.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "bookTable")
@Data
public class BookModel {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int bookId;
		
		private String bookName;
		private String bookAuthor;
		private String bookDescription;
		private String bookLogo;
		private double bookPrice;
		private long bookQuantity;
}
