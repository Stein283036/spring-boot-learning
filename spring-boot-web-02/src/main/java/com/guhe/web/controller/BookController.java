package com.guhe.web.controller;

import com.guhe.web.pojo.Book;
import com.guhe.web.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author njl
 * @date 2023/2/7
 */
@RequestMapping("/books")
@Controller
public class BookController {

	@Autowired
	private Environment environment; // 环境对象，可用来读取系统属性、配置信息等

	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/")
	public String index(Model model) {
		List<Book> books = bookRepository.findAll();
		model.addAttribute("books", books);
		return "index";
	}

	@PostMapping
	public String queryBooksByNameLikeOrTypeLike(
			@RequestParam("name") String name,
			@RequestParam("type") String type,
			Model model
	) {
		List<Book> books = bookRepository.findBooksByNameContainsIgnoreCaseOrTypeLike(name, type);
		model.addAttribute("books", books);
		return "desiredBooks";
	}
}
