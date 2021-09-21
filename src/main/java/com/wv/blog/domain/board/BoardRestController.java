package com.wv.blog.domain.board;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/board")
@Slf4j
public class BoardRestController {

	final String uploadUrl = "D:/workspace-eclipse/wvblog/src/main/resources/static/upload/";
	
	@PostMapping(path = "/imageUpload")
	public String imageUpload(MultipartFile multipartFile, HttpServletRequest request){
		String prefix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".") + 1, multipartFile.getOriginalFilename().length());
		String filename = UUID.randomUUID().toString() + "." + prefix;
		String filePath = uploadUrl + filename;
		File uploadFile = new File(filePath);
		String uploadPath = "/upload/" + filename;
		try {
			multipartFile.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		String root_path = request.getSession().getServletContext().getRealPath("/"); 
		log.info(root_path);
		
		return uploadPath;
	}
}
