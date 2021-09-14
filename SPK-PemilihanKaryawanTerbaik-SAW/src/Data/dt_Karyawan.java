package Data;
import java.sql.*;
import javax.swing.JOptionPane;
/*
@author Wahyu Hadi
*/
public class dt_Karyawan {
    private static Connection conn = new Koneksi.koneksi().configDB();
    public static void CreateData(String NIK, String Nama, String Email, String NoTelp, String Alamat, String Tempat_Lahir, String Tanggal_Lahir, String Jenkel, String Jabatan){
        String SQL = "INSERT INTO karyawan VALUES (?,?,?,?,?,?,?,?,?)";
        try{
            if(NIK.equals("") | Nama.equals("") | Email.equals("") | NoTelp.equals("") | Alamat.equals("")
               | Tempat_Lahir.equals("") | Tanggal_Lahir.equals(null) | Jenkel.equals("") | Jabatan.equals("")){
               JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong! \nData Gagal Disimpan");
            }else{
                PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, NIK);
                State.setString(2, Nama);
                State.setString(3, Email);
                State.setString(4, NoTelp);
                State.setString(5, Alamat);
                State.setString(6, Tempat_Lahir);
                State.setString(7, Tanggal_Lahir);
                State.setString(8, Jenkel);
                State.setString(9, Jabatan);
                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            }
        }catch(SQLException wahyu){
            JOptionPane.showMessageDialog(null, "Data gagal Disimpan " +wahyu);
        }
    }
    public static void UpdateData(String NIK, String Nama, String Email, String NoTelp, String Alamat, String Tempat_Lahir, String Tanggal_Lahir, String Jenkel, String Jabatan){
        String SQL = "update karyawan set Nama=?, Email=?, No_telp=?, Alamat=?, Tempat_lahir=?, Tgl_lahir=?, Jenkel=?, Jabatan=? where NIK='"+NIK+"'";
        try{
            if(NIK.equals("") | Nama.equals("") | Email.equals("") | NoTelp.equals("") | Alamat.equals("")
               | Tempat_Lahir.equals("") | Tanggal_Lahir.equals(null) | Jenkel.equals("") | Jabatan.equals("")){
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong! \nData Gagal Disimpan");
            }else{
                PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, Nama);
                State.setString(2, Email);
                State.setString(3, NoTelp);
                State.setString(4, Alamat);
                State.setString(5, Tempat_Lahir);
                State.setString(6, Tanggal_Lahir);
                State.setString(7, Jenkel);
                State.setString(8, Jabatan);
                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            }
        }catch(SQLException wahyu){
            JOptionPane.showMessageDialog(null, "Data gagal Diubah " +wahyu);
        }
    }
    public static void DeleteData(String NIK){
        int ok = JOptionPane.showConfirmDialog(null, "Hapus data ini ?","Request Confirmation",JOptionPane.YES_NO_OPTION);
        if(ok==0){
            String SQL = "DELETE FROM karyawan WHERE NIK = '"+NIK+"'";
            try{
                if(NIK.equals("")){
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong! \nData Gagal Dihapus");
                }else{
                    PreparedStatement State = conn.prepareStatement(SQL);
                    State.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Berhasil DiHapus");
                }
            }catch(SQLException wahyu){
                JOptionPane.showMessageDialog(null, "Data gagal DiHapus " +wahyu);
            }
        }
    }
}
