package com.ehr.spring;
//http://www.journaldev.com/2433/spring-mvc-tutorial
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ehr.spring.model.Person;
import com.ehr.spring.service.PersonService;

@Controller
public class PersonController {
	
	private PersonService personService;
	
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}
	
	@RequestMapping(value = "/CreatePatient", method = RequestMethod.GET)
	public String createPatient(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		model.addAttribute("listPhysicians", this.personService.listPhysicians());
		return "CreatePatient";
	}
	//Encryption module
	@RequestMapping(value = "/cda", method = RequestMethod.GET)//Cross Domain Authentication
	public String cda(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		model.addAttribute("listPhysicians", this.personService.listPhysicians());
		return "cdaEncrypt";
	}
	@RequestMapping(value = "/Decrypt", method = RequestMethod.GET)
	public String decrypt(Model model) {
		
		return "DecryptData";
	}
	@RequestMapping(value = "/DecryptData", method = RequestMethod.GET)
	public String decryptData(Model model,HttpServletRequest request) {
		String sessionToken=(String) request.getSession().getAttribute("sessionToken");
		System.out.println("sessionToken"+sessionToken);
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listDecryptPersons(sessionToken));
		return "DecryptData";
	}
	
	@RequestMapping(value = "/EditPatient", method = RequestMethod.GET)
	public String editPatient(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		model.addAttribute("listPhysicians", this.personService.listPhysicians());
		return "EditPatient";
	}
	@RequestMapping(value = "/DeletePatient", method = RequestMethod.GET)
	public String deletePatient(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
	
		return "DeletePatient";
	}
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		
		if(p.getId() == 0){
			//new person, add it
			this.personService.addPerson(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}
		
		return "redirect:/CreatePatient";
		
	}
	@RequestMapping(value= "/cda/encryptData", method = RequestMethod.POST)
	public String addcda(@ModelAttribute("person") Person p,Model model,HttpServletRequest request){
		String sessionToken=(String) request.getSession().getAttribute("sessionToken");
		System.out.println("sessionToken"+sessionToken);
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listEncrptedPersons(p,sessionToken));
		model.addAttribute("listPhysicians", this.personService.listPhysicians());
		return "EncryptedData";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
        return "redirect:/DeletePatient";
    }
 
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        model.addAttribute("listPhysicians", this.personService.listPhysicians());
        return "EditPatient";
    }
    @RequestMapping("/editCda/{id}")
    public String editCda(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        model.addAttribute("listPhysicians", this.personService.listPhysicians());
        return "cdaEncrypt";
    }
    
    @RequestMapping(value= "/patient/add", method = RequestMethod.POST)
	public String addPatient(@ModelAttribute("person") Person p){
		
		if(p.getId() == 0){
			//new person, add it
			this.personService.addPerson(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}
		
		return "redirect:/EditPatient";
		
	}
    @RequestMapping(value = "/delegate", method = RequestMethod.GET)
	public String delegation(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		model.addAttribute("listPhysicians", this.personService.listPhysicians());
		return "Delegation";
	}
    @RequestMapping("/delegateEdit/{id}")
    public String delegation(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
    	model.addAttribute("listPhysicians", this.personService.listPhysicians());
        return "Delegation";
    }
    @RequestMapping(value= "/delegate/add", method = RequestMethod.POST)
	public String delegatePerson(@ModelAttribute("person") Person p){
    	this.personService.updatePerson(p);
		
		/*if(p.getId() == 0){
			//new person, add it
			this.personService.addPerson(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}*/
		
		return "redirect:/delegate";
		
	}
	
}
