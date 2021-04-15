package hh.swd.harjoitustyo.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd.harjoitustyo.domain.Category;
import hh.swd.harjoitustyo.domain.CategoryRepository;

@Controller
public class CategoryController {

@Autowired 
private CategoryRepository repository; 

@RequestMapping(value="/categorylist")
public String categoryList(Model model) {	
    model.addAttribute("categories", repository.findAll());
    return "categorylist";
}

@RequestMapping(value = "/addcategory")
public String addCategory(Model model){
	model.addAttribute("category", new Category());
    return "addcategory";
}  
 
@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
public String save(Category category){
 repository.save(category);
 return "redirect:categorylist";
}   

@RequestMapping(value = "/deletecategory/{id}", method = RequestMethod.GET)
public String deleteCategory(@PathVariable("id") Long categoryId) {
	repository.deleteById(categoryId);
 return "redirect:../categorylist";
}  
 
}