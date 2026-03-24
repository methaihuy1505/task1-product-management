package com.example.product_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.product_management.model.Product;
import com.example.product_management.service.ProductService;
import com.example.product_management.request.ProductCreateRequest; 

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

 
    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("listProducts", productService.getAllProducts());
        return "product/index";
    }


    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("productDTO", new ProductCreateRequest());
        model.addAttribute("actionUrl", "/products/create"); 
        return "product/form";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute("productDTO") ProductCreateRequest request) {
        productService.createProduct(request);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Product existingProduct = productService.getProductById(id);
        
        ProductCreateRequest dto = new ProductCreateRequest();
        dto.setProName(existingProduct.getProName());
        dto.setOrder(existingProduct.getOrder());
        dto.setActive(existingProduct.isActive());
        
        model.addAttribute("productDTO", dto);
        model.addAttribute("actionUrl", "/products/edit/" + id); 
        return "product/form";
    }

    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable Integer id, @ModelAttribute("productDTO") ProductCreateRequest request) {
        productService.updateProduct(id, request);
        return "redirect:/products";
    }


    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}