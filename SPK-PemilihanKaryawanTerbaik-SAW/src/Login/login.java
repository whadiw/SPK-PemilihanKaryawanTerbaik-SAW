package Login;
import Koneksi.koneksi;
import Data.Session;
import Admin.admin;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
/*
@author Wahyu Hadi
*/
public class login extends javax.swing.JFrame {
    private static Connection conn = new koneksi().configDB();
    public login() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pKiri = new javax.swing.JPanel();
        Login = new javax.swing.JLabel();
        oUsername = new javax.swing.JLabel();
        txtUsernameLogin = new javax.swing.JTextField();
        oPassword = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lpassword = new javax.swing.JLabel();
        txtPassword_login = new javax.swing.JPasswordField();
        bg_login = new javax.swing.JLabel();
        pKanan = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pKiri.setBackground(new java.awt.Color(41, 59, 95));
        pKiri.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Login.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 58)); // NOI18N
        Login.setForeground(new java.awt.Color(41, 59, 95));
        Login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Login.setText("Login");
        pKiri.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 528, 69));

        oUsername.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Username.png"))); // NOI18N
        oUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        pKiri.add(oUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 255, -1, -1));

        txtUsernameLogin.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 30)); // NOI18N
        txtUsernameLogin.setForeground(new java.awt.Color(183, 183, 183));
        txtUsernameLogin.setText("Username");
        txtUsernameLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtUsernameLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameLoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameLoginFocusLost(evt);
            }
        });
        pKiri.add(txtUsernameLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 260, 336, 71));

        oPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Password.png"))); // NOI18N
        oPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        pKiri.add(oPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 390, -1, -1));

        btnLogin.setBackground(new java.awt.Color(19, 27, 43));
        btnLogin.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 38)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.setBorder(null);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pKiri.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 540, 438, 110));

        lpassword.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 30)); // NOI18N
        lpassword.setForeground(new java.awt.Color(183, 183, 183));
        lpassword.setText("Password");
        lpassword.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        pKiri.add(lpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 395, 336, 71));

        txtPassword_login.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 30)); // NOI18N
        txtPassword_login.setToolTipText("");
        txtPassword_login.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtPassword_login.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassword_loginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassword_loginFocusLost(evt);
            }
        });
        pKiri.add(txtPassword_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 395, 336, 71));

        bg_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-login.png"))); // NOI18N
        pKiri.add(bg_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        getContentPane().add(pKiri, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 568, 768));

        pKanan.setBackground(new java.awt.Color(41, 59, 95));
        pKanan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Fins Catering.png"))); // NOI18N
        pKanan.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 62, -1, -1));

        getContentPane().add(pKanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 0, 798, 768));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String SQL = "Select * from admin where Username='"+txtUsernameLogin.getText()+"' or Password='"+String.valueOf(txtPassword_login.getText())+"'";
        try{
            PreparedStatement state = conn.prepareStatement(SQL);
            ResultSet Result = state.executeQuery(SQL);
            if(Result.next()){
                if(txtUsernameLogin.getText().equals(Result.getString("Username"))&&String.valueOf(txtPassword_login.getText()).equals(Result.getString("Password"))){
                    Session.setUsername(Result.getString("Username"));
                    JOptionPane.showMessageDialog(null, "\tLogin Sukses \nSelamat Datang "+Result.getString("nama"));
                    new admin().setVisible(true);
                    this.dispose();
                }else if(!txtUsernameLogin.getText().equals(Result.getString("Username")) || String.valueOf(txtPassword_login.getText()).equals(Result.getString("Password"))){
                    JOptionPane.showMessageDialog(null, "Username Salah!", "Error!", JOptionPane.ERROR_MESSAGE);
                }else if(!txtUsernameLogin.getText().equals(Result.getString("Password")) || txtUsernameLogin.getText().equals(Result.getString("Username"))){
                    JOptionPane.showMessageDialog(null, "Password Salah!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Username & Password Salah!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }catch(SQLException wahyu){
            JOptionPane.showMessageDialog(null, "Error "+wahyu);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUsernameLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameLoginFocusGained
        if(txtUsernameLogin.getText().equals("Username")){
           txtUsernameLogin.setText("");
           txtUsernameLogin.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_txtUsernameLoginFocusGained

    private void txtUsernameLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameLoginFocusLost
        if(txtUsernameLogin.getText().equals("")){
           txtUsernameLogin.setText("Username");
           txtUsernameLogin.setForeground(new Color(183,183,183));
        }
    }//GEN-LAST:event_txtUsernameLoginFocusLost

    private void txtPassword_loginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassword_loginFocusGained
        lpassword.setVisible(false);
        if(txtPassword_login.getText().equals("")){
            txtPassword_login.setText("");
            txtPassword_login.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_txtPassword_loginFocusGained

    private void txtPassword_loginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassword_loginFocusLost
        if(txtPassword_login.getText().equals("")){
            txtPassword_login.setText("");
            txtPassword_login.setForeground(new Color(183,183,183));
            lpassword.setVisible(true);
        }
    }//GEN-LAST:event_txtPassword_loginFocusLost

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Login;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel bg_login;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lpassword;
    private javax.swing.JLabel oPassword;
    private javax.swing.JLabel oUsername;
    private javax.swing.JPanel pKanan;
    private javax.swing.JPanel pKiri;
    private javax.swing.JPasswordField txtPassword_login;
    private javax.swing.JTextField txtUsernameLogin;
    // End of variables declaration//GEN-END:variables
}
