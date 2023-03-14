package com.guhe.controller;

import com.guhe.primary.pojo.Book;
import com.guhe.primary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author njl
 * @date 2023/3/14
 */
@RequestMapping("/books")
@RestController
public class BookController {
	@Autowired
	private BookRepository bookRepository;

	@GetMapping
	public List<Book> queryAll() {
		return bookRepository.findAll();
	}
}
