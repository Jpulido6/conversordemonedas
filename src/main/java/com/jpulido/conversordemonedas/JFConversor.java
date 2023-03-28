/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.jpulido.conversordemonedas;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author ACER
 */
public class JFConversor extends javax.swing.JFrame {

    /**
     * Creates new form JFConversor KRW GBP EUR COP JPY yen
     */
    public JFConversor() {
        initComponents();

        setLocationRelativeTo(null);
    }

    public void convertir() {

        String apikey = "TTX9vBwi9G5lzo3zal6281enaRUIUOir";

        String monto = txtValor.getText();

        Map<String, String> equivalencias = new HashMap<>();
        equivalencias.put("PESO - COLOMBIANO", "COP");
        equivalencias.put("DOLAR", "USD");
        equivalencias.put("EURO", "EUR");
        equivalencias.put("LIBRAS ESTERLINAS", "GBP");
        equivalencias.put("YEN JAPONES", "JPY");
        equivalencias.put("WON SUL-COREANO", "KRW");

// Obtiene los códigos correspondientes a las divisas seleccionadas
        String from = equivalencias.get(comboDe.getSelectedItem().toString());
        String to = equivalencias.get(comboA.getSelectedItem().toString());

        String ur = "https://api.apilayer.com/exchangerates_data/convert?to=" + to + "&from=" + from + "&amount=" + monto + "";

        HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();

        HttpRequest req = HttpRequest.newBuilder().GET().uri(URI.create(ur)).header("apikey", apikey).build();

        try {

            HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

            JSONObject json = new JSONObject(res.body());
            Double resultado = json.getDouble("result");

            txtResultado.setText(resultado.toString());

        } catch (IOException ex) {
            Logger.getLogger(JFConversor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(JFConversor.class.getName()).log(Level.SEVERE, null, ex);
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

        jButton1 = new javax.swing.JButton();
        comboA = new javax.swing.JComboBox<>();
        comboDe = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        txtResultado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONVERSOR DE DIVISAS");

        jButton1.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        jButton1.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Convertir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        comboA.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        comboA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DOLAR", "PESO - COLOMBIANO", "EURO", "LIBRAS ESTERLINAS", "YEN JAPONES", "WON SUL-COREANO", " ", " " }));

        comboDe.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        comboDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PESO - COLOMBIANO", "DOLAR", "EURO", "LIBRAS ESTERLINAS", "YEN JAPONES", "WON SUL-COREANO", " " }));

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel1.setText("CONVERSOR DE DIVISAS");

        txtValor.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        txtResultado.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        convertir();
//        try {
//             TODO add your handling code here:
//
//            String apikey = "TTX9vBwi9G5lzo3zal6281enaRUIUOir";
//            String url = "https://api.exchangeratesapi.io/latest?access_key=" + apikey;
//
//            URL obj = new URL(url);
//            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//            con.setRequestMethod("GET");
//            con.connect();
//
//            int responseCode = con.getResponseCode();
//            if (responseCode == HttpURLConnection.HTTP_OK) {
//                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//                String inputLine;
//                StringBuffer response = new StringBuffer();
//
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//
//                }
//                in.close();
//
//            
//
//            }
//
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(JFConversor.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(JFConversor.class.getName()).log(Level.SEVERE, null, ex);
//        }


    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(JFConversor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFConversor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFConversor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFConversor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        FlatMacLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFConversor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboA;
    private javax.swing.JComboBox<String> comboDe;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtResultado;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
