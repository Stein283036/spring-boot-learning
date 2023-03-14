package com.guhe.flyway.mapper;

import com.guhe.flyway.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author njl
 * @date 2023/3/14
 */
public interface UserMapper {
	@Select("select * from tb_flyway_user where id = #{id}")
	User selectUserById(@Param("id") Long id);

	@Insert("insert into tb_flyway_user(name, age) values(#{name}, #{age})")
	int insertUser(User user);
}
