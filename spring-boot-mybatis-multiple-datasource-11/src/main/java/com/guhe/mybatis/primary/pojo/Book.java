package com.guhe.mybatis.primary.pojo;

import lombok.*;

/**
 * @author njl
 * @date 2023/3/14
 */
@Data
public class Book {
	private Long id;
	private String type;
	private String name;
	private String description;
}
