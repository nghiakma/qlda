/*
 * Copyright 2017 Quang Vinh (quangvinh.gulang@gmail.com)
 */
package Manager;

import Model.DoAn;
import connectDataBase.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author quangvinh.gulang@gmail.com
 */
public class DoAnManager {
    Connection conn;
    ArrayList<DoAn> lstSach= new ArrayList();  
    private PreparedStatement st;
    private ResultSet rs;
    public DoAnManager() {
        conn = new ConnectionDB().getConnection();
    }
    
    
     public ArrayList<DoAn> getAllSach(String search)
     {                           
        try {            
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM pmqltv.sach "
                    + "where trangthai IS NULL AND soluong > 0 AND lower(concat(masach,tensach,theloai,tacgia))"
                    +" like lower('%"+search+"%')");            
            ResultSet rs = pst.executeQuery();       
            while(rs.next()) {
                DoAn s = new DoAn();
                s.setMaSach(rs.getInt("masach"));
                s.setTenSach(rs.getString("tensach"));
                s.setTheLoai(rs.getString("theloai"));
                s.setTacGia(rs.getString("tacgia"));
                s.setNhaXuatBan(rs.getString("nhaxuatban"));
                s.setNamXuatBan(rs.getInt("namxuatban")); 
                s.setNgayNhap(rs.getString("ngaynhap"));
                s.setNgonNgu(rs.getString("ngonngu")); 
                s.setSoTrang(rs.getInt("sotrang")); 
                s.setSoLuong(rs.getInt("soluong")); 
                s.setGiaTien(rs.getInt("giatien")); 
                s.setDaMuon(rs.getInt("damuon")); 
                
               lstSach.add(s);              
            }
        } catch (SQLException ex) {
               System.out.println(ex.toString());  
     }
        return  lstSach;
     }
     
     
    public boolean themSach(DoAn sach) {
        boolean check = false; 
        try {
            DoAn s = sach;
            st = conn.prepareStatement("insert into sach(tensach, theloai, tacgia, nhaxuatban, "
                    +"namxuatban, ngaynhap, ngonngu, sotrang, soluong, giatien, damuon) values(?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, s.getTenSach());
            st.setString(2, s.getTheLoai());
            st.setString(3, s.getTacGia());
            st.setString(4, s.getNhaXuatBan());
            st.setInt(5, s.getNamXuatBan());
            st.setString(6, s.getNgayNhap());
            st.setString(7, s.getNgonNgu());
            st.setInt(8, s.getSoTrang());
            st.setInt(9, s.getSoLuong());
            st.setInt(10, s.getGiaTien());
            st.setInt(11, s.getDaMuon());
        
            int result = st.executeUpdate();
//            JOptionPane.showMessageDialog(null, "???? th??m S??ch th??nh c??ng!" , "Th??ng b??o", 1);
            check = result != 0;
        } catch (SQLException e) {
            System.out.println(e.toString());
//            JOptionPane.showMessageDialog(null, "S??ch ch??a ???????c th??m" , "Th??ng b??o", 1); 
        }
        return check;
    }
    public boolean suaSach(DoAn sach) {
        boolean check = false;
        DoAn s = sach;
        try {
            st = conn.prepareStatement( "UPDATE sach SET  tensach=?, theloai=?, tacgia=?, nhaxuatban=?,"
                    +" namxuatban=?, ngaynhap=?, ngonngu=?, sotrang=?, soluong=?, giatien=?  WHERE masach =? AND damuon <= ?" );
            
            st.setString(1, s.getTenSach());
            st.setString(2, s.getTheLoai());
            st.setString(3, s.getTacGia());
            st.setString(4,s.getNhaXuatBan());
            st.setInt(5, s.getNamXuatBan());
            st.setString(6, s.getNgayNhap());
            st.setString(7,s.getNgonNgu());
            st.setInt(8, s.getSoTrang());
            st.setInt(9, s.getSoLuong());
            st.setInt(10, s.getGiaTien());
            st.setInt(11, s.getMaSach());  
            st.setInt(12, s.getSoLuong());
                    
            int result = st.executeUpdate();
            check = result != 0;
        } catch (SQLException ex) {
               System.out.println(ex.toString());  
        }
        return check;
    }
    

    public void xoaSach(int maSach) {
        try {
            String sql = "SELECT COUNT(madocgia) FROM pmqltv.muontra WHERE masach = "+maSach+" AND ngaytra IS NULL";
            PreparedStatement pst = conn.prepareStatement(sql);   
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                int dangMuon= rs.getInt("COUNT(madocgia)");
                if(dangMuon == 0){
                    st = conn.prepareStatement("UPDATE sach SET  trangthai=?  WHERE masach =?");
            
                    st.setString(1, "???? x??a");
                    st.setInt(2, maSach);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(null, "???? X??a S??ch!" , "Th??ng b??o", 1);
                }else JOptionPane.showMessageDialog(null, "S??ch N??y ??ang ???????c M?????n!", "L???i X??a S??ch", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MuonTraManager.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "C?? l???i x???y ra!" , "Th??ng b??o", 2);
        }
//        try {
//            String sqlCommand = "delete from sach where masach = ?";
//            st = conn.prepareStatement(sqlCommand);
//            st.setInt(1, maSach);
//            st.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//            JOptionPane.showMessageDialog(null, "S??ch N??y ??ang ???????c M?????n", "L???i X??a S??ch", JOptionPane.ERROR_MESSAGE);
//        }
    }

    
    public void loadDataSachFromDB(JTable jtableSach,String search) {
     
        DoAnManager sachManager = new DoAnManager();
        if(search.equals("Nh???p m?? ????? ??n/ t??n ????? ??n/ lo???i ????? ??n/ ch??? ????? ??n c???n t??m")){
            search = "";
        }
        lstSach= sachManager.getAllSach(search);
        //Dua danh sach muon tra len jTable
        String[] colTieuDe = new String[]{ "M?? ????? ??N", "T??N ????? ??N", "LO???I ????? ??N", "T??NH TR???NG", 
            "CH??? ????? ??N", "N??I QU???N L?? ????? ??N", "N??M HT ????? ??N", "NG??Y NH???P", "NG??N NG???", "S??? TRANG", "S??? L?????NG", "GI?? TI???N B???N C???NG ????? ??N" };
        DefaultTableModel model = new DefaultTableModel(colTieuDe, 0);

        Object[] row;
        for (DoAn s : lstSach) {
            row = new Object[12];
            row[0] = s.getMaSach();
            row[1] = s.getTenSach();
            row[2] = s.getTheLoai();
            row[4] = s.getTacGia();
            row[5] = s.getNhaXuatBan();
            row[6] = s.getNamXuatBan();
            row[7] = s.getNgayNhap();
            row[8] = s.getNgonNgu();
            row[9] = s.getSoTrang();
            row[10] = s.getSoLuong();
            if (s.getSoLuong() > s.getDaMuon())
                row[3] = "S???n s??ng";
            else row[3] = "???? h???t";
            row[11] = s.getGiaTien();
       
            model.addRow(row);
        }
       
        jtableSach.setModel(model);
    }
    
    public void loadDataSachMuonFromDB(JTable jtableSach, String search, int[] maSach, String maDocGia) { 
        String[] colTieuDe = new String[]{ "M?? ????? ??N", "T??N ????? ??N", "LO???I ????? ??N", "NG??N NG???",
            "CH??? ????? ??N", "N??I QU???N L?? ????? ??N", "GI?? TI???N B???N C???NG ????? ??N" };
        DefaultTableModel model = new DefaultTableModel(colTieuDe, 0);
        Object[] row;
        if(search.equals("Nh???p m?? ????? ??n/ t??n ????? ??n/ lo???i ????? ??n c???n t??m")){ //ph???c v??? cho hi???n th??? g???i ?? - input hint trong jtext.
            search = "";
        }
        String sqlSachDaChon = "";// ??o???n string d??ng ????? truy v???n m?? s??ch c???n lo???i b??? trong ???? ch???n trong jtableSachChon.
        for(int i = 0; i< maSach.length; i++ ){
            sqlSachDaChon +=  "masach != " + maSach[i] + " AND ";
        }
        
        String sqlSachDaMuon = ""; //??o???n string d??ng ????? truy v???n m?? s??ch c???n lo???i b??? m?? ?????c gi??? ???? m?????n trong jtableSachChon.
        try {
            PreparedStatement pst1 = conn.prepareStatement("SELECT masach FROM pmqltv.muontra m WHERE"
                    +" ngaytra IS NULL AND madocgia = "+ maDocGia +"");
            ResultSet rs = pst1.executeQuery();       
            while(rs.next()) {
                sqlSachDaMuon += " masach != " + rs.getInt("masach") + " AND ";
            }
        } catch (SQLException ex) {
            System.out.println("??o???n l???i trong m???c th??m sql s??ch ???? m?????n");
        }
        
        try {            
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM pmqltv.sach "
                    + "where trangthai IS NULL AND soluong > damuon AND "+ sqlSachDaMuon 
                    + sqlSachDaChon +" lower(concat(masach, tensach, theloai, tacgia)) like lower('%"+search+"%')");            
            ResultSet rs = pst.executeQuery();       
            while(rs.next()) {
                row = new Object[7];
                row[0] = rs.getInt("masach");
                row[1] = rs.getString("tensach");
                row[2] = rs.getString("theloai");
                row[3] = rs.getString("ngonngu");
                row[4] = rs.getString("tacgia");
                row[5] = rs.getString("nhaxuatban");
                row[6] = rs.getInt("giatien"); 
                model.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());  
     }
        jtableSach.setModel(model);
    }
    
    public void loadSachPhieuMuon(JTable jtableSachPhieuMuon, int maPhieu){
        String[] colTieuDe = new String[]{ "M??", "T??N ????? ??N", "LO???I ????? ??N", "Ch??? ????? ??N", "N??I QU???N L?? ????? ??N" };
        DefaultTableModel model = new DefaultTableModel(colTieuDe, 0);
        Object[] row;
        
        try {            
            PreparedStatement pst = conn.prepareStatement("SELECT s.masach, tensach, theloai, tacgia, nhaxuatban"
                    + " FROM pmqltv.sach s, pmqltv.muontra m where m.maphieu = " +maPhieu+" AND s.masach = m.masach AND m.ngaytra IS NULL");            
            ResultSet rs = pst.executeQuery();       
            while(rs.next()) {
                row = new Object[5];
                row[0] = rs.getInt("s.masach");
                row[1] = rs.getString("tensach");
                row[2] = rs.getString("theloai");
                row[3] = rs.getString("tacgia");
                row[4] = rs.getString("nhaxuatban");
                model.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());  
     }
        jtableSachPhieuMuon.setModel(model);
        jtableSachPhieuMuon.getColumnModel().getColumn(0).setPreferredWidth(30);
        jtableSachPhieuMuon.getColumnModel().getColumn(1).setPreferredWidth(170);
        jtableSachPhieuMuon.getColumnModel().getColumn(2).setPreferredWidth(80);
        jtableSachPhieuMuon.getColumnModel().getColumn(3).setPreferredWidth(100);
        jtableSachPhieuMuon.getColumnModel().getColumn(4).setPreferredWidth(120);
    }
    
    
}
