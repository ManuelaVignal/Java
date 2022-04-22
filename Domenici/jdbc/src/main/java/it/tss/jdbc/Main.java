package it.tss.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tss
 */
public class Main {

    public static void main(String[] args) {
        try {

            //client mariadb
            String url = "jdbc:mariadb://localhost:3306";
            try (Connection connection = DriverManager.getConnection(url, "tss", "root")) {
                System.out.println("connessione ok");

                //setto il dabase dove lavorare
                connection.setCatalog("DBScuola");
                //creazione comandi
                Statement cmd = connection.createStatement();
                

                //cursore next su una riga successiva e si ferma quando sono finite le righe a null
                //in posizione riga gli posso chiedere i dati
                try (ResultSet rs = cmd.executeQuery("select * from t_corsi")) {
                    //cursore next su una riga successiva e si ferma quando sono finite le righe a null
                    //in posizione riga gli posso chiedere i dati
                    while (rs.next()) {
                        //leggi il contenuto della colonna titolocorso che è una stringa
                        System.out.println(rs.getString("titolocorso"));
                        System.out.println(rs.getInt("id_corso"));
                        System.out.println(rs.getInt(1));
                        

                    }

                }

            }
        } catch (SQLException ex) {
            System.out.println("errore" + ex);

        }

    }
}
