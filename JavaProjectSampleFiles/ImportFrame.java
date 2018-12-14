
package java2project;
import java.io.*;

public class ImportFrame extends javax.swing.JFrame {

    public ImportFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jfcChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        btnBrowseLocation = new javax.swing.JButton();
        btnImportLocations = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtFlights = new javax.swing.JTextField();
        btnBrowseFlights = new javax.swing.JButton();
        btnImportFlights = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Import Files");

        jLabel2.setText("Select Location Files:");

        btnBrowseLocation.setBackground(new java.awt.Color(51, 153, 255));
        btnBrowseLocation.setText("Browse");
        btnBrowseLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseLocationActionPerformed(evt);
            }
        });

        btnImportLocations.setBackground(new java.awt.Color(51, 153, 255));
        btnImportLocations.setText("Import Locations");
        btnImportLocations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportLocationsActionPerformed(evt);
            }
        });

        jLabel3.setText("Select Flights File:");

        btnBrowseFlights.setBackground(new java.awt.Color(51, 153, 255));
        btnBrowseFlights.setText("Browse");
        btnBrowseFlights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseFlightsActionPerformed(evt);
            }
        });

        btnImportFlights.setBackground(new java.awt.Color(51, 153, 255));
        btnImportFlights.setText("Import Flights");
        btnImportFlights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportFlightsActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(255, 153, 51));
        btnClose.setText("Close");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnImportLocations, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtFlights, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                    .addComponent(txtLocation, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnBrowseLocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBrowseFlights, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))
                            .addComponent(btnImportFlights, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseLocation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImportLocations, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFlights, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseFlights))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImportFlights, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImportLocationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportLocationsActionPerformed
     try
     {
     LocationImporter locobj=new LocationImporter(txtLocation.getText());  
     Thread t1=new Thread(locobj);
     t1.start();
     t1.join();
     Import imobj=new Import(locobj.IRobj); 
     imobj.setVisible(true);
     this.setVisible(false);
     this.dispose();
     }
     catch(InterruptedException ie)
     {
         System.out.println(ie.toString());
     }
    }//GEN-LAST:event_btnImportLocationsActionPerformed

    private void btnImportFlightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportFlightsActionPerformed
     try
     {
     FlightImporter fliobj=new FlightImporter(txtFlights.getText());
     Thread t1=new Thread(fliobj);
     t1.start();
     t1.join();
     Import imobj=new Import(fliobj.IRobj);
     imobj.setVisible(true);
     this.setVisible(false);
     this.dispose();
     }
     catch(InterruptedException ie)
     {
         System.out.println(ie.toString());
     }
   
    }//GEN-LAST:event_btnImportFlightsActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
       MainFrame frame=new MainFrame();
       frame.setVisible(true);
       this.setVisible(false);
       this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnBrowseLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseLocationActionPerformed
        int retValue=jfcChooser1.showOpenDialog(this);
        if(retValue==javax.swing.JFileChooser.APPROVE_OPTION)
        {
            try
            {
                File file=jfcChooser1.getSelectedFile();
                txtLocation.setText(file.getAbsolutePath());
                
            }
            catch(Exception ioe)
            {
                ioe.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnBrowseLocationActionPerformed

    private void btnBrowseFlightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseFlightsActionPerformed
        int retValue=jfcChooser1.showOpenDialog(this);
        if(retValue==javax.swing.JFileChooser.APPROVE_OPTION)
        {
            try
            {
                File file=jfcChooser1.getSelectedFile();
                txtFlights.setText(file.getAbsolutePath());
                
            }
            catch(Exception ioe)
            {
                ioe.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnBrowseFlightsActionPerformed

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
            java.util.logging.Logger.getLogger(ImportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImportFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseFlights;
    private javax.swing.JButton btnBrowseLocation;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnImportFlights;
    private javax.swing.JButton btnImportLocations;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JFileChooser jfcChooser1;
    private javax.swing.JTextField txtFlights;
    private javax.swing.JTextField txtLocation;
    // End of variables declaration//GEN-END:variables
}
