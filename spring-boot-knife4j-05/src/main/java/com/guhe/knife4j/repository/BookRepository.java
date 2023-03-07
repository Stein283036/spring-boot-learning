package com.guhe.knife4j.repository;

import com.guhe.knife4j.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author njl
 * @date 2023/2/7
 */
public interface BookRepository extends JpaRepository<Book, Long> {

}
