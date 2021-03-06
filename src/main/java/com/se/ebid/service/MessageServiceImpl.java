/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.ebid.service;

import com.se.ebid.dao.MessageDAO;
import com.se.ebid.entity.Message;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nuttapong
 */
@Service
public class MessageServiceImpl implements MessageService{

    private MessageDAO messageDAO;
    
    @Autowired
    public void setMessageDAO(MessageDAO messageDAO){
        this.messageDAO = messageDAO;
    }
    
    @Override
    public List<Message> getMessage() {
        return this.messageDAO.findByReceiverID(Common.getMemberID());
    }
    
    @Override
    @Transactional
    public boolean markAsRead(List<Message> messages) {
        for(Message message:messages) {
            if(!message.isSeen()) {
                message.setSeen(true);
                this.messageDAO.save(message);
            }
        }
        return true;
    }
    
    @Override
    @Transactional
    public long getUnreadCount(long memberID) {
        return this.messageDAO.getUnreadCount(memberID);
    }
    
     
}
