/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.es_prodotto;

import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author tss
 */
public class WinGestioneProdotto extends javax.swing.JFrame {

    ArrayList<Prodotto> lst_prodotti = new ArrayList();
    ArrayList<Scontrino> lst_scontrini = new ArrayList();

    /**
     * Creates new form WinGestioneCorso
     */
    public WinGestioneProdotto() {
        initComponents();
    }

    private void salvaProdotti() {
        // recupero un corso per volta
        // estraggo info tipo String
        // aggiungo info a un testo generico che poi setto in displaysiCSV();
        String testoDisplay = "";
        for (int i = 0; i < lst_prodotti.size(); i++) {
            // recupero un corso per volta
            Prodotto pr = lst_prodotti.get(i); //get(i) sarebbe listacorsi[i] in un array normale;
            String info = pr.getInfo();
            testoDisplay += info;
        }
        try {
            // creo file corsi.txt
            FileWriter myWriter = new FileWriter("/home/tss/Prodotti/prodotti.txt");
            myWriter.write(testoDisplay);
            // ci scrivo dentro testoDisplay
            // lo chiudo se no si blocca
            myWriter.close();
        } catch (Exception e) {

        }
    }
      private void salvaScontrini() {
        // recupero un corso per volta
        // estraggo info tipo String
        // aggiungo info a un testo generico che poi setto in displaysiCSV();
        String testoDisplay = "";
        for (int i = 0; i < lst_scontrini.size(); i++) {
            // recupero un corso per volta
           Scontrino sc = lst_scontrini.get(i); //get(i) sarebbe listacorsi[i] in un array normale;
            String info = sc.getInfo();
            testoDisplay += info;
        }
        try {
            // creo file corsi.txt
            FileWriter myWriter = new FileWriter("/home/tss/Prodotti/prodotti.txt");
            myWriter.write(testoDisplay);
            // ci scrivo dentro testoDisplay
            // lo chiudo se no si blocca
            myWriter.close();
        } catch (Exception e) {

        }
    }

    private void salvaProdottiCSV() {
        // recupero un corso per volta
        // estraggo info tipo String
        // aggiungo info a un testo generico che poi setto in display
        String testoDisplay = "nomeprodotto;id;prezzo\n";
        for (int i = 0; i < lst_prodotti.size(); i++) {
            // recupero un corso per volta
            Prodotto pr = lst_prodotti.get(i); //get(i) sarebbe listacorsi[i] in un array normale;
            String info = pr.getCSVInfo();
            testoDisplay += info;
        }
        try {
            // creo file corsi.txt
            FileWriter myWriter = new FileWriter("/home/tss/Prodotti/prodotti.csv");
            myWriter.write(testoDisplay);
            // ci scrivo dentro testoDisplay
            // lo chiudo se no si blocca
            myWriter.close();
        } catch (Exception e) {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        btnCreaProdotto = new javax.swing.JButton();
        lblTitolo = new javax.swing.JLabel();
        lblMsg = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstProdotti = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txNomeProdotto = new javax.swing.JTextField();
        txPrezzo = new javax.swing.JTextField();
        btnVendita = new javax.swing.JButton();
        tx_idprodotto = new javax.swing.JTextField();
        txprezzo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        spQuanti = new javax.swing.JSpinner();
        txidnew = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Id_Prodotto");

        btnCreaProdotto.setForeground(java.awt.Color.red);
        btnCreaProdotto.setText("Conferma dati");
        btnCreaProdotto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreaProdottoActionPerformed(evt);
            }
        });

        lblTitolo.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        lblTitolo.setForeground(java.awt.Color.blue);
        lblTitolo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitolo.setText("Gestione Prodotto");
        lblTitolo.setAlignmentX(0.5F);

        lblMsg.setForeground(java.awt.Color.red);

        lstProdotti.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lstProdottiKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(lstProdotti);

        jLabel1.setText("Nome Prodotto");

        jLabel2.setText("Prezzo:");

        jLabel7.setText("Lista prodotti");

        txNomeProdotto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNomeProdottoActionPerformed(evt);
            }
        });

        txPrezzo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPrezzoActionPerformed(evt);
            }
        });

        btnVendita.setForeground(java.awt.Color.magenta);
        btnVendita.setText("Gestione vendita");
        btnVendita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenditaActionPerformed(evt);
            }
        });

        jLabel3.setText("id prodotto");

        jLabel5.setText("quanti");

        jLabel6.setText("prezzo_ivato");

        btnClose.setForeground(new java.awt.Color(255, 123, 123));
        btnClose.setText("Chiudi");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitolo, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txPrezzo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                            .addComponent(txNomeProdotto, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel5))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(spQuanti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tx_idprodotto, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txidnew, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txprezzo, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnCreaProdotto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVendita, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTitolo)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txNomeProdotto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txPrezzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txidnew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnCreaProdotto)
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tx_idprodotto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(spQuanti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txprezzo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVendita)
                            .addComponent(btnClose))
                        .addGap(21, 21, 21))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreaProdottoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreaProdottoActionPerformed
        // TODO add your handling code here:
        //Recuperiamo i dati da interfaccia
        String np = txNomeProdotto.getText();
        String prezzo = txPrezzo.getText();
        String id = txidnew.getText();
        float pr = Float.parseFloat(prezzo);
        Prodotto prodotto = new Prodotto(np, id, pr);

        lst_prodotti.add(prodotto);
        salvaProdotti();
        salvaProdottiCSV();
        refreshLista();


    }//GEN-LAST:event_btnCreaProdottoActionPerformed

    private void txPrezzoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPrezzoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPrezzoActionPerformed


    private void btnVenditaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenditaActionPerformed

        String id = tx_idprodotto.getText();
        int quanti = (int) spQuanti.getValue();
        String prezzo = txprezzo.getText();
        float pr = Float.parseFloat(prezzo);
        Scontrino scontrino = new Scontrino(prezzo, quanti, pr);

        lst_scontrini.add(scontrino);
        salvaScontrini();


    }//GEN-LAST:event_btnVenditaActionPerformed

    private void refreshLista() {
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < lst_prodotti.size(); i++) {
            String nc = lst_prodotti.get(i).getNome_prodotto();
            model.addElement(nc);
        }
        lstProdotti.setModel(model);
    }
    private void txNomeProdottoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNomeProdottoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNomeProdottoActionPerformed

    private void lstProdottiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lstProdottiKeyPressed

     

    }//GEN-LAST:event_lstProdottiKeyPressed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WinGestioneProdotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WinGestioneProdotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WinGestioneProdotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WinGestioneProdotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WinGestioneProdotto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCreaProdotto;
    private javax.swing.JButton btnVendita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblTitolo;
    private javax.swing.JList<String> lstProdotti;
    private javax.swing.JSpinner spQuanti;
    private javax.swing.JTextField txNomeProdotto;
    private javax.swing.JTextField txPrezzo;
    private javax.swing.JTextField tx_idprodotto;
    private javax.swing.JTextField txidnew;
    private javax.swing.JTextField txprezzo;
    // End of variables declaration//GEN-END:variables
}
