package Admin;
import Data.Session;
import Data.*;
import Koneksi.koneksi;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/*
@author Wahyu Hadi
*/
public class admin extends javax.swing.JFrame {
    public Date ambil;
    public static String nik, nama, presensi, idpresensi;
    static int hadir;
    Date now = new Date();
    
    private static Connection conn = new koneksi().configDB();
    private DefaultTableModel tabmode, tabmodeL1, tabmodeL2;
    static SimpleDateFormat Date = new SimpleDateFormat("yyyy/MM/dd");
    
    public admin() {
        initComponents();
        String username = Session.getUsername();
        lUsername.setText(username);
        getnama();
        menuDasbor();
        getidbobot();
        tbKaryawan_HIT.setEnabled(false);
        tbKriteria_HIT.setEnabled(false);
        tbNormalisasi_HIT.setEnabled(false);
        lValueNilaiTertinggi.setVisible(false);
    }
    
    public void menuDasbor(){
        ic_dasbor_w.setVisible(true);
        ic_dasbor_b.setVisible(false);
        colorAktif(lDasbor);
        bg_dasbor.setVisible(true);
        conDasbor.setVisible(true);
        ic_admin_w.setVisible(false);
        ic_admin_b.setVisible(true);
        colorNoAktif(lAdmin);
        bg_admin.setVisible(false);
        conAdmin.setVisible(false);
        ic_karyawan_w.setVisible(false);
        ic_karyawan_b.setVisible(true);
        colorNoAktif(lKaryawan);
        bg_karyawan.setVisible(false);
        conKaryawan.setVisible(false);
        ic_presensi_w.setVisible(false);
        ic_presensi_b.setVisible(true);
        colorNoAktif(lPresensi);
        bg_presensi.setVisible(false);
        conPresensi.setVisible(false);
        ic_bobot_w.setVisible(false);
        ic_bobot_b.setVisible(true);
        colorNoAktif(lBobot);
        bg_bobot.setVisible(false);
        conBobot.setVisible(false);
        ic_kriteria_w.setVisible(false);
        ic_kriteria_b.setVisible(true);
        colorNoAktif(lKriteria);
        bg_kriteria.setVisible(false);
        conKriteria.setVisible(false);
        ic_hitung_w.setVisible(false);
        ic_hitung_b.setVisible(true);
        colorNoAktif(lHitung);
        bg_hitung.setVisible(false);
        conHitung.setVisible(false);
        JumlahKaryawan();
        JumlahKriteria();
        KaryawanTerbaik();
    }
    
    public void menuAdmin(){
        ic_dasbor_w.setVisible(false);
        ic_dasbor_b.setVisible(true);
        colorNoAktif(lDasbor);
        bg_dasbor.setVisible(false);
        conDasbor.setVisible(false);
        ic_admin_w.setVisible(true);
        ic_admin_b.setVisible(false);
        colorAktif(lAdmin);
        bg_admin.setVisible(true);
        conAdmin.setVisible(true);
        ic_karyawan_w.setVisible(false);
        ic_karyawan_b.setVisible(true);
        colorNoAktif(lKaryawan);
        bg_karyawan.setVisible(false);
        conKaryawan.setVisible(false);
        ic_presensi_w.setVisible(false);
        ic_presensi_b.setVisible(true);
        colorNoAktif(lPresensi);
        bg_presensi.setVisible(false);
        conPresensi.setVisible(false);
        ic_bobot_w.setVisible(false);
        ic_bobot_b.setVisible(true);
        colorNoAktif(lBobot);
        bg_bobot.setVisible(false);
        conBobot.setVisible(false);
        ic_kriteria_w.setVisible(false);
        ic_kriteria_b.setVisible(true);
        colorNoAktif(lKriteria);
        bg_kriteria.setVisible(false);
        conKriteria.setVisible(false);
        ic_hitung_w.setVisible(false);
        ic_hitung_b.setVisible(true);
        colorNoAktif(lHitung);
        bg_hitung.setVisible(false);
        conHitung.setVisible(false);
        tabelAdmin();
    }
    
    public void menuKaryawan(){
        ic_dasbor_w.setVisible(false);
        ic_dasbor_b.setVisible(true);
        colorNoAktif(lDasbor);
        bg_dasbor.setVisible(false);
        conDasbor.setVisible(false);
        ic_admin_w.setVisible(false);
        ic_admin_b.setVisible(true);
        colorNoAktif(lAdmin);
        bg_admin.setVisible(false);
        conAdmin.setVisible(false);
        ic_karyawan_w.setVisible(true);
        ic_karyawan_b.setVisible(false);
        colorAktif(lKaryawan);
        bg_karyawan.setVisible(true);
        conKaryawan.setVisible(true);
        ic_presensi_w.setVisible(false);
        ic_presensi_b.setVisible(true);
        colorNoAktif(lPresensi);
        bg_presensi.setVisible(false);
        conPresensi.setVisible(false);
        ic_bobot_w.setVisible(false);
        ic_bobot_b.setVisible(true);
        colorNoAktif(lBobot);
        bg_bobot.setVisible(false);
        conBobot.setVisible(false);
        ic_kriteria_w.setVisible(false);
        ic_kriteria_b.setVisible(true);
        colorNoAktif(lKriteria);
        bg_kriteria.setVisible(false);
        conKriteria.setVisible(false);
        ic_hitung_w.setVisible(false);
        ic_hitung_b.setVisible(true);
        colorNoAktif(lHitung);
        bg_hitung.setVisible(false);
        conHitung.setVisible(false);
        tabelKaryawan();
        kosonginKaryawan();
    }
    
    public void menuPresensi(){
        ic_dasbor_w.setVisible(false);
        ic_dasbor_b.setVisible(true);
        colorNoAktif(lDasbor);
        bg_dasbor.setVisible(false);
        conDasbor.setVisible(false);
        ic_admin_w.setVisible(false);
        ic_admin_b.setVisible(true);
        colorNoAktif(lAdmin);
        bg_admin.setVisible(false);
        conAdmin.setVisible(false);
        ic_karyawan_w.setVisible(false);
        ic_karyawan_b.setVisible(true);
        colorNoAktif(lKaryawan);
        bg_karyawan.setVisible(false);
        conKaryawan.setVisible(false);
        ic_presensi_w.setVisible(true);
        ic_presensi_b.setVisible(false);
        colorAktif(lPresensi);
        bg_presensi.setVisible(true);
        conPresensi.setVisible(true);
        ic_bobot_w.setVisible(false);
        ic_bobot_b.setVisible(true);
        colorNoAktif(lBobot);
        bg_bobot.setVisible(false);
        conBobot.setVisible(false);
        ic_kriteria_w.setVisible(false);
        ic_kriteria_b.setVisible(true);
        colorNoAktif(lKriteria);
        bg_kriteria.setVisible(false);
        conKriteria.setVisible(false);
        ic_hitung_w.setVisible(false);
        ic_hitung_b.setVisible(true);
        colorNoAktif(lHitung);
        bg_hitung.setVisible(false);
        conHitung.setVisible(false);
        IdPresensi();
        tabelPresensi();
        kosonginPresensi();
    }
    
    public void menuBobot(){
        ic_dasbor_w.setVisible(false);
        ic_dasbor_b.setVisible(true);
        colorNoAktif(lDasbor);
        bg_dasbor.setVisible(false);
        conDasbor.setVisible(false);
        ic_admin_w.setVisible(false);
        ic_admin_b.setVisible(true);
        colorNoAktif(lAdmin);
        bg_admin.setVisible(false);
        conAdmin.setVisible(false);
        ic_karyawan_w.setVisible(false);
        ic_karyawan_b.setVisible(true);
        colorNoAktif(lKaryawan);
        bg_karyawan.setVisible(false);
        conKaryawan.setVisible(false);
        ic_presensi_w.setVisible(false);
        ic_presensi_b.setVisible(true);
        colorNoAktif(lPresensi);
        bg_presensi.setVisible(false);
        conPresensi.setVisible(false);
        ic_bobot_w.setVisible(true);
        ic_bobot_b.setVisible(false);
        colorAktif(lBobot);
        bg_bobot.setVisible(true);
        conBobot.setVisible(true);
        ic_kriteria_w.setVisible(false);
        ic_kriteria_b.setVisible(true);
        colorNoAktif(lKriteria);
        bg_kriteria.setVisible(false);
        conKriteria.setVisible(false);
        ic_hitung_w.setVisible(false);
        ic_hitung_b.setVisible(true);
        colorNoAktif(lHitung);
        bg_hitung.setVisible(false);
        conHitung.setVisible(false);
        IdBobot();
        tabelBobot();
        kosonginBobot();
    }
    
    public void menuKriteria(){
        ic_dasbor_w.setVisible(false);
        ic_dasbor_b.setVisible(true);
        colorNoAktif(lDasbor);
        bg_dasbor.setVisible(false);
        conDasbor.setVisible(false);
        ic_admin_w.setVisible(false);
        ic_admin_b.setVisible(true);
        colorNoAktif(lAdmin);
        bg_admin.setVisible(false);
        conAdmin.setVisible(false);
        ic_karyawan_w.setVisible(false);
        ic_karyawan_b.setVisible(true);
        colorNoAktif(lKaryawan);
        bg_karyawan.setVisible(false);
        conKaryawan.setVisible(false);
        ic_presensi_w.setVisible(false);
        ic_presensi_b.setVisible(true);
        colorNoAktif(lPresensi);
        bg_presensi.setVisible(false);
        conPresensi.setVisible(false);
        ic_bobot_w.setVisible(false);
        ic_bobot_b.setVisible(true);
        colorNoAktif(lBobot);
        bg_bobot.setVisible(false);
        conBobot.setVisible(false);
        ic_kriteria_w.setVisible(true);
        ic_kriteria_b.setVisible(false);
        colorAktif(lKriteria);
        bg_kriteria.setVisible(true);
        conKriteria.setVisible(true);
        ic_hitung_w.setVisible(false);
        ic_hitung_b.setVisible(true);
        colorNoAktif(lHitung);
        bg_hitung.setVisible(false);
        conHitung.setVisible(false);
        IdKriteria();
        tabelKriteria();
        kosonginKriteria();
    }
    
    public void menuHitung(){
        ic_dasbor_w.setVisible(false);
        ic_dasbor_b.setVisible(true);
        colorNoAktif(lDasbor);
        bg_dasbor.setVisible(false);
        conDasbor.setVisible(false);
        ic_admin_w.setVisible(false);
        ic_admin_b.setVisible(true);
        colorNoAktif(lAdmin);
        bg_admin.setVisible(false);
        conAdmin.setVisible(false);
        ic_karyawan_w.setVisible(false);
        ic_karyawan_b.setVisible(true);
        colorNoAktif(lKaryawan);
        bg_karyawan.setVisible(false);
        conKaryawan.setVisible(false);
        ic_presensi_w.setVisible(false);
        ic_presensi_b.setVisible(true);
        colorNoAktif(lPresensi);
        bg_presensi.setVisible(false);
        conPresensi.setVisible(false);
        ic_bobot_w.setVisible(false);
        ic_bobot_b.setVisible(true);
        colorNoAktif(lBobot);
        bg_bobot.setVisible(false);
        conBobot.setVisible(false);
        ic_kriteria_w.setVisible(false);
        ic_kriteria_b.setVisible(true);
        colorNoAktif(lKriteria);
        bg_kriteria.setVisible(false);
        conKriteria.setVisible(false);
        ic_hitung_w.setVisible(true);
        ic_hitung_b.setVisible(false);
        colorAktif(lHitung);
        bg_hitung.setVisible(true);
        conHitung.setVisible(true);
        bHitungP_HIT.setEnabled(false);
        tabelKaryawan_HIT();
        tabelKriteria_HIT();
    }
    
    protected void getnama(){
        try{
            String sql = "SELECT * FROM admin WHERE Username='"+lUsername.getText()+"'";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if(hasil.next()){
                lUsername.setText(hasil.getString("Username"));
                lNama.setText(hasil.getString("Nama"));
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" +e);
        }
    }
    
    protected void getidbobot(){
        try{
            String sql = "SELECT Id_bobot FROM bobot ORDER BY Id_bobot DESC LIMIT 1";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if(hasil.next()){
                lIdbobot_HIT.setText(hasil.getString("Id_bobot"));
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" +e);
        }
    }
    
    public int JumlahKaryawan(){
        int count = 0;
        try{
            String SQL = "SELECT * FROM karyawan";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while (Result.next()) {
                count++;
            }  
            lValueDataKaryawan.setText(Integer.toString(count));
        }catch(SQLException wahyu){
            
        }
        return count;
    }
    
    public int JumlahKriteria(){
        int count = 0;
        try{
            String SQL = "SELECT * FROM kriteria";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while (Result.next()) {
                count++;
            }  
            lValueDataKriteria.setText(Integer.toString(count));
        }catch(SQLException wahyu){
            
        }
        return count;
    }
    
    public void KaryawanTerbaik(){
        try{
            String SQL = "SELECT Nama FROM hasil_akhir ORDER BY Grade DESC LIMIT 1";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(SQL);
            if(hasil.next()){
                lValueNilaiTertinggi.setText(hasil.getString("Nama"));
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "data gagal dipanggil" +e);
        }
    }
    
    protected void tabelAdmin(){
        Object [] Baris ={"Username", "Nama Admin", "Email", "No Telepon", "Alamat"};
        tabmode = new DefaultTableModel(null, Baris);
        String Cari = txtCari_ADM.getText();
        try{
            String SQL = "SELECT * FROM admin where Username like '%"+Cari+"%' or Nama like '%"+Cari+"%' order by Username asc";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while(Result.next()){
                tabmode.addRow(new Object[]{
                    Result.getString(1),
                    Result.getString(2), 
                    Result.getString(3),
                    Result.getString(4), 
                    Result.getString(5)
                });     
            }tbAdmin.setModel(tabmode);
        }
        catch(SQLException wahyu){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil"+wahyu);
        }
    }
    
    private void kosonginAdmin(){
        txtUsername_ADM.setText("");
        txtNama_ADM.setText("");
        txtEmail_ADM.setText("");
        txtTelp_ADM.setText("");
        txtAlamat_ADM.setText("");
        txtPassword_ADM.setText("");
    }
    
    protected void tabelKaryawan(){
        Object [] Baris ={"NIK", "Nama Karyawan", "Email", "No. Telp", "Alamat", "Tempat Lahir", "Tanggal Lahir", "Jenis Kelamin", "Jabatan"};
        tabmode = new DefaultTableModel(null, Baris);
        String Cari = txtCari_KAR.getText();
        try{
            String SQL = "SELECT * FROM karyawan WHERE NIK LIKE '%"+Cari+"%' OR Nama LIKE '%"+Cari+"%' ORDER BY NIK ASC";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while(Result.next()){
                tabmode.addRow(new Object[]{
                    Result.getString(1),
                    Result.getString(2), 
                    Result.getString(3),
                    Result.getString(4), 
                    Result.getString(5),
                    Result.getString(6),
                    Result.getString(7), 
                    Result.getString(8),
                    Result.getString(9)
                });     
            }tbKaryawan.setModel(tabmode);
        }
        catch(SQLException wahyu){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil"+wahyu);
        }
    }
    
    private void kosonginKaryawan(){
        txtNIK_KAR.setText("");
        txtNama_KAR.setText("");
        txtEmail_KAR.setText(""); 
        txtTelp_KAR.setText(""); 
        txtAlamat_KAR.setText("");
        txtTempatLahir_KAR.setText("");
        cbTglLahir_KAR.setDate(now);
        cbJK_KAR.setSelectedIndex(0);
        cbJabatan_KAR.setSelectedIndex(0);
    }
    
    protected void IdPresensi(){
        try{
            String Query = "Select Id_presensi from presensi order by Id_presensi asc";
            Statement st = conn.createStatement();
            ResultSet Res = st.executeQuery(Query);
            txtIdpresensi_PRE.setText("IDP0001");
            while(Res.next()){
                String Kode_hadir = Res.getString("Id_presensi").substring(3);
                int AN = Integer.parseInt(Kode_hadir)+1;
                String Nol = "";
                if (AN<10){Nol="000";
                } else if (AN<100){Nol="00";
                }else if (AN<1000){Nol="0";
                }else if (AN<10000){Nol="";
                }
                txtIdpresensi_PRE.setText("IDP" + Nol + AN);
            }
        }catch(SQLException wahyu){
            JOptionPane.showMessageDialog(this, "Auto Number Gagal"+wahyu);
        }
    }
    
    protected void tabelPresensi(){
        Object [] Baris ={"Id Presensi", "NIK", "Tanggal", "Kehadiran", "Keterangan"};
        tabmode = new DefaultTableModel(null, Baris);
        String Cari = txtCari_PRE.getText();
        try{
            String SQL = "SELECT * FROM presensi where Id_presensi like '%"+Cari+"%' or NIK like'%"+Cari+"%' order by Id_presensi asc";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while(Result.next()){
                tabmode.addRow(new Object[]{
                    Result.getString(1),
                    Result.getString(2), 
                    Result.getDate(3),
                    Result.getString(4), 
                    Result.getString(5)});     
                }tbPresensi.setModel(tabmode);
            }
        catch(SQLException wahyu){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil"+wahyu);
        }
    }
    
    private void kosonginPresensi(){
        txtNIK_PRE.setText("");
        cbTglPresensi_PRE.setDate(now); 
        cbKehadiran_PRE.setSelectedIndex(0); 
        txtKeterangan_PRE.setText("");
    }
    
    public void DataPresensiTerpilih(){
        popupPresensiKaryawan object = new popupPresensiKaryawan();
        object.Presensi = this;
        txtNIK_PRE.setText(nik);
    }
    
    protected void IdBobot(){
        try{
            String Query = "Select Id_bobot from bobot order by Id_bobot asc";
            Statement st = conn.createStatement();
            ResultSet Res = st.executeQuery(Query);
            txtIdbobot_BOB.setText("IDB0001");
            while(Res.next()){
                String Kode_bobot = Res.getString("Id_bobot").substring(3);
                int AN = Integer.parseInt(Kode_bobot)+1;
                String Nol = "";
                if (AN<10){Nol="000";
                } else if (AN<100){Nol="00";
                }else if (AN<1000){Nol="0";
                }else if (AN<10000){Nol="";
                }
                txtIdbobot_BOB.setText("IDB" + Nol + AN);
            }
        }catch(SQLException wahyu){
            JOptionPane.showMessageDialog(this, "Auto Number Gagal"+wahyu);
        }
    }
    
    protected void tabelBobot(){
        Object [] Baris ={"Id Bobot", "Loyalitas", "Kehadiran", "Kedisiplinan", "Perilaku", "Kinerja"};
        tabmode = new DefaultTableModel(null, Baris);
        String Cari = txtCari_BOB.getText();
        try{
            String SQL = "SELECT * FROM bobot where Id_bobot like '%"+Cari+"%' order by Id_bobot asc";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while(Result.next()){
                tabmode.addRow(new Object[]{
                    Result.getString(1),
                    Result.getFloat(2),
                    Result.getFloat(3),
                    Result.getFloat(4),
                    Result.getFloat(5),
                    Result.getFloat(6)
                });     
            }tbBobot.setModel(tabmode);
        }
        catch(SQLException wahyu){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil"+wahyu);
        }
    }
    
    private void kosonginBobot(){
        txtLoyalitas_BOB.setText(Float.toString(0));
        txtKehadiran_BOB.setText(Float.toString(0));
        txtKedisiplinan_BOB.setText(Float.toString(0));
        txtPerilaku_BOB.setText(Float.toString(0));
        txtKinerja_BOB.setText(Float.toString(0));
    }
    
    protected void IdKriteria(){
        try{
            String Query = "Select Id_kriteria from kriteria order by Id_kriteria asc";
            Statement st = conn.createStatement();
            ResultSet Res = st.executeQuery(Query);
            txtIdkriteria_KRI.setText("IDK0001");
            while(Res.next()){
                String Kode_kriteria = Res.getString("Id_kriteria").substring(3);
                int AN = Integer.parseInt(Kode_kriteria)+1;
                String Nol = "";
                if (AN<10){Nol="000";
                } else if (AN<100){Nol="00";
                }else if (AN<1000){Nol="0";
                }else if (AN<10000){Nol="";
                }
                txtIdkriteria_KRI.setText("IDK" + Nol + AN);
            }
        }catch(SQLException wahyu){
            JOptionPane.showMessageDialog(this, "Auto Number Gagal"+wahyu);
        }
    }
    
    protected void tabelKriteria(){
        Object [] Baris ={"Id Kriteria", "NIK","ID Presensi", "Loyalitas", "Kehadiran", "Kedisiplinan", "Perilaku", "Kinerja"};
        tabmode = new DefaultTableModel(null, Baris);
        String Cari = txtCari_KRI.getText();
        try{
            String SQL = "SELECT * FROM kriteria where Id_kriteria like '%"+Cari+"%' order by Id_kriteria asc";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while(Result.next()){
                tabmode.addRow(new Object[]{
                    Result.getString(1),
                    Result.getString(2),
                    Result.getString(3),
                    Result.getFloat(4),
                    Result.getFloat(5),
                    Result.getFloat(6),
                    Result.getFloat(7),
                    Result.getFloat(8)
                });     
            }tbKriteria.setModel(tabmode);
        }
        catch(SQLException wahyu){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil"+wahyu);
        }
    }
    
    private void kosonginKriteria(){
        txtNIK_KRI.setText("");
        txtIdpresensi_KRI.setText("");
        txtLoyalitas_KRI.setText(Integer.toString(0));
        txtKehadiran_KRI.setText(Integer.toString(0));
        txtKedisiplinan_KRI.setText(Integer.toString(0));
        cbPerilaku_KRI.setSelectedIndex(0);
        cbKinerja_KRI.setSelectedIndex(0);
    }
    
    public void DataKriteriaTerpilih(){
        popupKriteriaKaryawan ob = new popupKriteriaKaryawan();
        ob.Kriteria = this;
        txtNIK_KRI.setText(nik);
        txtIdpresensi_KRI.setText(idpresensi);
        txtKehadiran_KRI.setText(Integer.toString(hadir));
    }
    
    protected void tabelKaryawan_HIT(){
        Object [] Baris ={"NIK", "Nama", "Jabatan"};
        tabmode = new DefaultTableModel(null, Baris);
        try{
            String SQL = "SELECT * FROM karyawan";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while(Result.next()){
                tabmode.addRow(new Object[]{
                    Result.getString(1),
                    Result.getString(2),
                    Result.getString(9)
                });     
            }tbKaryawan_HIT.setModel(tabmode);
        }
        catch(SQLException wahyu){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil"+wahyu);
        }
    }
    
    protected void tabelKriteria_HIT(){
        Object [] Baris ={"Id Kriteria", "NIK", "Loyalitas", "Kehadiran", "Kedisiplinan", "Perilaku", "Kinerja"};
        tabmode = new DefaultTableModel(null, Baris);
        try{
            String SQL = "SELECT * FROM kriteria";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while(Result.next()){
                tabmode.addRow(new Object[]{
                    Result.getString(1),
                    Result.getString(2),
                    Result.getString(4),
                    Result.getString(5),
                    Result.getString(6),
                    Result.getString(7),
                    Result.getString(8)
                });     
            }tbKriteria_HIT.setModel(tabmode);
        }
        catch(SQLException wahyu){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil"+wahyu);
        }
    }
    
    protected void tabelNormalisasi_HIT(){
        LinkedList maximum = new LinkedList();
        Object [] Baris ={"Loyalitas", "Kehadiran", "Kedisiplinan", "Perilaku", "Kinerja"};
        tabmodeL1 = new DefaultTableModel(null, Baris);
        try{
            String SQL = "SELECT max(C1), max(C2), max(C3), max(C4), max(C5) FROM kriteria";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while(Result.next()){
                maximum.add(Result.getInt(1));
                maximum.add(Result.getInt(2));
                maximum.add(Result.getInt(3));
                maximum.add(Result.getInt(4));
                maximum.add(Result.getInt(5));
            }
            String sql = "SELECT C1,C2,C3,C4,C5 FROM kriteria";
            ResultSet result = State.executeQuery(sql);
            while(result.next()){
                tabmodeL1.addRow(new Object[]{
                    (result.getFloat(1)/Float.valueOf(maximum.get(0).toString())),
                    (result.getFloat(1)/Float.valueOf(maximum.get(1).toString())),
                    (result.getFloat(1)/Float.valueOf(maximum.get(2).toString())),
                    (result.getFloat(1)/Float.valueOf(maximum.get(3).toString())),
                    (result.getFloat(1)/Float.valueOf(maximum.get(4).toString())),
                });     
            }tbNormalisasi_HIT.setModel(tabmodeL1);
        }
        catch(SQLException wahyu){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil"+wahyu);
        }
    }
    
    protected void tabelHasilakhir_HIT(){
        try{
            tabmodeL2 = new DefaultTableModel();
            tabmodeL2.addColumn("NIK");
            tabmodeL2.addColumn("Nama");
            tabmodeL2.addColumn("Jabatan");
            tabmodeL2.addColumn("ID Kriteria");
            tabmodeL2.addColumn("ID Bobot");
            tabmodeL2.addColumn("Loyalitas");
            tabmodeL2.addColumn("Kehadiran");
            tabmodeL2.addColumn("Kedisiplinan");
            tabmodeL2.addColumn("Perilaku");
            tabmodeL2.addColumn("Kinerja");
            tabmodeL2.addColumn("Grade");
            tabmodeL2.addColumn("Username");
            tbHasilAkhir.setModel(tabmodeL2);
            
            String SQL = "SELECT * FROM hasil_akhir ORDER BY Grade DESC";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            while(Result.next()){
                tabmodeL2.addRow(new Object[]{
                    Result.getString(1),
                    Result.getString(2),
                    Result.getString(3),
                    Result.getString(4),
                    Result.getString(5),
                    Result.getFloat(6),
                    Result.getFloat(7),
                    Result.getFloat(8),
                    Result.getFloat(9),
                    Result.getFloat(10),
                    Result.getFloat(11),
                    Result.getString(12)
                });
            }
        }catch(SQLException wahyu){
            JOptionPane.showMessageDialog(this, "data gagal dipanggil"+wahyu);
        }
    }
    
    protected void hasilAkhir(){
        try{
            LinkedList bobot = new LinkedList();
            String SQL = "SELECT B1,B2,B3,B4,B5 FROM bobot ORDER BY Id_bobot DESC LIMIT 1";
            Statement State = conn.createStatement();
            ResultSet Result = State.executeQuery(SQL);
            tabelHasilakhir_HIT();
            while (Result.next()){
                 bobot.add(Result.getString(1));
                 bobot.add(Result.getString(2));
                 bobot.add(Result.getString(3));
                 bobot.add(Result.getString(4));
                 bobot.add(Result.getString(5));
            }
			
                for (int t = 0; t < tbNormalisasi_HIT.getRowCount(); t++) {
                    String sql = "DELETE FROM hasil_akhir WHERE NIK = NIK";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.executeUpdate();
                }
                for (int x = 0; x < tbNormalisasi_HIT.getRowCount(); x++){
                    float krit1;
                    float krit2;
                    float krit3;
                    float krit4;
                    float krit5;
                    float grade;
                        krit1 = (Float.valueOf(tbNormalisasi_HIT.getValueAt(x, 0).toString())*Float.valueOf(bobot.get(0).toString()));
                        krit2 = (Float.valueOf(tbNormalisasi_HIT.getValueAt(x, 1).toString())*Float.valueOf(bobot.get(1).toString()));
                        krit3 = (Float.valueOf(tbNormalisasi_HIT.getValueAt(x, 2).toString())*Float.valueOf(bobot.get(2).toString()));
                        krit4 = (Float.valueOf(tbNormalisasi_HIT.getValueAt(x, 3).toString())*Float.valueOf(bobot.get(3).toString()));
                        krit5 = (Float.valueOf(tbNormalisasi_HIT.getValueAt(x, 4).toString())*Float.valueOf(bobot.get(4).toString()));
                        grade=krit1+krit2+krit3+krit4+krit5;
                        String sql1 = "insert into hasil_akhir values(?,?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement St1 = conn.prepareStatement(sql1);
                        St1.setString(1, (String)tbKaryawan_HIT.getValueAt(x, 0));
                        St1.setString(2, (String)tbKaryawan_HIT.getValueAt(x, 1));
                        St1.setString(3, (String)tbKaryawan_HIT.getValueAt(x, 2));
                        St1.setString(4, (String)tbKriteria_HIT.getValueAt(x, 0));
                        St1.setString(5, lIdbobot_HIT.getText());
                        St1.setString(6, (String)tbKriteria_HIT.getValueAt(x, 2));
                        St1.setString(7, (String)tbKriteria_HIT.getValueAt(x, 3));
                        St1.setString(8, (String)tbKriteria_HIT.getValueAt(x, 4));
                        St1.setString(9, (String)tbKriteria_HIT.getValueAt(x, 5));
                        St1.setString(10, (String)tbKriteria_HIT.getValueAt(x, 6));
                        St1.setFloat(11, grade);
                        St1.setString(12, lUsername.getText());
                        St1.executeUpdate();
                }tabelHasilakhir_HIT();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pProfil = new javax.swing.JPanel();
        lNama = new javax.swing.JLabel();
        icProfil = new javax.swing.JLabel();
        icFav = new javax.swing.JLabel();
        lUsername = new javax.swing.JLabel();
        pMenu = new javax.swing.JPanel();
        mDasbor = new javax.swing.JPanel();
        lDasbor = new javax.swing.JLabel();
        ic_dasbor_w = new javax.swing.JLabel();
        ic_dasbor_b = new javax.swing.JLabel();
        bg_dasbor = new javax.swing.JLabel();
        mAdmin = new javax.swing.JPanel();
        lAdmin = new javax.swing.JLabel();
        ic_admin_w = new javax.swing.JLabel();
        ic_admin_b = new javax.swing.JLabel();
        bg_admin = new javax.swing.JLabel();
        mKaryawan = new javax.swing.JPanel();
        lKaryawan = new javax.swing.JLabel();
        ic_karyawan_w = new javax.swing.JLabel();
        ic_karyawan_b = new javax.swing.JLabel();
        bg_karyawan = new javax.swing.JLabel();
        mPresensi = new javax.swing.JPanel();
        lPresensi = new javax.swing.JLabel();
        ic_presensi_w = new javax.swing.JLabel();
        ic_presensi_b = new javax.swing.JLabel();
        bg_presensi = new javax.swing.JLabel();
        mBobot = new javax.swing.JPanel();
        lBobot = new javax.swing.JLabel();
        ic_bobot_w = new javax.swing.JLabel();
        ic_bobot_b = new javax.swing.JLabel();
        bg_bobot = new javax.swing.JLabel();
        mKriteria = new javax.swing.JPanel();
        lKriteria = new javax.swing.JLabel();
        ic_kriteria_w = new javax.swing.JLabel();
        ic_kriteria_b = new javax.swing.JLabel();
        bg_kriteria = new javax.swing.JLabel();
        mHitung = new javax.swing.JPanel();
        lHitung = new javax.swing.JLabel();
        ic_hitung_w = new javax.swing.JLabel();
        ic_hitung_b = new javax.swing.JLabel();
        bg_hitung = new javax.swing.JLabel();
        btnKeluar = new javax.swing.JLabel();
        pic = new javax.swing.JLabel();
        pContent = new javax.swing.JPanel();
        Shadow = new javax.swing.JLabel();
        conKriteria = new javax.swing.JPanel();
        lFormKriteria = new javax.swing.JLabel();
        lIdkriteria_KRI = new javax.swing.JLabel();
        txtIdkriteria_KRI = new javax.swing.JTextField();
        otIdkriteria_KRI = new javax.swing.JLabel();
        lNIK_KRI = new javax.swing.JLabel();
        otNIK_KRI = new javax.swing.JLabel();
        txtNIK_KRI = new javax.swing.JTextField();
        bCariKaryawan_KRI = new javax.swing.JButton();
        lIdpresensi_KRI = new javax.swing.JLabel();
        otIdpresensi_KRI = new javax.swing.JLabel();
        txtIdpresensi_KRI = new javax.swing.JTextField();
        lLoyalitas_KRI = new javax.swing.JLabel();
        otLoyalitas_KRI = new javax.swing.JLabel();
        txtLoyalitas_KRI = new javax.swing.JTextField();
        lIdKehadiran_KRI = new javax.swing.JLabel();
        otIdKehadiran_KRI = new javax.swing.JLabel();
        txtKehadiran_KRI = new javax.swing.JTextField();
        lKedisiplinan_KRI = new javax.swing.JLabel();
        otKedisiplinan_KRI = new javax.swing.JLabel();
        txtKedisiplinan_KRI = new javax.swing.JTextField();
        lPerilaku_KRI = new javax.swing.JLabel();
        otPerilaku_KRI = new javax.swing.JLabel();
        cbPerilaku_KRI = new javax.swing.JComboBox<String>();
        lKinerja_KRI = new javax.swing.JLabel();
        otKinerja_KRI = new javax.swing.JLabel();
        cbKinerja_KRI = new javax.swing.JComboBox<String>();
        line5 = new javax.swing.JLabel();
        bTambah_KRI = new javax.swing.JButton();
        bUbah_KRI = new javax.swing.JButton();
        bHapus_KRI = new javax.swing.JButton();
        bBatal_KRI = new javax.swing.JButton();
        bg_FormKriteria = new javax.swing.JLabel();
        lTabelKriteria = new javax.swing.JLabel();
        IconCari_KRI = new javax.swing.JLabel();
        lCari_KRI = new javax.swing.JLabel();
        txtCari_KRI = new javax.swing.JTextField();
        bgCari_KRI = new javax.swing.JLabel();
        jScrollPane_KRI = new javax.swing.JScrollPane();
        tbKriteria = new javax.swing.JTable();
        bCetak_KRI = new javax.swing.JButton();
        conAdmin = new javax.swing.JPanel();
        lFormAdmin = new javax.swing.JLabel();
        lUsername_ADM = new javax.swing.JLabel();
        otUsername_ADM = new javax.swing.JLabel();
        txtUsername_ADM = new javax.swing.JTextField();
        lNama_ADM = new javax.swing.JLabel();
        otNama_ADM = new javax.swing.JLabel();
        txtNama_ADM = new javax.swing.JTextField();
        lEmail_ADM = new javax.swing.JLabel();
        otEmail_ADM = new javax.swing.JLabel();
        txtEmail_ADM = new javax.swing.JTextField();
        lTelp_ADM = new javax.swing.JLabel();
        otTelp_ADM = new javax.swing.JLabel();
        txtTelp_ADM = new javax.swing.JTextField();
        lAlamat_ADM = new javax.swing.JLabel();
        otUsername_ADM1 = new javax.swing.JLabel();
        jScrollPane_ADM = new javax.swing.JScrollPane();
        txtAlamat_ADM = new javax.swing.JTextArea();
        lPassword_ADM = new javax.swing.JLabel();
        otEmail_ADM1 = new javax.swing.JLabel();
        txtPassword_ADM = new javax.swing.JTextField();
        line1 = new javax.swing.JLabel();
        bTambah_ADM = new javax.swing.JButton();
        bBatal_ADM = new javax.swing.JButton();
        bg_FormAdmin = new javax.swing.JLabel();
        lTabelAdmin = new javax.swing.JLabel();
        IconCari_ADM = new javax.swing.JLabel();
        lCari_ADM = new javax.swing.JLabel();
        txtCari_ADM = new javax.swing.JTextField();
        bgCari_ADM = new javax.swing.JLabel();
        jScrollPane_ADM2 = new javax.swing.JScrollPane();
        tbAdmin = new javax.swing.JTable();
        conDasbor = new javax.swing.JPanel();
        Dashbor = new javax.swing.JLabel();
        lValueDataKaryawan = new javax.swing.JLabel();
        lValueDataKriteria = new javax.swing.JLabel();
        lValueNilaiTertinggi = new javax.swing.JLabel();
        dashboardkonten = new javax.swing.JLabel();
        conHitung = new javax.swing.JPanel();
        lFormHitung = new javax.swing.JLabel();
        lIdbobot_HIT = new javax.swing.JLabel();
        otIdbobot = new javax.swing.JLabel();
        pPerhitungan = new javax.swing.JPanel();
        lDataKaryawan_HIT = new javax.swing.JLabel();
        jScrollPane_HIT = new javax.swing.JScrollPane();
        tbKaryawan_HIT = new javax.swing.JTable();
        lDataKriteria_HIT = new javax.swing.JLabel();
        jScrollPane_HIT2 = new javax.swing.JScrollPane();
        tbKriteria_HIT = new javax.swing.JTable();
        lNormalisasi_HIT = new javax.swing.JLabel();
        jScrollPane_HIT3 = new javax.swing.JScrollPane();
        tbNormalisasi_HIT = new javax.swing.JTable();
        lPeringkat_HIT = new javax.swing.JLabel();
        jScrollPane_HIT4 = new javax.swing.JScrollPane();
        tbHasilAkhir = new javax.swing.JTable();
        bHitungN_HIT = new javax.swing.JButton();
        bHitungP_HIT = new javax.swing.JButton();
        bCetakLaporan_HIT = new javax.swing.JButton();
        bg_FormHitung = new javax.swing.JLabel();
        conPresensi = new javax.swing.JPanel();
        lFormPresensi = new javax.swing.JLabel();
        lIdpresensi_PRE = new javax.swing.JLabel();
        txtIdpresensi_PRE = new javax.swing.JTextField();
        otIdpresensi_PRE = new javax.swing.JLabel();
        lNIK_PRE = new javax.swing.JLabel();
        otNIK_PRE = new javax.swing.JLabel();
        txtNIK_PRE = new javax.swing.JTextField();
        bCariKaryawan_PRE = new javax.swing.JButton();
        lTanggal_PRE = new javax.swing.JLabel();
        otTanggal_PRE = new javax.swing.JLabel();
        cbTglPresensi_PRE = new com.toedter.calendar.JDateChooser();
        lKehadiran_PRE = new javax.swing.JLabel();
        otKehadiran_PRE = new javax.swing.JLabel();
        cbKehadiran_PRE = new javax.swing.JComboBox<String>();
        lKeterangan_PRE = new javax.swing.JLabel();
        otKeterangan_PRE = new javax.swing.JLabel();
        txtKeterangan_PRE = new javax.swing.JTextField();
        line3 = new javax.swing.JLabel();
        bTambah_PRE = new javax.swing.JButton();
        bUbah_PRE = new javax.swing.JButton();
        bHapus_PRE = new javax.swing.JButton();
        bBatal_PRE = new javax.swing.JButton();
        bg_FormPresensi = new javax.swing.JLabel();
        lTabelPresensi = new javax.swing.JLabel();
        IconCari_PRE = new javax.swing.JLabel();
        lCari_PRE = new javax.swing.JLabel();
        txtCari_PRE = new javax.swing.JTextField();
        bgCari_PRE = new javax.swing.JLabel();
        jScrollPane_PRE = new javax.swing.JScrollPane();
        tbPresensi = new javax.swing.JTable();
        bCetak_PRE = new javax.swing.JButton();
        conKaryawan = new javax.swing.JPanel();
        lFormKaryawan = new javax.swing.JLabel();
        lNIK_KAR = new javax.swing.JLabel();
        otNIK_KAR = new javax.swing.JLabel();
        txtNIK_KAR = new javax.swing.JTextField();
        lNama_KAR = new javax.swing.JLabel();
        otNama_KAR = new javax.swing.JLabel();
        txtNama_KAR = new javax.swing.JTextField();
        lEmail_KAR = new javax.swing.JLabel();
        otEmail_KAR = new javax.swing.JLabel();
        txtEmail_KAR = new javax.swing.JTextField();
        lTelp_KAR = new javax.swing.JLabel();
        otTelp_KAR = new javax.swing.JLabel();
        txtTelp_KAR = new javax.swing.JTextField();
        lAlamat_KAR = new javax.swing.JLabel();
        otAlamat_KAR = new javax.swing.JLabel();
        jScrollPane_KAR = new javax.swing.JScrollPane();
        txtAlamat_KAR = new javax.swing.JTextArea();
        lTempatLahir_KAR = new javax.swing.JLabel();
        otTempatLahir_KAR = new javax.swing.JLabel();
        txtTempatLahir_KAR = new javax.swing.JTextField();
        lTglLahir_KAR = new javax.swing.JLabel();
        otTglLahir_KAR = new javax.swing.JLabel();
        cbTglLahir_KAR = new com.toedter.calendar.JDateChooser();
        lJabatan_KAR = new javax.swing.JLabel();
        otJabatan_KAR = new javax.swing.JLabel();
        cbJabatan_KAR = new javax.swing.JComboBox<String>();
        lJenkel_KAR = new javax.swing.JLabel();
        otJenkel_KAR = new javax.swing.JLabel();
        cbJK_KAR = new javax.swing.JComboBox<String>();
        line2 = new javax.swing.JLabel();
        bTambah_KAR = new javax.swing.JButton();
        bUbah_KAR = new javax.swing.JButton();
        bHapus_KAR = new javax.swing.JButton();
        bBatal_KAR = new javax.swing.JButton();
        bg_FormKaryawan = new javax.swing.JLabel();
        lTabelKaryawan = new javax.swing.JLabel();
        IconCari_KAR = new javax.swing.JLabel();
        lCari_KAR = new javax.swing.JLabel();
        txtCari_KAR = new javax.swing.JTextField();
        bgCari_KAR = new javax.swing.JLabel();
        jScrollPane_KAR2 = new javax.swing.JScrollPane();
        tbKaryawan = new javax.swing.JTable();
        bCetak_karyawan = new javax.swing.JButton();
        conBobot = new javax.swing.JPanel();
        lFormBobot = new javax.swing.JLabel();
        lIdbobot_BOB = new javax.swing.JLabel();
        txtIdbobot_BOB = new javax.swing.JTextField();
        otIdbobot_BOB = new javax.swing.JLabel();
        lLoyalitas_BOB = new javax.swing.JLabel();
        otLoyalitas_BOB = new javax.swing.JLabel();
        txtLoyalitas_BOB = new javax.swing.JTextField();
        lKehadiran_BOB = new javax.swing.JLabel();
        otKehadiran_BOB = new javax.swing.JLabel();
        txtKehadiran_BOB = new javax.swing.JTextField();
        lKedisiplinan_BOB = new javax.swing.JLabel();
        otKedisiplinan_BOB = new javax.swing.JLabel();
        txtKedisiplinan_BOB = new javax.swing.JTextField();
        lPerilaku_BOB = new javax.swing.JLabel();
        otPerilaku_BOB = new javax.swing.JLabel();
        txtPerilaku_BOB = new javax.swing.JTextField();
        lKinerja_BOB = new javax.swing.JLabel();
        otKinerja_BOB = new javax.swing.JLabel();
        txtKinerja_BOB = new javax.swing.JTextField();
        line4 = new javax.swing.JLabel();
        bTambah_BOB = new javax.swing.JButton();
        bBatal_BOB = new javax.swing.JButton();
        bg_FormBobot = new javax.swing.JLabel();
        lTabelBobot = new javax.swing.JLabel();
        IconCari_BOB = new javax.swing.JLabel();
        lCari_BOB = new javax.swing.JLabel();
        txtCari_BOB = new javax.swing.JTextField();
        bgCari_BOB = new javax.swing.JLabel();
        jScrollPane_BOB = new javax.swing.JScrollPane();
        tbBobot = new javax.swing.JTable();
        bCetak_BOB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pProfil.setBackground(new java.awt.Color(41, 59, 95));
        pProfil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lNama.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 21)); // NOI18N
        lNama.setForeground(new java.awt.Color(255, 255, 255));
        lNama.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lNama.setText("Nama");
        pProfil.add(lNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(1001, 17, 290, 27));

        icProfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/profil-icon.png"))); // NOI18N
        pProfil.add(icProfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(1308, 9, -1, -1));

        icFav.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/fav-icon.png"))); // NOI18N
        pProfil.add(icFav, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 11, -1, -1));

        getContentPane().add(pProfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 60));

        lUsername.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 21)); // NOI18N
        lUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lUsername.setText("Username");
        getContentPane().add(lUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(1001, 17, 290, 27));

        pMenu.setBackground(new java.awt.Color(255, 255, 255));
        pMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mDasbor.setBackground(new java.awt.Color(255, 255, 255));
        mDasbor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mDasbor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mDasborMouseClicked(evt);
            }
        });
        mDasbor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lDasbor.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lDasbor.setForeground(new java.awt.Color(255, 255, 255));
        lDasbor.setText("Dasbor");
        mDasbor.add(lDasbor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 12, 93, 30));

        ic_dasbor_w.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ic_dasbor_w.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/dasbor-icon-white.png"))); // NOI18N
        mDasbor.add(ic_dasbor_w, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 12, 43, -1));

        ic_dasbor_b.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ic_dasbor_b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/dasbor-icon-blue.png"))); // NOI18N
        mDasbor.add(ic_dasbor_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 12, 43, -1));

        bg_dasbor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-menu.png"))); // NOI18N
        mDasbor.add(bg_dasbor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pMenu.add(mDasbor, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 19, 239, 54));

        mAdmin.setBackground(new java.awt.Color(255, 255, 255));
        mAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mAdminMouseClicked(evt);
            }
        });
        mAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lAdmin.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lAdmin.setText("Admin");
        mAdmin.add(lAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 12, 93, 30));

        ic_admin_w.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ic_admin_w.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/admin-icon-white.png"))); // NOI18N
        mAdmin.add(ic_admin_w, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 12, 43, -1));

        ic_admin_b.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ic_admin_b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/admin-icon-blue.png"))); // NOI18N
        mAdmin.add(ic_admin_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 12, 43, -1));

        bg_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-menu.png"))); // NOI18N
        mAdmin.add(bg_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pMenu.add(mAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 93, 239, 54));

        mKaryawan.setBackground(new java.awt.Color(255, 255, 255));
        mKaryawan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mKaryawanMouseClicked(evt);
            }
        });
        mKaryawan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lKaryawan.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        lKaryawan.setText("Karyawan");
        mKaryawan.add(lKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 12, 120, 30));

        ic_karyawan_w.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ic_karyawan_w.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/karyawan-icon-white.png"))); // NOI18N
        mKaryawan.add(ic_karyawan_w, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 12, 43, -1));

        ic_karyawan_b.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ic_karyawan_b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/karyawan-icon-blue.png"))); // NOI18N
        mKaryawan.add(ic_karyawan_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 12, 43, -1));

        bg_karyawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-menu.png"))); // NOI18N
        mKaryawan.add(bg_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pMenu.add(mKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 167, 239, 54));

        mPresensi.setBackground(new java.awt.Color(255, 255, 255));
        mPresensi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mPresensi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mPresensiMouseClicked(evt);
            }
        });
        mPresensi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lPresensi.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lPresensi.setForeground(new java.awt.Color(255, 255, 255));
        lPresensi.setText("Presensi");
        mPresensi.add(lPresensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 12, 120, 30));

        ic_presensi_w.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ic_presensi_w.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/presensi-icon-white.png"))); // NOI18N
        mPresensi.add(ic_presensi_w, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 12, 43, -1));

        ic_presensi_b.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ic_presensi_b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/presensi-icon-blue.png"))); // NOI18N
        mPresensi.add(ic_presensi_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 12, 43, -1));

        bg_presensi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-menu.png"))); // NOI18N
        mPresensi.add(bg_presensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pMenu.add(mPresensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 241, 239, 54));

        mBobot.setBackground(new java.awt.Color(255, 255, 255));
        mBobot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mBobot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mBobotMouseClicked(evt);
            }
        });
        mBobot.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lBobot.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lBobot.setForeground(new java.awt.Color(255, 255, 255));
        lBobot.setText("Bobot");
        mBobot.add(lBobot, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 12, 120, 30));

        ic_bobot_w.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ic_bobot_w.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bobot-icon-white.png"))); // NOI18N
        mBobot.add(ic_bobot_w, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 12, 43, -1));

        ic_bobot_b.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ic_bobot_b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bobot-icon-blue.png"))); // NOI18N
        mBobot.add(ic_bobot_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 12, 43, -1));

        bg_bobot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-menu.png"))); // NOI18N
        mBobot.add(bg_bobot, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pMenu.add(mBobot, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 315, 239, 54));

        mKriteria.setBackground(new java.awt.Color(255, 255, 255));
        mKriteria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mKriteria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mKriteriaMouseClicked(evt);
            }
        });
        mKriteria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lKriteria.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lKriteria.setForeground(new java.awt.Color(255, 255, 255));
        lKriteria.setText("Kriteria");
        mKriteria.add(lKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 12, 120, 30));

        ic_kriteria_w.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ic_kriteria_w.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/kriteria-icon-white.png"))); // NOI18N
        mKriteria.add(ic_kriteria_w, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 12, 43, -1));

        ic_kriteria_b.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ic_kriteria_b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/kriteria-icon-blue.png"))); // NOI18N
        mKriteria.add(ic_kriteria_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 12, 43, -1));

        bg_kriteria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-menu.png"))); // NOI18N
        mKriteria.add(bg_kriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pMenu.add(mKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 389, 239, 54));

        mHitung.setBackground(new java.awt.Color(255, 255, 255));
        mHitung.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mHitung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mHitungMouseClicked(evt);
            }
        });
        mHitung.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lHitung.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lHitung.setForeground(new java.awt.Color(255, 255, 255));
        lHitung.setText("Hitung");
        mHitung.add(lHitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 12, 120, 30));

        ic_hitung_w.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ic_hitung_w.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/hitung-icon-white.png"))); // NOI18N
        mHitung.add(ic_hitung_w, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 10, 43, -1));

        ic_hitung_b.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ic_hitung_b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/hitung-icon-blue.png"))); // NOI18N
        mHitung.add(ic_hitung_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 10, 43, -1));

        bg_hitung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-menu.png"))); // NOI18N
        mHitung.add(bg_hitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pMenu.add(mHitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 463, 239, 54));

        btnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/keluar-icon.png"))); // NOI18N
        btnKeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKeluarMouseClicked(evt);
            }
        });
        pMenu.add(btnKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 613, -1, -1));

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/pic-rounded.jpg"))); // NOI18N
        pMenu.add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(pMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 274, 708));

        pContent.setBackground(new java.awt.Color(71, 89, 126));
        pContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Shadow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/menu-shadow.png"))); // NOI18N
        pContent.add(Shadow, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        conKriteria.setBackground(new java.awt.Color(71, 89, 126));
        conKriteria.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lFormKriteria.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 38)); // NOI18N
        lFormKriteria.setForeground(new java.awt.Color(255, 255, 255));
        lFormKriteria.setText("Form Kriteria");
        conKriteria.add(lFormKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 21, 330, 46));

        lIdkriteria_KRI.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        lIdkriteria_KRI.setForeground(new java.awt.Color(41, 59, 95));
        lIdkriteria_KRI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lIdkriteria_KRI.setText("ID Kriteria");
        conKriteria.add(lIdkriteria_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 109, 116, 35));

        txtIdkriteria_KRI.setEditable(false);
        txtIdkriteria_KRI.setBackground(new java.awt.Color(41, 59, 95));
        txtIdkriteria_KRI.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtIdkriteria_KRI.setForeground(new java.awt.Color(255, 255, 255));
        txtIdkriteria_KRI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdkriteria_KRI.setBorder(null);
        conKriteria.add(txtIdkriteria_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 108, 86, 35));

        otIdkriteria_KRI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 100x35 blue.png"))); // NOI18N
        conKriteria.add(otIdkriteria_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 108, -1, -1));

        lNIK_KRI.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        lNIK_KRI.setForeground(new java.awt.Color(41, 59, 95));
        lNIK_KRI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lNIK_KRI.setText("NIK");
        conKriteria.add(lNIK_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 163, 116, 35));

        otNIK_KRI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 279x35.png"))); // NOI18N
        conKriteria.add(otNIK_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 163, -1, -1));

        txtNIK_KRI.setEditable(false);
        txtNIK_KRI.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtNIK_KRI.setBorder(null);
        conKriteria.add(txtNIK_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 163, 265, 35));

        bCariKaryawan_KRI.setBackground(new java.awt.Color(41, 59, 95));
        bCariKaryawan_KRI.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        bCariKaryawan_KRI.setForeground(new java.awt.Color(255, 255, 255));
        bCariKaryawan_KRI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/cari-icon-white.png"))); // NOI18N
        bCariKaryawan_KRI.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bCariKaryawan_KRI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCariKaryawan_KRI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariKaryawan_KRIActionPerformed(evt);
            }
        });
        conKriteria.add(bCariKaryawan_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 161, 44, 39));

        lIdpresensi_KRI.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        lIdpresensi_KRI.setForeground(new java.awt.Color(41, 59, 95));
        lIdpresensi_KRI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lIdpresensi_KRI.setText("ID Presensi");
        conKriteria.add(lIdpresensi_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 218, 116, 35));

        otIdpresensi_KRI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 331x35.png"))); // NOI18N
        conKriteria.add(otIdpresensi_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 218, -1, -1));

        txtIdpresensi_KRI.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtIdpresensi_KRI.setBorder(null);
        conKriteria.add(txtIdpresensi_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 218, 317, 35));

        lLoyalitas_KRI.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        lLoyalitas_KRI.setForeground(new java.awt.Color(41, 59, 95));
        lLoyalitas_KRI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lLoyalitas_KRI.setText("Loyalitas");
        conKriteria.add(lLoyalitas_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 273, 116, 35));

        otLoyalitas_KRI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline Loyalitas.png"))); // NOI18N
        conKriteria.add(otLoyalitas_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 273, -1, -1));

        txtLoyalitas_KRI.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtLoyalitas_KRI.setBorder(null);
        conKriteria.add(txtLoyalitas_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 273, 242, 35));

        lIdKehadiran_KRI.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        lIdKehadiran_KRI.setForeground(new java.awt.Color(41, 59, 95));
        lIdKehadiran_KRI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lIdKehadiran_KRI.setText("Kehadiran");
        conKriteria.add(lIdKehadiran_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 109, 140, 35));

        otIdKehadiran_KRI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline Kehadiran.png"))); // NOI18N
        conKriteria.add(otIdKehadiran_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 108, -1, -1));

        txtKehadiran_KRI.setEditable(false);
        txtKehadiran_KRI.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtKehadiran_KRI.setBorder(null);
        conKriteria.add(txtKehadiran_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 108, 242, 35));

        lKedisiplinan_KRI.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        lKedisiplinan_KRI.setForeground(new java.awt.Color(41, 59, 95));
        lKedisiplinan_KRI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lKedisiplinan_KRI.setText("Kedisiplinan");
        conKriteria.add(lKedisiplinan_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 163, 140, 35));

        otKedisiplinan_KRI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline Kedisiplinan.png"))); // NOI18N
        conKriteria.add(otKedisiplinan_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 163, -1, -1));

        txtKedisiplinan_KRI.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtKedisiplinan_KRI.setBorder(null);
        conKriteria.add(txtKedisiplinan_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 163, 242, 35));

        lPerilaku_KRI.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        lPerilaku_KRI.setForeground(new java.awt.Color(41, 59, 95));
        lPerilaku_KRI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lPerilaku_KRI.setText("Perilaku");
        conKriteria.add(lPerilaku_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 218, 140, 35));

        otPerilaku_KRI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 331x35.png"))); // NOI18N
        conKriteria.add(otPerilaku_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 218, -1, -1));

        cbPerilaku_KRI.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cbPerilaku_KRI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Sangat Baik", "Baik", "Cukup", "Kurang" }));
        cbPerilaku_KRI.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cbPerilaku_KRI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        conKriteria.add(cbPerilaku_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 216, 335, 39));

        lKinerja_KRI.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 21)); // NOI18N
        lKinerja_KRI.setForeground(new java.awt.Color(41, 59, 95));
        lKinerja_KRI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lKinerja_KRI.setText("Kinerja");
        conKriteria.add(lKinerja_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(558, 273, 140, 35));

        otKinerja_KRI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 331x35.png"))); // NOI18N
        conKriteria.add(otKinerja_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 273, -1, -1));

        cbKinerja_KRI.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cbKinerja_KRI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Sangat Baik", "Baik", "Cukup", "Kurang" }));
        cbKinerja_KRI.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cbKinerja_KRI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        conKriteria.add(cbKinerja_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 271, 335, 39));

        line5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/line.png"))); // NOI18N
        conKriteria.add(line5, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 328, -1, -1));

        bTambah_KRI.setBackground(new java.awt.Color(29, 160, 42));
        bTambah_KRI.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        bTambah_KRI.setForeground(new java.awt.Color(255, 255, 255));
        bTambah_KRI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Tambah-icon.png"))); // NOI18N
        bTambah_KRI.setText("   Tambah");
        bTambah_KRI.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bTambah_KRI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bTambah_KRI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambah_KRIActionPerformed(evt);
            }
        });
        conKriteria.add(bTambah_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 346, 172, 54));

        bUbah_KRI.setBackground(new java.awt.Color(29, 113, 160));
        bUbah_KRI.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        bUbah_KRI.setForeground(new java.awt.Color(255, 255, 255));
        bUbah_KRI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/ubah-icon.png"))); // NOI18N
        bUbah_KRI.setText("   Ubah");
        bUbah_KRI.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bUbah_KRI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bUbah_KRI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbah_KRIActionPerformed(evt);
            }
        });
        conKriteria.add(bUbah_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 346, 172, 54));

        bHapus_KRI.setBackground(new java.awt.Color(160, 29, 29));
        bHapus_KRI.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        bHapus_KRI.setForeground(new java.awt.Color(255, 255, 255));
        bHapus_KRI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/hapus-icon.png"))); // NOI18N
        bHapus_KRI.setText("   Hapus");
        bHapus_KRI.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bHapus_KRI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bHapus_KRI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapus_KRIActionPerformed(evt);
            }
        });
        conKriteria.add(bHapus_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 346, 172, 54));

        bBatal_KRI.setBackground(new java.awt.Color(204, 204, 204));
        bBatal_KRI.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        bBatal_KRI.setForeground(new java.awt.Color(96, 96, 96));
        bBatal_KRI.setText("Batal");
        bBatal_KRI.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(96, 96, 96), 3, true));
        bBatal_KRI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bBatal_KRI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatal_KRIActionPerformed(evt);
            }
        });
        conKriteria.add(bBatal_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(636, 349, 407, 49));

        bg_FormKriteria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-formAdmin.png"))); // NOI18N
        conKriteria.add(bg_FormKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        lTabelKriteria.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 38)); // NOI18N
        lTabelKriteria.setForeground(new java.awt.Color(255, 255, 255));
        lTabelKriteria.setText("Tabel Kriteria");
        conKriteria.add(lTabelKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 439, -1, -1));

        IconCari_KRI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/cari-icon-blue.png"))); // NOI18N
        conKriteria.add(IconCari_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 448, -1, -1));

        lCari_KRI.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lCari_KRI.setForeground(new java.awt.Color(183, 183, 183));
        lCari_KRI.setText("Cari");
        lCari_KRI.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        conKriteria.add(lCari_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 439, 228, 46));

        txtCari_KRI.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        txtCari_KRI.setForeground(new java.awt.Color(183, 183, 183));
        txtCari_KRI.setBorder(null);
        txtCari_KRI.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCari_KRIFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCari_KRIFocusLost(evt);
            }
        });
        txtCari_KRI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCari_KRIKeyTyped(evt);
            }
        });
        conKriteria.add(txtCari_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 439, 228, 46));

        bgCari_KRI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-cari.png"))); // NOI18N
        conKriteria.add(bgCari_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 439, -1, -1));

        tbKriteria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tbKriteria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKriteriaMouseClicked(evt);
            }
        });
        jScrollPane_KRI.setViewportView(tbKriteria);

        conKriteria.add(jScrollPane_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 508, 1028, 124));

        bCetak_KRI.setBackground(new java.awt.Color(203, 115, 12));
        bCetak_KRI.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        bCetak_KRI.setForeground(new java.awt.Color(255, 255, 255));
        bCetak_KRI.setText("Cetak Laporan");
        bCetak_KRI.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bCetak_KRI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCetak_KRI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCetak_KRIActionPerformed(evt);
            }
        });
        conKriteria.add(bCetak_KRI, new org.netbeans.lib.awtextra.AbsoluteConstraints(799, 643, 259, 54));

        pContent.add(conKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 1088, 708));

        conAdmin.setBackground(new java.awt.Color(71, 89, 126));
        conAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lFormAdmin.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 38)); // NOI18N
        lFormAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lFormAdmin.setText("Form Admin");
        conAdmin.add(lFormAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 21, 250, 46));

        lUsername_ADM.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lUsername_ADM.setForeground(new java.awt.Color(41, 59, 95));
        lUsername_ADM.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lUsername_ADM.setText("Username");
        conAdmin.add(lUsername_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 109, 128, 35));

        otUsername_ADM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 331x35.png"))); // NOI18N
        conAdmin.add(otUsername_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 108, -1, -1));

        txtUsername_ADM.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtUsername_ADM.setBorder(null);
        conAdmin.add(txtUsername_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 108, 317, 35));

        lNama_ADM.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lNama_ADM.setForeground(new java.awt.Color(41, 59, 95));
        lNama_ADM.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lNama_ADM.setText("Nama");
        conAdmin.add(lNama_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 163, 128, 35));

        otNama_ADM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 331x35.png"))); // NOI18N
        conAdmin.add(otNama_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 163, -1, -1));

        txtNama_ADM.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtNama_ADM.setBorder(null);
        conAdmin.add(txtNama_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 163, 317, 35));

        lEmail_ADM.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lEmail_ADM.setForeground(new java.awt.Color(41, 59, 95));
        lEmail_ADM.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lEmail_ADM.setText("Email");
        conAdmin.add(lEmail_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 218, 128, 35));

        otEmail_ADM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 331x35.png"))); // NOI18N
        conAdmin.add(otEmail_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 218, -1, -1));

        txtEmail_ADM.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtEmail_ADM.setBorder(null);
        conAdmin.add(txtEmail_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 218, 317, 35));

        lTelp_ADM.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lTelp_ADM.setForeground(new java.awt.Color(41, 59, 95));
        lTelp_ADM.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lTelp_ADM.setText("No.Telp");
        conAdmin.add(lTelp_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 273, 128, 35));

        otTelp_ADM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 331x35.png"))); // NOI18N
        conAdmin.add(otTelp_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 273, -1, -1));

        txtTelp_ADM.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtTelp_ADM.setBorder(null);
        conAdmin.add(txtTelp_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 273, 317, 35));

        lAlamat_ADM.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lAlamat_ADM.setForeground(new java.awt.Color(41, 59, 95));
        lAlamat_ADM.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lAlamat_ADM.setText("Alamat");
        conAdmin.add(lAlamat_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 109, 122, 35));

        otUsername_ADM1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 331x90.png"))); // NOI18N
        conAdmin.add(otUsername_ADM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 108, -1, -1));

        jScrollPane_ADM.setBorder(null);
        jScrollPane_ADM.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane_ADM.setToolTipText("");
        jScrollPane_ADM.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane_ADM.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        txtAlamat_ADM.setColumns(20);
        txtAlamat_ADM.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtAlamat_ADM.setRows(5);
        jScrollPane_ADM.setViewportView(txtAlamat_ADM);

        conAdmin.add(jScrollPane_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 112, 317, 82));

        lPassword_ADM.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lPassword_ADM.setForeground(new java.awt.Color(41, 59, 95));
        lPassword_ADM.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lPassword_ADM.setText("Password");
        conAdmin.add(lPassword_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 218, 122, 35));

        otEmail_ADM1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 331x35.png"))); // NOI18N
        conAdmin.add(otEmail_ADM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 218, -1, -1));

        txtPassword_ADM.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtPassword_ADM.setBorder(null);
        conAdmin.add(txtPassword_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 218, 317, 35));

        line1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/line.png"))); // NOI18N
        conAdmin.add(line1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 328, -1, -1));

        bTambah_ADM.setBackground(new java.awt.Color(29, 160, 42));
        bTambah_ADM.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 28)); // NOI18N
        bTambah_ADM.setForeground(new java.awt.Color(255, 255, 255));
        bTambah_ADM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Tambah-icon.png"))); // NOI18N
        bTambah_ADM.setText("  Tambah");
        bTambah_ADM.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bTambah_ADM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bTambah_ADM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambah_ADMActionPerformed(evt);
            }
        });
        conAdmin.add(bTambah_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 346, 482, 54));

        bBatal_ADM.setBackground(new java.awt.Color(204, 204, 204));
        bBatal_ADM.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 28)); // NOI18N
        bBatal_ADM.setForeground(new java.awt.Color(96, 96, 96));
        bBatal_ADM.setText("Batal");
        bBatal_ADM.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(96, 96, 96), 3, true));
        bBatal_ADM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bBatal_ADM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatal_ADMActionPerformed(evt);
            }
        });
        conAdmin.add(bBatal_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 349, 486, 49));

        bg_FormAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-formAdmin.png"))); // NOI18N
        conAdmin.add(bg_FormAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        lTabelAdmin.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 38)); // NOI18N
        lTabelAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lTabelAdmin.setText("Tabel Admin");
        conAdmin.add(lTabelAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 439, -1, -1));

        IconCari_ADM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/cari-icon-blue.png"))); // NOI18N
        conAdmin.add(IconCari_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 448, -1, -1));

        lCari_ADM.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lCari_ADM.setForeground(new java.awt.Color(183, 183, 183));
        lCari_ADM.setText("Cari");
        lCari_ADM.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        conAdmin.add(lCari_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 439, 228, 46));

        txtCari_ADM.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        txtCari_ADM.setForeground(new java.awt.Color(183, 183, 183));
        txtCari_ADM.setBorder(null);
        txtCari_ADM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCari_ADMFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCari_ADMFocusLost(evt);
            }
        });
        txtCari_ADM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCari_ADMKeyTyped(evt);
            }
        });
        conAdmin.add(txtCari_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 439, 228, 46));

        bgCari_ADM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-cari.png"))); // NOI18N
        conAdmin.add(bgCari_ADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 439, -1, -1));

        tbAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane_ADM2.setViewportView(tbAdmin);

        conAdmin.add(jScrollPane_ADM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 508, 1028, 170));

        pContent.add(conAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 1088, 708));

        conDasbor.setBackground(new java.awt.Color(71, 89, 126));
        conDasbor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dashbor.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 38)); // NOI18N
        Dashbor.setForeground(new java.awt.Color(255, 255, 255));
        Dashbor.setText("Dasbor");
        conDasbor.add(Dashbor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 21, 150, 46));

        lValueDataKaryawan.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 50)); // NOI18N
        lValueDataKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        lValueDataKaryawan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lValueDataKaryawan.setText("1000");
        conDasbor.add(lValueDataKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 178, 445, 59));

        lValueDataKriteria.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 50)); // NOI18N
        lValueDataKriteria.setForeground(new java.awt.Color(255, 255, 255));
        lValueDataKriteria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lValueDataKriteria.setText("1000");
        conDasbor.add(lValueDataKriteria, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 386, 445, 59));

        lValueNilaiTertinggi.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 35)); // NOI18N
        lValueNilaiTertinggi.setForeground(new java.awt.Color(255, 255, 255));
        lValueNilaiTertinggi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lValueNilaiTertinggi.setText("-");
        conDasbor.add(lValueNilaiTertinggi, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 594, 770, 59));

        dashboardkonten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/dashboard konten.png"))); // NOI18N
        conDasbor.add(dashboardkonten, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        pContent.add(conDasbor, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 1088, 708));

        conHitung.setBackground(new java.awt.Color(71, 89, 126));
        conHitung.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lFormHitung.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 38)); // NOI18N
        lFormHitung.setForeground(new java.awt.Color(255, 255, 255));
        lFormHitung.setText("Perhitungan");
        conHitung.add(lFormHitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 21, 330, 46));

        lIdbobot_HIT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        lIdbobot_HIT.setForeground(new java.awt.Color(71, 89, 126));
        lIdbobot_HIT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lIdbobot_HIT.setText("Id Bobot");
        conHitung.add(lIdbobot_HIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 34, 113, 31));

        otIdbobot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-idbobot.png"))); // NOI18N
        conHitung.add(otIdbobot, new org.netbeans.lib.awtextra.AbsoluteConstraints(945, 34, -1, -1));

        pPerhitungan.setBackground(new java.awt.Color(71, 89, 126));
        pPerhitungan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lDataKaryawan_HIT.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 23)); // NOI18N
        lDataKaryawan_HIT.setForeground(new java.awt.Color(41, 59, 95));
        lDataKaryawan_HIT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lDataKaryawan_HIT.setText("Data Karyawan");
        pPerhitungan.add(lDataKaryawan_HIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 14, 320, 28));

        tbKaryawan_HIT.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        tbKaryawan_HIT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane_HIT.setViewportView(tbKaryawan_HIT);

        pPerhitungan.add(jScrollPane_HIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 48, 320, 178));

        lDataKriteria_HIT.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 23)); // NOI18N
        lDataKriteria_HIT.setForeground(new java.awt.Color(41, 59, 95));
        lDataKriteria_HIT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lDataKriteria_HIT.setText("Data Kriteria");
        pPerhitungan.add(lDataKriteria_HIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 14, 320, 28));

        tbKriteria_HIT.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        tbKriteria_HIT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane_HIT2.setViewportView(tbKriteria_HIT);

        pPerhitungan.add(jScrollPane_HIT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 48, 320, 178));

        lNormalisasi_HIT.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 23)); // NOI18N
        lNormalisasi_HIT.setForeground(new java.awt.Color(41, 59, 95));
        lNormalisasi_HIT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lNormalisasi_HIT.setText("Normalisasi Kriteria");
        pPerhitungan.add(lNormalisasi_HIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(693, 14, 320, 28));

        tbNormalisasi_HIT.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        tbNormalisasi_HIT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane_HIT3.setViewportView(tbNormalisasi_HIT);

        pPerhitungan.add(jScrollPane_HIT3, new org.netbeans.lib.awtextra.AbsoluteConstraints(693, 48, 320, 178));

        lPeringkat_HIT.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 23)); // NOI18N
        lPeringkat_HIT.setForeground(new java.awt.Color(41, 59, 95));
        lPeringkat_HIT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lPeringkat_HIT.setText("Hasil Akhir Pemilihan Karyawan Terbaik");
        pPerhitungan.add(lPeringkat_HIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 248, 983, 28));

        tbHasilAkhir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane_HIT4.setViewportView(tbHasilAkhir);

        pPerhitungan.add(jScrollPane_HIT4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 282, 998, 231));

        bHitungN_HIT.setBackground(new java.awt.Color(29, 160, 42));
        bHitungN_HIT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        bHitungN_HIT.setForeground(new java.awt.Color(255, 255, 255));
        bHitungN_HIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/proses-icon.png"))); // NOI18N
        bHitungN_HIT.setText("  Hitung Normalisasi");
        bHitungN_HIT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bHitungN_HIT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bHitungN_HIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHitungN_HITActionPerformed(evt);
            }
        });
        pPerhitungan.add(bHitungN_HIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 530, 239, 40));

        bHitungP_HIT.setBackground(new java.awt.Color(29, 160, 42));
        bHitungP_HIT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        bHitungP_HIT.setForeground(new java.awt.Color(255, 255, 255));
        bHitungP_HIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/proses-icon.png"))); // NOI18N
        bHitungP_HIT.setText("  Hitung Hasil Akhir");
        bHitungP_HIT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bHitungP_HIT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bHitungP_HIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHitungP_HITActionPerformed(evt);
            }
        });
        pPerhitungan.add(bHitungP_HIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 530, 239, 40));

        bCetakLaporan_HIT.setBackground(new java.awt.Color(29, 160, 42));
        bCetakLaporan_HIT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        bCetakLaporan_HIT.setForeground(new java.awt.Color(255, 255, 255));
        bCetakLaporan_HIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/cetak-icon.png"))); // NOI18N
        bCetakLaporan_HIT.setText("  Cetak Laporan");
        bCetakLaporan_HIT.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bCetakLaporan_HIT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCetakLaporan_HIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCetakLaporan_HITActionPerformed(evt);
            }
        });
        pPerhitungan.add(bCetakLaporan_HIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 530, 239, 40));

        bg_FormHitung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-Hitung.png"))); // NOI18N
        pPerhitungan.add(bg_FormHitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        conHitung.add(pPerhitungan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 1028, 587));

        pContent.add(conHitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 1088, 708));

        conPresensi.setBackground(new java.awt.Color(71, 89, 126));
        conPresensi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lFormPresensi.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 38)); // NOI18N
        lFormPresensi.setForeground(new java.awt.Color(255, 255, 255));
        lFormPresensi.setText("Form Presensi");
        conPresensi.add(lFormPresensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 21, 330, 46));

        lIdpresensi_PRE.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lIdpresensi_PRE.setForeground(new java.awt.Color(41, 59, 95));
        lIdpresensi_PRE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lIdpresensi_PRE.setText("ID Presensi");
        conPresensi.add(lIdpresensi_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 109, 139, 35));

        txtIdpresensi_PRE.setEditable(false);
        txtIdpresensi_PRE.setBackground(new java.awt.Color(41, 59, 95));
        txtIdpresensi_PRE.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtIdpresensi_PRE.setForeground(new java.awt.Color(255, 255, 255));
        txtIdpresensi_PRE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdpresensi_PRE.setBorder(null);
        conPresensi.add(txtIdpresensi_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 108, 86, 35));

        otIdpresensi_PRE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 100x35 blue.png"))); // NOI18N
        conPresensi.add(otIdpresensi_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 108, -1, -1));

        lNIK_PRE.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lNIK_PRE.setForeground(new java.awt.Color(41, 59, 95));
        lNIK_PRE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lNIK_PRE.setText("NIK");
        conPresensi.add(lNIK_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 163, 139, 35));

        otNIK_PRE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 279x35.png"))); // NOI18N
        conPresensi.add(otNIK_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 163, -1, -1));

        txtNIK_PRE.setEditable(false);
        txtNIK_PRE.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtNIK_PRE.setBorder(null);
        conPresensi.add(txtNIK_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 163, 265, 35));

        bCariKaryawan_PRE.setBackground(new java.awt.Color(41, 59, 95));
        bCariKaryawan_PRE.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        bCariKaryawan_PRE.setForeground(new java.awt.Color(255, 255, 255));
        bCariKaryawan_PRE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/cari-icon-white.png"))); // NOI18N
        bCariKaryawan_PRE.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bCariKaryawan_PRE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCariKaryawan_PRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariKaryawan_PREActionPerformed(evt);
            }
        });
        conPresensi.add(bCariKaryawan_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(489, 161, 44, 39));

        lTanggal_PRE.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lTanggal_PRE.setForeground(new java.awt.Color(41, 59, 95));
        lTanggal_PRE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lTanggal_PRE.setText("Tanggal");
        conPresensi.add(lTanggal_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 218, 139, 35));

        otTanggal_PRE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 331x35.png"))); // NOI18N
        conPresensi.add(otTanggal_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 218, -1, -1));

        cbTglPresensi_PRE.setBackground(new java.awt.Color(255, 255, 255));
        conPresensi.add(cbTglPresensi_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 220, 325, 31));

        lKehadiran_PRE.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lKehadiran_PRE.setForeground(new java.awt.Color(41, 59, 95));
        lKehadiran_PRE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lKehadiran_PRE.setText("Kehadiran");
        conPresensi.add(lKehadiran_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 163, 142, 35));

        otKehadiran_PRE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 331x35.png"))); // NOI18N
        conPresensi.add(otKehadiran_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 163, -1, -1));

        cbKehadiran_PRE.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cbKehadiran_PRE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Hadir", "Tidak Hadir" }));
        cbKehadiran_PRE.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cbKehadiran_PRE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        conPresensi.add(cbKehadiran_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 161, 335, 39));

        lKeterangan_PRE.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lKeterangan_PRE.setForeground(new java.awt.Color(41, 59, 95));
        lKeterangan_PRE.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lKeterangan_PRE.setText("Keterangan");
        conPresensi.add(lKeterangan_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 218, 142, 35));

        otKeterangan_PRE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 331x35.png"))); // NOI18N
        conPresensi.add(otKeterangan_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 218, -1, -1));

        txtKeterangan_PRE.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtKeterangan_PRE.setBorder(null);
        conPresensi.add(txtKeterangan_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 218, 317, 35));

        line3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/line.png"))); // NOI18N
        conPresensi.add(line3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 272, -1, -1));

        bTambah_PRE.setBackground(new java.awt.Color(29, 160, 42));
        bTambah_PRE.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        bTambah_PRE.setForeground(new java.awt.Color(255, 255, 255));
        bTambah_PRE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Tambah-icon.png"))); // NOI18N
        bTambah_PRE.setText("   Tambah");
        bTambah_PRE.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bTambah_PRE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bTambah_PRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambah_PREActionPerformed(evt);
            }
        });
        conPresensi.add(bTambah_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 290, 172, 54));

        bUbah_PRE.setBackground(new java.awt.Color(29, 113, 160));
        bUbah_PRE.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        bUbah_PRE.setForeground(new java.awt.Color(255, 255, 255));
        bUbah_PRE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/ubah-icon.png"))); // NOI18N
        bUbah_PRE.setText("   Ubah");
        bUbah_PRE.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bUbah_PRE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bUbah_PRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbah_PREActionPerformed(evt);
            }
        });
        conPresensi.add(bUbah_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 290, 172, 54));

        bHapus_PRE.setBackground(new java.awt.Color(160, 29, 29));
        bHapus_PRE.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        bHapus_PRE.setForeground(new java.awt.Color(255, 255, 255));
        bHapus_PRE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/hapus-icon.png"))); // NOI18N
        bHapus_PRE.setText("   Hapus");
        bHapus_PRE.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bHapus_PRE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bHapus_PRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapus_PREActionPerformed(evt);
            }
        });
        conPresensi.add(bHapus_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 290, 172, 54));

        bBatal_PRE.setBackground(new java.awt.Color(204, 204, 204));
        bBatal_PRE.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        bBatal_PRE.setForeground(new java.awt.Color(96, 96, 96));
        bBatal_PRE.setText("Batal");
        bBatal_PRE.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(96, 96, 96), 3, true));
        bBatal_PRE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bBatal_PRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatal_PREActionPerformed(evt);
            }
        });
        conPresensi.add(bBatal_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(636, 293, 407, 49));

        bg_FormPresensi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-formPresensi.png"))); // NOI18N
        conPresensi.add(bg_FormPresensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        lTabelPresensi.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 38)); // NOI18N
        lTabelPresensi.setForeground(new java.awt.Color(255, 255, 255));
        lTabelPresensi.setText("Tabel Presensi");
        conPresensi.add(lTabelPresensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 383, -1, -1));

        IconCari_PRE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/cari-icon-blue.png"))); // NOI18N
        conPresensi.add(IconCari_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 392, -1, -1));

        lCari_PRE.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lCari_PRE.setForeground(new java.awt.Color(183, 183, 183));
        lCari_PRE.setText("Cari");
        lCari_PRE.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        conPresensi.add(lCari_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 383, 228, 46));

        txtCari_PRE.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        txtCari_PRE.setForeground(new java.awt.Color(183, 183, 183));
        txtCari_PRE.setBorder(null);
        txtCari_PRE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCari_PREFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCari_PREFocusLost(evt);
            }
        });
        txtCari_PRE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCari_PREKeyTyped(evt);
            }
        });
        conPresensi.add(txtCari_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 383, 228, 46));

        bgCari_PRE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-cari.png"))); // NOI18N
        conPresensi.add(bgCari_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 383, -1, -1));

        tbPresensi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tbPresensi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPresensiMouseClicked(evt);
            }
        });
        jScrollPane_PRE.setViewportView(tbPresensi);

        conPresensi.add(jScrollPane_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 452, 1028, 180));

        bCetak_PRE.setBackground(new java.awt.Color(203, 115, 12));
        bCetak_PRE.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        bCetak_PRE.setForeground(new java.awt.Color(255, 255, 255));
        bCetak_PRE.setText("Cetak Laporan");
        bCetak_PRE.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bCetak_PRE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCetak_PRE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCetak_PREActionPerformed(evt);
            }
        });
        conPresensi.add(bCetak_PRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(799, 643, 259, 54));

        pContent.add(conPresensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 1088, 708));

        conKaryawan.setBackground(new java.awt.Color(71, 89, 126));
        conKaryawan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lFormKaryawan.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 38)); // NOI18N
        lFormKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        lFormKaryawan.setText("Form Karyawan");
        conKaryawan.add(lFormKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 21, 330, 46));

        lNIK_KAR.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lNIK_KAR.setForeground(new java.awt.Color(41, 59, 95));
        lNIK_KAR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lNIK_KAR.setText("NIK");
        conKaryawan.add(lNIK_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 109, 94, 35));

        otNIK_KAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 195x35.png"))); // NOI18N
        conKaryawan.add(otNIK_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 108, -1, -1));

        txtNIK_KAR.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtNIK_KAR.setBorder(null);
        conKaryawan.add(txtNIK_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 108, 181, 35));

        lNama_KAR.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lNama_KAR.setForeground(new java.awt.Color(41, 59, 95));
        lNama_KAR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lNama_KAR.setText("Nama");
        conKaryawan.add(lNama_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 163, 94, 35));

        otNama_KAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 195x35.png"))); // NOI18N
        conKaryawan.add(otNama_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 163, -1, -1));

        txtNama_KAR.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtNama_KAR.setBorder(null);
        conKaryawan.add(txtNama_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 163, 181, 35));

        lEmail_KAR.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lEmail_KAR.setForeground(new java.awt.Color(41, 59, 95));
        lEmail_KAR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lEmail_KAR.setText("Email");
        conKaryawan.add(lEmail_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 218, 94, 35));

        otEmail_KAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 195x35.png"))); // NOI18N
        conKaryawan.add(otEmail_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 218, -1, -1));

        txtEmail_KAR.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtEmail_KAR.setBorder(null);
        conKaryawan.add(txtEmail_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 218, 181, 35));

        lTelp_KAR.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lTelp_KAR.setForeground(new java.awt.Color(41, 59, 95));
        lTelp_KAR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lTelp_KAR.setText("No.Telp");
        conKaryawan.add(lTelp_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 273, 94, 35));

        otTelp_KAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 195x35.png"))); // NOI18N
        conKaryawan.add(otTelp_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 273, -1, -1));

        txtTelp_KAR.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtTelp_KAR.setBorder(null);
        conKaryawan.add(txtTelp_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 273, 181, 35));

        lAlamat_KAR.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lAlamat_KAR.setForeground(new java.awt.Color(41, 59, 95));
        lAlamat_KAR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lAlamat_KAR.setText("Alamat");
        conKaryawan.add(lAlamat_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 109, 152, 35));

        otAlamat_KAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 155x90.png"))); // NOI18N
        conKaryawan.add(otAlamat_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 108, -1, -1));

        jScrollPane_KAR.setBorder(null);
        jScrollPane_KAR.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane_KAR.setToolTipText("");
        jScrollPane_KAR.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane_KAR.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        txtAlamat_KAR.setColumns(20);
        txtAlamat_KAR.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtAlamat_KAR.setRows(5);
        jScrollPane_KAR.setViewportView(txtAlamat_KAR);

        conKaryawan.add(jScrollPane_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 112, 142, 82));

        lTempatLahir_KAR.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lTempatLahir_KAR.setForeground(new java.awt.Color(41, 59, 95));
        lTempatLahir_KAR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lTempatLahir_KAR.setText("Tempat Lahir");
        conKaryawan.add(lTempatLahir_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(371, 218, 152, 35));

        otTempatLahir_KAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 155x35.png"))); // NOI18N
        conKaryawan.add(otTempatLahir_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 218, -1, -1));

        txtTempatLahir_KAR.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtTempatLahir_KAR.setBorder(null);
        conKaryawan.add(txtTempatLahir_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 218, 142, 35));

        lTglLahir_KAR.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lTglLahir_KAR.setForeground(new java.awt.Color(41, 59, 95));
        lTglLahir_KAR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lTglLahir_KAR.setText("Tanggal Lahir");
        conKaryawan.add(lTglLahir_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 273, -1, 35));

        otTglLahir_KAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 155x35.png"))); // NOI18N
        conKaryawan.add(otTglLahir_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 273, -1, -1));

        cbTglLahir_KAR.setBackground(new java.awt.Color(255, 255, 255));
        conKaryawan.add(cbTglLahir_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(541, 275, 149, 31));

        lJabatan_KAR.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lJabatan_KAR.setForeground(new java.awt.Color(41, 59, 95));
        lJabatan_KAR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lJabatan_KAR.setText("Jabatan");
        conKaryawan.add(lJabatan_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(716, 109, 157, 35));

        otJabatan_KAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 155x35.png"))); // NOI18N
        conKaryawan.add(otJabatan_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(888, 108, -1, -1));

        cbJabatan_KAR.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cbJabatan_KAR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Manager Finance", "Admin", "Manager Operasional", "Head Chef", "Cook Helper", "Steward", "Waiters", "Driver" }));
        cbJabatan_KAR.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cbJabatan_KAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        conKaryawan.add(cbJabatan_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(886, 106, 159, 39));

        lJenkel_KAR.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lJenkel_KAR.setForeground(new java.awt.Color(41, 59, 95));
        lJenkel_KAR.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lJenkel_KAR.setText("Jenis Kelamin");
        conKaryawan.add(lJenkel_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(716, 163, 157, 35));

        otJenkel_KAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 155x35.png"))); // NOI18N
        conKaryawan.add(otJenkel_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(888, 163, -1, -1));

        cbJK_KAR.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cbJK_KAR.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Laki-laki", "Perempuan" }));
        cbJK_KAR.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cbJK_KAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        conKaryawan.add(cbJK_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(886, 161, 159, 39));

        line2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/line.png"))); // NOI18N
        conKaryawan.add(line2, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 328, -1, -1));

        bTambah_KAR.setBackground(new java.awt.Color(29, 160, 42));
        bTambah_KAR.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        bTambah_KAR.setForeground(new java.awt.Color(255, 255, 255));
        bTambah_KAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Tambah-icon.png"))); // NOI18N
        bTambah_KAR.setText("   Tambah");
        bTambah_KAR.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bTambah_KAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bTambah_KAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambah_KARActionPerformed(evt);
            }
        });
        conKaryawan.add(bTambah_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 346, 172, 54));

        bUbah_KAR.setBackground(new java.awt.Color(29, 113, 160));
        bUbah_KAR.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        bUbah_KAR.setForeground(new java.awt.Color(255, 255, 255));
        bUbah_KAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/ubah-icon.png"))); // NOI18N
        bUbah_KAR.setText("   Ubah");
        bUbah_KAR.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bUbah_KAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bUbah_KAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbah_KARActionPerformed(evt);
            }
        });
        conKaryawan.add(bUbah_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 346, 172, 54));

        bHapus_KAR.setBackground(new java.awt.Color(160, 29, 29));
        bHapus_KAR.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        bHapus_KAR.setForeground(new java.awt.Color(255, 255, 255));
        bHapus_KAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/hapus-icon.png"))); // NOI18N
        bHapus_KAR.setText("   Hapus");
        bHapus_KAR.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bHapus_KAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bHapus_KAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapus_KARActionPerformed(evt);
            }
        });
        conKaryawan.add(bHapus_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(439, 346, 172, 54));

        bBatal_KAR.setBackground(new java.awt.Color(204, 204, 204));
        bBatal_KAR.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        bBatal_KAR.setForeground(new java.awt.Color(96, 96, 96));
        bBatal_KAR.setText("Batal");
        bBatal_KAR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(96, 96, 96), 3, true));
        bBatal_KAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bBatal_KAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatal_KARActionPerformed(evt);
            }
        });
        conKaryawan.add(bBatal_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(636, 349, 407, 49));

        bg_FormKaryawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-formAdmin.png"))); // NOI18N
        conKaryawan.add(bg_FormKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        lTabelKaryawan.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 38)); // NOI18N
        lTabelKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        lTabelKaryawan.setText("Tabel Karyawan");
        conKaryawan.add(lTabelKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 439, -1, -1));

        IconCari_KAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/cari-icon-blue.png"))); // NOI18N
        conKaryawan.add(IconCari_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 448, -1, -1));

        lCari_KAR.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lCari_KAR.setForeground(new java.awt.Color(183, 183, 183));
        lCari_KAR.setText("Cari");
        lCari_KAR.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        conKaryawan.add(lCari_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 439, 228, 46));

        txtCari_KAR.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        txtCari_KAR.setForeground(new java.awt.Color(183, 183, 183));
        txtCari_KAR.setBorder(null);
        txtCari_KAR.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCari_KARFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCari_KARFocusLost(evt);
            }
        });
        txtCari_KAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCari_KARKeyTyped(evt);
            }
        });
        conKaryawan.add(txtCari_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 439, 228, 46));

        bgCari_KAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-cari.png"))); // NOI18N
        conKaryawan.add(bgCari_KAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 439, -1, -1));

        tbKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tbKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKaryawanMouseClicked(evt);
            }
        });
        jScrollPane_KAR2.setViewportView(tbKaryawan);

        conKaryawan.add(jScrollPane_KAR2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 508, 1028, 124));

        bCetak_karyawan.setBackground(new java.awt.Color(203, 115, 12));
        bCetak_karyawan.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        bCetak_karyawan.setForeground(new java.awt.Color(255, 255, 255));
        bCetak_karyawan.setText("Cetak Laporan");
        bCetak_karyawan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bCetak_karyawan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCetak_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCetak_karyawanActionPerformed(evt);
            }
        });
        conKaryawan.add(bCetak_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(799, 643, 259, 54));

        pContent.add(conKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 1088, 708));

        conBobot.setBackground(new java.awt.Color(71, 89, 126));
        conBobot.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lFormBobot.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 38)); // NOI18N
        lFormBobot.setForeground(new java.awt.Color(255, 255, 255));
        lFormBobot.setText("Form Bobot");
        conBobot.add(lFormBobot, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 21, 330, 46));

        lIdbobot_BOB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lIdbobot_BOB.setForeground(new java.awt.Color(41, 59, 95));
        lIdbobot_BOB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lIdbobot_BOB.setText("ID Bobot");
        conBobot.add(lIdbobot_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 109, 138, 35));

        txtIdbobot_BOB.setEditable(false);
        txtIdbobot_BOB.setBackground(new java.awt.Color(41, 59, 95));
        txtIdbobot_BOB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtIdbobot_BOB.setForeground(new java.awt.Color(255, 255, 255));
        txtIdbobot_BOB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdbobot_BOB.setBorder(null);
        conBobot.add(txtIdbobot_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 108, 86, 35));

        otIdbobot_BOB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 100x35 blue.png"))); // NOI18N
        conBobot.add(otIdbobot_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 108, -1, -1));

        lLoyalitas_BOB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lLoyalitas_BOB.setForeground(new java.awt.Color(41, 59, 95));
        lLoyalitas_BOB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lLoyalitas_BOB.setText("Loyalitas");
        conBobot.add(lLoyalitas_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 163, 138, 35));

        otLoyalitas_BOB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 331x35.png"))); // NOI18N
        conBobot.add(otLoyalitas_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 163, -1, -1));

        txtLoyalitas_BOB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtLoyalitas_BOB.setBorder(null);
        conBobot.add(txtLoyalitas_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 163, 317, 35));

        lKehadiran_BOB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lKehadiran_BOB.setForeground(new java.awt.Color(41, 59, 95));
        lKehadiran_BOB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lKehadiran_BOB.setText("Kehadiran");
        conBobot.add(lKehadiran_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 218, 138, 35));

        otKehadiran_BOB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 331x35.png"))); // NOI18N
        conBobot.add(otKehadiran_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 218, -1, -1));

        txtKehadiran_BOB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtKehadiran_BOB.setBorder(null);
        conBobot.add(txtKehadiran_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 218, 317, 35));

        lKedisiplinan_BOB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lKedisiplinan_BOB.setForeground(new java.awt.Color(41, 59, 95));
        lKedisiplinan_BOB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lKedisiplinan_BOB.setText("Kedisiplinan");
        conBobot.add(lKedisiplinan_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 273, 138, 35));

        otKedisiplinan_BOB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 331x35.png"))); // NOI18N
        conBobot.add(otKedisiplinan_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 273, -1, -1));

        txtKedisiplinan_BOB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtKedisiplinan_BOB.setBorder(null);
        conBobot.add(txtKedisiplinan_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 273, 317, 35));

        lPerilaku_BOB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lPerilaku_BOB.setForeground(new java.awt.Color(41, 59, 95));
        lPerilaku_BOB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lPerilaku_BOB.setText("Perilaku");
        conBobot.add(lPerilaku_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 163, 92, 35));

        otPerilaku_BOB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 331x35.png"))); // NOI18N
        conBobot.add(otPerilaku_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 163, -1, -1));

        txtPerilaku_BOB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtPerilaku_BOB.setBorder(null);
        conBobot.add(txtPerilaku_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 163, 317, 35));

        lKinerja_BOB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lKinerja_BOB.setForeground(new java.awt.Color(41, 59, 95));
        lKinerja_BOB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lKinerja_BOB.setText("Kinerja");
        conBobot.add(lKinerja_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 218, 92, 35));

        otKinerja_BOB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/outline 331x35.png"))); // NOI18N
        conBobot.add(otKinerja_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(712, 218, -1, -1));

        txtKinerja_BOB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        txtKinerja_BOB.setBorder(null);
        conBobot.add(txtKinerja_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(719, 218, 317, 35));

        line4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/line.png"))); // NOI18N
        conBobot.add(line4, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 328, -1, -1));

        bTambah_BOB.setBackground(new java.awt.Color(29, 160, 42));
        bTambah_BOB.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 28)); // NOI18N
        bTambah_BOB.setForeground(new java.awt.Color(255, 255, 255));
        bTambah_BOB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Tambah-icon.png"))); // NOI18N
        bTambah_BOB.setText("  Tambah");
        bTambah_BOB.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bTambah_BOB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bTambah_BOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambah_BOBActionPerformed(evt);
            }
        });
        conBobot.add(bTambah_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 346, 482, 54));

        bBatal_BOB.setBackground(new java.awt.Color(204, 204, 204));
        bBatal_BOB.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 28)); // NOI18N
        bBatal_BOB.setForeground(new java.awt.Color(96, 96, 96));
        bBatal_BOB.setText("Batal");
        bBatal_BOB.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(96, 96, 96), 3, true));
        bBatal_BOB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bBatal_BOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatal_BOBActionPerformed(evt);
            }
        });
        conBobot.add(bBatal_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 349, 486, 49));

        bg_FormBobot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-formAdmin.png"))); // NOI18N
        conBobot.add(bg_FormBobot, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        lTabelBobot.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 38)); // NOI18N
        lTabelBobot.setForeground(new java.awt.Color(255, 255, 255));
        lTabelBobot.setText("Tabel Bobot");
        conBobot.add(lTabelBobot, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 439, -1, -1));

        IconCari_BOB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/cari-icon-blue.png"))); // NOI18N
        conBobot.add(IconCari_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 448, -1, -1));

        lCari_BOB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        lCari_BOB.setForeground(new java.awt.Color(183, 183, 183));
        lCari_BOB.setText("Cari");
        lCari_BOB.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        conBobot.add(lCari_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 439, 228, 46));

        txtCari_BOB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 23)); // NOI18N
        txtCari_BOB.setForeground(new java.awt.Color(183, 183, 183));
        txtCari_BOB.setBorder(null);
        txtCari_BOB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCari_BOBFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCari_BOBFocusLost(evt);
            }
        });
        txtCari_BOB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCari_BOBKeyTyped(evt);
            }
        });
        conBobot.add(txtCari_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(809, 439, 228, 46));

        bgCari_BOB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bg-cari.png"))); // NOI18N
        conBobot.add(bgCari_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(755, 439, -1, -1));

        tbBobot.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane_BOB.setViewportView(tbBobot);

        conBobot.add(jScrollPane_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 508, 1028, 124));

        bCetak_BOB.setBackground(new java.awt.Color(203, 115, 12));
        bCetak_BOB.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 20)); // NOI18N
        bCetak_BOB.setForeground(new java.awt.Color(255, 255, 255));
        bCetak_BOB.setText("Cetak Laporan");
        bCetak_BOB.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bCetak_BOB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bCetak_BOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCetak_BOBActionPerformed(evt);
            }
        });
        conBobot.add(bCetak_BOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(799, 643, 259, 54));

        pContent.add(conBobot, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 0, 1088, 708));

        getContentPane().add(pContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 60, 1092, 708));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKeluarMouseClicked
        new Login.login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnKeluarMouseClicked

    private void txtCari_ADMFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCari_ADMFocusGained
        lCari_ADM.setVisible(false);
        if(txtCari_ADM.getText().equals("")){
            txtCari_ADM.setText("");
            txtCari_ADM.setForeground(new Color(71,89,126));
        }
    }//GEN-LAST:event_txtCari_ADMFocusGained

    private void txtCari_ADMFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCari_ADMFocusLost
        if(txtCari_ADM.getText().equals("")){
            txtCari_ADM.setText("");
            txtCari_ADM.setForeground(new Color(183,183,183));
            lCari_ADM.setVisible(true);
        }
    }//GEN-LAST:event_txtCari_ADMFocusLost

    private void mDasborMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mDasborMouseClicked
        menuDasbor();
    }//GEN-LAST:event_mDasborMouseClicked

    private void mAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mAdminMouseClicked
        menuAdmin();
    }//GEN-LAST:event_mAdminMouseClicked

    private void mKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mKaryawanMouseClicked
        menuKaryawan();
    }//GEN-LAST:event_mKaryawanMouseClicked

    private void mPresensiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mPresensiMouseClicked
        menuPresensi();
    }//GEN-LAST:event_mPresensiMouseClicked

    private void mBobotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mBobotMouseClicked
        menuBobot();
    }//GEN-LAST:event_mBobotMouseClicked

    private void mKriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mKriteriaMouseClicked
        menuKriteria();
    }//GEN-LAST:event_mKriteriaMouseClicked

    private void mHitungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mHitungMouseClicked
        menuHitung();
    }//GEN-LAST:event_mHitungMouseClicked

    private void bTambah_ADMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambah_ADMActionPerformed
        dt_Admin.CreateData(txtUsername_ADM.getText(), txtNama_ADM.getText(), txtEmail_ADM.getText(), txtTelp_ADM.getText(), txtAlamat_ADM.getText(), txtPassword_ADM.getText());
        tabelAdmin();
        kosonginAdmin();
    }//GEN-LAST:event_bTambah_ADMActionPerformed

    private void bBatal_ADMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatal_ADMActionPerformed
        kosonginAdmin();
    }//GEN-LAST:event_bBatal_ADMActionPerformed

    private void txtCari_ADMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCari_ADMKeyTyped
        tabelAdmin();
    }//GEN-LAST:event_txtCari_ADMKeyTyped

    private void bTambah_KARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambah_KARActionPerformed
        String Tgl_Lahir = Date.format(cbTglLahir_KAR.getDate());
        dt_Karyawan.CreateData(txtNIK_KAR.getText(), txtNama_KAR.getText(), txtEmail_KAR.getText(), txtTelp_KAR.getText(), txtAlamat_KAR.getText(), txtTempatLahir_KAR.getText(), Tgl_Lahir, (String)cbJK_KAR.getSelectedItem(), (String)cbJabatan_KAR.getSelectedItem());
        tabelKaryawan();
        kosonginKaryawan();
    }//GEN-LAST:event_bTambah_KARActionPerformed

    private void bUbah_KARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbah_KARActionPerformed
        String Tgl_Lahir = Date.format(cbTglLahir_KAR.getDate());
        dt_Karyawan.UpdateData(txtNIK_KAR.getText(), txtNama_KAR.getText(), txtEmail_KAR.getText(), txtTelp_KAR.getText(), txtAlamat_KAR.getText(), txtTempatLahir_KAR.getText(), Tgl_Lahir, (String)cbJK_KAR.getSelectedItem(), (String)cbJabatan_KAR.getSelectedItem());
        tabelKaryawan();
        kosonginKaryawan();
        txtNIK_KAR.setEnabled(true);
        bTambah_KAR.setEnabled(true);
    }//GEN-LAST:event_bUbah_KARActionPerformed

    private void bHapus_KARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapus_KARActionPerformed
        dt_Karyawan.DeleteData(txtNIK_KAR.getText());
        tabelKaryawan();
        kosonginKaryawan();
        txtNIK_KAR.setEnabled(true);
        bTambah_KAR.setEnabled(true);
    }//GEN-LAST:event_bHapus_KARActionPerformed

    private void bBatal_KARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatal_KARActionPerformed
        kosonginKaryawan();
        txtNIK_KAR.enable();
        bTambah_KAR.setEnabled(true);
    }//GEN-LAST:event_bBatal_KARActionPerformed

    private void txtCari_KARFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCari_KARFocusGained
        lCari_KAR.setVisible(false);
        if(txtCari_KAR.getText().equals("")){
            txtCari_KAR.setText("");
            txtCari_KAR.setForeground(new Color(71,89,126));
        }
    }//GEN-LAST:event_txtCari_KARFocusGained

    private void txtCari_KARFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCari_KARFocusLost
        if(txtCari_KAR.getText().equals("")){
            txtCari_KAR.setText("");
            txtCari_KAR.setForeground(new Color(183,183,183));
            lCari_KAR.setVisible(true);
        }
    }//GEN-LAST:event_txtCari_KARFocusLost

    private void txtCari_KARKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCari_KARKeyTyped
        tabelKaryawan();
    }//GEN-LAST:event_txtCari_KARKeyTyped

    private void bCetak_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCetak_karyawanActionPerformed
        try{
            BufferedImage image = ImageIO.read(getClass().getResource("/Gambar/logo-fins.jpg"));
            HashMap par = new HashMap();
            Locale locale = new Locale( "id", "ID" );
            par.put(JRParameter.REPORT_LOCALE, locale);
            par.put("Logo", image);
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/Laporan/karyawan.jasper"), par, conn);
            JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_bCetak_karyawanActionPerformed

    private void tbKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKaryawanMouseClicked
        int brs = tbKaryawan.getSelectedRow();
        String a = tbKaryawan.getValueAt(brs, 0).toString();
        String b = tbKaryawan.getValueAt(brs, 1).toString();
        String c = tbKaryawan.getValueAt(brs, 2).toString();
        String d = tbKaryawan.getValueAt(brs, 3).toString();
        String e = tbKaryawan.getValueAt(brs, 4).toString();
        String f = tbKaryawan.getValueAt(brs, 5).toString();
        ambil = java.sql.Date.valueOf(tbKaryawan.getValueAt(brs, 6).toString());
        String g = tbKaryawan.getValueAt(brs, 7).toString();
        String h = tbKaryawan.getValueAt(brs, 8).toString();
        txtNIK_KAR.setText(a);
        txtNama_KAR.setText(b);
        txtEmail_KAR.setText(c);
        txtTelp_KAR.setText(d);
        txtAlamat_KAR.setText(e);
        txtTempatLahir_KAR.setText(f);
        cbTglLahir_KAR.setDate(ambil);
        cbJK_KAR.setSelectedItem(g);
        cbJabatan_KAR.setSelectedItem(h);
        txtNIK_KAR.setEnabled(false);
        bTambah_KAR.setEnabled(false);
    }//GEN-LAST:event_tbKaryawanMouseClicked

    private void bTambah_PREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambah_PREActionPerformed
        String TglHadir = Date.format(cbTglPresensi_PRE.getDate());
        Data.dt_Presensi.CreateData(txtIdpresensi_PRE.getText(), txtNIK_PRE.getText(), TglHadir, (String)cbKehadiran_PRE.getSelectedItem(), txtKeterangan_PRE.getText());
        tabelPresensi();
        kosonginPresensi();
        IdPresensi();
    }//GEN-LAST:event_bTambah_PREActionPerformed

    private void bUbah_PREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbah_PREActionPerformed
        String TglHadir = Date.format(cbTglPresensi_PRE.getDate());
        Data.dt_Presensi.UpdateData(txtIdpresensi_PRE.getText(), txtNIK_PRE.getText(), TglHadir, (String)cbKehadiran_PRE.getSelectedItem(), txtKeterangan_PRE.getText());
        tabelPresensi();
        kosonginPresensi();
        IdPresensi();
        bTambah_PRE.setEnabled(true);
    }//GEN-LAST:event_bUbah_PREActionPerformed

    private void bHapus_PREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapus_PREActionPerformed
        dt_Presensi.DeleteData(txtIdpresensi_PRE.getText(), txtNIK_PRE.getText());
        tabelPresensi();
        kosonginPresensi();
        txtNIK_PRE.setEnabled(true);
        bTambah_PRE.setEnabled(true);
    }//GEN-LAST:event_bHapus_PREActionPerformed

    private void bBatal_PREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatal_PREActionPerformed
        tabelPresensi();
        kosonginPresensi();
        IdPresensi();
        bTambah_PRE.setEnabled(true);
    }//GEN-LAST:event_bBatal_PREActionPerformed

    private void txtCari_PREFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCari_PREFocusGained
        lCari_PRE.setVisible(false);
        if(txtCari_PRE.getText().equals("")){
            txtCari_PRE.setText("");
            txtCari_PRE.setForeground(new Color(71,89,126));
        }
    }//GEN-LAST:event_txtCari_PREFocusGained

    private void txtCari_PREFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCari_PREFocusLost
        if(txtCari_PRE.getText().equals("")){
            txtCari_PRE.setText("");
            txtCari_PRE.setForeground(new Color(183,183,183));
            lCari_PRE.setVisible(true);
        }
    }//GEN-LAST:event_txtCari_PREFocusLost

    private void txtCari_PREKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCari_PREKeyTyped
        tabelPresensi();
    }//GEN-LAST:event_txtCari_PREKeyTyped

    private void tbPresensiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPresensiMouseClicked
        int brs = tbPresensi.getSelectedRow();
        String a = tbPresensi.getValueAt(brs, 0).toString();
        String b = tbPresensi.getValueAt(brs, 1).toString();
        ambil = java.sql.Date.valueOf(tbPresensi.getValueAt(brs, 2).toString());
        String c = tbPresensi.getValueAt(brs, 3).toString();
        String d = tbPresensi.getValueAt(brs, 4).toString();
        txtIdpresensi_PRE.setText(a);
        txtNIK_PRE.setText(b);
        cbTglPresensi_PRE.setDate(ambil);
        cbKehadiran_PRE.setSelectedItem(c);
        txtKeterangan_PRE.setText(d);
        bTambah_PRE.setEnabled(false);
    }//GEN-LAST:event_tbPresensiMouseClicked

    private void txtCari_BOBFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCari_BOBFocusGained
        lCari_BOB.setVisible(false);
        if(txtCari_BOB.getText().equals("")){
            txtCari_BOB.setText("");
            txtCari_BOB.setForeground(new Color(71,89,126));
        }
    }//GEN-LAST:event_txtCari_BOBFocusGained

    private void txtCari_BOBFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCari_BOBFocusLost
        if(txtCari_BOB.getText().equals("")){
            txtCari_BOB.setText("");
            txtCari_BOB.setForeground(new Color(183,183,183));
            lCari_BOB.setVisible(true);
        }
    }//GEN-LAST:event_txtCari_BOBFocusLost

    private void txtCari_BOBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCari_BOBKeyTyped
        tabelBobot();
    }//GEN-LAST:event_txtCari_BOBKeyTyped

    private void bCariKaryawan_PREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariKaryawan_PREActionPerformed
        popupPresensiKaryawan objekS = new popupPresensiKaryawan();
        objekS.Presensi = this;
        objekS.setVisible(true);
        objekS.setResizable(false);
    }//GEN-LAST:event_bCariKaryawan_PREActionPerformed

    private void bTambah_KRIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambah_KRIActionPerformed
        float perilaku = 0;
        if(cbPerilaku_KRI.getSelectedItem().equals("Sangat Baik")){
            perilaku = 100;
        }
        else if(cbPerilaku_KRI.getSelectedItem().equals("Baik")){
            perilaku = 80;
        }
        else if(cbPerilaku_KRI.getSelectedItem().equals("Cukup")){
            perilaku = 60;
        }
        else if(cbPerilaku_KRI.getSelectedItem().equals("Kurang")){
            perilaku = 40;
        }
        float Kinerja = 0;
        if(cbKinerja_KRI.getSelectedItem().equals("Sangat Baik")){
            Kinerja = 100;
        }
        else if(cbKinerja_KRI.getSelectedItem().equals("Baik")){
            Kinerja = 80;
        }
        else if(cbKinerja_KRI.getSelectedItem().equals("Cukup")){
            Kinerja = 60;
        }
        else if(cbKinerja_KRI.getSelectedItem().equals("Kurang")){
            Kinerja = 40;
        }
        dt_Kriteria.CreateData(txtIdkriteria_KRI.getText(), txtNIK_KRI.getText(), txtIdpresensi_KRI.getText(), Float.parseFloat(txtLoyalitas_KRI.getText()), Float.parseFloat(txtKehadiran_KRI.getText()), Float.parseFloat(txtKedisiplinan_KRI.getText()), perilaku, Kinerja);
        tabelKriteria();
        kosonginKriteria();
        IdKriteria();
    }//GEN-LAST:event_bTambah_KRIActionPerformed

    private void bUbah_KRIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbah_KRIActionPerformed
        float perilaku = 0;
        if(cbPerilaku_KRI.getSelectedItem().equals("Sangat Baik")){
            perilaku = 100;
        }
        else if(cbPerilaku_KRI.getSelectedItem().equals("Baik")){
            perilaku = 80;
        }
        else if(cbPerilaku_KRI.getSelectedItem().equals("Cukup")){
            perilaku = 60;
        }
        else if(cbPerilaku_KRI.getSelectedItem().equals("Kurang")){
            perilaku = 40;
        }
        float Kinerja = 0;
        if(cbKinerja_KRI.getSelectedItem().equals("Sangat Baik")){
            Kinerja = 100;
        }
        else if(cbKinerja_KRI.getSelectedItem().equals("Baik")){
            Kinerja = 80;
        }
        else if(cbKinerja_KRI.getSelectedItem().equals("Cukup")){
            Kinerja = 60;
        }
        else if(cbKinerja_KRI.getSelectedItem().equals("Kurang")){
            Kinerja = 40;
        }
        dt_Kriteria.UpdateData(txtIdkriteria_KRI.getText(),txtNIK_KRI.getText(), txtIdpresensi_KRI.getText(), Float.parseFloat(txtLoyalitas_KRI.getText()), Float.parseFloat(txtKehadiran_KRI.getText()), Float.parseFloat(txtKedisiplinan_KRI.getText()), perilaku, Kinerja);
        tabelKriteria();
        bTambah_KRI.setEnabled(true);
        bCariKaryawan_KRI.setEnabled(true);
        kosonginKriteria();
    }//GEN-LAST:event_bUbah_KRIActionPerformed

    private void bHapus_KRIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapus_KRIActionPerformed
        dt_Kriteria.DeleteData(txtIdkriteria_KRI.getText(), txtNIK_KRI.getText());
        tabelKriteria();
        kosonginKriteria();
        bTambah_KRI.setEnabled(true);
        bCariKaryawan_KRI.setEnabled(true);
    }//GEN-LAST:event_bHapus_KRIActionPerformed

    private void bBatal_KRIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatal_KRIActionPerformed
        kosonginKriteria();
        bTambah_KRI.setEnabled(true);
        bCariKaryawan_KRI.setEnabled(true);
    }//GEN-LAST:event_bBatal_KRIActionPerformed

    private void txtCari_KRIFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCari_KRIFocusGained
        lCari_KRI.setVisible(false);
        if(txtCari_KRI.getText().equals("")){
            txtCari_KRI.setText("");
            txtCari_KRI.setForeground(new Color(71,89,126));
        }
    }//GEN-LAST:event_txtCari_KRIFocusGained

    private void txtCari_KRIFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCari_KRIFocusLost
        if(txtCari_KRI.getText().equals("")){
            txtCari_KRI.setText("");
            txtCari_KRI.setForeground(new Color(183,183,183));
            lCari_KRI.setVisible(true);
        }
    }//GEN-LAST:event_txtCari_KRIFocusLost

    private void txtCari_KRIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCari_KRIKeyTyped
        tabelKriteria();
    }//GEN-LAST:event_txtCari_KRIKeyTyped

    private void tbKriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKriteriaMouseClicked
        int brs = tbKriteria.getSelectedRow();
        String a = tbKriteria.getValueAt(brs, 0).toString();
        String b = tbKriteria.getValueAt(brs, 1).toString();
        String c = tbKriteria.getValueAt(brs, 2).toString();
        String d = tbKriteria.getValueAt(brs, 3).toString();
        String e = tbKriteria.getValueAt(brs, 4).toString();
        String f = tbKriteria.getValueAt(brs, 5).toString();
        double perilaku = Double.parseDouble(tbKriteria.getValueAt(brs, 6).toString());
        double kinerja = Double.parseDouble(tbKriteria.getValueAt(brs, 7).toString());
        if(perilaku == 100.0){
            cbPerilaku_KRI.setSelectedItem("Sangat Baik");
        }
        else if(perilaku == 80.0){
            cbPerilaku_KRI.setSelectedItem("Baik");
        }
        else if(perilaku == 60.0){
            cbPerilaku_KRI.setSelectedItem("Cukup");
        }
        else if(perilaku == 40.0){
            cbPerilaku_KRI.setSelectedItem("Kurang");
        }
        if(kinerja == 100.0){
            cbKinerja_KRI.setSelectedItem("Sangat Baik");
        }
        else if(kinerja == 80.0){
            cbKinerja_KRI.setSelectedItem("Baik");
        }
        else if(kinerja == 60.0){
            cbKinerja_KRI.setSelectedItem("Cukup");
        }
        else if(kinerja == 40.0){
            cbKinerja_KRI.setSelectedItem("Kurang");
        }
        txtIdkriteria_KRI.setText(a);
        txtNIK_KRI.setText(b);
        txtIdpresensi_KRI.setText(c);
        txtLoyalitas_KRI.setText(d);
        txtKehadiran_KRI.setText(e);
        txtKedisiplinan_KRI.setText(f);
        bTambah_KRI.setEnabled(false);
        bCariKaryawan_KRI.setEnabled(false);
    }//GEN-LAST:event_tbKriteriaMouseClicked

    private void bCariKaryawan_KRIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariKaryawan_KRIActionPerformed
        popupKriteriaKaryawan objek = new popupKriteriaKaryawan();
        objek.Kriteria = this;
        objek.setVisible(true);
        objek.setResizable(false);
    }//GEN-LAST:event_bCariKaryawan_KRIActionPerformed

    private void bTambah_BOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambah_BOBActionPerformed
        dt_Bobot.CreateData(txtIdbobot_BOB.getText(), Float.parseFloat(txtLoyalitas_BOB.getText()), Float.parseFloat(txtKehadiran_BOB.getText()), Float.parseFloat(txtKedisiplinan_BOB.getText()), Float.parseFloat(txtPerilaku_BOB.getText()), Float.parseFloat(txtKinerja_BOB.getText()));
        tabelBobot();
        kosonginBobot();
        IdBobot();
        getidbobot();
    }//GEN-LAST:event_bTambah_BOBActionPerformed

    private void bBatal_BOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatal_BOBActionPerformed
        kosonginBobot();
    }//GEN-LAST:event_bBatal_BOBActionPerformed

    private void bHitungN_HITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHitungN_HITActionPerformed
        tabelNormalisasi_HIT();
        bHitungP_HIT.setEnabled(true);
    }//GEN-LAST:event_bHitungN_HITActionPerformed

    private void bHitungP_HITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHitungP_HITActionPerformed
        hasilAkhir();
        try{
            BufferedImage image = ImageIO.read(getClass().getResource("/Gambar/logo-fins.jpg"));
            HashMap par = new HashMap();
            Locale locale = new Locale( "id", "ID" );
            par.put(JRParameter.REPORT_LOCALE, locale);
            par.put("Logo", image);
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/Laporan/Sertifikat.jasper"), par, conn);
            JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
//        bCetakLaporan_HIT.setEnabled(true);
        lValueNilaiTertinggi.setVisible(true);
        
    }//GEN-LAST:event_bHitungP_HITActionPerformed

    private void bCetak_PREActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCetak_PREActionPerformed
        try{
            BufferedImage image = ImageIO.read(getClass().getResource("/Gambar/logo-fins.jpg"));
            HashMap par = new HashMap();
            Locale locale = new Locale( "id", "ID" );
            par.put(JRParameter.REPORT_LOCALE, locale);
            par.put("Logo", image);
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/Laporan/presensi.jasper"), par, conn);
            JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_bCetak_PREActionPerformed

    private void bCetak_BOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCetak_BOBActionPerformed
         try{
            BufferedImage image = ImageIO.read(getClass().getResource("/Gambar/logo-fins.jpg"));
            HashMap par = new HashMap();
            Locale locale = new Locale( "id", "ID" );
            par.put(JRParameter.REPORT_LOCALE, locale);
            par.put("Logo", image);
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/Laporan/bobot.jasper"), par, conn);
            JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_bCetak_BOBActionPerformed

    private void bCetak_KRIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCetak_KRIActionPerformed
         try{
            BufferedImage image = ImageIO.read(getClass().getResource("/Gambar/logo-fins.jpg"));
            HashMap par = new HashMap();
            Locale locale = new Locale( "id", "ID" );
            par.put(JRParameter.REPORT_LOCALE, locale);
            par.put("Logo", image);
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/Laporan/kriteria.jasper"), par, conn);
            JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_bCetak_KRIActionPerformed

    private void bCetakLaporan_HITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCetakLaporan_HITActionPerformed
        try{
            BufferedImage image = ImageIO.read(getClass().getResource("/Gambar/logo-fins.jpg"));
            HashMap par = new HashMap();
            Locale locale = new Locale( "id", "ID" );
            par.put(JRParameter.REPORT_LOCALE, locale);
            par.put("Logo", image);
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/Laporan/hasil.jasper"), par, conn);
            JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_bCetakLaporan_HITActionPerformed

    public void colorAktif(JLabel l){
        l.setForeground(new Color(255,255,255));
    }
    
    public void colorNoAktif(JLabel l){
        l.setForeground(new Color(41,59,95));
    }
    
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
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dashbor;
    private javax.swing.JLabel IconCari_ADM;
    private javax.swing.JLabel IconCari_BOB;
    private javax.swing.JLabel IconCari_KAR;
    private javax.swing.JLabel IconCari_KRI;
    private javax.swing.JLabel IconCari_PRE;
    private javax.swing.JLabel Shadow;
    private javax.swing.JButton bBatal_ADM;
    private javax.swing.JButton bBatal_BOB;
    private javax.swing.JButton bBatal_KAR;
    private javax.swing.JButton bBatal_KRI;
    private javax.swing.JButton bBatal_PRE;
    private javax.swing.JButton bCariKaryawan_KRI;
    private javax.swing.JButton bCariKaryawan_PRE;
    private javax.swing.JButton bCetakLaporan_HIT;
    private javax.swing.JButton bCetak_BOB;
    private javax.swing.JButton bCetak_KRI;
    private javax.swing.JButton bCetak_PRE;
    private javax.swing.JButton bCetak_karyawan;
    private javax.swing.JButton bHapus_KAR;
    private javax.swing.JButton bHapus_KRI;
    private javax.swing.JButton bHapus_PRE;
    private javax.swing.JButton bHitungN_HIT;
    private javax.swing.JButton bHitungP_HIT;
    private javax.swing.JButton bTambah_ADM;
    private javax.swing.JButton bTambah_BOB;
    private javax.swing.JButton bTambah_KAR;
    private javax.swing.JButton bTambah_KRI;
    private javax.swing.JButton bTambah_PRE;
    private javax.swing.JButton bUbah_KAR;
    private javax.swing.JButton bUbah_KRI;
    private javax.swing.JButton bUbah_PRE;
    private javax.swing.JLabel bgCari_ADM;
    private javax.swing.JLabel bgCari_BOB;
    private javax.swing.JLabel bgCari_KAR;
    private javax.swing.JLabel bgCari_KRI;
    private javax.swing.JLabel bgCari_PRE;
    private javax.swing.JLabel bg_FormAdmin;
    private javax.swing.JLabel bg_FormBobot;
    private javax.swing.JLabel bg_FormHitung;
    private javax.swing.JLabel bg_FormKaryawan;
    private javax.swing.JLabel bg_FormKriteria;
    private javax.swing.JLabel bg_FormPresensi;
    private javax.swing.JLabel bg_admin;
    private javax.swing.JLabel bg_bobot;
    private javax.swing.JLabel bg_dasbor;
    private javax.swing.JLabel bg_hitung;
    private javax.swing.JLabel bg_karyawan;
    private javax.swing.JLabel bg_kriteria;
    private javax.swing.JLabel bg_presensi;
    private javax.swing.JLabel btnKeluar;
    private javax.swing.JComboBox<String> cbJK_KAR;
    private javax.swing.JComboBox<String> cbJabatan_KAR;
    private javax.swing.JComboBox<String> cbKehadiran_PRE;
    private javax.swing.JComboBox<String> cbKinerja_KRI;
    private javax.swing.JComboBox<String> cbPerilaku_KRI;
    private com.toedter.calendar.JDateChooser cbTglLahir_KAR;
    private com.toedter.calendar.JDateChooser cbTglPresensi_PRE;
    private javax.swing.JPanel conAdmin;
    private javax.swing.JPanel conBobot;
    private javax.swing.JPanel conDasbor;
    private javax.swing.JPanel conHitung;
    private javax.swing.JPanel conKaryawan;
    private javax.swing.JPanel conKriteria;
    private javax.swing.JPanel conPresensi;
    private javax.swing.JLabel dashboardkonten;
    private javax.swing.JLabel icFav;
    private javax.swing.JLabel icProfil;
    private javax.swing.JLabel ic_admin_b;
    private javax.swing.JLabel ic_admin_w;
    private javax.swing.JLabel ic_bobot_b;
    private javax.swing.JLabel ic_bobot_w;
    private javax.swing.JLabel ic_dasbor_b;
    private javax.swing.JLabel ic_dasbor_w;
    private javax.swing.JLabel ic_hitung_b;
    private javax.swing.JLabel ic_hitung_w;
    private javax.swing.JLabel ic_karyawan_b;
    private javax.swing.JLabel ic_karyawan_w;
    private javax.swing.JLabel ic_kriteria_b;
    private javax.swing.JLabel ic_kriteria_w;
    private javax.swing.JLabel ic_presensi_b;
    private javax.swing.JLabel ic_presensi_w;
    private javax.swing.JScrollPane jScrollPane_ADM;
    private javax.swing.JScrollPane jScrollPane_ADM2;
    private javax.swing.JScrollPane jScrollPane_BOB;
    private javax.swing.JScrollPane jScrollPane_HIT;
    private javax.swing.JScrollPane jScrollPane_HIT2;
    private javax.swing.JScrollPane jScrollPane_HIT3;
    private javax.swing.JScrollPane jScrollPane_HIT4;
    private javax.swing.JScrollPane jScrollPane_KAR;
    private javax.swing.JScrollPane jScrollPane_KAR2;
    private javax.swing.JScrollPane jScrollPane_KRI;
    private javax.swing.JScrollPane jScrollPane_PRE;
    private javax.swing.JLabel lAdmin;
    private javax.swing.JLabel lAlamat_ADM;
    private javax.swing.JLabel lAlamat_KAR;
    private javax.swing.JLabel lBobot;
    private javax.swing.JLabel lCari_ADM;
    private javax.swing.JLabel lCari_BOB;
    private javax.swing.JLabel lCari_KAR;
    private javax.swing.JLabel lCari_KRI;
    private javax.swing.JLabel lCari_PRE;
    private javax.swing.JLabel lDasbor;
    private javax.swing.JLabel lDataKaryawan_HIT;
    private javax.swing.JLabel lDataKriteria_HIT;
    private javax.swing.JLabel lEmail_ADM;
    private javax.swing.JLabel lEmail_KAR;
    private javax.swing.JLabel lFormAdmin;
    private javax.swing.JLabel lFormBobot;
    private javax.swing.JLabel lFormHitung;
    private javax.swing.JLabel lFormKaryawan;
    private javax.swing.JLabel lFormKriteria;
    private javax.swing.JLabel lFormPresensi;
    private javax.swing.JLabel lHitung;
    private javax.swing.JLabel lIdKehadiran_KRI;
    private javax.swing.JLabel lIdbobot_BOB;
    private javax.swing.JLabel lIdbobot_HIT;
    private javax.swing.JLabel lIdkriteria_KRI;
    private javax.swing.JLabel lIdpresensi_KRI;
    private javax.swing.JLabel lIdpresensi_PRE;
    private javax.swing.JLabel lJabatan_KAR;
    private javax.swing.JLabel lJenkel_KAR;
    private javax.swing.JLabel lKaryawan;
    private javax.swing.JLabel lKedisiplinan_BOB;
    private javax.swing.JLabel lKedisiplinan_KRI;
    private javax.swing.JLabel lKehadiran_BOB;
    private javax.swing.JLabel lKehadiran_PRE;
    private javax.swing.JLabel lKeterangan_PRE;
    private javax.swing.JLabel lKinerja_BOB;
    private javax.swing.JLabel lKinerja_KRI;
    private javax.swing.JLabel lKriteria;
    private javax.swing.JLabel lLoyalitas_BOB;
    private javax.swing.JLabel lLoyalitas_KRI;
    private javax.swing.JLabel lNIK_KAR;
    private javax.swing.JLabel lNIK_KRI;
    private javax.swing.JLabel lNIK_PRE;
    private javax.swing.JLabel lNama;
    private javax.swing.JLabel lNama_ADM;
    private javax.swing.JLabel lNama_KAR;
    private javax.swing.JLabel lNormalisasi_HIT;
    private javax.swing.JLabel lPassword_ADM;
    private javax.swing.JLabel lPerilaku_BOB;
    private javax.swing.JLabel lPerilaku_KRI;
    private javax.swing.JLabel lPeringkat_HIT;
    private javax.swing.JLabel lPresensi;
    private javax.swing.JLabel lTabelAdmin;
    private javax.swing.JLabel lTabelBobot;
    private javax.swing.JLabel lTabelKaryawan;
    private javax.swing.JLabel lTabelKriteria;
    private javax.swing.JLabel lTabelPresensi;
    private javax.swing.JLabel lTanggal_PRE;
    private javax.swing.JLabel lTelp_ADM;
    private javax.swing.JLabel lTelp_KAR;
    private javax.swing.JLabel lTempatLahir_KAR;
    private javax.swing.JLabel lTglLahir_KAR;
    private javax.swing.JLabel lUsername;
    private javax.swing.JLabel lUsername_ADM;
    private javax.swing.JLabel lValueDataKaryawan;
    private javax.swing.JLabel lValueDataKriteria;
    private javax.swing.JLabel lValueNilaiTertinggi;
    private javax.swing.JLabel line1;
    private javax.swing.JLabel line2;
    private javax.swing.JLabel line3;
    private javax.swing.JLabel line4;
    private javax.swing.JLabel line5;
    private javax.swing.JPanel mAdmin;
    private javax.swing.JPanel mBobot;
    private javax.swing.JPanel mDasbor;
    private javax.swing.JPanel mHitung;
    private javax.swing.JPanel mKaryawan;
    private javax.swing.JPanel mKriteria;
    private javax.swing.JPanel mPresensi;
    private javax.swing.JLabel otAlamat_KAR;
    private javax.swing.JLabel otEmail_ADM;
    private javax.swing.JLabel otEmail_ADM1;
    private javax.swing.JLabel otEmail_KAR;
    private javax.swing.JLabel otIdKehadiran_KRI;
    private javax.swing.JLabel otIdbobot;
    private javax.swing.JLabel otIdbobot_BOB;
    private javax.swing.JLabel otIdkriteria_KRI;
    private javax.swing.JLabel otIdpresensi_KRI;
    private javax.swing.JLabel otIdpresensi_PRE;
    private javax.swing.JLabel otJabatan_KAR;
    private javax.swing.JLabel otJenkel_KAR;
    private javax.swing.JLabel otKedisiplinan_BOB;
    private javax.swing.JLabel otKedisiplinan_KRI;
    private javax.swing.JLabel otKehadiran_BOB;
    private javax.swing.JLabel otKehadiran_PRE;
    private javax.swing.JLabel otKeterangan_PRE;
    private javax.swing.JLabel otKinerja_BOB;
    private javax.swing.JLabel otKinerja_KRI;
    private javax.swing.JLabel otLoyalitas_BOB;
    private javax.swing.JLabel otLoyalitas_KRI;
    private javax.swing.JLabel otNIK_KAR;
    private javax.swing.JLabel otNIK_KRI;
    private javax.swing.JLabel otNIK_PRE;
    private javax.swing.JLabel otNama_ADM;
    private javax.swing.JLabel otNama_KAR;
    private javax.swing.JLabel otPerilaku_BOB;
    private javax.swing.JLabel otPerilaku_KRI;
    private javax.swing.JLabel otTanggal_PRE;
    private javax.swing.JLabel otTelp_ADM;
    private javax.swing.JLabel otTelp_KAR;
    private javax.swing.JLabel otTempatLahir_KAR;
    private javax.swing.JLabel otTglLahir_KAR;
    private javax.swing.JLabel otUsername_ADM;
    private javax.swing.JLabel otUsername_ADM1;
    private javax.swing.JPanel pContent;
    private javax.swing.JPanel pMenu;
    private javax.swing.JPanel pPerhitungan;
    private javax.swing.JPanel pProfil;
    private javax.swing.JLabel pic;
    private javax.swing.JTable tbAdmin;
    private javax.swing.JTable tbBobot;
    private javax.swing.JTable tbHasilAkhir;
    private javax.swing.JTable tbKaryawan;
    private javax.swing.JTable tbKaryawan_HIT;
    private javax.swing.JTable tbKriteria;
    private javax.swing.JTable tbKriteria_HIT;
    private javax.swing.JTable tbNormalisasi_HIT;
    private javax.swing.JTable tbPresensi;
    private javax.swing.JTextArea txtAlamat_ADM;
    private javax.swing.JTextArea txtAlamat_KAR;
    private javax.swing.JTextField txtCari_ADM;
    private javax.swing.JTextField txtCari_BOB;
    private javax.swing.JTextField txtCari_KAR;
    private javax.swing.JTextField txtCari_KRI;
    private javax.swing.JTextField txtCari_PRE;
    private javax.swing.JTextField txtEmail_ADM;
    private javax.swing.JTextField txtEmail_KAR;
    private javax.swing.JTextField txtIdbobot_BOB;
    private javax.swing.JTextField txtIdkriteria_KRI;
    private javax.swing.JTextField txtIdpresensi_KRI;
    private javax.swing.JTextField txtIdpresensi_PRE;
    private javax.swing.JTextField txtKedisiplinan_BOB;
    private javax.swing.JTextField txtKedisiplinan_KRI;
    private javax.swing.JTextField txtKehadiran_BOB;
    private javax.swing.JTextField txtKehadiran_KRI;
    private javax.swing.JTextField txtKeterangan_PRE;
    private javax.swing.JTextField txtKinerja_BOB;
    private javax.swing.JTextField txtLoyalitas_BOB;
    private javax.swing.JTextField txtLoyalitas_KRI;
    private javax.swing.JTextField txtNIK_KAR;
    private javax.swing.JTextField txtNIK_KRI;
    private javax.swing.JTextField txtNIK_PRE;
    private javax.swing.JTextField txtNama_ADM;
    private javax.swing.JTextField txtNama_KAR;
    private javax.swing.JTextField txtPassword_ADM;
    private javax.swing.JTextField txtPerilaku_BOB;
    private javax.swing.JTextField txtTelp_ADM;
    private javax.swing.JTextField txtTelp_KAR;
    private javax.swing.JTextField txtTempatLahir_KAR;
    private javax.swing.JTextField txtUsername_ADM;
    // End of variables declaration//GEN-END:variables
}
