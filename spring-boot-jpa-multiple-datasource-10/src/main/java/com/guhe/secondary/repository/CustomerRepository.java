package com.guhe.secondary.repository;

import com.guhe.secondary.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author njl
 * @date 2023/3/14
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
