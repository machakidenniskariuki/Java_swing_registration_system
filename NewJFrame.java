/* This  is a Java Swing application  designed for managing a registration system with a MySQL database. 
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author denis
 */
public class NewJFrame extends javax.swing.JFrame {
private static final String USERNAME = "root";
    private static final String PASSWORD = " ";
    private static final String DATACONN = "jdbc:mysql://localhost:3306/denis";
      
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q,i;
    
    
    
    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   public void upDateDB() {
    try {
        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Establish connection to the database
        sqlConn = DriverManager.getConnection(DATACONN, USERNAME, PASSWORD);
        
        // Prepare SQL query
        pst = sqlConn.prepareStatement("SELECT * FROM registration");
        
        // Execute the query
        rs = pst.executeQuery();
        ResultSetMetaData stData = rs.getMetaData();
        
        // Get the number of columns in the result set
        q = stData.getColumnCount();
        
        // Get the table model and reset it
        DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
        RecordTable.setRowCount(0);
        
        // Fetch each row from the result set and add it to the table model
        while (rs.next()) {
            Vector<String> columnData = new Vector<>();
            for (i = 1; i <= q; i++) {
                columnData.add(rs.getString("ID"));
                columnData.add(rs.getString("NAME"));
                columnData.add(rs.getString("GENDER"));
                columnData.add(rs.getString("ADDRES"));
                columnData.add(rs.getString("CONTACT"));
            }
            RecordTable.addRow(columnData);
        }
    } catch (Exception ex) {
        // Display any exceptions in a dialog box
        JOptionPane.showMessageDialog(null, ex);
    } finally {
        // Ensure resources are closed properly
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (sqlConn != null) sqlConn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
 
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        id = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        contact = new javax.swing.JLabel();
        idtext = new javax.swing.JTextField();
        nametext = new javax.swing.JTextField();
        addresstext = new javax.swing.JTextField();
        contacttext = new javax.swing.JTextField();
        exit = new javax.swing.JButton();
        register = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 0, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        id.setText("ID");
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 30, -1));

        name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        name.setText("NAME");
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        gender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        gender.setText("GENDER");
        getContentPane().add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 20));

        address.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        address.setText("ADDRESS");
        getContentPane().add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        contact.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        contact.setText("CONTACT");
        getContentPane().add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        idtext.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(idtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 140, -1));

        nametext.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(nametext, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 140, -1));

        addresstext.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(addresstext, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 140, -1));

        contacttext.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(contacttext, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 140, -1));

        exit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        exit.setForeground(new java.awt.Color(204, 0, 0));
        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        register.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        register.setForeground(new java.awt.Color(0, 153, 0));
        register.setText("REGISTER");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        getContentPane().add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

        jTable1.setBackground(new java.awt.Color(204, 255, 255));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "GENDER", "ADRESS", "CONTACT"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 590, 320));

        male.setBackground(new java.awt.Color(255, 204, 204));
        male.setText("male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        getContentPane().add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 50, -1));

        female.setBackground(new java.awt.Color(255, 204, 204));
        female.setText("female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        getContentPane().add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 70, -1));

        update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        update.setForeground(new java.awt.Color(0, 102, 204));
        update.setText("update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete.setText("delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 310, 90, 30));

        jLabel1.setText("registration");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 140, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
try {
        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Establish connection to the database
        sqlConn = DriverManager.getConnection(DATACONN, USERNAME, PASSWORD);
        
        // Prepare SQL query
        pst = sqlConn.prepareStatement("INSERT INTO registration (ID, NAME, GENDER, ADDRES, CONTACT) VALUES (?, ?, ?, ?, ?)");
        
        // Set the parameters for the SQL query
        pst.setString(1, idtext.getText());
        pst.setString(2, nametext.getText());

        String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : "";
        pst.setString(3, gender);  
        pst.setString(4, addresstext.getText());
        pst.setString(5, contacttext.getText()); // Changed index to 5
        
        // Execute the query
        pst.executeUpdate();
        
        // Show confirmation message
        JOptionPane.showMessageDialog(this, "Record added");
        
        // Update the database table
        upDateDB();
    } catch (Exception ex) {
        // Show error message
        JOptionPane.showMessageDialog(this, ex);
    } finally {
        // Ensure resources are closed properly
        try {
            if (pst != null) pst.close();
            if (sqlConn != null) sqlConn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
        // TODO add your handling code here:
    }//GEN-LAST:event_registerActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
  JFrame frame = new JFrame("Exit");
    int response = JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "MySQL Connector", JOptionPane.YES_NO_OPTION);
    if (response == JOptionPane.YES_OPTION) {
        System.exit(0);
    }  // TfODO add your handling code here:
         // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
if(male.isSelected())
				{
					female.setSelected(false);
				}        // TODO add your handling code here:
    }//GEN-LAST:event_maleActionPerformed

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
if(female.isSelected())
				{
					male.setSelected(false);
				}        // TODO add your handling code here:
    }//GEN-LAST:event_femaleActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
try {
        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection to the database
        sqlConn = DriverManager.getConnection(DATACONN, USERNAME, PASSWORD);

        // Prepare SQL query with a WHERE clause to specify which record to update
        pst = sqlConn.prepareStatement("UPDATE registration SET NAME = ?, GENDER = ?, ADDRES = ?, CONTACT = ? WHERE ID = ?");

        // Set the parameters for the SQL query
        pst.setString(1, nametext.getText());

        String gender = male.isSelected() ? "Male" : female.isSelected() ? "Female" : "";
        pst.setString(2, gender);
        pst.setString(3, addresstext.getText());
        pst.setString(4, contacttext.getText());
        pst.setString(5, idtext.getText()); // ID should be set last, as it is used in the WHERE clause

        // Execute the query
        pst.executeUpdate();

        // Show confirmation message
        JOptionPane.showMessageDialog(this, "Record updated");

        // Update the database table
        upDateDB();
    } catch (Exception ex) {
        // Show error message
        JOptionPane.showMessageDialog(this, ex);
    } finally {
        // Ensure resources are closed properly
        try {
            if (pst != null) pst.close();
            if (sqlConn != null) sqlConn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }      // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

    try {
        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection to the database
        sqlConn = DriverManager.getConnection(DATACONN, USERNAME, PASSWORD);

        // Prepare SQL query to delete the record with the specified ID
        pst = sqlConn.prepareStatement("DELETE FROM registration WHERE ID = ?");

        // Set the parameter for the SQL query
        pst.setString(1, idtext.getText());

        // Execute the query
        pst.executeUpdate();

        // Show confirmation message
        JOptionPane.showMessageDialog(this, "Record deleted");

        // Update the database table
        upDateDB();
    } catch (Exception ex) {
        // Show error message
        JOptionPane.showMessageDialog(this, ex);
    } finally {
        // Ensure resources are closed properly
        try {
            if (pst != null) pst.close();
            if (sqlConn != null) sqlConn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }

        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JTextField addresstext;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel contact;
    private javax.swing.JTextField contacttext;
    private javax.swing.JButton delete;
    private javax.swing.JButton exit;
    private javax.swing.JRadioButton female;
    private javax.swing.JLabel gender;
    private javax.swing.JLabel id;
    private javax.swing.JTextField idtext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton male;
    private javax.swing.JLabel name;
    private javax.swing.JTextField nametext;
    private javax.swing.JButton register;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
