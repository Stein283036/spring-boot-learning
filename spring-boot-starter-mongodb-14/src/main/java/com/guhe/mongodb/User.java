package com.guhe.mongodb;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author njl
 * @date 2023/3/15
 */
@AllArgsConstructor
@Data
public class User {
	private Long id;
	private String name;
	private Integer age;
}
