/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PRINCIPAL;

import dao.ConexionDB;
import vista.Login;


public class main {

 
    public static void main(String[] args) {
     Login log = new Login();
     log.setVisible(true);
     log.setLocationRelativeTo(null);
     ConexionDB cnx = new ConexionDB();
    }
    
}
