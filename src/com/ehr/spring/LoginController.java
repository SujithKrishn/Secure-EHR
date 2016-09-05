package com.ehr.spring;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ehr.spring.model.FGA;
import com.ehr.spring.model.Group;
import com.ehr.spring.model.Login;
import com.ehr.spring.model.Person;
import com.ehr.spring.service.FGAService;
import com.ehr.spring.service.GroupService;
import com.ehr.spring.service.LoginService;

@Controller
public class LoginController {

	private LoginService loginService;
	private GroupService groupService;
	private FGAService fgaService;
	public FGAService getFgaService() {
		return fgaService;
	}
	@Autowired(required=true)
	@Qualifier(value="fgaService")
	public void setFgaService(FGAService fgaService) {
		this.fgaService = fgaService;
	}
	public GroupService getGroupService() {
		return groupService;
	}
	@Autowired(required=true)
	@Qualifier(value="groupService")
	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}
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

	
	@RequestMapping(value="/validateLogin", method = RequestMethod.POST)
	 public ModelAndView validateLogin(@ModelAttribute("login") Login login,Model model,HttpServletRequest request) {  
     //  String message = "HELLO SPRING MVC HOW R U"; 
		
		 request.getSession().setAttribute("login",login);
		if(this.loginService.validateUser(login))
		{
		model.addAttribute("listPersons", this.loginService.userAccessData(login));
       return new ModelAndView("HomePage");  
		}
		else{
			model.addAttribute("message","Login Failed");
		return new ModelAndView("EhrLogin");
		}
		
		}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	 public ModelAndView home(Model model,HttpServletRequest request) {  
    //  String message = "HELLO SPRING MVC HOW R U"; 
		
		 Login login = (Login)request.getSession().getAttribute("login");
		if(this.loginService.validateUser(login))
		{
		model.addAttribute("listPersons", this.loginService.userAccessData(login));
      return new ModelAndView("HomePage");  
		}
		else{
			model.addAttribute("message","Login Failed");
		return new ModelAndView("EhrLogin");
		}
		
		}
	@RequestMapping(value = "/group", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("group", new Group());
		model.addAttribute("listPersons", this.groupService.listGroups());
		return "CGroup";
		
	}
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String listUsers(Model model) {
		model.addAttribute("user", new Login());
		model.addAttribute("listPersons", this.loginService.listUsers());
		model.addAttribute("listGroups", this.loginService.listExistingGroups());
		return "CreateUser";
		
	}
	@RequestMapping(value = "/revoke", method = RequestMethod.GET)
	public String revoke(Model model) {
		model.addAttribute("user", new Login());
		model.addAttribute("listPersons", this.loginService.listUsers());
		model.addAttribute("listGroups", this.loginService.listExistingGroups());
		return "Revocation";
		
	}
	@RequestMapping("/revokeUser/{id}")
    public String revokeUser(@PathVariable("id") int id){
		
        this.loginService.deleteUser(id);
        return "redirect:/revoke";
    }
	@RequestMapping(value = "/fga", method = RequestMethod.GET)
	public String listFGA(Model model) {
		model.addAttribute("fga", new FGA());
		model.addAttribute("listPersons", this.fgaService.listFGAs());
		model.addAttribute("listFGAColumns", this.fgaService.listFGAColumns());
		model.addAttribute("listGroups", this.loginService.listExistingGroups());
		return "FineGrainedAC";
		
	}
		@RequestMapping(value= "/CreateGroup", method = RequestMethod.POST)
		public String addGroup(@ModelAttribute("group") Group p){
			
			if(p.getGroupId() == 0){
				//new person, add it
				this.groupService.createGroup(p);
			}else{
				//existing person, call update
				this.groupService.updateGroup(p);
			}
			
			return "redirect:/group";
			
		}
		@RequestMapping(value= "/CreateFGA", method = RequestMethod.POST)
		public String addFGA(@ModelAttribute("fga") FGA p){
			
			if(p.getId() == 0){
				//new person, add it
				this.fgaService.createFGA(p);
			}else{
				//existing person, call update
				this.fgaService.updateFGA(p);
			}
			
			return "redirect:/fga";
			
		}
		@RequestMapping(value= "/CreateUser", method = RequestMethod.POST)
		public String addUser(@ModelAttribute("user") Login p){
			
			if(p.getLoginId() == 0){
				//new person, add it
				this.loginService.createUser(p);
			}else{
				//existing person, call update
				this.loginService.updateUser(p);
			}
			
			return "redirect:/user";
			
		}
		
		@RequestMapping("/removeGroup/{id}")
	    public String removeGroup(@PathVariable("id") int id){
			
	        this.groupService.deleteGroup(id);
	        return "redirect:/group";
	    }
		@RequestMapping("/removeUser/{id}")
	    public String removeUser(@PathVariable("id") int id){
			
	        this.loginService.deleteUser(id);
	        return "redirect:/user";
	    }
		@RequestMapping("/removeFGA/{id}")
	    public String removeFGA(@PathVariable("id") int id){
			
	        this.fgaService.deleteFGA(id);
	        return "redirect:/fga";
	    }
	 
	    @RequestMapping("/editGroup/{id}")
	    public String editGroup(@PathVariable("id") int id, Model model){
	        model.addAttribute("group", this.groupService.getGroupById(id));
	        model.addAttribute("listPersons", this.groupService.listGroups());
	        
	        return "CGroup";
	    }
	    @RequestMapping("/editFGA/{id}")
	    public String editFGA(@PathVariable("id") int id, Model model){
	        model.addAttribute("fga", this.fgaService.getFGAById(id));
	        model.addAttribute("listPersons", this.fgaService.listFGAs());
	    	model.addAttribute("listFGAColumns", this.fgaService.listFGAColumns());
			model.addAttribute("listGroups", this.loginService.listExistingGroups());
	        return "FineGrainedAC";
	    }
	    @RequestMapping("/editUser/{id}")
	    public String editUser(@PathVariable("id") int id, Model model){
	        model.addAttribute("user", this.loginService.getUserById(id));
	        model.addAttribute("listPersons", this.loginService.listUsers());
	        model.addAttribute("listGroups", this.loginService.listExistingGroups());
	        return "CreateUser";
	    }
	    @RequestMapping(value = "/ttp", method = RequestMethod.GET)
		public String ttp(Model model) {
	    	model.addAttribute("ttp", new FGA());
			return "ttp";
			
		}
	    
	   
	   		
	   		
	    @RequestMapping(value = "/ttpToken")
		public String ttpToken(Model model,HttpServletRequest request) {
	    	 
	    	char[] alphNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

	    	Random rnd = new Random();
	    	StringBuilder sb = new StringBuilder((100000 + rnd.nextInt(900000)) + "-");
	    	for (int i = 0; i < 5; i++)
	    	    sb.append(alphNum[rnd.nextInt(alphNum.length)]);

	    	String id = sb.toString();

	    	System.out.println("ID-------------------------"+id);
	    	request.getSession().setAttribute("sessionToken",id);
			model.addAttribute("sessionToken", id);
			return "ttp";
			
		}
}
