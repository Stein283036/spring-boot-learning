package com.guhe.mongodb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * @author njl
 * @date 2023/3/15
 */
@SpringBootTest
class SpringBootMongoDBAppTest {
	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private UserRepository userRepository;

	@Test
	void testUser() {
		User user1 = new User(100L, "倪京龙", 23);
		User user2 = new User(101L, "何晶雯", 22);
		userRepository.saveAll(Arrays.asList(user1, user2));
		Iterable<User> users = userRepository.findAllById(Arrays.asList(100L, 101L));
		System.out.println("users = " + users);
		userRepository.deleteById(100L);
		Assertions.assertEquals(1, userRepository.findAll().size());
	}

	@Test
	void testDocument() {
		Document doc1 = Document.builder().id(1L).description("MongoDB 文档 A").content("学习使用 MongoDB").build();
		Document doc2 = new Document(2L, "MongoDB 文档 2", "学习在 Java 中使用 MongoDB");
		documentRepository.saveAll(Arrays.asList(doc1, doc2));
	}
}