package com.bookstore.main.dto;

import lombok.Data;

@Data
public class BookDTO {
	
	public String bookName;
	public String bookAuthor;
	public String bookDescription;
	public String bookLogo;
	public double bookPrice;
	public long bookQuantity;
}
