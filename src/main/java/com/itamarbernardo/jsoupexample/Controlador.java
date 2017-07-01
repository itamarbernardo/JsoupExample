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
public class Controlador extends Thread implements Runnable {

    private List<String> palavrasReservadas;
    private EstruturaAcessoHTML estrutura = new EstruturaAcessoHTML();
    private String endereco;

    public Controlador(List<String> palavrasReservadas, String endereco) {
        this.palavrasReservadas = palavrasReservadas;
        this.endereco = endereco;
    }

    @Override
    public void run() {
        Hora h = new Hora();
        int m = h.pegarHora();
        while (true) {
            //if (m > 8 && m < 21) {
                mandaEmail();

//            }else{
//              System.out.println("Esperando dar a hora programada...");
//                try {
//                    Thread.sleep(60000);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        }

    }

    public void mandaEmail() {
        String links1 = estrutura.acesso(endereco, palavrasReservadas);

        if (links1.length() > 1) {
            Email e = new Email();
            try {
                e.sendEmail("itamarbernardo2013@gmail.com", "Itamar", "Alerta da UFAL: Possível convocação da lista de espera", "Olá Itamar,"
                        + " nosso sistema verificou uma possível divulgação da lista de espera nos sites requisitados. Por favor, dê"
                        + " uma olhada nesses links:" + links1);
            } catch (EmailException ex) {
                Logger.getLogger(HTMLParserExample1.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                Thread.sleep(7200000); // Duas horas: 7200000
            } catch (InterruptedException ex) {
                Logger.getLogger(HTMLParserExample1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
