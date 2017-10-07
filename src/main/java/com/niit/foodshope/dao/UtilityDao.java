package com.niit.foodshope.dao;


import java.util.List;

import org.springframework.validation.ObjectError;
import org.springframework.web.multipart.MultipartFile;


public interface UtilityDao {
	public String getImage(String folderName,int id);
	public void setErrors(List<ObjectError> errors);
	public List<ObjectError> getErrors();
	public String uploadImage(MultipartFile image,String fileName,String folder,int imageId);

}
