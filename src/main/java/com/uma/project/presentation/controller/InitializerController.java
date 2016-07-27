/**
 * 
 */
package com.uma.project.presentation.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uma.project.services.data.initializer.DataInitializerService;

/**
 * @author HP
 *
 */
@Controller
public class InitializerController {

	@Resource
	DataInitializerService dataInitializerService;

	@RequestMapping("/init/getAllChampionship")
	@ResponseBody
	String getAllChampionship(Model model) {
		return dataInitializerService.getAllChampionship();
	}

	@RequestMapping("/init/getTeams")
	@ResponseBody
	String getTeams(Model model) {
		return dataInitializerService.getTeams("396");
	}
}
