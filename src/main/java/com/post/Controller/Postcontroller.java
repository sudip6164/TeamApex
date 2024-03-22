package com.post.Controller;



import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

 




import com.post.models.Post;
import com.post.prepository.Prepo;


@Controller
public class Postcontroller {
	
	@Autowired
	private  Userservice uService;
	
	@Autowired
	private Prepo prepo;
	
	
	
	
	@GetMapping("/uploadPost")
	public String  Uploadpost(Model model)
	{
		List<Post> imgList = prepo.findAll();
		model.addAttribute("imgList", imgList);
		return "ImageAdd.html";
		
	}
		

	 
	 @PostMapping("/upload")
	 public String uploadPhoto(@RequestParam MultipartFile postphoto , Model model) {

		 
		 Post post = new Post();
		 post.setPostphoto(postphoto.getOriginalFilename());
		 Post  uploading = prepo.save(post);
		 
		 if(uploading!=null)
			 {
			 
			try {
				System.out.println(new ClassPathResource("").getFile().getAbsolutePath());
				
				File saveFile = new ClassPathResource("/Users/sauravshrestha/Documents/workspace-spring-tool-suite-4-4.21.1.RELEASE/Saurav/src/main/resources/static/Images/").getFile();
				
				Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+postphoto.getOriginalFilename());
				System.out.println(path);
				Files.copy(postphoto.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);
				
			}catch (Exception e) {
			
				// TODO: handle exception
			e.printStackTrace();
			 }
			 }
		 
		List<Post> imgList = prepo.findAll();
	model.addAttribute("imgList", imgList);
	return "ImageAdd.html";
		 
	 }
	 
}
