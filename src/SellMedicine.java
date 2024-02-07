/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;
import dao.ConnectionProvider;
import dao.PharmacyUtils;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.table.TableModel;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author apple
 */
public class SellMedicine extends javax.swing.JFrame {

    public String numberPattern = "^[0-9]*$";
    private int finalTotalPrice = 0;
    private String billId = "";
    private String Username = "";

    /**
     * Creates new form SellMedicine
     */
    public SellMedicine() {
        initComponents();
    }

    public SellMedicine(String tempUsername) {
        initComponents();
        setLocationRelativeTo(null);

    }

    private void medicineName(String nameOrUniqueId) {
        DefaultTableModel model = (DefaultTableModel) medicineTable.getModel();
        model.setRowCount(0);
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from medicine where name like '" + nameOrUniqueId + "%' or uniqueId like '" + nameOrUniqueId + "%'");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("uniqueId") + "- " + rs.getString("name")});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void clearMedicineFields() {
        txtUniqueId.setText("");
        txtName.setText("");
        txtCompanyName.setText("");
        txtPrice.setText("");
        txtQuantity.setText("");
        txtTotalPrice.setText("");
    }

    public String getUniqueId(String prefix) {
        return prefix + System.nanoTime();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        medicineTable = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUniqueId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtCompanyName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        txtTotalPrice = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblFinalTotalPrice = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("Sell Medicine");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 6, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 77, 1351, 6));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 153));
        jLabel2.setText("Medicine ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 112, -1, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 153));
        jLabel3.setText("Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 186, -1, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 153));
        jLabel4.setText("Search");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 144, -1, -1));

        medicineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine"
            }
        ));
        medicineTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medicineTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(medicineTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 182, 677, 580));

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        getContentPane().add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 141, 237, -1));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 153));
        jLabel5.setText("Company Name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 267, -1, -1));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 153));
        jLabel6.setText("Price");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1063, 113, -1, -1));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 153));
        jLabel7.setText("Quantity");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1063, 184, -1, -1));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 153));
        jLabel8.setText("Total price");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1063, 267, -1, -1));
        getContentPane().add(txtUniqueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 148, 273, -1));

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNameKeyPressed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 222, 273, -1));
        getContentPane().add(txtCompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 303, 273, -1));
        getContentPane().add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1063, 149, 229, -1));

        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQuantityKeyPressed(evt);
            }
        });
        getContentPane().add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(1063, 220, 229, -1));
        getContentPane().add(txtTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(1063, 303, 229, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine ID", "Name", "Company Name", "Quantity", "Price", "Total Price"
            }
        ));
        cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(cartTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 383, 571, 270));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add to cart.png"))); // NOI18N
        jButton2.setText("Add To Cart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1168, 339, -1, -1));

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 153));
        jLabel9.setText("RS:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(761, 671, -1, -1));

        lblFinalTotalPrice.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblFinalTotalPrice.setForeground(new java.awt.Color(255, 153, 153));
        lblFinalTotalPrice.setText("00");
        getContentPane().add(lblFinalTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(803, 671, -1, -1));

        jButton3.setFont(new java.awt.Font("InaiMathi", 1, 13)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/generate bill & print.png"))); // NOI18N
        jButton3.setText("Purchase and Print");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 670, 170, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/adminDashboardBackground.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        String search = txtSearch.getText();
        medicineName(search);        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String quantity = txtQuantity.getText();
        String uniqueId = txtUniqueId.getText();

        if (!quantity.equals("") && !uniqueId.equals("")) {
            String companyName = txtName.getText();
            String price = txtCompanyName.getText();
            String name = txtName.getText();
            String totalPrice = txtTotalPrice.getText();
            int checkStock = 0;
            int checkMedicineAlreadyExistInCart = 0;
            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from medicine where uniqueId=" + uniqueId + "");
                while (rs.next()) {
                    if (rs.getInt("quantity") >= Integer.parseInt(quantity)) {
                        checkStock = 1;
                    } else {
                        JOptionPane.showMessageDialog(null, "Medicine is out of stock. Only " + rs.getInt("quantity") + "is left");
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            if (checkStock == 1) {
                DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
                if (cartTable.getRowCount() != 0) {
                    for (int i = 0; i < cartTable.getRowCount(); i++) {
                        if (Integer.parseInt(dtm.getValueAt(i, 0).toString()) == Integer.parseInt(uniqueId)) {
                            checkMedicineAlreadyExistInCart = 1;
                            JOptionPane.showMessageDialog(null, "Medicine already exist");

                        }
                    }
                }
                if (checkMedicineAlreadyExistInCart == 0) {
                    dtm.addRow(new Object[]{uniqueId, name, companyName, price, quantity, totalPrice});
                    finalTotalPrice = finalTotalPrice + Integer.parseInt(totalPrice);
                    lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
                    JOptionPane.showMessageDialog(null, "Added Successfully");

                }
                clearMedicineFields();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Quantity and Medicine ID field is required");

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        medicineName("");
        txtUniqueId.setEditable(false);
        txtName.setEditable(false);
        txtCompanyName.setEditable(false);
        txtPrice.setEditable(false);
        txtTotalPrice.setEditable(false);

    }//GEN-LAST:event_formComponentShown

    private void medicineTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medicineTableMouseClicked
        int index = medicineTable.getSelectedRow();
        TableModel model = medicineTable.getModel();
        String nameOrUniqueId = model.getValueAt(index, 0).toString();

        String uniqueId[] = nameOrUniqueId.split("-", 0);
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from medicine where uniqueId='" + uniqueId[0] + "'");
            while (rs.next()) {
                txtUniqueId.setText(uniqueId[0]);
                txtName.setText(rs.getString("name"));
                txtCompanyName.setText(rs.getString("companyName"));
                txtPrice.setText(rs.getString("price"));
                txtQuantity.setText("");
                txtTotalPrice.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_medicineTableMouseClicked

    private void txtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameKeyPressed

    private void txtQuantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyPressed
        String quantity = txtQuantity.getText();
        if (!quantity.equals("")) {
            String price = txtPrice.getText();
            if (!quantity.matches(numberPattern)) {
                JOptionPane.showMessageDialog(null, "Quantity field is invalid");
            }
            int totalPrice = Integer.parseInt(quantity) * Integer.parseInt(price);
            txtTotalPrice.setText(String.valueOf(totalPrice));
        } else {
            txtTotalPrice.setText("");
        }
    }//GEN-LAST:event_txtQuantityKeyPressed

    private void cartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartTableMouseClicked
        int index = cartTable.getSelectedRow();
        int a = JOptionPane.showConfirmDialog(null, "Do you want to remove this medicine?", "Select", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            TableModel model = cartTable.getModel();
            String total = model.getValueAt(index, 5).toString();
            finalTotalPrice = finalTotalPrice - Integer.parseInt(total);
            lblFinalTotalPrice.setText(String.valueOf(finalTotalPrice));
            ((DefaultTableModel) cartTable.getModel()).removeRow(index);
        }
    }//GEN-LAST:event_cartTableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (finalTotalPrice != 0) {
            billId = getUniqueId("Bill-");

            DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
            if (cartTable.getRowCount() != 0) {
                for (int i = 0; i < cartTable.getRowCount(); i++) {
                    try {
                        Connection con = ConnectionProvider.getCon();
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("update  medicine set quantity=quantity-" + Integer.parseInt(dtm.getValueAt(i, 4).toString()) + " Where uniqueId=" + Integer.parseInt(dtm.getValueAt(i, 0).toString()));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            }
            try {
                SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                Calendar cal = Calendar.getInstance();
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("insert into bill(billId,billDate,totalPaid,generatedBy) values(?,?,?,?)");
                ps.setString(1, billId);
                ps.setString(2, myFormat.format(cal.getTime()));
                ps.setInt(3, finalTotalPrice);
                ps.setString(4, Username);
                ps.executeUpdate();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            //for creating bill
            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(PharmacyUtils.billPath + "" + billId + ".pdf"));
                doc.open();
                Paragraph pharmacyName = new Paragraph("                       Pharmacy Management System\n");
                doc.add(pharmacyName);
                Paragraph starLine = new Paragraph("********************************************************");
                doc.add(starLine);
                Paragraph details = new Paragraph("\tBill ID: "+billId+"\nDate: "+new Date()+"\nTotal Paid: "+finalTotalPrice);
                doc.add(details);
                doc.add(starLine);
                PdfPTable tb1 = new PdfPTable(6);
                tb1.addCell("Medicine ID");
                tb1.addCell("Name");
                tb1.addCell("Company Name");
                tb1.addCell("Price");
                tb1.addCell("Quantity");
                tb1.addCell(" Total Price");
                for(int i=0;i<cartTable.getRowCount();i++){
                    String a = cartTable.getValueAt(i,0).toString();
                    String b = cartTable.getValueAt(i,1).toString();
                    String c = cartTable.getValueAt(i,2).toString();
                    String d = cartTable.getValueAt(i,3).toString();
                    String e = cartTable.getValueAt(i,4).toString();
                    String f = cartTable.getValueAt(i,5).toString();
                    tb1.addCell(a);
                    tb1.addCell(b);
                    tb1.addCell(c);
                    tb1.addCell(d);
                    tb1.addCell(e);
                    tb1.addCell(f);
                }
                doc.add(tb1);
                doc.add(starLine);
                Paragraph thanksMsg = new Paragraph("Thank you, Please visit again.");
                doc.add(thanksMsg);
                // open pdf
                OpenPdf.openById(String.valueOf(billId));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            doc.close();
            setVisible(false);
            new SellMedicine(Username).setVisible(true);
        }
        else{
                            JOptionPane.showMessageDialog(null, "Please add some medicine to cart");

        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellMedicine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellMedicine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cartTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFinalTotalPrice;
    private javax.swing.JTable medicineTable;
    private javax.swing.JTextField txtCompanyName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTotalPrice;
    private javax.swing.JTextField txtUniqueId;
    // End of variables declaration//GEN-END:variables
}
