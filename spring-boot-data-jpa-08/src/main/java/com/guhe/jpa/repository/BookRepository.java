package com.guhe.jpa.repository;

import com.guhe.jpa.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author njl
 * @date 2023/3/14
 */
public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findAllByNameLikeIgnoreCaseOrDescriptionLikeIgnoreCaseOrderByIdDesc(String name, String description);

}
