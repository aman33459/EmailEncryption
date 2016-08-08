/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aman.inbox;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author User
 */
public class getinbox {
    public Message[] receive(String username, String password) throws MessagingException
    {
        Message[] messages=null;
      Properties props2=System.getProperties();
       props2.setProperty("mail.store.protocol", "imaps");
        // I used imaps protocol here
 
        Session session2=Session.getDefaultInstance(props2, null);
 
          try {
 
                    Store store=session2.getStore("imaps");
 
                    store.connect("imap.gmail.com",username,password);
 
                    Folder folder=store.getFolder("INBOX");//get inbox
 
                    folder.open(Folder.READ_ONLY);//open folder only to read
 
  
   //4) retrieve the messages from the folder in an array and print it  
        messages = folder.getMessages(); 
          }
          catch(Exception e)
          {
              System.out.println("Error");
          }
    return messages;
    }
}
