package com.niit.foodshope.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id; 
	@Size(min=4,max=30,message="Category Should atleast have 4 Char")
	private String name;
	@Size(min=4,max=30,message="Description Should atleast have 4 Char")
	private String description;
	@Transient
	private MultipartFile categoryImage;
	public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MultipartFile getCategoryImage() {
		return categoryImage;
	}
	public void setCategoryImage(MultipartFile categoryImage) {
		this.categoryImage = categoryImage;
	}
	
	
}
