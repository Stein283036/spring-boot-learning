package com.guhe.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

/**
 * @author njl
 * @date 2023/3/16
 */
@SpringBootTest
class SpringBootEmailAppTest {
	@Autowired
	private JavaMailSender javaMailSender;

	@Test
	void testSendMimeEmailEmbeddedImage() throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		mimeMessageHelper.setFrom("597061520@qq.com");
		mimeMessageHelper.setTo("stein283036@gmail.com");
		mimeMessageHelper.setSubject("MimeMessage Embedded Image");
		String text = "<html><body><img src=\"cid:beauty\"></body></html>";
		mimeMessageHelper.setText(text, true);
		ClassPathResource beautyResource = new ClassPathResource("static/beauty.jpg");
		mimeMessageHelper.addInline("beauty", beautyResource );
		javaMailSender.send(mimeMessage);
	}

	// 像这个发送邮件任务尤其是带有附件，发送速度很慢，就可以使用异步任务来处理
	@Test
	void testSendMimeEmail() throws MessagingException, IOException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
		mimeMessageHelper.setFrom("597061520@qq.com");
		mimeMessageHelper.setTo("stein283036@gmail.com");
		mimeMessageHelper.setSubject("MimeMessage");
		mimeMessageHelper.setText("有附件的邮件");
		// 使用 ClassPathResource 创建类路径下时的资源不要加 classpath 前缀
		ClassPathResource beautyResource = new ClassPathResource("static/beauty.jpg");
		mimeMessageHelper.addAttachment("美女", beautyResource.getFile());
		ClassPathResource mountainResource = new ClassPathResource("static/mountain.jpg");
		mimeMessageHelper.addAttachment("山景", mountainResource.getFile());
		javaMailSender.send(mimeMessage);
	}

	@Test
	void testSendEmail() {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom("597061520@qq.com");
		smm.setTo("stein283036@gmail.com", "stein061520@gmail.com");
		smm.setSubject("Learning Spring Boot");
		smm.setText("send email with the help of org.springframework.mail.javamail.JavaMailSender");
		javaMailSender.send(smm);
	}
}