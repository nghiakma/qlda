/*
quangvinh.gulang@gmail.com
 */
package Manager;

import java.sql.*;
import connectDataBase.*;

/**
 *
 * @author quangvinh.gulang@gmail.com
 */
public class CheckDangNhap {
    public static Connection conn = null;
    public static ResultSet rs= null;
    public static PreparedStatement pst= null;
    
    public static String testDangNhap(){
        try {
            conn= ConnectionDB.getConnection();
            return "Kết nối dữ liệu thành công.";
            
        } catch (Exception e) {
            return "Kết nối dữ liệu thất bại.";
        }    
    }
    
    public static ResultSet cLog(String tendangnhap, String matkhau){
        String sql="SELECT * FROM pmqltv.nhanvien WHERE trangthai IS NULL AND"
                + " BINARY tendangnhap=? AND BINARY matkhau=?";
        try{
        pst = conn.prepareStatement(sql);
        pst.setString(1, tendangnhap);
        pst.setString(2, matkhau);
        return rs = pst.executeQuery();
        }
        catch(Exception e)
        {
            return rs = null;
        }
    }
    
}
