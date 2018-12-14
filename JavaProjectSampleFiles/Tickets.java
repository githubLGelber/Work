
package java2project;
import javax.swing.*;
import java.util.*;
public class Tickets extends javax.swing.JFrame {
    java2project.BusinessObjects.Flight flight1=new java2project.BusinessObjects.Flight();
    java2project.BusinessObjects.Booking book=new java2project.BusinessObjects.Booking();
    EnumerationClass.Plane plane1;
    public Tickets(Booking1 booking1) {
        initComponents();
        lblFlightNum.setText(booking1.booking.getFlightNumber());
        java2project.BusinessObjects.Flight flight1=DatabaseOperations1.getFlightByFlightNumber(booking1.booking.getFlightNumber());
        createQuantityModel(flight1);
        book=booking1.booking;
    }
    public void createQuantityModel(java2project.BusinessObjects.Flight flight1)
    {
       String planeType=flight1.getPlane();
       switch(planeType)
       {
           case "AIRBUSA350":
               plane1=EnumerationClass.Plane.AIRBUSA350;
               break;
           case "AIRBUSA280":
               plane1=EnumerationClass.Plane.AIRBUSA280;
               break;
           case "BOEING737":
               plane1=EnumerationClass.Plane.BOEING737;
               break;
           case "BOEING747":
               plane1=EnumerationClass.Plane.BOEING747;
               break;
       }
       int Capacity=plane1.getPassengerCapacity();
       int seatsUnoccupied=Capacity-flight1.getSeatsTaken();
       DefaultComboBoxModel model0=new DefaultComboBoxModel();
       if(seatsUnoccupied>=12)
       {
           for(int i=1;i<13;i++)
           {
               model0.addElement(i);
           }
       }
       else if(seatsUnoccupied<12)
       {
           for(int i=1;i<seatsUnoccupied+1;i++)
           {
               model0.addElement(i);
           }
       }
       cmbTicket.setModel(model0);
       
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msgMessage = new javax.swing.JOptionPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblFlightNum = new javax.swing.JLabel();
        cmbTicket = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        chk1 = new javax.swing.JCheckBox();
        btnBook = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Select Tickets");

        jLabel2.setText("Flight:");

        jLabel3.setText("How many tickets would you like to get:");

        cmbTicket.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Would you like to get insurance?");

        chk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk1ActionPerformed(evt);
            }
        });

        btnBook.setBackground(new java.awt.Color(51, 153, 255));
        btnBook.setText("Book the Flight");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
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
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFlightNum, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(chk1)
                                .addComponent(cmbTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnClose))))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFlightNum, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(chk1))
                .addGap(18, 18, 18)
                .addComponent(btnBook)
                .addGap(18, 18, 18)
                .addComponent(btnClose)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk1ActionPerformed
      
    }//GEN-LAST:event_chk1ActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
       int tick=(Integer)cmbTicket.getSelectedItem();
       java2project.BusinessObjects.Flight flight1=DatabaseOperations1.getFlightByFlightNumber(book.getFlightNumber());
       book.setQuantity((Integer)cmbTicket.getSelectedItem());
       flight1.setSeatsTaken(flight1.getSeatsTaken()+book.getQuantity());
       DatabaseOperations1.UpdateFlight(flight1);
       createQuantityModel(flight1);
       if(chk1.isSelected())
       {
           double price1=book.getPrice();
           double price2=price1*tick;
           double price3=price2+20;
           book.setPrice(price3);
           book.setInsurance(true);
       }
       else
       {
           double price1=book.getPrice();
           double price2=price1*tick;
           book.setPrice(price2);
           book.setInsurance(false);
       }
       DatabaseOperations1.AddBooking(book);
       msgMessage.showMessageDialog(this,"Booking updated successfully","Update",javax.swing.JOptionPane.INFORMATION_MESSAGE); 
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        Booking1 booking=new Booking1();
        booking.setVisible(true);
        this.setVisible(false);
        this.dispose();
        
    }//GEN-LAST:event_btnCloseActionPerformed

    /**
     * @param args the command line arguments
     */
   /* public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tickets().setVisible(true);
            }
        });
    }
*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnClose;
    private javax.swing.JCheckBox chk1;
    private javax.swing.JComboBox cmbTicket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblFlightNum;
    private javax.swing.JOptionPane msgMessage;
    // End of variables declaration//GEN-END:variables
}
