package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.tomcat.jni.Mmap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.model.ProductPojo;
import com.mysql.cj.x.protobuf.MysqlxCrud.Update;
import com.service.ProductsSerivce;

@Controller
public class ProductController {
	@Autowired
	ProductsSerivce productsSerivce;

	@GetMapping("/products")
	public String showProducts(ModelMap m) {
		List<ProductPojo> list = productsSerivce.getAllProducts();
		m.addAttribute("products", list);
		return "admin/products";
	}

	@GetMapping("/products/add")
	public String showAddProducts(@ModelAttribute("product") ProductPojo product) {
		return "admin/addproduct";
	}

	@GetMapping("/products/edit")
	public String showEditProducts(@RequestParam String id, ModelMap map) {

		map.addAttribute("product", productsSerivce.getProductById(id));
		return "admin/editproduct";
	}

	@PostMapping("/products/upsert")
	public String upsertProducts(@ModelAttribute("product") @Valid ProductPojo newProduct, BindingResult result, ModelMap m) {
		String r = productsSerivce.upsertProduct(newProduct);
		if(result.hasErrors()){
			return "admin/addproduct";
		}
		if (r.equals("success")) {
			String message;
			if (newProduct.getID() == null) {
				message = "Product Successfully added";
			} else {
				message = "Product Successfully Updated";
			}
			m.addAttribute("message", message);
			m.addAttribute("next", "/products");
			m.addAttribute("nextname", "Go back to all Products");
			return "message";
		}
		m.addAttribute("error", r);
		return "message";

	}

	@GetMapping("/products/delete")
	public String showDeleteProduct(@RequestParam String id, ModelMap map) {

		map.addAttribute("product", productsSerivce.getProductById(id));
		return "admin/deleteproduct";
	}

	@PostMapping("/products/delete")
	public String deleteProduct(@ModelAttribute("product") ProductPojo product, ModelMap map) {
		String r = productsSerivce.deleteProduct(product);
		if (r.equals("success")) {
			map.addAttribute("message", "Product successfully deleted");
			map.addAttribute("next", "/products");
			map.addAttribute("nextname", "Go back to all Products");
			return "message";
		}
		map.addAttribute("error", r);
		return "admin/deleteproduct";
	}

}
