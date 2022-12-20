package com.microservice.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.microservice.entities.FileSystemEntity;

public interface FileSystemService {
	
	public FileSystemEntity store(MultipartFile file)throws IOException;
	
	public FileSystemEntity getFile(String id);
	
	public Stream<FileSystemEntity>getAllFiles();
	
	// update 
	
	// delete

}
