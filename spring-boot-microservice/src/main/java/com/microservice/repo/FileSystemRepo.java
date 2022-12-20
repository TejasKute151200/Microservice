package com.microservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.microservice.entities.FileSystemEntity;
 
@Repository
public interface FileSystemRepo extends JpaRepository<FileSystemEntity, String>{

}
