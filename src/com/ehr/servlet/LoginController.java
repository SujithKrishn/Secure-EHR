package com.ehr.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ehr.spring.model.Login;
import com.ehr.spring.model.Person;
import com.ehr.spring.service.LoginService;

@Controller
public class LoginController {

	private LoginService loginService;
	public LoginService getLoginService() {
		return loginService;
	}
	@Autowired(required=true)
	@Qualifier(value="loginService")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping("/login")
	 public ModelAndView login() {  
      //  String message = "HELLO SPRING MVC HOW R U";  
        return new ModelAndView("EhrLogin");  
    } 
	@RequestMapping("/login1")
	 public ModelAndView login1() {  
     //  String message = "HELLO SPRING MVC HOW R U";  
       return new ModelAndView("EhrLogin");  
   } 
	
//	@RequestMapping(value="/validateLogin", method = RequestMethod.POST)
//	 public ModelAndView validateLogin(@ModelAttribute("login") Login login) {  
//     //  String message = "HELLO SPRING MVC HOW R U"; 
//		if(this.loginService.validateUser(login))
//       return new ModelAndView("EHR");  
//		else
//		return new ModelAndView("EhrLogin");
//   } 
//	@RequestMapping(value="/validateLogin", method = RequestMethod.POST)
//	 public ModelAndView validateLogin1() {  
//    //  String message = "HELLO SPRING MVC HOW R U"; 
//		
//      return new ModelAndView("EHR");  
//		
//  } 
//	@RequestMapping(value="/validateLogin")
//	 public ModelAndView validateLogin2() {  
//   //  String message = "HELLO SPRING MVC HOW R U"; 
//		
//     return new ModelAndView("EHR");  
//		
// } 
/*	@RequestMapping(value = "/validateLogin", method = RequestMethod.POST)
	public String login(@Validated Login user, Model model) {
		model.addAttribute("userName", user.getLoginName());
		return "EHR";
	}*/
	@RequestMapping("/validateLogin")
	 public ModelAndView validateLogin() {  
     //  String message = "HELLO SPRING MVC HOW R U";  
       return new ModelAndView("EHR");  
   } 
	
}
