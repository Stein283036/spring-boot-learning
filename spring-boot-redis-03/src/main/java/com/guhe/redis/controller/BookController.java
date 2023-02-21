package com.guhe.redis.controller;

import com.guhe.redis.pojo.Book;
import com.guhe.redis.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author njl
 * @date 2023/2/7
 */
@RequestMapping("/books")
@RestController
public class BookController {

	@Autowired
	private RedisTemplate<String, List<Book>> redisTemplate2;

	@Autowired
	private RedisTemplate<String, Book> redisTemplate1;

	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/")
	@Cacheable(value = "books", key = "cachedBooks", unless = "#books != null") // 将方法的返回值进行缓存
	public List<Book> queryAllBooks() {
//		List<Book> cachedBooks = redisTemplate2.opsForValue().get("cachedBooks");
//		if (cachedBooks != null) {
//			return cachedBooks;
//		}
		List<Book> books = bookRepository.findAll();
//		redisTemplate2.opsForValue().set("cachedBooks", books);
		return books;
	}

	@GetMapping("/{id}")
	public Book queryBookById(@PathVariable("id") Long id) {
		Book cachedBookWithId = redisTemplate1.opsForValue().get("book_" + id);
		if (cachedBookWithId != null) {
			return cachedBookWithId;
		}
		Book book = bookRepository.findBookById(id);
		redisTemplate1.opsForValue().set("book_" + id, book);
		return book;
	}

	@DeleteMapping("/{id}")
	@CacheEvict(value = "book_#{id}")
	public Book removeBookById(@PathVariable("id") Long id) {
		Book book = queryBookById(id);
		bookRepository.deleteById(id);
		return book;
	}
}
