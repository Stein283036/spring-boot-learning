package com.guhe.jpa.controller;

import com.guhe.jpa.pojo.Book;
import com.guhe.jpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public List<Book> queryBooksByNameOrDesc(
			@RequestParam("name") String name,
			@RequestParam("description") String description
	) {
		// 需要显示地拼接上模糊查询的标识 %
		return bookRepository.findAllByNameLikeIgnoreCaseOrDescriptionLikeIgnoreCaseOrderByIdDesc(
				"%" + name + "%",
				"%" + description + "%"
		);
	}
}
