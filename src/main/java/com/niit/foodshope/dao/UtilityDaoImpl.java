package com.niit.foodshope.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;
import org.springframework.web.multipart.MultipartFile;

@Service("utilityDao")
public class UtilityDaoImpl implements UtilityDao{
	List<ObjectError> errors=new ArrayList<ObjectError>();
	public String getImage(String folderName,int id){
		String fileName="";
		File folder=new File("D:/DevOps/workspace/foodshope/src/main/webapp/resources/images/"+folderName+"/");
		for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	        } else {
	        	System.out.println(fileEntry.getName().substring(0,fileEntry.getName().indexOf(".")));
	            if(fileEntry.getName().substring(0,fileEntry.getName().indexOf(".")).equals(String.valueOf(id))){
	            	fileName=fileEntry.getName();
	            	System.out.println(id);
	            }
	        }
	    }
		return fileName;
	}
	
	//Upload Image
	
	public void uploadImage(MultipartFile file){
		String error,fileName=null;
		try {
            fileName = file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File("D:/DevOps/workspace/ecomerce/src/main/webapp/resources/images/network/" + fileName)));
            buffStream.write(bytes);
            buffStream.close();
            error= "You have successfully uploaded " + fileName;
            System.out.println("---------->"+error);
        } catch (Exception e) {
        	error="You failed to upload " + fileName + ": " + e.getMessage();
        	System.out.println(e);
        }
	}
	
	public String uploadImage(MultipartFile image,String fileName,String folder,int imageId){
		String error="";
		//try {
		Path path=Paths.get("D:/DevOps/workspace/foodshope/src/main/webapp/resources/images/category/"+imageId+fileName.substring(fileName.indexOf('.')));
		if (!Files.exists(path)) {
		    try {
				Files.createFile(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (image != null && !image.isEmpty()) {
            try {
            	image.transferTo(new File(path.toString()));
            	error= "You have successfully uploaded " + fileName;
            } catch (Exception e) {
                e.printStackTrace();
                error="You failed to upload " + fileName + ": " + e.getMessage();
                throw new RuntimeException(" image saving failed.", e);
            }
		}
		return error;
	}
		public void setErrors(List<ObjectError> errors) {
		this.errors=errors;
	}

	public List<ObjectError> getErrors() {
		// TODO Auto-generated method stub
		return errors;
	}
	
}
