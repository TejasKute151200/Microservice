package com.microservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="FileData")
public class FileSystemEntity {

	@Id
	@GeneratedValue(generator ="uuid")
	@GenericGenerator(name = "uuid",strategy = "uuid2")
	private String id;
	
	private String name;
	
	private String type;
	
	@Lob
	private byte[] data;

	public FileSystemEntity() {

	}

	public FileSystemEntity(String name, String type, byte[] data) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}	
}
