package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.order.model.Products;
import com.order.service.Productimplementation;



@Controller
public class ProductController {

	@Autowired
	private Productimplementation productImplementation;
	
	@GetMapping("/homeproduct")
	public String getHome(Model model) {
		List<Products> listProducts=productImplementation.getProducts();
		model.addAttribute("listProducts", listProducts);
		return "products";
	}
	
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Products p=new Products();
		model.addAttribute("product", p);
		return "new_product";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveNewProduct(@ModelAttribute("product") Products product) {
		productImplementation.saveProducts(product);
		System.out.println(product);
		return "redirect:/homeproduct";
	}
	
	@RequestMapping("/{id}")
	public ModelAndView EditProduct(@PathVariable(name="id") int id) {
		ModelAndView mav=new ModelAndView("edit_product");
		Products product= productImplementation.getProduct(id);
		mav.addObject("product",product);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String DeleteProduct(@PathVariable(name="id") int id) {
		productImplementation.deleteProductById(id);
		return "redirect:/homeproduct";
	}
	
	
}
