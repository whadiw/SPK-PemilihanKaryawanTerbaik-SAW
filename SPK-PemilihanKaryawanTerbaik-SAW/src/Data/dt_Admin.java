package Data;
import java.sql.*;
import javax.swing.JOptionPane;
/*
@author Wahyu Hadi
*/
public class dt_Admin {
    private static Connection conn = new Koneksi.koneksi().configDB();
    public static void CreateData(String Username, String Nama, String Email, String NoTelp, String Alamat, String Pass){
        String SQL = "insert into admin values (?,?,?,?,?,?)";
        try{
            if(Username.equals("") | Nama.equals("") | Email.equals("") | NoTelp.equals("") | Alamat.equals("") | Pass.equals("")){
                JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong! \nData Gagal Disimpan");
            }else{   
                PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, Username);
                State.setString(2, Nama);
                State.setString(3, Email);
                State.setString(4, NoTelp);
                State.setString(5, Alamat);
                State.setString(6, Pass);
                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            }
        }catch(SQLException wahyu){
            JOptionPane.showMessageDialog(null, "Data gagal Disimpan " +wahyu);
        }
    }
}
