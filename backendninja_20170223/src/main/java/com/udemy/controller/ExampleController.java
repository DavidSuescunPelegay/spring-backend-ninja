package com.udemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.component.ExampleComponent;
import com.udemy.service.ExampleService;

@Controller
@RequestMapping("/example")
public class ExampleController {

	public static final String EXAMPLE_VIEW = "example";
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;

	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;

	// Primera forma
	// @RequestMapping(value="/exampleString", method=RequestMethod.GET)
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		exampleComponent.sayHello();

		// model.addAttribute("person", new Person("David Suescun Pelegay",
		// 20));
		model.addAttribute("people", exampleService.getListPeople());

		return EXAMPLE_VIEW;
	}

	// Segunda forma
	// @RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		// mav.addObject("person", new Person("David Suescun Pelegay", 20));
		mav.addObject("people", exampleService.getListPeople());

		// return new ModelAndView(EXAMPLE_VIEW);
		return mav;
	}
}
