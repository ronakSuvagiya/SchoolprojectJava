package com.SchoolManagement.controler;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.SchoolManagement.common.ResponesDto;
import com.SchoolManagement.common.setResult;
import com.SchoolManagement.dao.ImageCatDao;
import com.SchoolManagement.dao.ImageDao;
import com.SchoolManagement.dao.SchoolDao;
import com.SchoolManagement.dto.ImageCatDto;
import com.SchoolManagement.dto.ImageDto;
import com.SchoolManagement.enitiy.ImageCatMaster;
import com.SchoolManagement.enitiy.ImageMaster;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



@RestController
public class UploadImageApi {
	
	
	@Autowired
	SchoolDao school;
	
	@Autowired
	ImageCatDao imageCat;
	
	@Autowired
	ImageDao imgMaster;
	
	@Autowired
    ServletContext context;
	
	public static String uploadDir = "/WEB-INF/classes/static/image/";
									  

	@PostMapping("/addCatApi")
	public ResponseEntity<ResponesDto> addcat(@RequestBody ImageCatDto imageDto){
		ImageCatMaster img = convertDto(imageDto);
		imageCat.save(img);
		setResult result = new setResult();
		ResponesDto respone = result.setResponse(HttpStatus.OK.value(), "Add Image Category Successfully");
		return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
	}
	
	@GetMapping("/getCatApi")
	public List<ImageCatMaster> getCat(@RequestParam("school") Integer school){
		return imageCat.findByschool(this.school.findById(school).get());
	}
	
	@PostMapping(value = "/addImageApi",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponesDto> addImage(@RequestParam("file") MultipartFile image1, Integer cat, Integer schoolId){
	
		String absoluteFilePath = context.getRealPath(uploadDir);
		ImageMaster image = new ImageMaster();
		//String extension = FilenameUtils.getExtension(imageDto.getImage_name().getOriginalFilename());
		System.out.println(absoluteFilePath);
	    Path fileNameAndPath = Paths.get(absoluteFilePath, image1.getOriginalFilename());
	    try {
	      Files.write(fileNameAndPath, image1.getBytes());
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
		image.setImage_name(image1.getOriginalFilename());
		image.setSchool(school.findById(schoolId).get());
		image.setCat(imageCat.findById(cat).get());
		try {
			imgMaster.save(image);
			setResult result = new setResult();
			ResponesDto respone = result.setResponse(HttpStatus.OK.value(), "Upload Image Successfully");
			return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			setResult result = new setResult();
			ResponesDto respone = result.setResponse(300, "Something is worng");
			return new ResponseEntity<ResponesDto>(respone, HttpStatus.OK);
		}
	}
	
	
	public ImageCatMaster convertDto(ImageCatDto imageDto) {
		ImageCatMaster img = new ImageCatMaster();
		img.setName(imageDto.getName());
		img.setSchool(school.findById(imageDto.getSchool()).get());
		return img;
	}
}
