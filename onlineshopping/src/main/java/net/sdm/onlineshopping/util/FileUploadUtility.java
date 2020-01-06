package net.sdm.onlineshopping.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
public static final String ABS_PATH= "C:\\Online\\Shopping-Online\\onlineshopping\\src\\main\\webapp\\assets\\images\\";
public static String REAL_PATH="";
public static void uploadFile(HttpServletRequest request, MultipartFile file,
		String name) {
	REAL_PATH=request.getSession().getServletContext().getRealPath("/assets/images/");
	
	if(!new File(ABS_PATH).exists())
	{
		new File(ABS_PATH).mkdirs();
	}
	
	if(!new File(REAL_PATH).exists())
	{
		new File(REAL_PATH).mkdirs();
	}
	
	try{
		file.transferTo(new File(ABS_PATH +name+ ".jpg"));
		file.transferTo(new File(REAL_PATH +name+ ".jpg"));
		
	}
	catch(Exception E)
	{
		
	}
	
}
}
