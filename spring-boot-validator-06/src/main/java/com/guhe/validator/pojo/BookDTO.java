package com.guhe.validator.pojo;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author njl
 * @date 2023/3/8
 */
@Data
public class BookDTO {
	// 书名不能为空（""）
	@Size(min = 3, max = 5)
	@NotNull
	private String name;

	@NotEmpty
	private String description;

	@NotNull
	private String type;

	@Max(100)
	@Min(10)
	private Integer price;
}
