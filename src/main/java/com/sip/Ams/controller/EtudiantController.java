package com.sip.Ams.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sip.Ams.entities.Etudiant;

@Controller
public class EtudiantController {
List<Etudiant> etudiant = new ArrayList<>();
	
	{
		
		etudiant.add(new Etudiant(1, "amine", "amine@gmail.com"));
		etudiant.add(new Etudiant(2, "rami", "rami@gmail.com"));
		etudiant.add(new Etudiant(3, "patrick", "patrick@gmail.com"));
	}
	
	
	@RequestMapping("/home")
	public String message(Model model) {
		System.out.println("bienvenue");
		String formation="fullstack";
		String lieu="Sesame";
		model.addAttribute("tranning", formation);
		model.addAttribute("location", lieu);
		return "info";
	}
	
	//public String listProduits(Model model)
	//{
		//List<String> produits = new ArrayList<>();
		//produits.add("Voiture");
		//produits.add("Camion");
		//produits.add("Moto");
		//produits.add("Bus");
		//model.addAttribute("mesProduits", produits);
		//return "product";
	//}
	@RequestMapping("/produits")
	public ModelAndView listProduits()
	{ModelAndView mv=new ModelAndView();
		List<String> produits = new ArrayList<>();
		produits.add("Voiture");
		produits.add("Camion");
		produits.add("Moto");
		produits.add("Bus");
		//model.addAttribute("mesProduits", produits);
		mv.addObject("mesProduits",produits);
		mv.setViewName("product");
		return mv;
	}
	@RequestMapping("/etudiants")
	public ModelAndView listStudents()
	{ ModelAndView mv=new ModelAndView();
		
		System.out.println(etudiant);
		//model.addAttribute("mesProduits", produits);
		mv.addObject("students",etudiant);
		mv.setViewName("liststudents");
		return mv;
	}
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addStudentForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addStudent");
		return mv;

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addStudent(@RequestParam("id") int id, @RequestParam("nomEtudiant") String nom,
			@RequestParam("email") String email) {
		// ModelAndView mv = new ModelAndView();
		// mv.setViewName("listStudents");
		// return mv;
		Etudiant e = new Etudiant(id, nom, email);
		etudiant.add(e);
		return "redirect:etudiants";

	}

	
	

}
