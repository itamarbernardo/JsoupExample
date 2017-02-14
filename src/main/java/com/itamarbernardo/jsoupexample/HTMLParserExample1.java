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
        
        Controlador c = new Controlador(palavrasReservadas);
        c.init();
        
    }
}
