package com.goIt.ProductManagement.controller;

import com.goIt.ProductManagement.model.dto.ManufacturerDTO;
import com.goIt.ProductManagement.model.dto.ProductDTO;
import com.goIt.ProductManagement.model.service.ManufacturerService;
import com.goIt.ProductManagement.model.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Set;
import java.util.UUID;

@Controller
@RequestMapping(path = "product")
public class ProductController {
    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;
    private final ManufacturerService manufacturerService;

    @Autowired
    public ProductController(ProductService productService, ManufacturerService manufacturerService) {
        this.productService = productService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping("index")
    public String showProductIndexPage(Model model) {
        LOG.info("showProductsPage.");
        Set<ProductDTO> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public RedirectView save(@ModelAttribute("product") ProductDTO productDTO) {
        productService.save(productDTO);
        return new RedirectView("index");
    }

    @ModelAttribute("ProductForm")
    public ProductDTO defaultProductDTO() {
        return new ProductDTO();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("new")
    public String ShowNewProductPage(Model model) {
        LOG.info("ShowNewProductPage");
        ProductDTO product = new ProductDTO();
        Set<ManufacturerDTO> manufacturers = manufacturerService.findAll();
        model.addAttribute("product", product);
        model.addAttribute("manufacturers", manufacturers);
        return "productNew";
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/update")
    public String ShowUpdateProductPage(@RequestParam(name="id") UUID id, Model model) {
        LOG.info("ShowUpdateProductPage");
        ProductDTO product = productService.findById(id);
        Set<ManufacturerDTO> manufacturers = manufacturerService.findAll();
        model.addAttribute("product", product);
        model.addAttribute("manufacturers", manufacturers);
        return "productUpdate";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/delete")
    public RedirectView delete(@RequestParam(name = "id") UUID id) {
        productService.delete(id);
        return new RedirectView("index");
    }
}
