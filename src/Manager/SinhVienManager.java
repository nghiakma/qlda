/*
 quangvinh.gulang@gmail.com
 */
package Manager;

import Model.SinhVien;
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
import java.util.Calendar;
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
public class SinhVienManager {
    Connection conn;
    ArrayList<SinhVien> lstDocGia= new ArrayList();  
    private PreparedStatement st;
    public static final int HAN_THE = 5;// hạn sử dụng thẻ là 5 năm.
    public SinhVienManager() {
        conn = new ConnectionDB().getConnection();
    }
    
    
    public ArrayList<SinhVien> getAllDocGia(String search)
    {                           
        try {            
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM pmqltv.docgia "
                    +"where (trangthai IS NULL OR (docgia.madocgia IN (SELECT muontra.madocgia FROM "
                    +"pmqltv.muontra WHERE ngaytra IS NULL))) AND lower(concat(madocgia,tendocgia,email))"
                    +" like lower('%"+search+"%')");            
            ResultSet rs = pst.executeQuery();       
            while(rs.next()) {
                SinhVien dg = new SinhVien();
                dg.setMaDocGia(rs.getInt("madocgia"));
                dg.setTenDocGia(rs.getString("tendocgia"));
                dg.setNgaySinh(rs.getString("ngaysinh"));
                dg.setGioiTinh(rs.getString("gioitinh"));
                dg.setDiaChi(rs.getString("diachi"));
                dg.setEmail(rs.getString("email"));
                dg.setDienThoai(rs.getString("dienthoai")); 
                dg.setNgayLapThe(rs.getString("ngaylapthe"));
                
                lstDocGia.add(dg);              
            }
        } catch (SQLException ex) {
               System.out.println(ex.toString());  
        }
        return  lstDocGia;
    }
     
     
    public boolean themDocGia(SinhVien docGia) {
        boolean check = false; 
        try {
            SinhVien dg = docGia;
            st = conn.prepareStatement("insert into docgia(tendocgia, ngaysinh, "
                    +"gioitinh, diachi, email, dienthoai, ngaylapthe) values(?,?,?,?,?,?,?)");
            st.setString(1, dg.getTenDocGia());
            st.setString(2, dg.getNgaySinh());
            st.setString(3, dg.getGioiTinh());
            st.setString(4, dg.getDiaChi());
            st.setString(5, dg.getEmail());
            st.setString(6, dg.getDienThoai());
            st.setString(7, dg.getNgayLapThe());
            
            int result = st.executeUpdate();
            check = result != 0;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return check;
    }
    
    public boolean suaDocGia(SinhVien docgia) {
        boolean check = false;
        SinhVien dg = docgia;
        try {
            st = conn.prepareStatement("UPDATE docgia SET  tendocgia=?, ngaysinh=?, "
                    +"gioitinh=?, diachi=?, email=?, dienthoai=?, ngaylapthe=? WHERE madocgia =?");
            
            st.setString(1, dg.getTenDocGia());
            st.setString(2, dg.getNgaySinh());
            st.setString(3, dg.getGioiTinh());
            st.setString(4,dg.getDiaChi());
            st.setString(5, dg.getEmail());
            st.setString(6, dg.getDienThoai());
            st.setString(7, dg.getNgayLapThe());
            st.setInt(8, dg.getMaDocGia());
            int result = st.executeUpdate();
            check = result != 0;
        } catch (SQLException ex) {
               System.out.println(ex.toString());  
        }
        return check;
    }
    
    
    public void xoaDocGia(int maDocGia) {
        try {
            String sql = "SELECT COUNT(masach) FROM pmqltv.muontra WHERE madocgia = "+maDocGia+" AND ngaytra IS NULL";
            PreparedStatement pst = conn.prepareStatement(sql);   
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                int dangMuon= rs.getInt("COUNT(masach)");
                if(dangMuon == 0){
                    st = conn.prepareStatement("UPDATE docgia SET  trangthai=?  WHERE madocgia =?");
            
                    st.setString(1, "đã xóa");
                    st.setInt(2, maDocGia);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Đã Xóa Độc Giả!" , "Thông báo", 1);
                }else JOptionPane.showMessageDialog(null, "Độc Giả Này Đang Mượn Sách", "Lỗi Xóa Độc Giả", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MuonTraManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!" , "Thông báo", 2);
        }
    }

    
    public void loadDataDocGiaFromDB(JTable jtableDocGia,String search) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SinhVienManager docGiaManager = new SinhVienManager();
        if(search.equals("Nhập mã sinh viên/ tên sinh viên/ email cần tìm")){
            search = "";
        }
        lstDocGia= docGiaManager.getAllDocGia(search);
        //Dua danh sach muon tra len jTable
        String[] colTieuDe = new String[]{ "MÃ SINH VIÊN", "HỌ TÊN", "NGÀY SINH", "GIỚI TÍNH", "ĐỊA CHỈ", "EMAIL", "ĐIỆN THOẠI", "NGÀY LẬP THẺ", "NGÀY HẾT HẠN" };
        DefaultTableModel model = new DefaultTableModel(colTieuDe, 0);
        Object[] row;
        for (SinhVien dg : lstDocGia) {
            row = new Object[9];
            row[0] = dg.getMaDocGia();
            row[1] = dg.getTenDocGia();
            row[2] = dg.getNgaySinh();
            row[3] = dg.getGioiTinh();
            row[4] = dg.getDiaChi();
            row[5] = dg.getEmail();
            row[6] = dg.getDienThoai();
            row[7] = dg.getNgayLapThe();
            
            // tính ngày hết hạn thẻ = ngày lập cộng với HAN_THE.
            Calendar c1 = Calendar.getInstance();
            c1.setTime(java.sql.Date.valueOf(dg.getNgayLapThe()));
            c1.roll(Calendar.YEAR, HAN_THE);                
            row[8] = dateFormat.format(c1.getTime());
       
            model.addRow(row);
        }       
        jtableDocGia.setModel(model);
    }   
    
    public void loadDataDocGiaMTFromDB(JTable jtableDocGia,String search) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SinhVienManager docGiaManager = new SinhVienManager();
        if(search.equals("Nhập mã sinh viên/ tên sinh viên/ email cần tìm")){
            search = "";
        }
        lstDocGia= docGiaManager.getAllDocGia(search);
        //Dua danh sach muon tra len jTable
        String[] colTieuDe = new String[]{ "MÃ SINH VIEN", "HỌ TÊN", "NGÀY SINH", "GIỚI TÍNH", "NGÀY HẾT HẠN" };
        DefaultTableModel model = new DefaultTableModel(colTieuDe, 0);
        Object[] row;
        for (SinhVien dg : lstDocGia) {
            row = new Object[5];
            row[0] = dg.getMaDocGia();
            row[1] = dg.getTenDocGia();
            row[2] = dg.getNgaySinh();
            row[3] = dg.getGioiTinh();
            
            // tính ngày hết hạn thẻ = ngày lập cộng với HAN_THE.
            Calendar c1 = Calendar.getInstance();
            c1.setTime(java.sql.Date.valueOf(dg.getNgayLapThe()));
            c1.roll(Calendar.YEAR, HAN_THE);                
            row[4] = dateFormat.format(c1.getTime());
       
            model.addRow(row);
        }       
        jtableDocGia.setModel(model);
    }
    
    public void xoaDocGiaHetHan(){
        Date ngayHienTai = new Date();
        Calendar c1 = Calendar.getInstance();
        c1.setTime(ngayHienTai);
        c1.roll(Calendar.YEAR, -HAN_THE);
        java.sql.Date c2  = new java.sql.Date(c1.getTimeInMillis());
        try {
            st = conn.prepareStatement("UPDATE docgia SET trangthai=? WHERE trangthai "
                    +"IS NULL AND (DATEDIFF(?,ngaylapthe) > 0)");
            
            st.setString(1, "Hết hạn");
            st.setDate(2, c2);
            int result = st.executeUpdate();
            if(result != 0){
                System.out.println("Đã xóa một số thẻ độc giả hết hạn");
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi tại xóa độc giả hết hạn");    
            System.out.println(ex.toString());  
        }
    }
   
    
}
