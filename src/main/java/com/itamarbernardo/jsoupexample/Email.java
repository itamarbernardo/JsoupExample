/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itamarbernardo.jsoupexample;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author ANAFLAVIA
 */
public class Email {

    public Email(){
        
    }
    
    public void sendEmail(String destinatario, String nomeDest, String assunto, String msg) throws EmailException {

        SimpleEmail email = new SimpleEmail();
        //Utilize o hostname do seu provedor de email
        System.out.println("alterando hostname...");
        email.setHostName("smtp.gmail.com");
        //Quando a porta utilizada não é a padrão (gmail = 465)
        email.setSmtpPort(465);
        //Adicione os destinatários
        email.addTo(destinatario, nomeDest);
        //Configure o seu email do qual enviará
        email.setFrom("notificacoes.sistemas@gmail.com", "Notificações Sistemas");
        //Adicione um assunto
        email.setSubject(assunto);
        //Adicione a mensagem do email
        email.setMsg(msg);
        //Para autenticar no servidor é necessário chamar os dois métodos abaixo
        System.out.println("autenticando...");
        email.setSSL(true);
        email.setAuthentication("notificacoes.sistemas@gmail.com", "notif0918sist");
        System.out.println("enviando...");
        email.send();
        System.out.println("Email enviado!");
    }

}
