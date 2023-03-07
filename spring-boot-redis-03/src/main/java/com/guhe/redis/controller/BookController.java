package com.guhe.redis.controller;

import com.guhe.redis.pojo.Book;
import com.guhe.redis.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
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

	/**
	 * 缓存管理器
	 */
	@Autowired
	private CacheManager cacheManager;

	@Autowired
	private BookRepository bookRepository;

	@GetMapping
	// value 指定缓存所属的组，key 指定缓存的键，unless 用来设置在什么条件下不进行缓存，condition 指定满足什么条件进行缓存
	@Cacheable(value = "books", key = "'cachedBooks'", unless = "#result == null ") // 将方法的返回值进行缓存
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
	@Cacheable(value = "books", key = "'book_' + #id", condition = "#id != null", unless = "#result == null")
	public Book queryBookById(@PathVariable("id") Long id) {
//		Book cachedBookWithId = redisTemplate1.opsForValue().get("book_" + id);
//		if (cachedBookWithId != null) {
//			return cachedBookWithId;
//		}
		Book book = bookRepository.findBookById(id);
		// 以编程式的方式使用缓存
//		redisTemplate1.opsForValue().set("book_" + id, book);
		return book;
	}

	@DeleteMapping("/{id}")
	// 通过指定 allEntries 为 true，删除该缓存组下面的所有缓存
	@CacheEvict(value = "books", key = "'book_' + #id", allEntries = true)
	public Book removeBookById(@PathVariable("id") Long id) {
		Book book = queryBookById(id);
		bookRepository.deleteById(id);
		return book;
	}
}
