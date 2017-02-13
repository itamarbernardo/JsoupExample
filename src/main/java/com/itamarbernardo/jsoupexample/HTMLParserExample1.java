package com.itamarbernardo.jsoupexample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.mail.EmailException;

public class HTMLParserExample1 {

    public static void main(String[] args) {

        List<String> palavrasReservadas = new ArrayList<String>();
        palavrasReservadas.add("Remanejamento");
        palavrasReservadas.add("remanejamento");
        palavrasReservadas.add("lista");
        palavrasReservadas.add("Lista");
        palavrasReservadas.add("Espera");
        palavrasReservadas.add("espera");
        palavrasReservadas.add("Edital");
        
        EstruturaAcessoHTML estrutura = new EstruturaAcessoHTML();
        estrutura.start();
        EstruturaAcessoHTML estrutura2 = new EstruturaAcessoHTML();
        estrutura2.start();
        
        Email e = new Email();
        try {
            e.sendEmail("itamarbernardo2013@gmail.com", "Itamar", "Alerta da UFAL: Possível convocação da lista de espera", "Olá Itamar,"
                    + " nosso sistema verificou uma possível divulgação da lista de espera nos sites requisitados. Por favor, dê uma olhada nesses links:");
        } catch (EmailException ex) {
            Logger.getLogger(HTMLParserExample1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(true){
            estrutura.acesso("http://www.ufal.edu.br/", palavrasReservadas);
            estrutura2.acesso("http://www.copeve.ufal.br/", palavrasReservadas);
            try {
                Thread.sleep(2500); //espera duas horas
            } catch (InterruptedException ex) {
                Logger.getLogger(HTMLParserExample1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
