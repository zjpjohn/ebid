/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.ebid.service;

import com.se.ebid.controller.BlacklistForm;
/**
 *
 * @author Nuttapong
 */
public interface BlacklistService {
    public boolean blacklist(BlacklistForm blacklistForm);
}
