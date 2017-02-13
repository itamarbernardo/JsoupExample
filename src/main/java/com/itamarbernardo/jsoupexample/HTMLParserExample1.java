package com.itamarbernardo.jsoupexample;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

public class HTMLParserExample1 {

    public static void main(String[] args) {

        List<String> palavrasReservadas = new ArrayList<String>();
        palavrasReservadas.add("Remanejamento");
        palavrasReservadas.add("remanejamento");
        palavrasReservadas.add("lista");
        palavrasReservadas.add("Lista");
        palavrasReservadas.add("Espera");
        palavrasReservadas.add("espera");
        palavrasReservadas.add("SiSU");
        palavrasReservadas.add("Portal");


        String[] textoSeparado;
        Document doc;
        try {

            // need http protocol
            doc = Jsoup.connect("http://www.ufal.edu.br/").userAgent("Mozilla").get();

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
                            JOptionPane.showMessageDialog(null, "Achei alguma coisa! " + link.attr("href"));
                        }
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
