package com.goIt.ProductManagement.controller;

import com.goIt.ProductManagement.model.dto.ProductDTO;
import com.goIt.ProductManagement.model.entity.User;
import com.goIt.ProductManagement.model.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping(path = "product")
public class ProductController {
    private ProductService productService;
    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("index")
    public String showProductIndexPage(Model model){
        LOG.info("showProductsPage.");
        Set<ProductDTO> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

}
