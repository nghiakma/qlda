/*
 * Copyright 2017 Quang Vinh (quangvinh.gulang@gmail.com)
 */
package Manager;

import Model.ThongKe;
import connectDataBase.ConnectionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quangvinh.gulang@gmail.com
 */
public class ThongKeManager {
    Connection conn;
    ArrayList<ThongKe> lstThongKe= new ArrayList();  
    public ThongKeManager() {
        conn = new ConnectionDB().getConnection();
    }
    
    public ArrayList<ThongKe> getDocGiaTK(Date ngaybd, Date ngaykt) {                           
        try {            
            PreparedStatement pst = conn.prepareStatement("SELECT m.madocgia,tendocgia, COUNT(m.madocgia)" +
                    " FROM pmqltv.muontra m, pmqltv.docgia d where d.madocgia = m.madocgia and (ngaymuon"
                    +" between '"+ngaybd+"' and '"+ngaykt+"') GROUP BY m.madocgia ORDER BY COUNT(m.madocgia) DESC");  
            ResultSet rs = pst.executeQuery();       
            while(rs.next()) {
                ThongKe tk = new ThongKe();
                tk.setMaDoiTuong(rs.getInt("m.madocgia"));
                tk.setThongKe(rs.getString("tendocgia"));
                tk.setSoLuong(rs.getInt("COUNT(m.madocgia)")); 

                lstThongKe.add(tk);              
            }
        } catch (SQLException ex) {
               System.out.println(ex.toString());  
    }
        return lstThongKe;
    }
    
    public ArrayList<ThongKe> getSachTK(Date ngaybd, Date ngaykt) {                           
        try {            
            PreparedStatement pst = conn.prepareStatement("SELECT m.masach, tensach, COUNT(m.masach)" 
                    +" FROM pmqltv.muontra m, pmqltv.sach s where s.masach = m.masach and (ngaymuon"
                    +" between '"+ngaybd+"' and '"+ngaykt+"') GROUP BY m.masach ORDER BY COUNT(m.masach) DESC");  
            ResultSet rs = pst.executeQuery();       
            while(rs.next()) {
                ThongKe tk = new ThongKe();
                tk.setMaDoiTuong(rs.getInt("m.masach")); 
                tk.setThongKe(rs.getString("tensach"));
                tk.setSoLuong(rs.getInt("COUNT(m.masach)")); 
                  
                lstThongKe.add(tk);              
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());  
    }
        return lstThongKe;
    }
    
    public ArrayList<ThongKe> getTheLoaiTK(Date ngaybd, Date ngaykt) {                           
        try {            
            PreparedStatement pst = conn.prepareStatement("SELECT theloai, COUNT(m.masach)" 
                    +" FROM pmqltv.muontra m, pmqltv.sach s WHERE s.masach = m.masach AND (ngaymuon"
                    +"  BETWEEN '"+ngaybd+"' AND '"+ngaykt+"') GROUP BY s.theloai ORDER BY COUNT(m.masach) DESC");  
            ResultSet rs = pst.executeQuery();  
            int count = 1;
            while(rs.next()) {
                ThongKe tk = new ThongKe();
                tk.setMaDoiTuong(count); 
                tk.setThongKe(rs.getString("theloai"));
                tk.setSoLuong(rs.getInt("COUNT(m.masach)")); 
                  
                lstThongKe.add(tk);
                count++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());  
    }
        return lstThongKe;
    }
    
    public ArrayList<ThongKe> getTacGiaTK(Date ngaybd, Date ngaykt) {                           
        try {            
            PreparedStatement pst = conn.prepareStatement("SELECT tacgia, COUNT(m.masach)" 
                    +" FROM pmqltv.muontra m, pmqltv.sach s WHERE s.masach = m.masach AND (ngaymuon"
                    +"  BETWEEN '"+ngaybd+"' AND '"+ngaykt+"') GROUP BY s.tacgia ORDER BY COUNT(m.masach) DESC");  
            ResultSet rs = pst.executeQuery();  
            int count = 1;
            while(rs.next()) {
                ThongKe tk = new ThongKe();
                tk.setMaDoiTuong(count); 
                tk.setThongKe(rs.getString("tacgia"));
                tk.setSoLuong(rs.getInt("COUNT(m.masach)")); 
                  
                lstThongKe.add(tk); 
                count++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());  
    }
        return lstThongKe;
    }
    
    public ArrayList<ThongKe> getNhaXuatBanTK(Date ngaybd, Date ngaykt) {                           
        try {            
            PreparedStatement pst = conn.prepareStatement("SELECT nhaxuatban, COUNT(m.masach)" 
                    +" FROM pmqltv.muontra m, pmqltv.sach s WHERE s.masach = m.masach AND (ngaymuon"
                    +"  BETWEEN '"+ngaybd+"' AND '"+ngaykt+"') GROUP BY s.nhaxuatban ORDER BY COUNT(m.masach) DESC");  
            ResultSet rs = pst.executeQuery();  
            int count = 1;
            while(rs.next()) {
                ThongKe tk = new ThongKe();
                tk.setMaDoiTuong(count); 
                tk.setThongKe(rs.getString("nhaxuatban"));
                tk.setSoLuong(rs.getInt("COUNT(m.masach)")); 
                  
               lstThongKe.add(tk); 
               count++;
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());  
    }
        return lstThongKe;
    }
    
    public void getDanhSachViPham(JTable jTableThongKe,Date ngaybd, Date ngaykt) {
     
        String[] colTieuDe = new String[]{ "M?? M?????N TR???", "M?? SINH VI??N", "T??N SINH VI??N", 
            "T??N ????? ??N","NG??Y M?????N","NG??Y TR???", "L?? DO", "TI???N PH???T", "T??NH TR???NG"};
        DefaultTableModel model = new DefaultTableModel(colTieuDe, 0);
        Object[] row;
        try {            
            PreparedStatement pst = conn.prepareStatement("SELECT v.mamuontra, m.madocgia, d.tendocgia,"
                    +" s.tensach, quahan, lydo, m.ngaymuon, m.ngaytra, v.xuly FROM pmqltv.muontra m, pmqltv.sach s, pmqltv.vipham v,"
                    +" pmqltv.docgia d WHERE m.mamuontra = v.mamuontra AND d.madocgia= m.madocgia AND s.masach= m.masach"
                    +" AND (m.ngaytra BETWEEN '"+ngaybd+"' AND '"+ngaykt+"') ORDER BY d.madocgia DESC");  
            ResultSet rs = pst.executeQuery();  
            while(rs.next()) {
                row = new Object[9];
                row[0] = rs.getInt("v.mamuontra");
                row[1] = rs.getInt("m.madocgia");
                row[2] = rs.getString("d.tendocgia");
                row[3] = rs.getString("s.tensach");
                row[4] = rs.getString("m.ngaymuon");
                row[5] = rs.getString("m.ngaytra");
                row[6] = rs.getString("lydo");
                row[7] = rs.getInt("quahan")*2000; //ti???n ph???t = qu?? h???n * 2000.
                if(rs.getString("v.xuly")!= null){
                    row[8]= "???? x??? l??";
                }else row[8]="Ch??a x??? l??";
                
                model.addRow(row);
            }
            jTableThongKe.setModel(model);
        } catch (SQLException ex) {
               System.out.println(ex.toString());  
        }
    }
    
    public ArrayList<ThongKe> getSachHetTK() {                           
        try {            
            PreparedStatement pst = conn.prepareStatement("SELECT masach, tensach, soluong" 
                    +" FROM pmqltv.sach WHERE trangthai IS NULL AND soluong = damuon");  
            ResultSet rs = pst.executeQuery();       
            while(rs.next()) {
                ThongKe tk = new ThongKe();
                tk.setMaDoiTuong(rs.getInt("masach")); 
                tk.setThongKe(rs.getString("tensach"));
                tk.setSoLuong(rs.getInt("soluong")); 
                  
                lstThongKe.add(tk);              
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());  
        }
        return lstThongKe;
    }
    
    public void getDocGiaHetHan(JTable jTableThongKe,Date ngaybd, Date ngaykt) {
//        String trangThai = "H???t h???n";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        
        Calendar bd = Calendar.getInstance();
        bd.setTime(ngaybd);
        bd.roll(Calendar.YEAR, -SinhVienManager.HAN_THE); 
        Calendar kt = Calendar.getInstance();
        kt.setTime(ngaykt);
        kt.roll(Calendar.YEAR, -SinhVienManager.HAN_THE); 
                
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String[] colTieuDe = new String[]{ "M?? SINH VI??N", "H??? T??N", "NG??Y SINH", "GI???I T??NH",
            "?????A CH???", "EMAIL", "??I???N THO???I", "NG??Y L???P TH???", "NG??Y H???T H???N"};
        DefaultTableModel model = new DefaultTableModel(colTieuDe, 0);
        Object[] row;
        try {            
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM pmqltv.docgia WHERE"
                    +" trangthai = 'H???t h???n' AND ngaylapthe BETWEEN '"+sdf.format(bd.getTime())+"' AND"
                    +" '"+sdf.format(kt.getTime())+"'");  
            ResultSet rs = pst.executeQuery();  
            while(rs.next()) {
                row = new Object[9];
                row[0] = rs.getInt("madocgia");
                row[1] = rs.getString("tendocgia");
                row[2] = rs.getString("ngaysinh");
                row[3] = rs.getString("gioitinh");
                row[4] = rs.getString("diachi");
                row[5] = rs.getString("email");
                row[6] = rs.getString("dienthoai");
                row[7] = rs.getString("ngaylapthe");
                
                //hi???n th??? ng??y h???t h???n
                Calendar c1 = Calendar.getInstance();
                c1.setTime(java.sql.Date.valueOf(rs.getString("ngaylapthe")));
                c1.roll(Calendar.YEAR, SinhVienManager.HAN_THE);                
                row[8] = dateFormat.format(c1.getTime());
            
                model.addRow(row);
            }
            jTableThongKe.setModel(model);
        } catch (SQLException ex) {
               System.out.println(ex.toString());  
        }
    }
}
