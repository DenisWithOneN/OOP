package com.doors;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DoorController {
	
	DoorDAO doorDao = new DoorDAO();
	
	@GetMapping("/doors/{id}")
	public ModelAndView doorPageByID(@PathVariable int id) throws SQLException, IOException {
		
		int totalDoors = doorDao.getNumberOfDoors();
		
	if (id > totalDoors) {
		ModelAndView mavError = new ModelAndView("errorPage");
		return mavError;
	}
		
		ModelAndView mav = new ModelAndView("doorPage");
		Door door = doorDao.getById(id);
		mav.addObject("doorel", door);
		return mav;
		
	}
	
	@GetMapping("/doors")
	public ModelAndView getAllDoors() throws SQLException, IOException {
		
		ModelAndView mav = new ModelAndView("doors");
		
		ArrayList<Door> doors = doorDao.getAllDoors();
		mav.addObject("doors", doors);
		return mav;
	}
	
	@GetMapping("/doors/create")
	public ModelAndView createDoor() {
		return new ModelAndView("createDoor");
	}
	
	//redirect view
	@PostMapping("/doors/create")
	public ModelAndView createNewDoor(@RequestParam String material, @RequestParam double height, @RequestParam double width, @RequestParam LocalDate installationDate) throws SQLException, IOException {
		ModelAndView mav = new ModelAndView("doors");
		Door door = new Door(material, height, width, installationDate);
		doorDao.insertDoor(door);
		
		ArrayList<Door> doors = doorDao.getAllDoors();
		mav.addObject("doors", doors);
		
		return mav;
	}
}

