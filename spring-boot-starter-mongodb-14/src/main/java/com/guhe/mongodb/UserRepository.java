package com.guhe.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author njl
 * @date 2023/3/15
 */
public interface UserRepository extends MongoRepository<User, Long> {

}
