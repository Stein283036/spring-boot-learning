package com.guhe.mybatis.secondary.mapper;

import com.guhe.mybatis.secondary.pojo.Customer;
import org.apache.ibatis.annotations.Param;

/**
 * @author njl
 * @date 2023/3/14
 */
public interface CustomerMapper {
	Customer selectById(@Param("id") Long id);
}
