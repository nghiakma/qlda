/*
 * Copyright 2017 Quang Vinh (quangvinh.gulang@gmail.com)
 */
package Manager;

import connectDataBase.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quangvinh.gulang@gmail.com
 */
public class ViPhamManager {
    Connection conn;
    private PreparedStatement st;
    public ViPhamManager() {
        conn = new ConnectionDB().getConnection();
    }
    public void loadDataViPhamFromDB(JTable jtableViPham,String search) {
        
        String[] colTieuDe = new String[]{"MÃ VI PHẠM", "MÃ MƯỢN TRẢ", "MÃ SINH VIÊN", "TÊN SINH VIÊN", 
            "TÊN ĐỒ ÁN","NGÀY MƯỢN","NGÀY TRẢ", "LÝ DO", "TIỀN PHẠT"};
        DefaultTableModel model = new DefaultTableModel(colTieuDe, 0);
        Object[] row;
        if(search.equals("Nhập mã sinh viên/ tên sinh viên/ tên đồ án cần tìm")){
            search = "";
        }
        
        try {            
            PreparedStatement pst = conn.prepareStatement("SELECT v.mavipham, v.mamuontra, m.madocgia, d.tendocgia,"
                    +" s.tensach, v.quahan, v.lydo, m.ngaymuon, m.ngaytra FROM pmqltv.muontra m, pmqltv.sach s, pmqltv.vipham v,"
                    +" pmqltv.docgia d WHERE m.mamuontra = v.mamuontra AND d.madocgia= m.madocgia AND s.masach= m.masach"
                    +" AND v.xuly IS NULL AND lower(concat(m.madocgia,d.tendocgia,s.tensach)) like lower('%"+ search +"%') ORDER BY m.madocgia ASC");  
            ResultSet rs = pst.executeQuery();  
            while(rs.next()) {
                row = new Object[9];
                row[0] = rs.getInt("v.mavipham");
                row[1] = rs.getInt("v.mamuontra");
                row[2] = rs.getInt("m.madocgia");
                row[3] = rs.getString("d.tendocgia");
                row[4] = rs.getString("s.tensach");
                row[5] = rs.getString("m.ngaymuon");
                row[6] = rs.getString("m.ngaytra");
                row[7] = rs.getString("v.lydo");
                row[8] = rs.getInt("v.quahan")*2000; //tiền phạt = quá hạn * 2000.
                
                model.addRow(row);
            }
            jtableViPham.setModel(model);
        } catch (SQLException ex) {
            System.out.println("Chỗ này");
               System.out.println(ex.toString());  
        }        
    }
    
    public boolean xulyViPham(int maViPham) {
        boolean check = false;
        try {
            st = conn.prepareStatement("UPDATE pmqltv.vipham SET xuly = ? WHERE mavipham =?");
            
            st.setString(1, "Đã xử lý");
            st.setInt(2, maViPham);
            int result = st.executeUpdate();
            check = result != 0;
        } catch (SQLException ex) {
               System.out.println(ex.toString());  
        }
        return check;
    }
}
