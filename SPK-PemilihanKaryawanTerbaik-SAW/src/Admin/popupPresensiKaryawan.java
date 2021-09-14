package Admin;
import Koneksi.koneksi;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/*
@author Wahyu Hadi
*/
public class popupPresensiKaryawan extends javax.swing.JFrame {
    private static Connection conn = new koneksi().configDB();
    private DefaultTableModel tabmode, tabmodeL;
    public admin Presensi = null;
    
    public popupPresensiKaryawan() {
        initComponents();
        DataKaryawan();
    }

    public void DataKaryawan(){
        Object [] Baris ={"NIK", "Nama", "Jabatan"};
        tabmode = new DefaultTableModel(null, Baris);
        String Cari = txtSearch.getText();
        try{
            String SQL = "SELECT karyawan.NIK, karyawan.Nama, karyawan.Jabatan "
                    + "FROM karyawan where karyawan.NIK like '%"+Cari+"%'";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while(Result.next()){
                tabmode.addRow(new Object[]{
                    Result.getString(1),
                    Result.getString(2),     
                    Result.getString(3)});     
                }tbKaryawan.setModel(tabmode);
            }
        catch(SQLException wahyu){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil"+wahyu);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        bKembali = new javax.swing.JLabel();
        ljudulpopup = new javax.swing.JLabel();
        search = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane = new javax.swing.JScrollPane();
        tbKaryawan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/kembali-icon.png"))); // NOI18N
        bKembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bKembali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bKembaliMouseClicked(evt);
            }
        });
        bg.add(bKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 6, -1, -1));

        ljudulpopup.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 38)); // NOI18N
        ljudulpopup.setForeground(new java.awt.Color(71, 89, 126));
        ljudulpopup.setText("Tabel Karyawan");
        bg.add(ljudulpopup, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 36, -1, -1));

        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/search-popup.png"))); // NOI18N
        bg.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 36, -1, -1));

        txtSearch.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        txtSearch.setBorder(null);
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });
        bg.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 38, 270, 47));

        tbKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        tbKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKaryawanMouseClicked(evt);
            }
        });
        jScrollPane.setViewportView(tbKaryawan);

        bg.add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 99, 1076, 439));

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1121, 556));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKaryawanMouseClicked
        int row = tbKaryawan.getSelectedRow();
        Presensi.nik = tbKaryawan.getValueAt(row, 0).toString();
        Presensi.DataPresensiTerpilih();
        this.dispose();
    }//GEN-LAST:event_tbKaryawanMouseClicked

    private void bKembaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bKembaliMouseClicked
        dispose();
    }//GEN-LAST:event_bKembaliMouseClicked

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        DataKaryawan();
    }//GEN-LAST:event_txtSearchKeyTyped

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
            java.util.logging.Logger.getLogger(popupPresensiKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(popupPresensiKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(popupPresensiKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(popupPresensiKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new popupPresensiKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bKembali;
    private javax.swing.JPanel bg;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel ljudulpopup;
    private javax.swing.JLabel search;
    private javax.swing.JTable tbKaryawan;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
