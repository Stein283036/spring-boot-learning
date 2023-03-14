package com.guhe.mybatis.pojo;

import lombok.Data;

/**
 * @author njl
 * @date 2023/3/14
 */
@Data
public class Book {
	private Long id;
	private String name;
	private String type;
	private String description;
}
