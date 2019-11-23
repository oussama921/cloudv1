package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.entities.Animal;

@Controller
public class FirstController {
	
	@GetMapping("/home")
	//@ResponseBody
	public String home(){
		//return "Spring boot MVC";
		return "first/home";
	}
	
	@GetMapping("/acceuil")
	public String acceuil(@RequestParam (required=false,defaultValue = "Spring Boot") String framework,ModelMap monObj) {
		String ecole[] = {"SESAME","ISG","Polytech"};
		String  formation = "Spring boot & Angular";
		String ch ="Vous avez choisi" + framework;
		ArrayList<String> names= new ArrayList<>();
		
		ArrayList<Animal> animals = new ArrayList<>();
		Animal a=new Animal();
		Animal b=new Animal();
		
		names.add("Amine");
		names.add("Haytem");
		names.add("Latifa");
		
		a.setAge(28);
		a.setNom("Lion");
		b.setAge(28);
		b.setNom("Lion");
		
		animals.add(a);
		animals.add(b);
		
		monObj.put("ec",ecole);
		monObj.put("forma",formation);
		monObj.put("names",names);
		monObj.put("animals",animals);
		monObj.put("msg",ch);
		return "/first/acceuil";
	}
	
	@GetMapping("/nompre")
	public String nompre(@RequestParam (required=false,defaultValue= "No name")String nom,@RequestParam (required=false,defaultValue="No prenom") String prenom,ModelMap monObj) {
		
		monObj.put("nom",nom);
		monObj.put("prenom",prenom);
	
		return "/first/nompre";
	}
}
