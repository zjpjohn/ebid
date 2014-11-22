/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.ebid.controller;

import com.se.ebid.service.FeedbackService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mtmmoei
 */
@Controller
public class GiveFeedbackController {

    private FeedbackService feedbackService;

    @Autowired
    public void setFeedbackService(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @RequestMapping("/giveFeedback")
    public String viewGiveFeedback(Model model) {
        model.addAttribute("title", "ให้ Feedback");
        model.addAttribute("feedbackForm", new FeedbackForm());
//         List<CategoryType> categoryList = new ArrayList<CategoryType>( Arrays.asList(CategoryType.values() ));  
//        model.addAttribute("categoryList", categoryList);

        return "giveFeedbackView";
    }

    public void onSubmit(FeedbackForm form) {
        //do sth
    }
}
