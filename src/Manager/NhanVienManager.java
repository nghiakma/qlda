/*
quangvinh.gulang@gmail.com
 */
package Manager;

import Model.NhanVien;
import connectDataBase.ConnectionDB;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author quangvinh.gulang@gmail.com
 */
public class NhanVienManager {
    Connection conn;
    ArrayList<NhanVien> lstNhanVien= new ArrayList();  
    private PreparedStatement st;
    public NhanVienManager() {
        conn = new ConnectionDB().getConnection();
    }
    
    
     public ArrayList<NhanVien> getAllNhanVien(String search)
     {                           
        try {            
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM pmqltv.nhanvien "
                    + "WHERE manhanvien != 1 AND trangthai IS NULL AND lower(concat(manhanvien,tennhanvien,chucvu)) like lower('%"+search+"%')");            
            ResultSet rs = pst.executeQuery();       
            while(rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNhanVien(rs.getInt("manhanvien"));
                nv.setTenNhanVien(rs.getString("tennhanvien"));
                nv.setChucVu(rs.getString("chucvu"));
                nv.setGioiTinh(rs.getString("gioitinh"));
                nv.setNgaySinh(rs.getString("ngaysinh"));
                nv.setDienThoai(rs.getString("dienthoai")); 
                nv.setEmail(rs.getString("email"));
                nv.setTenDangNhap(rs.getString("tendangnhap"));
                                  
                lstNhanVien.add(nv);              
            }
        } catch (SQLException ex) {
               System.out.println(ex.toString());  
     }
        return  lstNhanVien;
     }
     
     
    public boolean themNhanVien(NhanVien nhanvien) {
        boolean check = false; 
        try {
            NhanVien nv = nhanvien;
            st = conn.prepareStatement("insert into nhanvien(tennhanvien, chucvu,"
                    +" gioitinh, ngaysinh, dienthoai, email, tendangnhap) values(?,?,?,?,?,?,?)");
            st.setString(1, nv.getTenNhanVien());
            st.setString(2, nv.getChucVu());
            st.setString(3, nv.getGioiTinh());
            st.setString(4, nv.getNgaySinh());            
            st.setString(5, nv.getDienThoai());
            st.setString(6, nv.getEmail());
            st.setString(7, nv.getTenDangNhap());

            int result = st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã thêm Nhân viên thành công!" , "Thông báo", 1);
            check = result != 0;
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Nhân viên không được thêm" , "Thông báo", 1); 
        }
        return check;
    }
    
    public boolean suaNhanVien(NhanVien nhanvien) {
        boolean check = false;
        NhanVien nv = nhanvien;
        try {
            st = conn.prepareStatement( "UPDATE nhanvien SET  tennhanvien=?, chucvu=?,"
                    +" gioitinh=?, ngaysinh=?, dienthoai=?, email=?, tendangnhap=?  WHERE manhanvien =?" );
            
            st.setString(1, nv.getTenNhanVien());
            st.setString(2, nv.getChucVu());
            st.setString(3, nv.getGioiTinh());
            st.setString(4,nv.getNgaySinh());
            st.setString(5, nv.getDienThoai());
            st.setString(6, nv.getEmail());
            st.setString(7, nv.getTenDangNhap());
            st.setInt(8, nv.getMaNhanVien());
            int result = st.executeUpdate();
            check = result != 0;
        } catch (SQLException ex) {
            System.out.println(ex.toString());  
        }
        return check;
    }
    
    public boolean doiMatKhau(int maNhanVien, String matKhau) {
        boolean check = false;
        try {
            st = conn.prepareStatement( "UPDATE nhanvien SET  matkhau = ? WHERE manhanvien = ?" );
            st.setString(1, matKhau);
            st.setInt(2, maNhanVien);
            int result = st.executeUpdate();
            check = result != 0;
        } catch (SQLException ex) {
               System.out.println(ex.toString());  
        }
        return check;
    }
    
    public void xoaNhanVien(int maNhanVien) {
        try {
                st = conn.prepareStatement("UPDATE nhanvien SET  trangthai=?  WHERE manhanvien =?");

                st.setString(1, "đã xóa");
                st.setInt(2, maNhanVien);
                st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Đã Xóa Nhân Viên!" , "Thông báo", 1);
        } catch (SQLException ex) {
            Logger.getLogger(MuonTraManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!" , "Thông báo", 2);
        }
        
//        try {
//            String sqlCommand = "delete from nhanvien where manhanvien = ?";
//            st = conn.prepareStatement(sqlCommand);
//            st.setInt(1, maNhanVien);
//            st.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//            JOptionPane.showMessageDialog(null, "Nhân Viên Này Đã Được Sử Dụng", "Lỗi Xóa Nhân Viên", JOptionPane.ERROR_MESSAGE);
//        }
    }

    
    
    public void loadDataNhanVienFromDB(JTable jtableNhanVien,String search) {
     
        NhanVienManager nhanVienManager = new NhanVienManager();
        if(search.equals("Nhập mã nhân viên/ tên nhân viên/ chức vụ cần tìm")){
            search = "";
        }
        lstNhanVien= nhanVienManager.getAllNhanVien(search);
        //Dua danh sach nhan vien len jTable
        String[] colTieuDe = new String[]{ "MÃ NHÂN VIÊN", "HỌ TÊN", "CHỨC VỤ", "GIỚI TÍNH", "NGÀY SINH", "ĐIỆN THOẠI", "EMAIL", "TÊN ĐĂNG NHẬP" };
        DefaultTableModel model = new DefaultTableModel(colTieuDe, 0);
        Object[] row;
        for (NhanVien nv : lstNhanVien) {
            row = new Object[8];
            row[0] = nv.getMaNhanVien();
            row[1] = nv.getTenNhanVien();
            row[2] = nv.getChucVu();
            row[3] = nv.getGioiTinh();
            row[4] = nv.getNgaySinh();
            row[5] = nv.getDienThoai();
            row[6] = nv.getEmail();
            row[7] = nv.getTenDangNhap();
       
            model.addRow(row);
        }
        jtableNhanVien.setModel(model);
    }
    
   
}
