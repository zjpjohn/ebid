/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.se.ebid.controller;

import java.util.Locale;
import javax.validation.constraints.Size;

/**
 *
 * @author Quxiz
 */
public class SearchForm {
    private CategoryType category;
    
    @Size(min = 1, message = "Keyword must not be empty")
    private String keyword;

    public CategoryType getCategory() {
        return category;
    }

    public void setCategory(CategoryType category) {
        this.category = category;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    
}
