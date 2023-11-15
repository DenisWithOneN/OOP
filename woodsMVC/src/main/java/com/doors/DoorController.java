package com.doors;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
