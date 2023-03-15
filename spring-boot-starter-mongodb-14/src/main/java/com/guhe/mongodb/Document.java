package com.guhe.mongodb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author njl
 * @date 2023/3/15
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class Document {
	private Long id;
	private String description;
	private String content;
}
