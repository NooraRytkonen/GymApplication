package hh.swd.harjoitustyo.webcontrol;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd.harjoitustyo.domain.CategoryRepository;
import hh.swd.harjoitustyo.domain.GroupExercise;
import hh.swd.harjoitustyo.domain.GroupExerciseRepository;


@Controller
public class GroupExerciseController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showIndex() {
		return "index";
	}
	
	@RequestMapping(value = "/gym", method = RequestMethod.GET)
	public String showAboutGym() {
		return "gym";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String showContact() {
		return "contact";
	}
	
	@Autowired
	private GroupExerciseRepository groupExerciseRepository; 

	@Autowired 
	private CategoryRepository categoryRepository; 
	
	// Login
	@RequestMapping(value="/login")
	public String login() {	
	    return "login";
	}
	
	// Show all group exercises 
    @RequestMapping(value="/groupexerciselist")
    public String studentList(Model model) {	
        model.addAttribute("groupexercises", groupExerciseRepository.findAll());
        return "groupexerciselist";
    }
    
    
    // RESTful service to get all group exercises
    @RequestMapping(value="/groupexercises", method = RequestMethod.GET)
    public @ResponseBody List<GroupExercise> groupExerciseListRest() {	
        return (List<GroupExercise>) groupExerciseRepository.findAll();  
    }    

    // RESTful service to get group exercise by id  
    @RequestMapping(value="/groupexercises/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<GroupExercise> findGroupExerciseRest(@PathVariable("id") Long groupExerciseId) {	
    	return groupExerciseRepository.findById(groupExerciseId);
    }      

    // RESTful service to save new group execise
    @RequestMapping(value="/groupexercises", method = RequestMethod.POST)
    public @ResponseBody GroupExercise saveGroupExerciseRest(@RequestBody GroupExercise groupExercise) {	
    	return groupExerciseRepository.save(groupExercise);
    }
    
    // Add new group exercise
    @RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("groupExercise", new GroupExercise());
    	model.addAttribute("categories", categoryRepository.findAll()); // gets information from category
        return "addgroupexercise";
    }    
    
    // Save new group exercise
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(GroupExercise groupExercise){
        groupExerciseRepository.save(groupExercise);
        return "redirect:groupexerciselist";
    }    
    
    // Edit group exercise
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long groupExerciseId, Model model) {
    	model.addAttribute("groupExercise", groupExerciseRepository.findById(groupExerciseId));
    	model.addAttribute("categories", categoryRepository.findAll());
        return "editgroupexercise";
    }

    // Delete group exercise
    @PreAuthorize("hasAuthority('ADMIN')") 
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long groupExerciseId, Model model) {
    	groupExerciseRepository.deleteById(groupExerciseId);
        return "redirect:../groupexerciselist";
    }  
}
