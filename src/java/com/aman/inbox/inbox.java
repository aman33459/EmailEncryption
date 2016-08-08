/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aman.inbox;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;

/**
 *
 * @author User
 */
public class inbox {
    String content="well done";
    public String recieveEmail( String user, String password,int k) throws MessagingException, IOException {  
    Properties props2=System.getProperties();
    String destFilePath1="o";
        props2.setProperty("mail.store.protocol", "imaps");
        // I used imaps protocol here
 
        Session session2=Session.getDefaultInstance(props2, null);
 
            try {
 
                    Store store=session2.getStore("imaps");
 
                    store.connect("imap.gmail.com",user,password);
 
                    Folder folder=store.getFolder("INBOX");//get inbox
 
                    folder.open(Folder.READ_ONLY);//open folder only to read
 
  
   //4) retrieve the messages from the folder in an array and print it  
   Message[] messages = folder.getMessages();  
   int i=k;
   //for (int i = messages.length-1; i >= messages.length-2; i--) {  
    Message message = messages[i];  
    System.out.println("---------------------------------");  
    System.out.println("Email Number " + (messages.length - i ));  
    System.out.println("Subject: " + message.getSubject());  
    System.out.println("From: " + message.getFrom()[0]);
    String type=message.getContentType();
    if(type.contains("multipart")){
    Multipart mm= (Multipart) messages[i].getContent();
    for( int j = 0 ; j < mm.getCount() ;j++)
    {
     MimeBodyPart part =(MimeBodyPart) mm.getBodyPart(j);  
     if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())){
       String  destFilePath = "E:/attachment/" + part.getFileName()+".png";
         
    FileOutputStream output = new FileOutputStream(destFilePath);
    InputStream input = part.getInputStream();
    byte[] buffer = new byte[4096];
    int byteRead;
    destFilePath1=destFilePath;
    while ((byteRead = input.read(buffer)) != -1) {
        output.write(buffer, 0, byteRead);
    }
    
    output.close();
        }
     else
     {
          content=(part.getContent().toString());
     }

    }
     System.out.println();
    }
    else
    {
        content=(message.getContent().toString());
        destFilePath1="ok";
    }
   //}  
  
   //5) close the store and folder objects  
   folder.close(false);  
   store.close();  
  
  } catch (NoSuchProviderException e) {e.printStackTrace();}   
  catch (MessagingException e) {e.printStackTrace();}  
  catch (IOException e) {e.printStackTrace();} 
   return destFilePath1;
 }
 public String getcon()
    {
        return content;
    }
    /*public static void main(String args[]) throws MessagingException, IOException
    {
        inbox aa =new inbox();
        aa.recieveEmail("aman33459@gmail.com", "aman@2206", 0);
        
    }*/
}
