package com.guhe.primary.repository;

import com.guhe.primary.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author njl
 * @date 2023/3/14
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
