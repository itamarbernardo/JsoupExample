/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itamarbernardo.jsoupexample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author ANAFLAVIA
 */
public class EstruturaAcessoHTML extends Thread implements Runnable{

    private String[] textoSeparado;
    private Document doc;
    
    @Override
    public void run(){
        
    }
    
    public void acesso(String url, List<String> palavrasReservadas) {
        try {

            // need http protocol
            doc = Jsoup.connect(url).userAgent("Mozilla").get();

            // get page title
            String title = doc.title();
            System.out.println("title : " + title);

            // get all links
            Elements links = doc.select("a[href]");
            for (Element link : links) {

                // get the value from href attribute
                System.out.println("\nlink : " + link.attr("href"));
                System.out.println("text : " + link.text());
                textoSeparado = link.text().split(" ");
//                System.out.println(Arrays.toString(textoSeparado));

                for (String t : textoSeparado) {
                    for (String p : palavrasReservadas) {
                        if (t.equals(p)) {

                            JOptionPane.showMessageDialog(null, "Achei alguma coisa! " + link.attr("href") + "\nTexto: " + link.text());
                            
                        }
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
