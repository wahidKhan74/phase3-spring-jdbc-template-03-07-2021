package com.simplilearn.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simplilearn.webapp.dao.EProductDAO;
import com.simplilearn.webapp.entity.EProduct;

@Controller
public class MainController {

	@Autowired
	EProductDAO eproductDAO;
	
	@RequestMapping(value="/listProduct", method=RequestMethod.GET)
	public String listProducts(ModelMap map) {		
		List<EProduct> list = eproductDAO.getProducts();		
		map.addAttribute("list", list);
		return "listProduct";
	}
}
