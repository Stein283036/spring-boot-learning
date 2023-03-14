package com.guhe.mybatis.secondary.pojo;

import lombok.*;

import java.time.LocalDate;

/**
 * @author njl
 * @date 2023/3/14
 */
@Data
public class Customer {
	private Long id;
	private String name;
	private String email;
	private LocalDate birth;
}
