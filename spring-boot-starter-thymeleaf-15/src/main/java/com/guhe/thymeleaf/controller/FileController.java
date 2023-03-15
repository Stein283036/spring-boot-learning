package com.guhe.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author njl
 * @date 2023/3/15
 */
@RequestMapping("/files")
@Controller
public class FileController {
	@Value("${common.file.upload}")
	private String path;

	@GetMapping("/upload")
	public String upload() {
		return "upload";
	}

	@GetMapping("/multiple/upload")
	public String multipleUpload() {
		return "multiple-upload";
	}

	@ResponseBody
	@PostMapping("/upload")
	public String uploadFile(@RequestPart MultipartFile file) throws IOException {
		Files.copy(file.getInputStream(), Paths.get(path, file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		return "文件存储成功，存储路径为 " + path + file.getOriginalFilename();
	}

	@ResponseBody
	@PostMapping("/multiple/upload")
	public String multipleUpload(@RequestPart MultipartFile[] files) throws IOException {
		for (MultipartFile file : files) {
			Files.copy(file.getInputStream(), Paths.get(path, file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		}
		return "你总共上传了 " + files.length + " 张图片。";
	}
}
