/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.se.ebid.dao;

import com.se.ebid.entity.Member;
import java.util.List;

/**
 *
 * @author Quxiz
 */
public interface MemberDAO {
 
    public void save(Member member);
     
    public List<Member> list();
    
    public Member findByUserID(String userID);
     
    public Member findByActivateKey(String activateKey);
    
    public Member findByMemberID(long memberID);
    
    public Member findByEmail(String email);
}
