package com.guhe.druid.pojo;

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
@Entity
public class Book {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@Column(nullable = false, unique = true, length = 50)
	private String name;

	@Column(nullable = false, length = 20)
	private String type;

	@Column
	private String description;
}
