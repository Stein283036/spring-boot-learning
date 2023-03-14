package com.guhe.mybatis.mapper;

import com.guhe.mybatis.pojo.Book;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * @author njl
 * @date 2023/3/14
 */
@Mapper
public interface BookMapper {

	List<Book> selectAllBook();

	// 如果数据表中的列和 Java Bean 的属性不一致时配置结果集映射
	@Results({
			@Result(column = "type", property = "type", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "name", property = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "description", property = "description", javaType = String.class, jdbcType = JdbcType.VARCHAR),
	})
	@Select("select * from tb_book where id = #{id};")
	Book selectBookById(@Param("id") Long id);

	@Insert("insert into tb_book(type, name, description) values(#{type}, #{name}, #{description})")
	int insertBook(Book book);

	@Delete("delete from tb_book where id = #{id}")
	int deleteBookById(@Param("id") Long id);

	@Update("update tb_book set type = #{type}, name = #{name}, description = #{description} where id = #{id}")
	int updateBookById(Book book);
}
