package com.guhe.redis.pojo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author njl
 * @date 2023/3/8
 */
@Table(name = "tb_user")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private Integer age;
}
