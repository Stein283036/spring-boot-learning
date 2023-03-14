package com.guhe.mybatis.primary.mapper;

import com.guhe.mybatis.primary.pojo.Book;
import org.apache.ibatis.annotations.Param;

/**
 * @author njl
 * @date 2023/3/14
 */
public interface BookMapper {
	Book selectById(@Param("id") Long id);
}
