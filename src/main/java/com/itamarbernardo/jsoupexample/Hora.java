/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itamarbernardo.jsoupexample;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author ANAFLAVIA
 */
public class Hora {
    
    public int pegarHora(){
// 	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
//	Date date = new Date(); 
//	return dateFormat.format(date); 
    GregorianCalendar calendar = new GregorianCalendar();
    int hora = calendar.get(Calendar.HOUR_OF_DAY);
    return hora;
    }
    
}
