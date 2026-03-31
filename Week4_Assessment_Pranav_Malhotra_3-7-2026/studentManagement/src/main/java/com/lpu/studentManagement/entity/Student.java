package com.lpu.studentManagement.entity;

import java.io.Serializable;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique = true)
	private String email;
	private String course;
	private int marks;
	@Embedded
	@AttributeOverrides({
	    @AttributeOverride(name="fileName", column=@Column(name="profile_file_name")),
	    @AttributeOverride(name="fieldType", column=@Column(name="profile_field_type")),
	    @AttributeOverride(name="data", column=@Column(name="profile_data"))
	})
	private FileData profileImage;
	@Embedded
	@AttributeOverrides({
	    @AttributeOverride(name="fileName", column=@Column(name="assignment_file_name")),
	    @AttributeOverride(name="fieldType", column=@Column(name="assignemt_field_type")),
	    @AttributeOverride(name="data", column=@Column(name="assignemt_data"))
	})
	private FileData assignmentFile;
	private String password;
	private String role;
}
