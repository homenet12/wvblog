package com.wv.blog.domain.common;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile implements MultipartFile{

	private String name;
	private Long size;
	private String type;
	private Long lastModified;
	private LocalDate lastModifiedDate;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getOriginalFilename() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public boolean isEmpty() {
		if(size <= 0) return false;
		return true;
	}

	@Override
	public long getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public byte[] getBytes() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void transferTo(File dest) throws IOException, IllegalStateException {
		// TODO Auto-generated method stub
		
	}

}
