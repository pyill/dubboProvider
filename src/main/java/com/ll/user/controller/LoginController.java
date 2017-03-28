package com.ll.user.controller;  
  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
import com.ll.user.entity.User;  
import com.ll.user.service.UserService;
  
@Controller  
@RequestMapping("/test")   
public class LoginController {  
    @Autowired  
    private UserService userService;  
  
@RequestMapping("/dologin.do") //url  
public String dologin(User user, Model model){
	System.out.println("dologin-in");
    if(userService.doUserLogin(user)){  
        model.addAttribute("successMsg", "成功");
        model.addAttribute("name", user.getUsername());  
        return "/success"; 
    }else{  
        model.addAttribute("failMsg", "失败");  
        return "/fail";  
    }     
}  
}  