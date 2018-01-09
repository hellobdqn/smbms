package cn.smbms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.smbms.pojo.User;
import cn.smbms.service.user.UserService;
import cn.smbms.tools.Constants;
/**
 * 登录控制层
 * @author Administrator
 *
 */
@Controller
public class LoginController {
	private Logger logger = Logger.getLogger(LoginController.class);
	@Resource
	private UserService userService;
	//登录页面
	@RequestMapping("/login.html")
	public String login(){
		logger.info("login====>");
		return "login";
	}
	//验证用户登录
	@RequestMapping(value="/dologin.html",method=RequestMethod.POST)
	public String doLogin(@RequestParam String userCode,
						  @RequestParam String userPassword,
						  HttpServletRequest request,HttpSession session){
		User user = null;
		user = userService.login(userCode, userPassword);
		if(null != user){
			session.setAttribute(Constants.USER_SESSION, user);
			return "redirect:/sys/main.html";
		}else{
			request.setAttribute("error", "用户名或者密码有误!!");
			return "login";
		}
	}
	//主界面
	@RequestMapping("/sys/main.html")
	public String main(){
		return "frame";
	}
	//注销用户
	@RequestMapping("/logout.html")
	public String logout(HttpSession session){
		session.removeAttribute(Constants.USER_SESSION);
		return "login";
	}
	

}
