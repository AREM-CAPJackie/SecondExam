package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

 
public class URLReader { 
  public static void main(String[] args) throws Exception {
      System.out.println("THIS IS THE /hello RESPONSE:");
      printResult(new URL("https://parcialarem.herokuapp.com/hello"));
      
      System.out.println("THIS IS THE / RESPONSE:");
      printResult(new URL("https://parcialarem.herokuapp.com/"));
      
      System.out.println("THIS IS THE /db RESPONSE:");
      printResult(new URL("https://parcialarem.herokuapp.com/db"));
      
    } 

    private static void printResult(URL urlHeroku) {
        try (BufferedReader reader = new BufferedReader(
          new InputStreamReader(urlHeroku.openStream()))) { 
            String inputLine = null; 
            while ((inputLine = reader.readLine()) != null) { 
                  System.out.println(inputLine); 
             } 
       } catch (IOException x) { 
               System.err.println(x); 
       } 
    }
}