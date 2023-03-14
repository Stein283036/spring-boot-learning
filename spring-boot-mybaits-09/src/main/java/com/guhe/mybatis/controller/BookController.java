package com.guhe.mybatis.controller;

import com.guhe.mybatis.mapper.BookMapper;
import com.guhe.mybatis.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author njl
 * @date 2023/3/14
 */
@RequestMapping("/books")
@RestController
public class BookController {
	@Autowired
	private BookMapper bookMapper;

	@GetMapping
	public List<Book> queryAllBook() {
		return bookMapper.selectAllBook();
	}

	@PostMapping
	public Integer saveBook(@RequestBody Book book) {
		return bookMapper.insertBook(book);
	}

	@DeleteMapping("/{id}")
	public Integer removeBookById(@PathVariable("id") Long id) {
		return bookMapper.deleteBookById(id);
	}

	@PutMapping
	public Integer updateBookById(Book book) {
		return bookMapper.updateBookById(book);
	}

	@GetMapping("/{id}")
	public Book queryBookById(@PathVariable("id") Long id) {
		return bookMapper.selectBookById(id);
	}
}
