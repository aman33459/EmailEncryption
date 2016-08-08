/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.aman.captchgen;

import java.util.Random;

/**
 *
 * @author User
 */
public class randomgen {
     public String generateCaptcha() {
  Random random = new Random();
  int length = 5;
  StringBuffer captchaStringBuffer = new StringBuffer();
  for (int i = 0; i < length; i++) {
   int captchaNumber = Math.abs(random.nextInt()) % 60;
   int charNumber = 0;
   if (captchaNumber < 26) {
    charNumber = 65 + captchaNumber;
   }
   else if (captchaNumber < 52){
    charNumber = 97 + (captchaNumber - 26);
   }
   else {
    charNumber = 48 + (captchaNumber - 52);
   }
   captchaStringBuffer.append((char)charNumber);
  }

  return captchaStringBuffer.toString();
 } 

}
