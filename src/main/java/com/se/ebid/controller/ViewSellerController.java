/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.ebid.controller;

import com.se.ebid.entity.Feedback;
import com.se.ebid.service.MemberService;
import com.sun.corba.se.impl.interceptors.PINoOpHandlerImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author mtmmoei
 */
@Controller
public class ViewSellerController {

    private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(value = "/viewSeller/{sellerID}", method = RequestMethod.GET)
    @SuppressWarnings("empty-statement")
    public String viewSeller(@PathVariable("sellerID") String sellerName, Model model) {
        model.addAttribute("title", "ข้อมูลผู้ขาย");
        model.addAttribute("seller", this.memberService.getSeller(sellerName));
        long sellerID = this.memberService.getSeller(sellerName).getMemberID();
        List<Feedback> sellerFeedback = this.memberService.getSellerFeedback(sellerID);
        long sellerRating=0;
        for(int i=0; i<sellerFeedback.size();i++)sellerRating +=sellerFeedback.get(i).getSellerRating();                ;
        sellerRating = sellerRating/sellerFeedback.size();
        model.addAttribute("sellerFeedBack", sellerFeedback);
        model.addAttribute("sellerRating", sellerRating);
        return "viewSellerView";
    }
}
