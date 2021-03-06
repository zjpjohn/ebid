/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.ebid.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 *
 * @author Nuttapong
 */
public class Common {
    
    static final int ADMIN_ID = -1;
    static final String ADMIN_NAME = "eBid_ADMIN";
    static final String BASE_URL = "http://localhost:8080/ebid/";
    static final String VIEW_MESSAGE_URL = "viewMessage/";
    static final String VIEW_ITEM_URL = "viewItem/";
    static final String ANSWER_QUESTION_URL = "answerQuestion/";
    static final String SOLVE_COMPLAINT_URL = "solveComplaint/";
    static final String RESET_PASSWORD_URL = "resetPassword/";
    static final String ACTIVATE_MEMBER_URL = "activateMember/";
    static final String GIVE_FEEDBACK_URL = "giveFeedback/";
    static final String CHECK_OUT_URL = "checkOut/";
    
    static final long getMemberID(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser = (CustomUser)auth.getPrincipal();
        return customUser.getMemberID();
    }
    
    static final String getUserID(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser = (CustomUser)auth.getPrincipal();
        return customUser.getUserID();
    }
    
    public static final boolean sendMail(String to, String subject, String text) {
        System.out.println("!!!!!!!!!!!!!!!!!!! test send email !!!!!!!!!!!!!!!!!!!");
        String host = "smtp.gmail.com";
        final String user = "ebid.se2014@gmail.com";//change accordingly  
        final String password = "eBid2014";//change accordingly  

        //String to = "iqmathematics@gmail.com";//change accordingly  

        //Get the session object  
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", "465");
	props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
  
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });
       
        //Compose the message  
        System.out.println("!!!!!! connect success");
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //message.setSubject("javatpoint");
            message.setSubject(subject);
            //message.setText("This is simple program of sending email using JavaMail API");
            message.setText(text);
            System.out.println("!!!!! initialize message success !!!!!!!!!");
            //send the message  
            Transport.send(message);

            System.out.println("message sent successfully...");

        } catch (Exception e) {
            System.out.println("!!! message catch error !!!");
            //e.printStackTrace();
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            return false;
            
        }
        return true;
    } 
}
