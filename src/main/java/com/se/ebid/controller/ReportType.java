/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.ebid.controller;

/**
 *
 * @author mtmmoei
 */
public enum ReportType {
    BID("ประมูล"), BUY("ซื้อโดยตรง"), ALL("โดยรวม");
     private String name;

    private ReportType(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
