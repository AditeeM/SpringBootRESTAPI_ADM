package com.adm.sb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adm.sb.dao.AlienRepo;
import com.adm.sb.model.Alien;

@RestController //to remove the duplicacy in @response body
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}

//5	
//	@RequestMapping("/addAlien")
//	public String addAlien(Alien alien)
//	{   repo.save(alien);
//		return "home";
//	}
	
	@PostMapping("/alien")
	//@ResponseBody
	public Alien addAlien
	//( Alien alien) //for formdata
	(@RequestBody Alien alien)// request body for sending raw data
	{   repo.save(alien);
		return alien;
	}
	@RequestMapping("/getAlien")
	public ModelAndView addAlien(@RequestParam int aid)
	//public ModelAndView getAlien(@RequestParam int aid)
	{//spring rest working request param fetch value from client
		ModelAndView mv= new ModelAndView("showAlien");
		Alien alien=repo.findById(aid).orElse(new Alien());
//		System.out.println(repo.findByTech("java"));
//		System.out.println(repo.findByAidGreaterThan(2));
//		System.out.println(repo.findByRechSorted("java"));
		mv.addObject(alien);
		return mv;
	}
	//optional
	//@RequestMapping("/aliens")
	@GetMapping("/aliens")
	//@ResponseBody
	public List<Alien> getAliens()
	{
		return repo.findAll();
	}
	
	//@RequestMapping("/aliens")
	//@RequestMapping("/alien/102")
	@RequestMapping("/alien/{aid}")// wildcard
	//@ResponseBody //return data
	//public String getAliens()
	//public String getAlien(@PathVariable("aid")int aid)//wildcard
	public Optional<Alien> getAlien(@PathVariable("aid")int aid)
	{//spring rest working request param fetch value from client
		
	//string returning view name but fetching data
		//return repo.findAll().toString();
		//return repo.findById(102).toString();
		//return repo.findById(aid).toString();//wildcard
		return repo.findById(aid);
			
	}
	
	//delete and update

}












