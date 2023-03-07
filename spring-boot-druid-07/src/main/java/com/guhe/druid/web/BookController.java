package com.guhe.druid.web;

import com.guhe.druid.pojo.Book;
import com.guhe.druid.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author njl
 * @date 2023/3/8
 */
@RequestMapping("/books")
@RestController
public class BookController {
	@Autowired
	private BookRepository bookRepository;

	@GetMapping
	public List<Book> queryAllBook() {
		return bookRepository.findAll();
	}

	@GetMapping("/condition")
	public List<Book> queryByNameLike(@RequestParam("name") String name) {
		return bookRepository.findAllByNameLike(name);
	}

	@GetMapping("{id}")
	public Book queryBookById(@PathVariable("id") Long id) {
		return bookRepository.findById(id).orElse(null);
	}

	@DeleteMapping("{id}")
	public void removeBookById(@PathVariable("id") Long id) {
		bookRepository.deleteById(id);
	}
}
