package Data;
import java.sql.*;
import javax.swing.JOptionPane;
/*
@author Wahyu Hadi
*/
public class dt_Kriteria {
    private static Connection conn = new Koneksi.koneksi().configDB();
    public static void CreateData(String Id, String NIK, String Id_presensi, float C1, float C2, float C3, float C4, float C5){
        String SQL = "INSERT INTO kriteria VALUES (?,?,?,?,?,?,?,?)";
        try{
            if(Id.equals("") | NIK.equals("") | C2==0 | C3==0 | C4==0 | C5==0){
               JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong! \nData Gagal Disimpan");
            }else{
                PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, Id);
                State.setString(2, NIK);
                State.setString(3, Id_presensi);
                State.setFloat(4, C1);
                State.setFloat(5, C2);
                State.setFloat(6, C3);
                State.setFloat(7, C4);
                State.setFloat(8, C5);
                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            }
        }catch(SQLException wahyu){
            JOptionPane.showMessageDialog(null, "Data gagal Disimpan " +wahyu);
        }
    }
    public static void UpdateData(String Id, String NIK, String Nama, float C1, float C2, float C3, float C4, float C5){
        String SQL = "update kriteria set NIK=?, Id_presensi=?, C1=?, C2=?, C3=?, C4=?, C5=? where Id_kriteria='"+Id+"'";
        try{
            if(NIK.equals("") | Nama.equals("") | NIK.equals("") | C2==0 | C3==0 | C4==0 | C5==0){
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong! \nData Gagal Disimpan");
            }else{
                PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, NIK);
                State.setString(2, Nama);
                State.setFloat(3, C1);
                State.setFloat(4, C2);
                State.setFloat(5, C3);
                State.setFloat(6, C4);
                State.setFloat(7, C5);
                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            }
        }catch(SQLException wahyu){
            JOptionPane.showMessageDialog(null, "Data gagal Diubah " +wahyu);
        }
    }
    public static void DeleteData(String ID, String NIK){
        int ok = JOptionPane.showConfirmDialog(null, "Hapus","Request Confirmation",JOptionPane.YES_NO_OPTION);
        if(ok==0){
            String SQL = "DELETE FROM kriteria where Id_kriteria = '"+ID+"'";
            try{
                if(ID.equals("")  | NIK.equals("")){
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong! \nData Gagal Disimpan");
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
