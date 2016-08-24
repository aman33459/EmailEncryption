/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aman.inbox;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
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
public class content {
    
    String content="";
    private String decry(String cipher , String key) throws UnsupportedEncodingException
    {   int temp=0;
//String ptext;
        //System.out.println(cipher);
       
        byte[] mimeEncodedString = Base64.getMimeDecoder().decode(cipher);
        cipher=new String(mimeEncodedString,"utf-8");
    int s[]=new int[256];
    int k[]=new int[256];
    /*DataInputStream in=new DataInputStream(System.in);
    System.out.print("Enter the plain text\n");
    ptext=in.readLine();
    System.out.print("\n\nENTER KEY TEXT\t\t");
    key=in.readLine();*/
    //char ptextc[]=ptext.toCharArray();
    char cipherc[]=cipher.toCharArray();
    char keyc[]=key.toCharArray();
    int cipher1[]=new int[cipher.length()];
    int decrypt[]=new int[cipher.length()];
    int keyi[]=new int[key.length()];
    for(int i=0;i<cipher.length();i++)
    {
        cipher1[i]=(int)cipherc[i];
    }
    for(int i=0;i<key.length();i++)
    {
        keyi[i]=(int)keyc[i];
    }
    for(int i=0;i<255;i++)
    {
        s[i]=i;
        k[i]=keyi[i%key.length()];
    }
        int j=0;
    for(int i=0;i<255;i++)
    {
        j=(j+s[i]+k[i])%256;
        temp=s[i];
        s[i]=s[j];
        s[j]=temp;
    }
    int i=0;
    j=0;
    int z=0;
    for(int l=0;l<cipher.length();l++)
    {
        i=(l+1)%256;
        j=(j+s[i])%256;
        temp=s[i];
        s[i]=s[j];
        s[j]=temp;
        z=s[(s[i]+s[j])%256];
        //cipher[l]=z^ptexti[l];
        decrypt[l]=z^cipher1[l];
    }
    char convert[]=new char[decrypt.length];
    for(int l=0;l<decrypt.length;l++)
    {
    convert[l]=(char)decrypt[l];
    System.out.print(convert[l]);
    }
        System.out.println();

    String ss = "";
    for ( int kk =0 ; kk < convert.length ; kk++ )
    {
        ss=ss+convert[kk];
    }
    return ss;

    }
    public String recieveEmail( String user, String password,int k,String key) throws MessagingException, IOException {  
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
          content=decry((part.getContent().toString()),key);
          
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
   return content;
 }
}
