/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.ebid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mtmmoei
 */
@Controller
public class ViewSellerController {
    @RequestMapping("/viewSeller")
     public String viewSeller(Model model) {
        model.addAttribute("title", "Seller detail");
        return "viewSellerView";
    }
    
    
}