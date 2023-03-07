package com.guhe.validator.web;

import com.guhe.validator.pojo.BookDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author njl
 * @date 2023/3/8
 */
@RequestMapping("/books")
@RestController
public class BookController {
	@PostMapping
	public BookDTO addBook(@Validated @RequestBody BookDTO bookDTO) {
		return bookDTO;
	}
}
