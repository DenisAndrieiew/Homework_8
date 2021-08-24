package com.goIt.ProductManagement.controller;

import com.goIt.ProductManagement.model.dto.ManufacturerDTO;
import com.goIt.ProductManagement.model.dto.ProductDTO;
import com.goIt.ProductManagement.model.service.ManufacturerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping(path = "manufacturer")
public class ManufacturerController {
    private ManufacturerService manufacturerService;
    private static final Logger LOG = LoggerFactory.getLogger(ManufacturerController.class);
    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }
    @GetMapping("index")
    public String showProductIndexPage(Model model){
        LOG.info("showManufacturersPage.");
        Set<ManufacturerDTO> manufacturers = manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturers);
        return "manufacturers";
    }
}
