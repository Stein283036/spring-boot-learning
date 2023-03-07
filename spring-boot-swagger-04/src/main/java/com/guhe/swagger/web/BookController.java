package com.guhe.swagger.web;

import com.guhe.swagger.pojo.Book;
import com.guhe.swagger.repository.BookRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author njl
 * @date 2023/3/8
 */
@Api(value = "书籍请求处理器")
@RequestMapping("/books")
@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@ApiOperation("添加书籍")
	@ApiImplicitParams(
			{
					@ApiImplicitParam(name = "name", value = "书籍名称"),
					@ApiImplicitParam(name = "type", value = "书籍类型"),
					@ApiImplicitParam(name = "description", value = "书籍描述"),
			}
	)
	@PostMapping
	public Book addBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	// paramType: Valid values are path, query, body, header or form.
	@ApiImplicitParam(
			name = "id",
			value = "书的 id",
			required = true,
			paramType = "path",
			dataTypeClass = Long.class,
			example = "1"
	)
	@ApiOperation("根据 书籍 id 删除书籍")
	@DeleteMapping("{id}")
	public void removeBookById(@PathVariable("id") Long id) {
		bookRepository.deleteById(id);
	}

	@ApiOperation("查询所有书籍")
	@GetMapping
	public List<Book> queryAllBooks() {
		return bookRepository.findAll();
	}
}
