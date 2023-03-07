package com.guhe.redis.repository;

import com.guhe.redis.pojo.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author njl
 * @date 2023/3/8
 */
// 在这个持久层上面使用注解配置表示这个接口相关的数据库操作都保存在 users 缓存组下面
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Long> {
	@Cacheable(key = "'allUsers'", unless = "#result == null")
	List<User> findAll();

	@Cacheable(key = "'user_' + #id", condition = "#id != null")
	User findUserById(Long id);

	@CacheEvict(key = "'book_' + #id", condition = "#id != null", allEntries = true)
	@Override
	void deleteById(Long id);
}
