package Data;
import java.sql.*;
import javax.swing.JOptionPane;
/*
@author Wahyu Hadi
*/
public class dt_Bobot {
    private static Connection conn = new Koneksi.koneksi().configDB();
    public static void CreateData(String Id, float B1, float B2, float B3, float B4, float B5){
        String SQL = "INSERT INTO bobot VALUES (?,?,?,?,?,?)";
        try{
            if(Id.equals("") | B1==0 | B2==0 | B3==0 | B4==0 | B5==0){
               JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong! \nData Gagal Disimpan");
            }else{
                PreparedStatement State = conn.prepareStatement(SQL);
                State.setString(1, Id);
                State.setFloat(2, B1);
                State.setFloat(3, B2);
                State.setFloat(4, B3);
                State.setFloat(5, B4);
                State.setFloat(6, B5);
                State.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            }
        }catch(SQLException wahyu){
            JOptionPane.showMessageDialog(null, "Data gagal Disimpan " +wahyu);
        }
    }
}
