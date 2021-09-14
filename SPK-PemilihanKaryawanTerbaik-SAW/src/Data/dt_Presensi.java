package Data;
import java.sql.*;
import javax.swing.JOptionPane;
/*
@author Wahyu Hadi
*/
public class dt_Presensi {
    private static Connection conn = new Koneksi.koneksi().configDB();
    public static void CreateData(String ID, String NIK, String Tgl, String Kehadiran, String Keterangan){
        String SQL = "insert into presensi values (?,?,?,?,?)";
        try{
            if(ID.equals("") | NIK.equals("") | Kehadiran.equals("") | Keterangan.equals("")){
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong! \nData Gagal Disimpan");
            }else{                   
                PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, ID);
                State.setString(2, NIK);
                State.setString(3, Tgl);
                State.setString(4, Kehadiran);
                State.setString(5, Keterangan);
                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            } 
        }catch(SQLException wahyu){
            JOptionPane.showMessageDialog(null, "Data gagal Disimpan " +wahyu);
        }
    }
    
    public static void UpdateData(String ID, String NIK, String Tgl, String Kehadiran, String Keterangan){
        String SQL = "update presensi set NIK=?, Tgl=?, Kehadiran=?, Keterangan=? where Id_presensi='"+ID+"'";
        try{
            if(ID.equals("") | NIK.equals("")| Kehadiran.equals("") | Keterangan.equals("")){
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong! \nData Gagal Disimpan");
            }else{ 
                PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, NIK);
                State.setString(2, Tgl);
                State.setString(3, Kehadiran);
                State.setString(4, Keterangan);
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
            String SQL = "DELETE FROM presensi where Id_presensi = '"+ID+"'";
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
