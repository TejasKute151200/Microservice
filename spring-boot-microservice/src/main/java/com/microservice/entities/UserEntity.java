package com.microservice.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity implements Serializable {
	
	/**
	 * Created By TejTechWorld
	 **/
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Name Field Can not be Blank Or Null")
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@NotBlank(message = "Mobile Number Field Can not be Blank Or Null")
	@Column(name="mobile", unique=true)
	private String mobile;

//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="created_by")
//	private UserEntity createdBy;
	
	@Column(name="created_on")
	@CreationTimestamp
	private Date createdOn;	
	
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="updated_by")
//	private UserEntity updatedBy;
	
	@Column(name="updated_on")
	@UpdateTimestamp
	private Date updatedOn;
	
}

