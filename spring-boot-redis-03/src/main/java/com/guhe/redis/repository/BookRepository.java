package com.guhe.redis.repository;

import com.guhe.redis.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author njl
 * @date 2023/2/7
 */
public interface BookRepository extends JpaRepository<Book, Long> {
	Book findBookById(Long id);

	List<Book> findBooksByNameContainsIgnoreCaseOrTypeLike(String name, String type);
}
