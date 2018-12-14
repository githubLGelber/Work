
package java2project;
import java.util.*;
import javax.swing.*;
public class Booking1 extends javax.swing.JFrame {
     java2project.BusinessObjects.Booking booking=new java2project.BusinessObjects.Booking();
     java2project.BusinessObjects.Flight flight=new java2project.BusinessObjects.Flight();
     Date flightDate;
     java2project.BusinessObjects.Location location=new java2project.BusinessObjects.Location();
     public void createCabinClassModel()
     {
         DefaultComboBoxModel model1=new DefaultComboBoxModel();
         model1.addElement(EnumerationClass.CabinClass.ECONOMY_CLASS);
         model1.addElement(EnumerationClass.CabinClass.FIRST_CLASS);
         model1.addElement(EnumerationClass.CabinClass.PRESTIGE_CLASS);
         cmbClass.setModel(model1);
         
     }
     public void createFromLocationsModel()
     {
      DefaultComboBoxModel model2=new DefaultComboBoxModel();    
      ArrayList<java2project.BusinessObjects.Location> array1=DatabaseOperations1.GetAllLocations();
      for(java2project.BusinessObjects.Location loc1:array1)
      {
          model2.addElement(loc1);
      } 
      cmbFrom.setModel(model2);
      array1.clear();
     }
     
     public void createToLocationsModel()
     {
         DefaultComboBoxModel model3=new DefaultComboBoxModel();
         ArrayList<java2project.BusinessObjects.Location> array2=DatabaseOperations1.GetAllLocations();
         for(java2project.BusinessObjects.Location loc2:array2)
         {
           model3.addElement(loc2);
         } 
         int i= cmbFrom.getSelectedIndex();
         model3.removeElementAt(i);
         cmbTo.setModel(model3);
         array2.clear();
     }
     public void createDatesModel()
     {
         DefaultComboBoxModel model4=new DefaultComboBoxModel();
         cmbDate.removeAllItems();
         java2project.BusinessObjects.Location from=(java2project.BusinessObjects.Location) cmbFrom.getSelectedItem();
         String from1=from.getAirportCode();
         java2project.BusinessObjects.Location to=(java2project.BusinessObjects.Location) cmbTo.getSelectedItem();
         String to1=to.getAirportCode();
         ArrayList<java2project.BusinessObjects.Flight> array3=DatabaseOperations1.GetAllFlightsForLocation(from1,to1);

         for(java2project.BusinessObjects.Flight f1:array3)
         {
             model4.addElement(f1);
         }
         if(array3.isEmpty())
         {
             model4.addElement("No available flights");
         }
         cmbDate.setModel(model4);
        
         array3.clear();

     }
     public Booking1() {
        initComponents();
        createCabinClassModel();
        createFromLocationsModel();
        createToLocationsModel();
        createDatesModel();
        pan1.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbFrom = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbTo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cmbDate = new javax.swing.JComboBox();
        btnSearch = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnClose = new javax.swing.JButton();
        pan1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cmbClass = new javax.swing.JComboBox();
        btnBook = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Booking");

        jLabel2.setText("From:");

        cmbFrom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFromActionPerformed(evt);
            }
        });

        jLabel3.setText("To:");

        cmbTo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbToActionPerformed(evt);
            }
        });

        jLabel4.setText("Date you want to travel:");

        cmbDate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSearch.setBackground(new java.awt.Color(51, 153, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(255, 153, 51));
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jLabel5.setText("Choose the class:");

        cmbClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBook.setBackground(new java.awt.Color(51, 153, 255));
        btnBook.setText("Book");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pan1Layout = new javax.swing.GroupLayout(pan1);
        pan1.setLayout(pan1Layout);
        pan1Layout.setHorizontalGroup(
            pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pan1Layout.createSequentialGroup()
                        .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)
                        .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        pan1Layout.setVerticalGroup(
            pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pan1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBook))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbDate, javax.swing.GroupLayout.Alignment.LEADING, 0, 165, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbFrom, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(138, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
            .addGroup(layout.createSequentialGroup()
                .addComponent(pan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
     
     java2project.BusinessObjects.Flight flightObj=(java2project.BusinessObjects.Flight) cmbDate.getSelectedItem();
     booking.setPrice(flightObj.getPrice());
     booking.setCabinClass(String.valueOf(cmbClass.getSelectedItem()));
     booking.setFlightNumber(flightObj.getFlightNumber());
     if(String.valueOf(cmbClass.getSelectedItem()).equals("PRESTIGE_CLASS"))
     {
         booking.setPrice(flightObj.getPrice()*1.2);
     }
     else if(String.valueOf(cmbClass.getSelectedItem()).equals("FIRST_CLASS"))
     {
         booking.setPrice(flightObj.getPrice()*1.35);

     }
     Tickets frame=new Tickets(this);
     frame.setVisible(true);
     this.setVisible(false);
     this.dispose();
     
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
      MainFrame frame=new MainFrame();
      frame.setVisible(true);
      this.setVisible(false);
      this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void cmbFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFromActionPerformed
     createToLocationsModel();
     createDatesModel();   

    }//GEN-LAST:event_cmbFromActionPerformed

    private void cmbToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbToActionPerformed
      createDatesModel();
    }//GEN-LAST:event_cmbToActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
     try
     {
      java2project.BusinessObjects.Flight flightObj=(java2project.BusinessObjects.Flight) cmbDate.getSelectedItem();
      flightDate=flightObj.getDateTime();
      java2project.BusinessObjects.Location from=(java2project.BusinessObjects.Location) cmbFrom.getSelectedItem();
      String from1=from.getAirportCode();
      java2project.BusinessObjects.Location to=(java2project.BusinessObjects.Location) cmbTo.getSelectedItem();
      String to1=to.getAirportCode();
      ArrayList<java2project.BusinessObjects.Flight> array4=DatabaseOperations1.GetAllFlightsForLocation2(from1, to1, flightDate);
      pan1.setVisible(true);
      array4.clear();
     }
     catch(Exception e)
     {
        System.out.println(e.toString());
     }
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(Booking1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Booking1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Booking1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Booking1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Booking1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cmbClass;
    private javax.swing.JComboBox cmbDate;
    private javax.swing.JComboBox cmbFrom;
    private javax.swing.JComboBox cmbTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pan1;
    // End of variables declaration//GEN-END:variables
}
