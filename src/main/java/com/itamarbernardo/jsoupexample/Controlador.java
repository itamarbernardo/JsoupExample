/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itamarbernardo.jsoupexample;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author ANAFLAVIA
 */
public class Controlador {

    private List<String> palavrasReservadas;
    private EstruturaAcessoHTML estrutura = new EstruturaAcessoHTML();
    private EstruturaAcessoHTML estrutura2 = new EstruturaAcessoHTML();
    private EstruturaAcessoHTML estrutura3 = new EstruturaAcessoHTML();

    public Controlador(List<String> palavrasReservadas) {
        this.palavrasReservadas = palavrasReservadas;
        this.estrutura.start();
        this.estrutura2.start();
        this.estrutura3.start();

    }

    public void init() {
        while (true) {
            mandaEmail();
        }
    }

    public void mandaEmail() {
        String links1 = estrutura.acesso("http://www.ufal.edu.br/", palavrasReservadas);
        String links2 = estrutura2.acesso("http://www.copeve.ufal.br/", palavrasReservadas);
        //String links3 = estrutura3.acesso("http://processodeingresso.upe.pe.gov.br/", palavrasReservadas);

        String linksTotais = links1 + "\n" + links2;
        //JOptionPane.showMessageDialog(null, linksTotais.length());
        if (linksTotais.length() > 1) {
            Email e = new Email();
            try {
                e.sendEmail("itamarbernardo2013@gmail.com", "Itamar", "Alerta da UFAL: Possível convocação da lista de espera", "Olá Itamar,"
                        + " nosso sistema verificou uma possível divulgação da lista de espera nos sites requisitados. Por favor, dê"
                        + " uma olhada nesses links:" + linksTotais);
            } catch (EmailException ex) {
                Logger.getLogger(HTMLParserExample1.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Thread.sleep(7200000); // Duas horas: 7200000
            } catch (InterruptedException ex) {
                Logger.getLogger(HTMLParserExample1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
