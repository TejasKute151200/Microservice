package com.microservice.service.impl;

import java.io.IOException;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.microservice.entities.FileSystemEntity;
import com.microservice.repo.FileSystemRepo;
import com.microservice.service.FileSystemService;

@Service
public class FileSystemServiceImpl implements FileSystemService {

	@Autowired
	private FileSystemRepo fileRepo;

	@Override
	public FileSystemEntity store(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileSystemEntity fileSystem = new FileSystemEntity(fileName, file.getContentType(), file.getBytes());
		return fileRepo.save(fileSystem);
	}

	@Override
	public FileSystemEntity getFile(String id) {
		return fileRepo.findById(id).get();
	}

	@Override
	public Stream<FileSystemEntity> getAllFiles() {
		return fileRepo.findAll().stream();
	}
}
