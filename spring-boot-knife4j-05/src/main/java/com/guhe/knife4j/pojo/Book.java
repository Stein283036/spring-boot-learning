package com.guhe.knife4j.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author njl
 * @date 2023/3/8
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "tb_book")
@ApiModel("书籍")
@Entity
public class Book {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@ApiModelProperty("书籍 id")
	private Long id;

	@ApiModelProperty("书籍名称")
	@Column(nullable = false, unique = true, length = 50)
	private String name;

	@ApiModelProperty("书籍类型")
	@Column(nullable = false, length = 20)
	private String type;

	@ApiModelProperty("书籍描述")
	@Column
	private String description;
}
