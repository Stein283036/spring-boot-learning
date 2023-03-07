package com.guhe.druid.repository;

import com.guhe.druid.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author njl
 * @date 2023/3/8
 */
public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findAllByNameLike(String name);
}
