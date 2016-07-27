/**
 * 
 */
package com.uma.project.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HP
 *
 */
@Controller
public class HomeController {

	// @Resource
	// CalendrierService calendrierService;
	//
	// @Resource
	// ClubService clubService;

	@RequestMapping("/")
	String home(Model model) {
		return "index";
	}

	@RequestMapping("/options")
	String options(Model model) {
		return "/options/optionInit";
	}

	// @RequestMapping("/page")
	// String page(Model model) {
	// return "page";
	// }
	//
	// @RequestMapping("/page1")
	// String page1(Model model) {
	// return "page1";
	// }

	// @RequestMapping("/calendrier")
	// @ResponseBody
	// String getCalendrier() {
	// return calendrierService.getCalendrier();
	// }
	//
	// @RequestMapping("/club")
	// @ResponseBody
	// String getClub(@RequestParam int id) {
	// return clubService.getClub(id).getName();
	// }
	//
	// @RequestMapping("/club/{id}")
	// @ResponseBody
	// String getClub2(@PathVariable int id) {
	// return clubService.getClub(id).getName();
	// }
	//
	// @RequestMapping("/index")
	// @ResponseBody
	// String index() {
	// return "page indx";
	// }

}
