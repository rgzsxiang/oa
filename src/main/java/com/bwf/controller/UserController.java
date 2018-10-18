package com.bwf.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bwf.entity.User;
import com.bwf.service.IUserService;
import com.bwf.utils.StringUtils;

@Controller
@RequestMapping("user")
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	IUserService userService;
	
	//显示登录页面
	@GetMapping("login")
	public String login( Integer error , ModelMap modelMap ){
		modelMap.addAttribute("error",error);
		return "user/login";
	}
	
	//进行登录
	@PostMapping("doLogin")
	public String doLogin(User user,HttpSession session){
		logger.info("{},{}",user.getUsername(),user.getPassword());
		
		//把数据库中的密码加密
		user.setPassword(com.bwf.utils.StringUtils.md5(user.getPassword()));
		
		//执行登录功能
		User loginUser = userService.login(user);
		logger.info("password:{}",user.getPassword());
		
		if(loginUser==null){
			logger.info("登录失败，用户名或密码错误");
			//带着错误信息，跳转到登录页面
			return "redirect:/user/login？error=1";
		}else{
			logger.info("登录成功！");
			//登录成功，保存登录状态,把用户对象写入session
			session.setAttribute("user", loginUser);
					
			// 跳转到 首页
			return "redirect:/index";
		}

	}
	
	// 退出登录,首先清除session
	@GetMapping("logout")
	public String logout( HttpSession session ){
		session.removeAttribute("user");
		return "redirect:/user/login";
	}


}
