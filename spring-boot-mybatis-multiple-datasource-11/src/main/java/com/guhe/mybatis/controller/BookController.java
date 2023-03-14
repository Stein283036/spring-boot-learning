package com.guhe.mybatis.controller;

import com.guhe.mybatis.primary.mapper.BookMapper;
import com.guhe.mybatis.primary.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author njl
 * @date 2023/3/14
 */
@RequestMapping("/books")
@RestController
public class BookController {
	@Autowired
	private BookMapper bookMapper;

	@GetMapping("/{id}")
	public Book findById(@PathVariable("id") Long id) {
		return bookMapper.selectById(id);
	}
}
