package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientThread extends Thread {
    public final static int NUMBER_OF_THREADS = 20;
    public final static String urlHeroku = "https://parcialarem.herokuapp.com/";
    
    public static void main(String[] args){
        for(int i = 0; i<NUMBER_OF_THREADS; i++){
            Thread h = new ClientThread();
            h.start();
        }
    }

    @Override
    public void run() {
        try {
            printResult("hello");

            printResult("");

            printResult("db");
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void printResult(String pathHeroku) throws MalformedURLException {
        URL result = new URL(urlHeroku+pathHeroku);
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(result.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}